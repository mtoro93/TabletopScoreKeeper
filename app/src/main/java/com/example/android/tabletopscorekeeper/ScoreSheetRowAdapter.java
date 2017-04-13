package com.example.android.tabletopscorekeeper;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat on 1/24/2017.
 */

public class ScoreSheetRowAdapter extends ArrayAdapter<ScoreSheetRow>{

    public ScoreSheetRowAdapter (Activity context, ArrayList<ScoreSheetRow> scores)
    {
        super(context, 0 , scores);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.sheriff_score_list_item, parent, false);
        }

        ScoreSheetRow currentScoreSheet = getItem(position);

        TextView scoringItem = (TextView) listItemView.findViewById(R.id.sheriff_scoring_item);
        scoringItem.setText(currentScoreSheet.getScoringItemName());

        TextView playerOneName = (TextView) listItemView.findViewById(R.id.player_one_name_sheriff);
        playerOneName.setText(currentScoreSheet.getPlayerName(0));

        TextView playerTwoName = (TextView) listItemView.findViewById(R.id.player_two_name_sheriff);
        playerTwoName.setText(currentScoreSheet.getPlayerName(1));

        TextView playerThreeName = (TextView) listItemView.findViewById(R.id.player_three_name_sheriff);
        TextView playerFourName = (TextView) listItemView.findViewById(R.id.player_four_name_sheriff);
        EditText playerFourScore = (EditText) listItemView.findViewById(R.id.player_four_score_sheriff);
        TextView playerFiveName = (TextView) listItemView.findViewById(R.id.player_five_name_sheriff);
        EditText playerFiveScore = (EditText) listItemView.findViewById(R.id.player_five_score_sheriff);

        int numberPlayers = currentScoreSheet.getNumPlayers();

        if (numberPlayers == 3)
        {
            playerThreeName.setText(currentScoreSheet.getPlayerName(2));
            playerFourName.setVisibility(View.GONE);
            playerFourScore.setVisibility(View.GONE);
            playerFiveName.setVisibility(View.GONE);
            playerFiveScore.setVisibility(View.GONE);
        }
        else if (numberPlayers == 4)
        {
            playerFourName.setVisibility(View.VISIBLE);
            playerFourScore.setVisibility(View.VISIBLE);
            playerFourName.setText(currentScoreSheet.getPlayerName(3));
            playerFiveName.setVisibility(View.GONE);
            playerFiveScore.setVisibility(View.GONE);
        }
        else if (numberPlayers == 5)
        {
            playerFourName.setVisibility(View.VISIBLE);
            playerFiveName.setVisibility(View.VISIBLE);
            playerFourScore.setVisibility(View.VISIBLE);
            playerFiveScore.setVisibility(View.VISIBLE);
            playerFourName.setText(currentScoreSheet.getPlayerName(3));
            playerFiveName.setText(currentScoreSheet.getPlayerName(4));
        }

        return listItemView;
    }
}
