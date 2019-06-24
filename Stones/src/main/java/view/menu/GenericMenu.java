package view.menu;

import java.util.Arrays;
import java.util.Comparator;

public class GenericMenu<T extends Enum<T> & ISortedMenu> {

    private Class<T> menuType;

    public GenericMenu(Class<T> menuType) {
        this.menuType = menuType;
    }

    /**
     * Returns menu items in sorted order
     *
     * @return menu items in sorted order
     */
    public T[] getSortedMenu() {
        T[] enumConstants = menuType.getEnumConstants();
        Arrays.sort(enumConstants, Comparator.comparing(t -> t.getSortOrder()));
        return enumConstants;
    }
}
