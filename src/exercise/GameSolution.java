package exercise;

import util.Solution;

import java.util.ArrayList;

public class GameSolution extends Solution<ArrayList<Integer>> {

    // Expect in values and solutions the actual answer (Maxnumber) at index 0, instance-stuff later

    @Override
    public boolean check(ArrayList<Integer> values, ArrayList<Integer> solution) {
        int theirs = values.get(0);
        int correct = solution.get(0);
        if(theirs != correct) {
            return false;
        }
        return true;
    }

/*  Will be needed later for correct visualization*/

    @Override
    public String header() {
        String head = super.header();
        head += delim + "elements";
        return head;
    }

    @Override
    public String line(Integer i) {
        String l = super.line(i);
        l += delim;
        l += solutions.get(i).get(1);

        return l;
    }

    @Override
    public String solutionToString(int id) {
        ArrayList<Integer> solution = solutions.get(id);
        return solution.get(0).toString();
    }

    public int solutionToInteger(int id) {
        ArrayList<Integer> solution = solutions.get(id);
        return solution.get(0);
    }
}
