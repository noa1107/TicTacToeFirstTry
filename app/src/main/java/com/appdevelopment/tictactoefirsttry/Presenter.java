package com.appdevelopment.tictactoefirsttry;

public class Presenter
{
    private Model model;
    private IView view;
    private int currentPlayer=1;
    public Presenter(IView view)
    {
        model = new Model();
        this.view = view;
    }

    public void moveFromUser(int row, int col)
    {
        if(model.isLegal(row,col))
        {
            model.doMove(row,col,currentPlayer);
            view.updateView(row,col,currentPlayer);
            Constants.GAME_STATUS status = model.checkWin();
            if(status == Constants.GAME_STATUS.WIN)
                view.displayMessage("WIN, to play again click start");

            else if (status == Constants.GAME_STATUS.TIE)
                view.displayMessage("to play again click start");

        }
    }




}
