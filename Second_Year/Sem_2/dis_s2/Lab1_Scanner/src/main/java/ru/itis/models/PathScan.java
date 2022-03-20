package ru.itis.models;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import java.util.ArrayList;
import java.util.List;

public class PathScan {

    public static List<Class<?>> findAllClasses(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new ArrayList<>(reflections.getSubTypesOf(Object.class));
    }
}