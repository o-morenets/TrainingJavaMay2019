package entity;

import annotation.MethodAnnotation;

import java.awt.*;

public interface ITextWindow {

    @MethodAnnotation
    static Color getDefaultTextColor() {
        return TextWindow.DEFAULT_TEXT_COLOR;
    }

    @MethodAnnotation
    String getText();

    Color getTextColor();

    @MethodAnnotation
    void setTextColor(Color textColor);

    void setText(String new_text);
}
