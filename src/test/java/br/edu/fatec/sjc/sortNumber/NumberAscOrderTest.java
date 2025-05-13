package br.edu.fatec.sjc.sortNumber;

import br.edu.fatec.sjc.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    private CustomStack<Double> stack;
    @Mock
    CalculableStrategy<Double> calculableStrategy;

    NumberAscOrder<Double> numberAscOrder;

    @BeforeEach
    public void setup() {
        stack = new CustomStack<>(6, calculableStrategy);
    }

    @Test
    public void sortNumberAsc() throws NoSuchFieldException, IllegalAccessException, StackEmptyException {
        List<Double> valores = Arrays.asList(1.3, 4.5, 1.2, 2.3, 8.9, 1.1);
        valores.forEach(e -> {
            try {
                when(calculableStrategy.calculateValue(e)).thenReturn(e);
                stack.push(e);
            } catch (StackFullException ex) {
                throw new RuntimeException(ex);
            }
        });
        numberAscOrder = new NumberAscOrder<>(stack);
        List<Double> resultado = numberAscOrder.sort();
        Assertions.assertEquals(resultado.get(0),valores.get(5));
        Assertions.assertEquals(resultado.get(5),valores.get(4));
    }

    @Test
    public void sortNumberAscListEmpty() throws StackEmptyException {
        numberAscOrder = new NumberAscOrder<>(stack);
        Assertions.assertThrows(RuntimeException.class, () -> numberAscOrder.sort());
    }
}
