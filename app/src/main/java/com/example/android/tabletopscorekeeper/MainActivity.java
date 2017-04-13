package com.example.android.tabletopscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the sheriff view
        TextView sheriffView = (TextView) findViewById(R.id.sheriff);
        // set an on click listener to navigate to a new activity for that game
        sheriffView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create new intent and start sheriff activity
                Intent sheriffIntent = new Intent(MainActivity.this, SheriffActivity.class);
                startActivity(sheriffIntent);
            }
        });

        // Find the five tribes view
        TextView fiveTribesView = (TextView) findViewById(R.id.five_tribes);
        // set an on click listener to navigate to a new activity for that game
        fiveTribesView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // create new intent and start five tribes activity
                Intent fiveTribesIntent = new Intent(MainActivity.this, FiveTribesActivity.class);
                startActivity(fiveTribesIntent);
            }
        });

        // Find the sushi go view
        TextView sushiGoView = (TextView) findViewById(R.id.sushi_go);
        // set an on click listener to navigate to a new activity for that game
        sushiGoView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // create new intent and start sushi go activity
                Intent sushiGoIntent = new Intent(MainActivity.this, SushiGoActivity.class);
                startActivity(sushiGoIntent);
            }
        });
    }
}
