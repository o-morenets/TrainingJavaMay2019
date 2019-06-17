package entity;

import annotation.FieldAnnotation;
import annotation.MethodAnnotation;

import java.awt.*;
import java.lang.annotation.Native;

/**
 * Created 11.06.2019
 */
public class TextWindow extends Window implements ITextWindow {

    public static final String DEFAULT_TEXT = "No text";
    public static final Color DEFAULT_TEXT_COLOR = Color.LIGHT_GRAY;

    private String text;

    @FieldAnnotation
    private Color textColor;

    public boolean isProtected;

    /**
     * Default constructor
     */
    private TextWindow() {
        this(DEFAULT_TEXT, DEFAULT_TEXT_COLOR);
    }

    /**
     * Constructor
     */
    public TextWindow(String text, Color textColor) {
        this.text = text;
        this.textColor = textColor;
    }

    /**
     * Constructor
     */
    public TextWindow(Point topLeft, Point bottomRight, Color windowColor, String text, Color textColor) {
        this.text = text;
        this.textColor = textColor;
    }

    // Getters & Setters

    @MethodAnnotation(enabled = false)
    private static String getDefaultText() {
        return DEFAULT_TEXT;
    }

    @Override
    @MethodAnnotation
    public String getText() {
        return text;
    }

    @MethodAnnotation(enabled = true)
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Color getTextColor() {
        return textColor;
    }

    @Override
    @MethodAnnotation
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "TextWindow{" + "text='" + text + '\'' + ", textColor=" + textColor + '}';
    }

    @MethodAnnotation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TextWindow that = (TextWindow) o;

        if (text != null ? !text.equals(that.text) : that.text != null)
            return false;
        return textColor != null ? textColor.equals(that.textColor) : that.textColor == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (textColor != null ? textColor.hashCode() : 0);
        return result;
    }
}
