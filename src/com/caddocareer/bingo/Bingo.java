package com.caddocareer.bingo;

import com.caddocareer.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Bingo {
    private JPanel jPanel;
    private JLabel labelPlayer1;
    private JLabel labelPlayer2;
    private JLabel labelPlayer1Score;
    private JLabel labelPlayer2Score;
    private JPanel board;
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(Arrays.deepToString(Main.bingoHome.getBoardNums()));
            }
        });
    }

//    private void checkMatch()
//    {
//        for(int i = 0; i < 25; i++)
//        {
//
//        }
//    }


}
