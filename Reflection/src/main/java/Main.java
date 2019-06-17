import annotation.MethodAnnotation;
import entity.ITextWindow;
import entity.TextWindow;
import proxy.ImmutableProxy;
import reflection.Reflection;

import java.awt.*;

/**
 * Created 11.06.2019
 */
public class Main {

    public static void main(String[] args) throws Exception {

        TextWindow textWindow = new TextWindow(new Point(1, 2), new Point(3, 4),
                Color.RED, "Some text", Color.GREEN);

        Class<MethodAnnotation> annotationClass = MethodAnnotation.class;

        System.out.println("Package: " + textWindow.getClass().getPackage().getName());
        System.out.println("Class modifiers: " + Reflection.getModifiers(textWindow.getClass()));
        System.out.println("Class name: " + textWindow.getClass().getSimpleName());
        System.out.println("Implements interfaces:");
        Reflection.getInterfaces(textWindow).forEach(System.out::println);
        System.out.println("Superclass: " + ((Class) textWindow.getClass()).getSuperclass().getSimpleName());
        System.out.println();

        System.out.println("Invoke Annotated Methods:");
        Reflection.invokeAnnotatedMethods(textWindow, annotationClass);
        System.out.println();

        System.out.println("Constructors:");
        Reflection.getConstructors(textWindow).forEach(System.out::println);
        System.out.println();

        System.out.println("Methods:");
        Reflection.getMethods(textWindow).forEach(System.out::println);
        System.out.println();

        System.out.println("Fields:");
        Reflection.getFields(textWindow).forEach(System.out::println);
        System.out.println();

        System.out.println("Immutable Proxy:");
        ITextWindow immutableTextWindow = ImmutableProxy.getImmutableProxy(textWindow);
        System.out.println("getDate on textWindow: " + textWindow.getText());
        System.out.println("getDate on immutableTextWindow: " + immutableTextWindow.getText());
        System.out.println("Trying to setText on textWindow...");
        try {
            textWindow.setText("New Text");
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
        System.out.println("Trying to setText on immutableTextWindow.... ");
        try {
            immutableTextWindow.setText("New Text");
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
