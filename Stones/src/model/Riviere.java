package model;

import model.entity.IGemstone;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Riviere {

    private List<IGemstone> stones;

    public double totalCaratWeight() {
        return stones.stream().mapToDouble(IGemstone::getCaratWeight).sum();
    }

    public double totalCost() {
        return stones.stream().mapToDouble(IGemstone::getCost).sum();
    }

    public List<IGemstone> sortByCost() {
        return stones.stream().sorted(Comparator.comparing(IGemstone::getCost)).collect(Collectors.toList());
    }

    public List<IGemstone> findByTransparencyRange(int transparencyLow, int transparencyHigh) {
        return stones.stream()
                .filter(s -> s.getTransparency() >= transparencyLow && s.getTransparency() <= transparencyHigh)
                .collect(Collectors.toList());
    }

    // Getters & Setters

    public void setStones(List<IGemstone> stones) {
        this.stones = stones;
    }
}
