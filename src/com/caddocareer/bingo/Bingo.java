package com.caddocareer.bingo;

import javax.swing.*;

public class Bingo {
    private JPanel jPanel;
    private JLabel labelPlayer1;
    private JLabel labelPlayer2;
    private JLabel labelPlayer1Score;
    private JLabel labelPlayer2Score;
    private JPanel board;
    public BoardGraphics boardGraphics = new BoardGraphics();

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public Bingo()
    {
        board.add(boardGraphics);
    }
}
