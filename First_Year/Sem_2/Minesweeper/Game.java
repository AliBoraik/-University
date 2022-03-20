package Minesweeper;


public class Game {
    // matrix for the random bombs
    private final int[][] board;
    // matrix for display
    private final String[][] show;
    // Matrix of number of adjacent bombs
    private final int[][] bombs;
    // If the player chooses a bomb, it is true
    public boolean gameOver=false;
    // To choose the difficulty level of the game
    public int hard=4;
    //To calculate the number of bombs per item
    private int bomb=0;
    public Game(int length,int width){
        board=new int[length][width];
        show=new String[length][width];
        bombs=new int[length][width];
        PutTheBombs();

    }
    public void play(int l,int w){
        if (board[l][w]==-1){
            bomb(l,w);
        }else {
            notBomb(l,w);
            showTheBoard();
        }
    }
    // this method if the element has bomb
    private void bomb(int l,int w) {
        show[l][w] = "B";
        this.gameOver=true;
        showTheBoard();
        System.out.println("*******  Game Over *******");
    }
    // also if the element not has bomb we need check the neighbors of the element
    private void notBomb(int l,int w) {
        if (board[l][w]==0) {
            board[l][w] = -2;
            show[l][w] = "-";
            for (int i = l - 1; i <= l + 1; i++) {
                if (i >= 0 && i < show.length) {
                    for (int j = w - 1; j <= w + 1; j++) {
                        if (j >= 0 && j < show[0].length) {
                            if (neighbors(i, j)) {
                                openTheBox(i, j);
                                notBomb(i, j);
                            }
                        }
                    }
                }
            }
        }
    }
    // Check neighbors neighbors
    private boolean neighbors(int x,int y){
        boolean a=false;
        for (int i =x-1; i <=x+1 ; i++) {
            if (i>=0&&i< show.length) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j >= 0 && j < show[0].length) {
                        if (board[i][j]!=-1){
                            a=true;
                        }else {
                            if (bombs[x][y]>0){
                                return false;
                            }
                            bomb++;
                        }
                    }
                }
            }
        }
        //if the neighbors neighbors don have bombs method openTheBox opens a box
        if (bomb>0){

            bombs[x][y]=bomb;
            bomb=0;
            return false;
        }
        return a;
    }
    private void openTheBox(int x,int y){
        for (int i =x-1; i <=x+1 ; i++) {
            if (i >= 0&&i< show.length) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j >= 0 && j < show[0].length) {
                           show[i][j]="-";
                        }
                    }
                }
            }
        }
    public void showTheBoard(){
        for (int i = 0; i <show.length ; i++) {
            for (int j = 0; j <show[0].length ; j++) {
                neighboringBombs(i,j);
            }
            System.out.println();
        }
    }
    private void neighboringBombs(int x, int y) {
        if (show[x][y].equals("#")||board[x][y]==-1){
            System.out.print(show[x][y]+" ");
            return;
        }
        for (int i =x-1; i <=x+1 ; i++) {
            if (i >= 0 && i < show.length) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j >= 0 && j < show[0].length) {
                        if (show[i][j].equals("#")) {
                            System.out.print(bombs[x][y]+" ");
                            return;
                        }
                    }
                }
            }
        }
        System.out.print(show[x][y]+" ");
    }
    private void PutTheBombs(){
        // put the bombs is array board (random)
        for (int i = 0; i < board.length ; i++) {
            int n=0;
            while (n!=hard){
                randomBomb(i);
                n++;
            }
        }
        // Supply Matrix Display
        for (int i = 0; i <show.length ; i++) {
            for (int j = 0; j < show[0].length; j++) {
                show[i][j] = "#";
            }
        }
    }
    private void randomBomb(int i){
        int h=(int)(Math.random()* board[0].length);
        while (h>=board[0].length){
            h=(int)(Math.random()* board.length);
        }
        board[i][h]=-1;
    }
}