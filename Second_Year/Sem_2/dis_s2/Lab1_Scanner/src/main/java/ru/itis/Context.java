package ru.itis;

import ru.itis.annotations.Component;
import ru.itis.annotations.Inject;
import ru.itis.models.PathScan;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Context {
    public final Map<String, Object> components;
    private final String PATH_FOR_SCAN ;

    public Context(Class<?> startClass) {
        components = new HashMap<>();
        PATH_FOR_SCAN = startClass.getPackage().getName();
        startScan();
    }

    private void startScan() {

        List<Class<?>> classList = PathScan.findAllClasses(PATH_FOR_SCAN);


        // ищем компоненты @Component
        classList.forEach(cl -> {
            for (Annotation a1 : cl.getAnnotations()) {
                if (a1.annotationType().equals(Component.class)) {
                    try {
                        Constructor<?> cons = cl.getConstructor();
                        Object object = cons.newInstance();
                        //set to components
                        components.put(cl.getSimpleName(), object);

                    } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        // ищем поля @Inject
        classList.forEach(cl -> {
            for (Field field : cl.getDeclaredFields()) {
                Annotation[] annotations = field.getAnnotations();
                for (Annotation a : annotations) {
                    if (Inject.class.equals(a.annotationType())) {
                        field.setAccessible(true);
                        try {
                            field.set(components.get(cl.getSimpleName()), components.get(field.getType().getSimpleName()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}