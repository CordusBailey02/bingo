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
    private static final int EASY = 25;
    private static final int NORMAL = 50;
    private static final int HARD = 75;
    private String[][] boardNums = new String[4][4];

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public String[][] getBoardNums() {
        return boardNums;
    }

    public BingoHome()
    {
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.setTitle("Bingo Game");
                Main.frame.setContentPane(Main.bingo.getjPanel());
                values(NORMAL);
                Main.frame.revalidate();
            }
        });
    }

    private void values(int diff)
    {
        int col = 0;
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                boardNums[j][col] = String.valueOf(Randomizer.nextInt(0, diff));
            }
            col++;
        }
        if(diff < 75)
        {
            boardNums[2][2] = "Free";
        }
    }
}
