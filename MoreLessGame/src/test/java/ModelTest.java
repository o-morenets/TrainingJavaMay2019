import model.Model;
import org.junit.Before;
import org.junit.Test;
import view.GlobalConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by o-morenets on 29.05.2019.
 */
public class ModelTest {

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new Model();
    }

    @Test
    public void checkValue() throws Exception {
        assertTrue(model.isNumberGuessed(model.getSecretValue()));
        assertFalse(model.isNumberGuessed(model.getSecretValue() + 1));
        assertTrue(model.getStatistics().contains(model.getSecretValue() + 1));
        assertTrue(model.getStatistics().contains(model.getSecretValue()));
    }

    @Test
    public void setPrimaryBarrier() throws Exception {
        model.setInitialBarriers(GlobalConstants.MIN_BARRIER, GlobalConstants.MAX_BARRIER);
        assertEquals(GlobalConstants.MIN_BARRIER, model.getMinBarrier());
        assertEquals(GlobalConstants.MAX_BARRIER, model.getMaxBarrier());
    }

    @Test
    public void setSecretValue() throws Exception {
        model.setMinBarrier(GlobalConstants.MIN_BARRIER);
        model.setMaxBarrier(GlobalConstants.MAX_BARRIER);
        for (int i = 0; i < 1_000_000; i++) {
            model.setSecretNumber();
            assertTrue(model.getSecretValue() > model.getMinBarrier()
                    && model.getSecretValue() < model.getMaxBarrier());
        }
    }

}