package model.entity;

public enum Gemstone implements IGemstone {
    EMERALD(1.2, 1000.00, 65),
    RUBY(3.5, 3500.00, 70),
    DIAMOND(5.0, 5000.00, 100),
    SAPPHIRE(4.0, 1200.00, 80),
    TOPAZ(0.55, 200.00, 20),
    AGATE(0.9, 350.00, 45),
    ZIRCON(2.1, 540.00, 95),
    QUARTZ(3.5, 550.00, 50),
    AMBER(0.65, 120.00, 25),
    ONYX(2.5, 485.00, 85),
    CORAL(3.2, 365.00, 35);

    private double caratWeight;
    private double cost;
    private int transparency;

    Gemstone(double caratWeight, double cost, int transparency) {
        this.caratWeight = caratWeight;
        this.cost = cost;
        this.transparency = transparency;
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
}
