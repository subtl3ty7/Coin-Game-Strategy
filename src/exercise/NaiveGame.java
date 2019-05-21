package exercise;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Soeren on 22.04.2018.
 */
public class NaiveGame extends GameAlgorithm {

    @Override
    protected String name() {
        return "Naive Game";
    }

    public long[] call(ArrayList<Integer> numbers) {
        Integer[] arr = new Integer[numbers.size()];
        arr = numbers.toArray(arr);

        //TIMING START
        long startTime = System.nanoTime();

        int res = Game.naiveGame(arr);

        long elapsedTime = System.nanoTime() - startTime;
        //TIMING END

        numbers.clear();
        Collections.addAll(numbers, arr);
        long[] result = {elapsedTime, res};
        return result;
    }
}
