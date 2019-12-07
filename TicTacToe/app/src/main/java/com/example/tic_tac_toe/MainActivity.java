package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Gamestate Representation
    // 0 - X
    // 1 - O
    // 2 - NULL
    Boolean gameActive = true;
    int activePlayer = 0;
    int [] gameState = { 2, 2, 2, 2, 2, 2, 2, 2, 2,};
    int [][] winPositions= {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    public void playerTap(View view)
    {
        ImageView img = (ImageView)view;
        int tappedImg = Integer.parseInt(img.getTag().toString());

        if(!gameActive || (gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2
                && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2
                && gameState[7]!=2 && gameState[8]!=2))
        {
            gameReset(view);
        }
        if(gameState[tappedImg] == 2 && gameActive)
        {
            gameState[tappedImg] = activePlayer;
            img.setTranslationX(-1000f);
            if(activePlayer == 0)
            {
                img.setImageResource(R.drawable.x1);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap To Play");
            }
            else
            {
                img.setImageResource(R.drawable.o1);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X 's Turn Tap To Play");
            }
            img.animate().translationXBy(1000f).setDuration(300);
        }

        //check if player has won
        for(int[] winPosition : winPositions)
        {
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]]
                == gameState[winPosition[2]] && gameState[winPosition[0]]!= 2)
            {
                //someone has win the game !!
                //Find out who is win !!
                String winstr;
                gameActive = false;
                if(gameState[winPosition[0]] == 0)
                {
                    winstr = "X has WON";
                }
                else
                {
                    winstr = "O has WON";
                }
                //Display the winner on statusbar(textview)
                TextView status = findViewById(R.id.status);
                status.setText(winstr);
            }

        }

    }


    public  void gameReset(View view)
    {
        gameActive = true;
        activePlayer = 0;
        for(int i = 0 ;i <gameState.length ; i++)
        {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X 's Turn Tap To Play");
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
