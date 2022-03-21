package ru.itis.models;

import ru.itis.Main;
import ru.itis.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@Component
public class ScanEntity {
    private final Map<String, List<String>> entities;
    private final String PATH_FOR_SCAN;

    public ScanEntity() {
        entities = new HashMap<>();
        PATH_FOR_SCAN = Main.class.getPackage().getName();
        startScan();
    }

    private void startScan() {

        List<Class<?>> classList = PathScan.findAllClasses(PATH_FOR_SCAN);

        // ищем @Entity
        classList.forEach(cl -> {
            for (Annotation a1 : cl.getAnnotations()) {
                if (a1.annotationType().equals(Entity.class)) {

                    List<String> fields = new LinkedList<>();

                    for (Field field : cl.getDeclaredFields()) {
                        // ищем @Id @Column @ManyToOne
                        String nameColumn = annotationName(field);

                        if (nameColumn != null) {
                            fields.add(nameColumn);
                        }
                    }
                    Entity e = cl.getAnnotation(Entity.class);
                    String nameEntity = (!e.name().equals("")) ? e.name() : cl.getSimpleName();
                    entities.put(nameEntity, fields);
                }
            }
        });
    }

    public Map<String, List<String>> getAllEntities() {
        return entities;
    }

    private String annotationName(Field field) {
        // check column name
        if (field.isAnnotationPresent(Column.class)) {
            Column c = field.getAnnotation(Column.class);
            return (!c.name().equals("")) ? c.name() : field.getName();
        }

        // check ManyToOne name
        if (field.isAnnotationPresent(ManyToOne.class)) {
            ManyToOne c = field.getAnnotation(ManyToOne.class);
            return (!c.name().equals("")) ? c.name() : field.getName();
        }

        if (field.isAnnotationPresent(Id.class)) {
            return field.getName();
        }

        return null;
    }

    public List<String> getEntity(String nameEntity) {
        return entities.get(nameEntity);
    }


}