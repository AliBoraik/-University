package Exercises.Queens_8;

public class Board {
    private int size;
    private int[][] field;

    public Board(int size) {
        this.size = size;
        field = new int[size][size];
    }
    public boolean tryQueen(int i){
        boolean result=false;
        for (int j = 0; j <size ; j++) {
            if (field[i][j]==0){
                setQueen(i,j);
                if (i==7){
                    result=true;
                }else {
                    if (!(result=tryQueen(i+1))){
                        resetQueen(i,j);
                    }
                }
                if (result){
                    break;
                }
            }
        }
        return result;
    }
    public void setQueen(int i, int j){
        for (int k = 0; k <size ; k++) {
            field[k][j]=1;
            field[i][k]=1;
            int foo;
            foo=j-i+k;
            if (foo>=0&&foo<size){
                field[k][foo]=1;
                foo=i+i-k;
            }
            if (foo>=0&&foo<size){
                field[k][foo]=1;
            }
            field[i][j]=-1;
        }
    }
    public void resetQueen(int i, int j){
        for (int k = 0; k <size ; k++) {
            field[k][j]=0;
            field[i][k]=0;
            int foo;
            foo=j-i+k;
            if (foo>=0&&foo<size){
                field[k][foo]=0;
                foo=i+i-k;
            }
            if (foo>=0&&foo<size){
                field[k][foo]=0;
            }
            field[i][j]=-0;
        }
    }
    public void play(){
        tryQueen(0);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 1) res += ".";
                else res += "Q";
            }
            res += "\n";
        }
        return res;
    }
}
