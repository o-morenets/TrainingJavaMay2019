/*
  Created by o-morenets on 29.05.2019.
 */

import model.Model;
import view.View;
import controller.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * This test class is using for test controller unit
 */
public class ControllerMockTest {

    @Mock
    private Model model;

    @Mock
    private View view;

    @Spy
    private Controller controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        controller.setModel(model);
        controller.setView(view);
    }

    @Test
    public void testUserInputs() {
        int[] answers = {-50, 150, -50, 150, 70, -45, 50};
        final Controller when = doAnswer(new Answer<Integer>() {
            private int count = 0;

            public Integer answer(InvocationOnMock invocation) {
                return answers[count++];
            }
        }).when(controller);
        when.inputValidIntValueInRange(any(), model.getMinBarrier(), model.getMaxBarrier());

        doNothing().when(controller).inputAndSetBarriers(any());

        when(model.getMinBarrier()).thenReturn(-50);
        when(model.getMaxBarrier()).thenReturn(150);
        when(model.getSecretValue()).thenReturn(-50);
        when(model.getMaxBarrier()).thenReturn(150);

        when(model.isNumberGuessed(70)).thenReturn(false);
        when(model.isNumberGuessed(-45)).thenReturn(false);
        when(model.isNumberGuessed(50)).thenReturn(true);

        when(model.getStatistics()).thenReturn(new ArrayList<>());

        controller.processUser();

        verify(view, times(1)).printMessage(anyString());
        verify(view).printStatistics(anyList());
    }

}