package com.appdevelopment.tictactoefirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements IView
{

    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);

    }

    @Override
    public void updateView(int row, int col, int player)
    {
        String tag = ""+row+","+col;
        ConstraintLayout cl = findViewById(R.id.parentLayout);
        Button v = cl.findViewWithTag(tag);
        v.setText(player);
    }

    @Override
    public void displayMessage(String message)
    {

    }
    public void userMove(View view)
    {
        Button button = (Button)view;
        String s = button.getTag().toString();
        String[] res = s.split(",");
        int row = Integer.valueOf(res[0]); // s[0]
        int col = Integer.valueOf(res[1]); // s[1]
        presenter.moveFromUser(row,col);
    }
}