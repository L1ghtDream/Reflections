package dev.lightdream.reflections;

import dev.lightdream.lambda.lambda.ReturnLambdaExecutor;
import dev.lightdream.logger.Debugger;
import dev.lightdream.logger.Logger;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@Deprecated
public class Mapper {

    private final @Getter String packageName;
    private final @Getter Set<Class<?>> classes;

    public Mapper(String packageName) {
        this.packageName = packageName;
        this.classes = getClasses(packageName, Thread.currentThread().getContextClassLoader());
    }

    public Mapper(String packageName, ClassLoader classLoader) {
        this.packageName = packageName;
        classes = getClasses(packageName, classLoader);
    }

    public Mapper(Set<Class<?>> classes) {
        this.classes = classes;
        this.packageName = classes.toArray()[0].getClass().getPackage().getName();
    }

    public Mapper(ReturnLambdaExecutor<Set<Class<?>>> classesProvider) {
        this.classes = classesProvider.execute();
        this.packageName = classes.toArray()[0].getClass().getPackage().getName();
    }

    private Set<Class<?>> getClasses(String packageName, ClassLoader classLoader) {
        Set<Class<?>> classes = new HashSet<>();

        ClassGraph classGraph = new ClassGraph()
                .addClassLoader(classLoader)
                .enableAllInfo()
                .acceptPackages(packageName);

        try (ScanResult scanResult = classGraph.scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                try {
                    classes.add(Class.forName(classInfo.getName(), true, classLoader));
                } catch (Throwable throwable) {
                    if (Debugger.isEnabled()) {
                        throwable.printStackTrace();
                    }
                }
            }
        } catch (Throwable throwable) {
            Logger.warn("If you are running any software that is loading the classes dynamically" +
                    " (such as a Minecraft Forge), you may need to use its specific platform API to get the classes and " +
                    "use the Mapper<init>(Set<Class<?>>) or Mapper<init>(ReturnLambdaExecutor<Set<Class<?>>>)"
            );
            if (Debugger.isEnabled()) {
                Logger.warn(throwable.getMessage());
                if (Debugger.isEnabled()) {
                    throwable.printStackTrace();
                }
            }
        }

        return classes;
    }

    public Reflections createReflections() {
        return new Reflections(this);
    }
}
