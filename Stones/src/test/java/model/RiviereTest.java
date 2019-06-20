package model;

import model.entity.Gemstone;
import model.entity.IGemstone;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RiviereTest {

    private static final double DELTA = 0.0001;
    private static final int LO_TRANSPARENCY_RANGE = 50;
    private static final int HI_TRANSPARENCY_RANGE = 95;

    private Riviere riviere;
    private double expectedTotalCost;
    private double expectedTotalCaratWeight;
    private List<IGemstone> expectedSortedList;
    private List<IGemstone> expectedFilteredList;

    @Before
    public void setUp() {
        riviere = new Riviere();
        riviere.addStone(Gemstone.ZIRCON);  // caratWeight = 2.1, cost =  540, transparency =  95
        riviere.addStone(Gemstone.DIAMOND); // caratWeight = 5.0, cost = 5000, transparency = 100
        riviere.addStone(Gemstone.RUBY);    // caratWeight = 3.5, cost = 3500, transparency = 70
        riviere.addStone(Gemstone.AGATE);   // caratWeight = 0.9, cost =  350, transparency = 45
        riviere.addStone(Gemstone.QUARTZ);  // caratWeight = 3.5, cost =  550, transparency = 50

        expectedTotalCost = 9940.0;
        expectedTotalCaratWeight = 15.0;

        expectedSortedList = Arrays.asList(
                Gemstone.DIAMOND,
                Gemstone.RUBY,
                Gemstone.QUARTZ,
                Gemstone.ZIRCON,
                Gemstone.AGATE
        );

        expectedFilteredList = Arrays.asList(
                Gemstone.ZIRCON,
                Gemstone.RUBY,
                Gemstone.QUARTZ
        );
    }

    @Test
    public void totalCaratWeight() {
        assertEquals(expectedTotalCaratWeight, riviere.totalCaratWeight(), DELTA);
    }

    @Test
    public void totalCost() {
        assertEquals(expectedTotalCost, riviere.totalCost(), DELTA);
    }

    @Test
    public void sortByCost() {
        assertEquals(expectedSortedList, riviere.sortByCost());
    }

    @Test
    public void findByTransparencyRange() {
        assertEquals(expectedFilteredList, riviere.findByTransparencyRange(LO_TRANSPARENCY_RANGE, HI_TRANSPARENCY_RANGE));
    }
}