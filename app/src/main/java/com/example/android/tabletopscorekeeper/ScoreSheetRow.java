package com.example.android.tabletopscorekeeper;

import java.util.ArrayList;

/**
 * Created by eisat on 1/24/2017.
 */

public class ScoreSheetRow {

    private int mScoringItemName;

    static private ArrayList<String> mPlayerNames;
    ArrayList<String> mPlayerScores;


    public ScoreSheetRow(int scoreItemName)
    {
        mScoringItemName = scoreItemName;
    }

    public static void setPlayerNames (ArrayList<String> playerNames)
    {
        mPlayerNames = playerNames;
    }

    public int getScoringItemName()
    {
        return mScoringItemName;
    }

    public String getPlayerName(int index)
    {
        return mPlayerNames.get(index);
    }

    public int getNumPlayers()
    {
        return mPlayerNames.size();
    }

}
