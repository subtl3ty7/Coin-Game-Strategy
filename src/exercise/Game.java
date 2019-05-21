package exercise;


public class Game {
    public static final boolean NAIVE_GAME_IS_IMPLEMENTED = true;
    public static final boolean GAME_IS_IMPLEMENTED = true;



    public static int naiveGame(Integer[] bowls) {
        return rekursiveMethod(0,bowls.length-1,bowls);
    }

   static int rekursiveMethod(int i,int j,Integer[] bowls){
        if (j==i){
            return bowls[i];
        }
        if(j==i+1){
            return Math.max(bowls[i],bowls[j]);
        }
       return Math.max(bowls[i]+Math.min(rekursiveMethod(i+2,j,bowls),rekursiveMethod(i+1,j-1,bowls)),bowls[j]+Math.min(rekursiveMethod(i+1,j-1,bowls),rekursiveMethod(i,j-2,bowls)));


    }


    public static int dynGame(Integer[] bowls) {

        int storagearray[][] = new int[bowls.length][bowls.length];
        int help, i, j, a, b, c;
        for (help = 0; help < bowls.length; ++help)
        {
            for (i = 0, j = help; j < bowls.length; ++i, ++j)
            {
                if((i + 2) <= j){
                    a = storagearray[i + 2][j];
                } else a = 0;
                if((i + 1) <= (j - 1)){
                    b= storagearray[i +1][j -  1];
                } else b = 0;
                if(i <= (j - 2)){
                    c= storagearray[i][j -  2];
                } else c = 0;

                storagearray[i][j] = Math.max(bowls[i] +
                        Math.min(a, b), bowls[j] +
                        Math.min(b, c));
            }
        }

        return storagearray[0][bowls.length - 1];
    }
}
