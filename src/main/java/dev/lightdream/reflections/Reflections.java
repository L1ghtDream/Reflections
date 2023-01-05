package dev.lightdream.reflections;

import dev.lightdream.logger.Logger;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Reflections {
    private final @NotNull Mapper mapper;

    public Reflections(@NonNull Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     * @param annotation  The annotation to search for
     * @return A set of classes that have the specified annotation
     */
    public @NonNull Set<Class<?>> getClassesAnnotatedWith(Class<? extends Annotation> annotation) {
        return mapper
                .getClasses()
                .stream()
                .filter(clazz -> clazz.isAnnotationPresent(annotation))
                .collect(Collectors.toSet());
    }

    /**
     * @param annotation  The annotation to search for
     * @return A set of methods that have the specified annotation
     */
    public @NonNull Set<Method> getMethodsAnnotatedWith(Class<? extends Annotation> annotation) {
        Set<Method> classes = new HashSet<>();

        mapper.getClasses().forEach(clazz -> {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    classes.add(method);
                }
            }
        });

        return classes;
    }
}
