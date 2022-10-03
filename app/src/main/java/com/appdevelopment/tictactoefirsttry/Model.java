package com.appdevelopment.tictactoefirsttry;

public class Model
{

    // תכונות
    private int[][]  board;
    private int numTurns;
    private final int ROWS = 3,COLS = 3;


    public Model()
    {
        this.numTurns = 0;
        this.board = new int[ROWS][COLS];
    }

    public boolean isLegal(int row,int col)
    {
        return numTurns<9 && this.board[row][col]==0;
    }
    public Constants.GAME_STATUS checkWin()
    {
        int val = board.length;
        int sumR0=0;
        int sumR1=0;
        int sumR2=0;
        int sumC0=0;
        int sumC1=0;
        int sumC2=0;
        int sumX1=0;
        int sumX2=0;

        for (int i = 0; i < val ; i++)
        {
            sumR0+=board[0][i];
            sumR1+=board[1][i];
            sumR2+=board[2][i];
            sumC0+=board[0][i];
            sumC1+=board[1][i];
            sumC2+=board[2][i];
            sumX1+=board[i][i];
            sumX2+=board[0][2]+board[1][1]+board[2][0];
        }
        if(sumC0==3||sumC1==3||sumC2==3||
                sumC0==-3||sumC1==-3||sumC2==-3||
                sumR0==3||sumR1==3||sumR2==3||
                sumR0==-3||sumR1==-3||sumR2==-3||
                sumX1==3||sumX2==3||sumX1==-3||sumX2==-3)
            return Constants.GAME_STATUS.WIN;
        return Constants.GAME_STATUS.TIE;

    }

    public void doMove(int row, int col, int player)
    {
        this.board[row][col] = player;
        this.numTurns++;
    }


}
