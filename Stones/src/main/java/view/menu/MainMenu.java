package view.menu;

public enum MainMenu implements ISortedMenu {

    ITEM_EXIT(999, "menu.item.exit"),
    ITEM_CREATE_NEW_RIVIERE(1, "menu.item.createNewRiviere"),
    ITEM_ADD_STONE(2, "menu.item.addStone"),
    ITEM_PRINT_RIVIERE(3, "menu.item.printRiviere"),
    ITEM_SORT_STONES(4, "menu.item.sortStones"),
    ITEM_FILTER_BY_TRANSPARENCY_RANGE(5, "menu.item.filterByTransparencyRange"),
    ITEM_CHANGE_LANGUAGE(10, "menu.item.changeLanguage");

    private int sortOrder;
    private String bundleKey;

    MainMenu(int sortOrder, String bundleKey) {
        this.sortOrder = sortOrder;
        this.bundleKey = bundleKey;
    }

    @Override
    public int getSortOrder() {
        return sortOrder;
    }

    @Override
    public String toString() {
        return bundleKey;
    }
}
