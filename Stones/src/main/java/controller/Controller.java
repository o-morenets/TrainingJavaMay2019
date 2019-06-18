package controller;

import model.Riviere;
import model.entity.Gemstone;
import model.entity.IGemstone;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private final Riviere model;
    private final View view;

    public Controller(Riviere model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        model.setStones(selectStones());
        double totalCaratWeight = model.totalCaratWeight();
        view.printMessage(totalCaratWeight);
        double totalCost = model.totalCost();
        view.printMessage(totalCost);
        List<IGemstone> stonesSortedByCost = model.sortByCost();
        view.printMessage(stonesSortedByCost);
        List<IGemstone> stonesByTransparencyRange = model.findByTransparencyRange(55, 95);
        view.printMessage(stonesByTransparencyRange);
    }

    private List<IGemstone> selectStones() {
        return new ArrayList<IGemstone>() {
            {
                addAll(Arrays.asList(
                        Gemstone.RUBY,
                        Gemstone.SAPPHIRE,
                        Gemstone.ZIRCON,
                        Gemstone.AMBER,
                        Gemstone.QUARTZ,
                        Gemstone.ONYX,
                        Gemstone.QUARTZ,
                        Gemstone.DIAMOND,
                        Gemstone.CORAL,
                        Gemstone.EMERALD,
                        Gemstone.TOPAZ,
                        Gemstone.AGATE)
                );
            }
        };
    }
}
