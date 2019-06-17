package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created 11.06.2019
 */
public class Reflection {

    /**
     * Invokes all annotated methods
     */
    public static void invokeAnnotatedMethods(Object o, Class<? extends Annotation> annotationClass) {
        Set<Method> methods = new LinkedHashSet<>();
        Class clazz = o.getClass();
        methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        methods.addAll(Arrays.asList(clazz.getMethods()));
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(annotationClass);
            if (annotation == null) {
                continue;
            }
            System.out.print("\nInvoking: " +
                    Reflection.getModifiers(method.getClass()) +
                    method.getReturnType().getSimpleName() + " " +
                    method.getName() +
                    "(" + Reflection.getParameters(method) + ")");

            if (method.getParameterTypes().length > 0) {
                System.out.println(" - skip");
            } else {
                System.out.println();

                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }

                try {
                    Object returned = method.invoke(o);
                    System.out.println("Result: " + returned);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * getConstructors
     */
    public static List<String> getConstructors(Object o) {
        List<String> constructorsList = new ArrayList<>();
        Class clazz = o.getClass();
        Set<Constructor> constructors = new LinkedHashSet<>();
        constructors.addAll(Arrays.asList(clazz.getDeclaredConstructors()));
        constructors.addAll(Arrays.asList(clazz.getConstructors()));

        for (Constructor constructor : constructors) {
            String s = getAnnotations(constructor) +
                    getModifiers(constructor.getClass()) +
                    constructor.getName() +
                    "(" + getParameters(constructor) + ")";

            constructorsList.add(s);
        }

        return constructorsList;
    }

    /**
     * getMethods
     */
    public static List<String> getMethods(Object o) {
        List<String> methodsList = new ArrayList<>();
        Class clazz = o.getClass();
        Set<Method> methods = new LinkedHashSet<>();
        methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        methods.addAll(Arrays.asList(clazz.getMethods()));

        for (Method method : methods) {
            String s = getAnnotations(method) +
                    getModifiers(method.getClass()) +
                    method.getReturnType().getSimpleName() + " " +
                    method.getName() +
                    "(" + getParameters(method) + ")\n";

            methodsList.add(s);
        }

        return methodsList;
    }

    /**
     * getFields
     */
    public static List<String> getFields(Object o) {
        List<String> fieldsList = new ArrayList<>();
        Class clazz = o.getClass();
        Set<Field> fields = new LinkedHashSet<>();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getFields()));

        for (Field field : fields) {
            String s = getAnnotations(field) +
                    getModifiers(field.getClass()) +
                    field.getType().getSimpleName() + " " +
                    field.getName() + "\n";

            fieldsList.add(s);
        }

        return fieldsList;
    }

    /**
     * getInterfaces
     */
    public static List<String> getInterfaces(Object o) {
        List<String> interfacesList = new ArrayList<>();
        Class clazz = o.getClass();
        Set<Class> interfaces = new LinkedHashSet<>(Arrays.asList(clazz.getInterfaces()));

        for (Class anInterface : interfaces) {
            String s = getModifiers(anInterface.getClass()) +
                    anInterface.getSimpleName();

            interfacesList.add(s);
        }

        return interfacesList;
    }

    private static String getAnnotations(Executable executable) {
        StringBuilder sb = new StringBuilder();
        for(Annotation annotaion : executable.getAnnotations()){
            sb.append("@").append(annotaion.annotationType().getSimpleName()).append("\n");
        }
        return sb.toString();
    }

    private static String getAnnotations(Field field) {
        StringBuilder sb = new StringBuilder();
        for(Annotation annotaion : field.getAnnotations()){
            sb.append("@").append(annotaion.annotationType().getSimpleName()).append("\n");
        }
        return sb.toString();
    }

    public static String getModifiers(Class clazz) {
        StringBuilder result = new StringBuilder();

        int modifiers = clazz.getModifiers();

        if (Modifier.isPublic(modifiers)) {
            result.append("public ");
        }
        if (Modifier.isProtected(modifiers)) {
            result.append("protected ");
        }
        if (Modifier.isPrivate(modifiers)) {
            result.append("private ");
        }
        if (Modifier.isStatic(modifiers)) {
            result.append("static ");
        }
        if (Modifier.isFinal(modifiers)) {
            result.append("final ");
        }
        if (Modifier.isAbstract(modifiers)) {
            result.append("abstract ");
        }
        if (Modifier.isSynchronized(modifiers)) {
            result.append("synchronized ");
        }
        if (Modifier.isNative(modifiers)) {
            result.append("native ");
        }
        if (Modifier.isStrict(modifiers)) {
            result.append("strictfp ");
        }
        return result.toString();
    }

    private static String getParameters(Executable executable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < executable.getParameterTypes().length; i++) {
            stringBuilder.append(executable.getParameterTypes()[i].getSimpleName());
            if (i < executable.getParameterTypes().length - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}