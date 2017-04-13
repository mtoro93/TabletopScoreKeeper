package com.example.android.tabletopscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eisat on 12/31/2016.
 */

public class SheriffScoreActivity extends AppCompatActivity {

    int[] goodsNames = new int[15];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheriff_score_layout);

        Bundle playerData = getIntent().getExtras();

        int numberOfPlayers = playerData.getInt("numberOfPlayers");
        int optionalGoodsIncluded = playerData.getInt("optionalGoods");
        ArrayList<String> playerNames = playerData.getStringArrayList("playerNames");

        Log.v("Players:", "" + numberOfPlayers);
        Log.v("Optional Goods", "" + optionalGoodsIncluded);
        for (int i = 0; i < numberOfPlayers; i++)
            Log.v("Player" + (i+1) + ": ", playerNames.get(i));

        final ArrayList<ScoreSheetRow> scores = new ArrayList<ScoreSheetRow>();

        // clear the list before adding elements, this prevents the list from expanding in case the user navigates backwards in the app
        scores.clear();

        ScoreSheetRow.setPlayerNames(playerNames);
        if (optionalGoodsIncluded == 1)
        {
            setAllGoodsNames();
            for (int i = 0; i < 15; i++)
                scores.add(new ScoreSheetRow(goodsNames[i]));
        }
        else
        {
            setGoodsNames();
            for (int i = 0; i < 8; i++)
                scores.add(new ScoreSheetRow(goodsNames[i]));
        }


        ScoreSheetRowAdapter adapter = new ScoreSheetRowAdapter(this, scores);

        ListView listView = (ListView) findViewById(R.id.sheriff_list);
        listView.setAdapter(adapter);
    }

    private void setGoodsNames()
    {
        goodsNames[0] = R.string.sheriff_apple;
        goodsNames[1] = R.string.sheriff_cheese;
        goodsNames[2] = R.string.sheriff_bread;
        goodsNames[3] = R.string.sheriff_chicken;
        goodsNames[4] = R.string.sheriff_pepper;
        goodsNames[5] = R.string.sheriff_mead;
        goodsNames[6] = R.string.sheriff_silk;
        goodsNames[7] = R.string.sheriff_crossbow;
    }

    private void setAllGoodsNames()
    {
        goodsNames[0] = R.string.sheriff_apple;
        goodsNames[1] = R.string.sheriff_cheese;
        goodsNames[2] = R.string.sheriff_bread;
        goodsNames[3] = R.string.sheriff_chicken;
        goodsNames[4] = R.string.sheriff_pepper;
        goodsNames[5] = R.string.sheriff_mead;
        goodsNames[6] = R.string.sheriff_silk;
        goodsNames[7] = R.string.sheriff_crossbow;
        goodsNames[8] = R.string.sheriff_bleu;
        goodsNames[9] = R.string.sheriff_golden;
        goodsNames[10] = R.string.sheriff_gouda;
        goodsNames[11] = R.string.sheriff_green;
        goodsNames[12] = R.string.sheriff_pumpernickel;
        goodsNames[13] = R.string.sheriff_royal;
        goodsNames[14] = R.string.sheriff_rye;
    }
}
