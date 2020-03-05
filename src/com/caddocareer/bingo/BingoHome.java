package com.caddocareer.bingo;

import com.caddocareer.Main;
import com.caddocareer.Randomizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class BingoHome {
    private JPanel jPanel;
    private JButton startGameButton;
    private JComboBox comboBoxDiff;
    private String[][] boardNums = new String[5][5];

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public String[][] getBoardNums()
    {
        return boardNums;
    }

    public String getBoardNum(int row, int column) {
        return boardNums[row][column];
    }

    public BingoHome()
    {
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.setTitle("Bingo Game");
                Main.frame.setContentPane(Main.bingo.getjPanel());
                values(String.valueOf(comboBoxDiff.getSelectedItem()));
                Main.frame.revalidate();
            }
        });
    }

    private void values(String diff)
    {
        int difficulty;
        if(diff.equalsIgnoreCase("easy"))
        {
            difficulty = 25;
        }
        else if(diff.equalsIgnoreCase("normal"))
        {
            difficulty = 50;
        }
        else
        {
            difficulty = 75;
        }
        int row = 0;
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                boardNums[j][row] = String.valueOf(Randomizer.nextInt(0, difficulty));
            }
            row++;
        }
        if(difficulty < 75)
        {
            boardNums[2][2] = "Free";
        }
    }
}
