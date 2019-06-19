package model.entity;

import view.menu.ISortedMenu;

public enum Gemstone implements IGemstone, ISortedMenu {

    EMERALD(1.2, 1000.00, 65, "stone.emerald"),
    RUBY(3.5, 3500.00, 70, "stone.ruby"),
    DIAMOND(5.0, 5000.00, 100, "stone.diamond"),
    SAPPHIRE(4.0, 1200.00, 80, "stone.saphire"),
    TOPAZ(0.55, 200.00, 20, "stone.topaz"),
    AGATE(0.9, 350.00, 45, "stone.agate"),
    ZIRCON(2.1, 540.00, 95, "stone.zircon"),
    QUARTZ(3.5, 550.00, 50, "stone.quartz"),
    AMBER(0.65, 120.00, 25, "stone.amber"),
    ONYX(2.5, 485.00, 85, "stone.onyx"),
    CORAL(3.2, 365.00, 35, "stone.coral");

    public static final int SORT_NATURAL_ORDER = 0;

    private double caratWeight;
    private double cost;
    private int transparency;
    private String bundleKey;

    Gemstone(double caratWeight, double cost, int transparency, String bundleKey) {
        this.caratWeight = caratWeight;
        this.cost = cost;
        this.transparency = transparency;
        this.bundleKey = bundleKey;
    }

    @Override
    public double getCaratWeight() {
        return caratWeight;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public int getTransparency() {
        return transparency;
    }

    @Override
    public int getSortOrder() {
        return SORT_NATURAL_ORDER;
    }

    @Override
    public String toString() {
        return bundleKey;
    }
}
