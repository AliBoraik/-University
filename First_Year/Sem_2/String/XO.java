package ru.kpfu.classwork.String;

public class XO {
    private final int[][] braid;
    private final int x=1;
    private final int o=2;
    private int xSteps=0;
    boolean gameOver=false;
    public XO(){
        braid=new int[3][3];
    }

    public void setX(int Row,int Column){
        if (braid[Row][Column] == 0) {
            braid[Row][Column] = this.x;
            xSteps++;
            string();
            if (xSteps>2){
                if (check(x)){
                    gameOver=true;
                    System.out.println("****** GAME OVER ******");
                }
            }
        }else {
            string();
        }
    }

    public void setY(int Row,int Column){
        if (braid[Row][Column]==0){
            braid[Row][Column]=o;
            string();
            if (xSteps>2){
                if (check(o)){
                    gameOver=true;
                    System.out.println("****** GAME OVER ******");
                }
            }
        }else {
            string();
        }
    }
    private void string() {
        for (int[] ints : braid) {
            for (int j = 0; j < braid.length; j++) {
                if (ints[j] == x) {
                    System.out.print("X ");
                } else {
                    if (ints[j] == o) {
                        System.out.print("O ");
                    } else
                        System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private boolean check(int x){
        // for columns
        boolean ch1=false;
        // for Rows
        boolean ch2=false;
        // for center
        boolean ch3=false;
        for (int i = 0,j=1; i < braid.length; i++,j++) {
            if (j< braid.length) {
                // columns
                if (braid[0][i] == braid[j][i] && braid[j][i] == braid[braid.length - 1][i]) {
                    ch1 = true;
                    break;
                }
                // Rows
                if (braid[i][0] == braid[i][j] && braid[i][j] == braid[i][braid.length - 1]) {
                    ch2 = true;
                    break;
                }
            }
        }
        // center
        if (braid[1][1]==x)
                ch3=((braid[0][0]==braid[1][1]&&braid[0][0]==braid[2][2])||(braid[0][2]==braid[1][1]&&braid[0][2]==braid[2][0]));
        return ch1 || ch2 || ch3;
    }


}