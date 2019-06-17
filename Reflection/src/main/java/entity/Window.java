package entity;

import annotation.MethodAnnotation;

import java.awt.*;

/**
 * Created 11.06.2019
 */
public class Window {

    public static final Color DEFAULT_WINDOW_COLOR = Color.WHITE;

    private Point topLeft;
    private Point bottomRight;
    private Color windowColor;

    protected boolean isProtected;

    /**
     * Default constructor
     */
    Window() {
        this(null, null, DEFAULT_WINDOW_COLOR);
    }

    /**
     * Constructor
     */
    private Window(Point topLeft, Point bottomRight, Color windowColor) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.windowColor = windowColor;
    }

    // Getters & Setters

    @MethodAnnotation
    public static Color getDefaultWindowColor() {
        return DEFAULT_WINDOW_COLOR;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    @MethodAnnotation
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @MethodAnnotation
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    @MethodAnnotation
    public Color getWindowColor() {
        return windowColor;
    }

    public void setWindowColor(Color windowColor) {
        this.windowColor = windowColor;
    }

    @MethodAnnotation
    @Override
    public String toString() {
        return "Window{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", windowColor=" + windowColor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Window window = (Window) o;

        if (topLeft != null ? !topLeft.equals(window.topLeft) : window.topLeft != null) return false;
        if (bottomRight != null ? !bottomRight.equals(window.bottomRight) : window.bottomRight != null) return false;
        return windowColor != null ? windowColor.equals(window.windowColor) : window.windowColor == null;

    }

    @MethodAnnotation
    @Override
    public int hashCode() {
        int result = topLeft != null ? topLeft.hashCode() : 0;
        result = 31 * result + (bottomRight != null ? bottomRight.hashCode() : 0);
        result = 31 * result + (windowColor != null ? windowColor.hashCode() : 0);
        return result;
    }

}
