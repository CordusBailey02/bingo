package com.caddocareer;

import com.caddocareer.bingo.Bingo;
import com.caddocareer.bingo.BingoHome;
import com.caddocareer.bingo.Board;

import javax.swing.*;
import java.awt.*;

public class Main extends ConsoleProgram {

    public static JFrame frame = new JFrame();
    public static BingoHome bingoHome = new BingoHome();
    public static Bingo bingo = new Bingo();
    public static Board board = new Board();

    public static void main(String[] args)
    {
        frame.setTitle("Bingo");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setContentPane(bingoHome.getjPanel());
    }

}
