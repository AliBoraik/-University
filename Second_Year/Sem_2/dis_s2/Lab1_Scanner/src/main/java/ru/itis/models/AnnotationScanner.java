package ru.itis.models;


import ru.itis.annotations.Component;
import ru.itis.annotations.Inject;
import ru.itis.components.TestClass;
import ru.itis.components.TestComponent1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * IoC Inversion of Control
 * <p>
 * DI Dependency Injection
 */
public class AnnotationScanner {

    public static String PATH_FOR_SCAN = "ru.itis.components";


    public static void main(String[] arg) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN + ":");

        List<Class<?>> classList = PathScan.findAllClasses(PATH_FOR_SCAN);


        classList.forEach(cl -> {
            System.out.print("Class name : " + cl.getSimpleName() + " ->");

            for (Field f : cl.getFields()) {
                System.out.println("\t" + f.getName());
                Annotation[] annotations = f.getAnnotations();
                for (Annotation an : annotations) {
                    for (Field fa : an.annotationType().getDeclaredFields()) {
                        System.out.print("\t" + fa.getName());
                    }
                }
            }
            System.out.println();
        });


        classList.forEach(cl -> {
            System.out.println("Class name : " + cl.getSimpleName() + " ->");
            Annotation[] annotations = cl.getAnnotations();
            for (Annotation a1 : annotations) {
                if (a1.annotationType().equals(Component.class)) {
                    System.out.println("\t" + cl.getSimpleName() + " is Component!");
                    break;
                }
            }
        });

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());

            for (Field field : cl.getDeclaredFields()) {
                System.out.println("\t\t" + field.getName() + " of type " + field.getType().getCanonicalName());
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    System.out.println("raw type: " + pt.getRawType());
                    System.out.println("owner type: " + pt.getOwnerType());
                    System.out.println("actual type args:");
                    for (Type t : pt.getActualTypeArguments()) {
                        System.out.println("    " + t);
                    }
                }

            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }
        }


        System.out.println("STEP 4: scan class annotations:");
        Annotation[] annotations = TestComponent1.class.getAnnotations();
        for (Annotation a1 : annotations) {
            if (a1.annotationType().equals(Component.class)) {
                System.out.println("\tTestComponent is Component!");
                break;
            }

        }

        System.out.println("STEP 5: scan fields annotations:");

        Field[] fields = TestClass.class.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] fannotations = f.getAnnotations();
            for (Annotation a2 : fannotations) {
                if (a2.annotationType().equals(Inject.class)) {
                    System.out.printf("\tField %s %s Inject!%n", f.getType().getName(), f.getName());
                }
            }
        }


        System.out.println("...");
    }
}
