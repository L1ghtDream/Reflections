package dev.lightdream.reflections;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

public class Mapper {

    private final @Getter Set<Class<?>> classes;

    public Mapper(String packageName) {
        classes = getClasses(packageName);
    }

    @SneakyThrows
    private Set<Class<?>> getClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Set<Class<?>> classes = new HashSet<>();

        ClassGraph classGraph = new ClassGraph()
                .addClassLoader(classLoader)
                .enableAllInfo();

        classGraph.acceptPackages(packageName);

        try (ScanResult scanResult = classGraph.scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                classes.add(Class.forName(classInfo.getName(), true, classLoader));
            }
        }

        return classes;
    }

}
