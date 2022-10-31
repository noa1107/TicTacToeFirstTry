package com.appdevelopment.tictactoefirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IView
{
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

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
        String tag = row+","+col;
        ConstraintLayout cl = findViewById(R.id.parentLayout);
        Button v = cl.findViewWithTag(tag);
        v.setText(player);
    }

    @Override
    public void displayMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
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

    public void startGame(View view)
    {
        ConstraintLayout cl = findViewById(R.id.parentLayout);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j <3 ; j++)
            {
                Button v = cl.findViewWithTag(i+","+j);
                v.setText("");
            }
        }
    }
}