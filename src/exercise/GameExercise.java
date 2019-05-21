package exercise;

import util.Exercise;
import util.Prompt;
import util.Solution;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class GameExercise extends Exercise {

    public GameExercise(Path instancesBase_P, Path solutionsBase_P) {
        setInstancesBase(instancesBase_P);
        setSolutionsBase(solutionsBase_P);
    }

    @Override
    public String name() {
        return "DynamicGame";
    }

    @Override
    public void run() throws IOException {
        GameSolution sol = new GameSolution();
        this.<GameSolution>promptInstances(sol, instancesBase, solutionsBase, ".csv");
    }

    @Override
    protected void runWithFile(BufferedReader reader, Solution sol) throws IOException, GameAlgorithm.GameAlgorithmErrorException {
        GameSolution gameSol = (GameSolution) sol;

        if(!Game.NAIVE_GAME_IS_IMPLEMENTED)
            System.out.println("Warning: naiveGame() marked as not implemented!");

        if(!Game.GAME_IS_IMPLEMENTED)
            System.out.println("Warning: game() marked as not implemented!");

        int numInstances = Integer.parseInt(reader.readLine());
        System.out.println("Simulating Games... ");

        for(String line = reader.readLine(); line != null; line = reader.readLine()) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            String[] splitted = line.split(",");
            int id = Integer.parseInt(splitted[0]);
            String seqType = splitted[1];

            int target = Integer.parseInt(splitted[splitted.length-1]);
            int[] sequence = new int[splitted.length-3];
            int i = 0;

            for(String number : Arrays.copyOfRange(splitted, 2, splitted.length-1)) {
                numbers.add(Integer.parseInt(number));
                sequence[i++] = Integer.parseInt(number);
            }

            switch(seqType){
                case "Big":
                    System.out.println("Playing Round " + id + "/" + numInstances);
                    break;

                case "Abgabe":
                    if(id % 5 == 0)
                        System.out.println("Playing Round " + id + "/" + numInstances);
                    break;

                case "Debug":
                    if(id % 10 == 0)
                        System.out.println("Playing Round " + id + "/" + numInstances);
                    break;

                default:
                    if(id % 50 == 0)
                        System.out.println("Playing Round " + id + "/" + numInstances);
                    break;


            }

            if(Game.NAIVE_GAME_IS_IMPLEMENTED) {
                if (!playGameNaively(id, seqType, target, numbers, gameSol)) {

                    throw new GameAlgorithm.GameAlgorithmErrorException(id, "naiveGame", sequence, gameSol.solutionToInteger(gameSol.numSolutions() - 1), target);
                }
            }

            if(Game.GAME_IS_IMPLEMENTED) {
                if (!playGame(id, seqType, target, numbers, gameSol)) {
                    throw new GameAlgorithm.GameAlgorithmErrorException(id, "dynGame", sequence, gameSol.solutionToInteger(gameSol.numSolutions() - 1), target);
                }
            }
        }

        if(Game.GAME_IS_IMPLEMENTED || Game.NAIVE_GAME_IS_IMPLEMENTED) {
            System.out.println(Prompt.getSuccessMessage("All Rounds correctly calculated!"));
            System.out.print("\n");
        }
        else {
            System.out.println(Prompt.getErrorMessage("Both Algorithms are not marked as implemented! Output is empty!"));
            System.out.print("\n");
        }
    }

    private boolean playGame(int id, String seqType, int target, ArrayList<Integer> numbers, GameSolution sol) throws IOException {

        DynamicGame dynamicGame = new DynamicGame();

        long[] timeResult = dynamicGame.call(numbers);

        ArrayList<Integer> correctSolution = new ArrayList<Integer>();
        ArrayList<Integer> theirSolution = new ArrayList<Integer>();
        theirSolution.add(0, (int)timeResult[1]);
        correctSolution.add(0, target);
        theirSolution.add(1, numbers.size());
        correctSolution.add(1, numbers.size());

        return sol.addSolution(id, dynamicGame.name(), seqType, timeResult[0], theirSolution, correctSolution);
    }

    private boolean playGameNaively(int id, String seqType, int target, ArrayList<Integer> numbers, GameSolution sol) {

        NaiveGame game = new NaiveGame();

        long[] timeResult = game.call(numbers);

        ArrayList<Integer> correctSolution = new ArrayList<Integer>();
        ArrayList<Integer> theirSolution = new ArrayList<Integer>();
        theirSolution.add(0, (int)timeResult[1]);
        correctSolution.add(0, target);
        theirSolution.add(1, numbers.size());
        correctSolution.add(1, numbers.size());

        return sol.addSolution(id, game.name(), seqType, timeResult[0], theirSolution, correctSolution);
    }
}
