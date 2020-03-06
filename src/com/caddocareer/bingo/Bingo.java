package com.caddocareer.bingo;

import com.caddocareer.Main;
import com.caddocareer.Randomizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class Bingo {
    private JPanel jPanel;
    private JPanel board;
    private JButton buttonPlay;
    private JLabel labelChosenNum;
    private JButton button1;
    public Board boardGraphics = new Board();
    private static boolean[][] tracker = new boolean[5][5];

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public Bingo()
    {
        board.add(boardGraphics);
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(Arrays.deepToString(Main.bingoHome.getBoardNums()));
                labelChosenNum.setText(chooseNum((String) Objects.requireNonNull(Main.bingoHome.getComboBoxDiff().getSelectedItem())));
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkMatch();
                System.out.println(Arrays.deepToString(Main.bingoHome.getBoardNums()));
                System.out.println(Arrays.deepToString(tracker));
            }
        });
    }

    int colNum;
    int boxNum;
    private String chooseNum(String diff)
    {
        //Chooses Number That Will Have To Big In The Box
        colNum = Randomizer.nextInt(0, 4);
        String col;
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
        boxNum = Randomizer.nextInt(0, difficulty);

        //Chooses Which Column(B, I, N, G, O) The Number Has To Be In
        if(colNum == 0) {
            col = "B";
        }
        else if(colNum == 1) {
            col = "I";
        }
        else if(colNum == 2) {
            col = "N";
        }
        else if(colNum == 3) {
            col = "G";
        }
        else
        {
            col = "O";
        }
        return col + " " + boxNum;
    }

    private void checkMatch()
    {
        for(int i = 0; i < 5; i++)
        {
            int row = Integer.parseInt(Main.bingoHome.getBoardNum(colNum, i));
            if(boxNum == row)
            {
                tracker[colNum][i] = true;
            }
        }
    }


}
