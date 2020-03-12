package com.caddocareer.bingo;

import com.caddocareer.Main;
import com.caddocareer.Randomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.PaintEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.Objects;

public class Bingo {
    private JPanel jPanel;
    private JPanel board;
    private JButton buttonPlay;
    private JLabel labelChosenNum;
    private JButton button1;
    private static boolean[][] tracker = new boolean[5][5];
    public Board boardGraph = new Board();
    int colSelectCord = 0;
    int rowSelectCord = 0;

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public Bingo()
    {
        board.add(boardGraph);

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
                int x = 120;
                int y = 120;
//                public void mouseClicked(MouseEvent e) {
//                    x = e.getX();
//                    y = e.getY();
                    int xCord = 90;
                    int yCord = 90;

                    for(int i = 0; i < 5; i++)
                    {
                        for(int j = 0; j < 5; j++) {
                            if ((x > xCord && x < xCord * 2) && (y < yCord && y > yCord * 2)) {
                                checkMatch();
                            }
                            xCord += 90;
                            colSelectCord++;
                        }
                        yCord += 90;
                        rowSelectCord++;
                    }
//                }
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
            if(Integer.parseInt(Main.bingoHome.getBoardNum(colSelectCord, rowSelectCord)) == Integer.parseInt(Main.bingoHome.getBoardNum(colNum, i)))
            {
                tracker[colNum][i] = true;
//                Main.board.markSpot(Main.board.getXCord(colNum), Main.board.getYCord(i));
                Main.board.markSpot(70, 70);
            }
        }
    }
}
