package com.example.android.tabletopscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.GONE;

/**
 * Created by eisat on 12/31/2016.
 */

public class SheriffActivity extends AppCompatActivity {

    // initialized to 0 for exception catching; if 0, present a toast
    int mNumberOfPlayers = 0;
    // integer instead of bool for exception catching; 0 is false, 1 is true, -1 is unchecked
    int mOptionalGoodsIncluded = -1;

    TextView mPlayerNamesHeader;
    EditText mPlayerNames[] = new EditText[5];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheriff_layout);

        mPlayerNamesHeader = (TextView) findViewById(R.id.sheriff_player_names);
        mPlayerNames[0] = (EditText) findViewById(R.id.sheriff_player_one_name);
        mPlayerNames[1] = (EditText) findViewById(R.id.sheriff_player_two_name);
        mPlayerNames[2] = (EditText) findViewById(R.id.sheriff_player_three_name);
        mPlayerNames[3] = (EditText) findViewById(R.id.sheriff_player_four_name);
        mPlayerNames[4] = (EditText) findViewById(R.id.sheriff_player_five_name);
        playerNameVisibility(1);
    }

    public void players (View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.three_player_sheriff:
                if (checked)
                {
                    mNumberOfPlayers = 3;
                    playerNameVisibility(mNumberOfPlayers);
                }
                break;
            case R.id.four_player_sheriff:
                if (checked)
                {
                    mNumberOfPlayers = 4;
                    playerNameVisibility(mNumberOfPlayers);
                }
                break;
            case R.id.five_player_sheriff:
                if (checked)
                {
                    mNumberOfPlayers = 5;
                    playerNameVisibility(mNumberOfPlayers);
                }
                break;
        }
    }

    public void optionalGoods(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.optional_goods_included:
                if (checked)
                    mOptionalGoodsIncluded = 1;
                break;
            case R.id.optional_goods_not_included:
                if (checked)
                    mOptionalGoodsIncluded = 0;
                break;
        }
    }

    public void begin (View view)
    {
        if (mNumberOfPlayers == 0 || mOptionalGoodsIncluded == -1)
        {
            Toast.makeText(SheriffActivity.this, "Please check both options", Toast.LENGTH_LONG).show();
        }
        else
        {
            // create new intent to navigate to
            Intent scoreIntent = new Intent(SheriffActivity.this, SheriffScoreActivity.class);

            // create bundle to store info from this class and send to new activity
            Bundle playerData = new Bundle();
            // add data to bundle via a keyword and the value
            playerData.putInt("numberOfPlayers", mNumberOfPlayers);
            playerData.putInt("optionalGoods", mOptionalGoodsIncluded);

            ArrayList<String> playerNames = addPlayerNames(mNumberOfPlayers);
            playerData.putStringArrayList("playerNames", playerNames);

            // add the bundle to the intent
            scoreIntent.putExtras(playerData);
            startActivity(scoreIntent);
        }
    }

    private void playerNameVisibility(int choice)
    {
        switch (choice)
        {
            case 1:
                mPlayerNamesHeader.setVisibility(GONE);
                for (int i = 0; i < 5; i++)
                    mPlayerNames[i].setVisibility(GONE);
                break;
            case 3:
                mPlayerNamesHeader.setVisibility(View.VISIBLE);
                for (int i = 0; i < 3; i++)
                    mPlayerNames[i].setVisibility(View.VISIBLE);
                mPlayerNames[3].setVisibility(GONE);
                mPlayerNames[4].setVisibility(GONE);
                break;
            case 4:
                mPlayerNamesHeader.setVisibility(View.VISIBLE);
                for (int i = 0; i < 4; i++)
                    mPlayerNames[i].setVisibility(View.VISIBLE);
                mPlayerNames[4].setVisibility(GONE);
                break;
            case 5:
                mPlayerNamesHeader.setVisibility(View.VISIBLE);
                for (int i = 0; i < 5; i++)
                    mPlayerNames[i].setVisibility(View.VISIBLE);
                break;
        }
    }

    private ArrayList<String> addPlayerNames(int numberOfPlayers)
    {
        ArrayList<String> playerNames = new ArrayList<>();
        String names[] = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++)
            if (mPlayerNames[i].getText().toString().equals(""))
                names[i] = "P" + (i+1);
            else
                names[i] = mPlayerNames[i].getText().toString();

        for (int i = 0; i < numberOfPlayers; i++)
            playerNames.add(names[i]);

        return playerNames;
    }
}
