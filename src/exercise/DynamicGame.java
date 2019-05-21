package exercise;

import java.util.ArrayList;
import java.util.Collections;

public class DynamicGame extends GameAlgorithm {

    @Override
    protected String name() {
        return "DynamicGame";
    }

    public long[] call(ArrayList<Integer> numbers) {
        Integer[] arr = new Integer[numbers.size()];
        arr = numbers.toArray(arr);

        //TIMING START
        long startTime = System.nanoTime();

        int res = Game.dynGame(arr);

        long elapsedTime = System.nanoTime() - startTime;
        //TIMING END

        numbers.clear();
        Collections.addAll(numbers, arr);
        long[] result = {elapsedTime, res};
        return result;
    }
}
