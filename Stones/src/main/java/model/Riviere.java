package model;

import model.entity.IGemstone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Riviere {

    /** List to store gemstones */
    private List<IGemstone> stones = new ArrayList<>();

    /**
     * Creates new riviere by clearing the list of gemstones
     */
    public void createNewRiviere() {
        stones.clear();
    }

    /**
     * Calculates total carat weight of gemstones
     *
     * @return total carat weight of gemstones
     */
    public double totalCaratWeight() {
        return stones.stream()
                .mapToDouble(IGemstone::getCaratWeight)
                .sum();
    }

    /**
     * Calculates total cost of all gemstones

     * @return total cost of all gemstones
     */
    public double totalCost() {
        return stones.stream()
                .mapToDouble(IGemstone::getCost)
                .sum();
    }

    /**
     * Returns gemstones sorted by their price (most expensive goes first)
     *
     * @return sorted list of gemstones
     */
    public List<IGemstone> sortByCost() {
        return stones.stream()
                .sorted(Comparator.comparing(IGemstone::getCost).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Filters gemstones by their transparency property
     *
     * @param transparencyLow  transparency low bound
     * @param transparencyHigh transparency hi bound

     * @return list of gemstones filtered by their transparency
     */
    public List<IGemstone> findByTransparencyRange(int transparencyLow, int transparencyHigh) {
        return stones.stream()
                .filter(s -> s.getTransparency() >= transparencyLow && s.getTransparency() <= transparencyHigh)
                .collect(Collectors.toList());
    }

    /**
     * Adds stone to list
     *
     * @param stone stone to be added
     */
    public void addStone(IGemstone stone) {
        stones.add(stone);
    }

    // Getters & Setters

    public List<IGemstone> getStones() {
        return stones;
    }
}
