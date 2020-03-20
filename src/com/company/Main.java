package com.company;

import javax.swing.*;

public class Main extends ConsoleProgram {

    public static JFrame frame = new JFrame();
    public static Bingo bingo = new Bingo();
    public static BingoHome bingoHome = new BingoHome();

    public void run()
    {
        frame.setTitle("Bingo");
        frame.setVisible(true);
        frame.setSize(650, 755);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(bingoHome.getjPanel());


    }
}


