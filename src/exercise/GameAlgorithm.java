package exercise;

import util.Algorithm;
import util.Prompt;

import java.util.Arrays;

public abstract class GameAlgorithm extends Algorithm {

    static public class GameAlgorithmErrorException extends Exception {

        // Overwrite again in DynamicGame to also output correct Solution
        public GameAlgorithmErrorException(int id, String name, int[] instance, int theirs, int correct) {
            super(Prompt.getErrorMessage(
                    "\nInstance "  + id + " with " + name + " not correctly solved!" +
                    "\nInstance: " + Arrays.toString(instance) +
                    "\nYour Solution:" + theirs +
                    "\nCorrect: " + correct)
            );
        }
    }
}
