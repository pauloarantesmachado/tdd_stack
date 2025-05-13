package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder <T extends Number & Comparable<T>> {

    private List<T> numbers;

    public NumberAscOrder(CustomStack<T> customStack) throws StackEmptyException {
        this.numbers = new ArrayList<T>();
        while (!customStack.isEmpty()) {
            T number = customStack.pop();
            if(number != null){
                numbers.add(number);
            }
        }
    }

    public List<T> sort()
    {
        if(this.numbers.isEmpty()){
            throw new RuntimeException("List is null");
        }
        Collections.sort(this.numbers);
        return this.numbers;
    }
}
