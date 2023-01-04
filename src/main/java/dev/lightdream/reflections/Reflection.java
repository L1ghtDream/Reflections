package dev.lightdream.reflections;

import dev.lightdream.logger.Logger;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Reflection {
    private static Mapper globalMapper;
    private Mapper localMapper;

    public static void setMapper(Mapper mapper) {
        Reflection.globalMapper = mapper;
    }

    private @Nullable Mapper getMapper(String... packageName) {
        if (globalMapper != null) {
            return globalMapper;
        }
        Logger.warn("No global mapper found. For performance reasons, it is recommended to set a global mapper.");
        if (localMapper != null) {
            return localMapper;
        }

        if (packageName.length == 0) {
            Logger.error("No package name was passed! Please pass a package name to the Reflection class.");
            return null;
        }

        localMapper = new Mapper(packageName[0]);
        return localMapper;
    }


    /**
     * @param annotation The annotation to search for
     * @param packageName Only provide if you did not set a globalMapper <strong>(Highly unrecommended)</strong>
     * @return A set of classes that have the specified annotation
     */
    public @NonNull Set<Class<?>> getClassesAnnotatedWith(Class<? extends Annotation> annotation, String... packageName) {
        Mapper mapper = getMapper(packageName);

        if (mapper == null) {
            return new HashSet<>();
        }

        return mapper
                .getClasses()
                .stream()
                .filter(clazz -> clazz.isAnnotationPresent(annotation))
                .collect(Collectors.toSet());
    }

    /**
     * @param annotation The annotation to search for
     * @param packageName Only provide if you did not set a globalMapper <strong>(Highly unrecommended)</strong>
     * @return A set of methods that have the specified annotation
     */
    public @NonNull Set<Method> getMethodsAnnotatedWith(Class<? extends Annotation> annotation, String... packageName) {
        Mapper mapper = getMapper(packageName);

        if (mapper == null) {
            return new HashSet<>();
        }

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
