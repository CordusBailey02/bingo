package com.caddocareer.bingo;

import com.caddocareer.Main;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public Board()
    {
        super();
        setVisible(true);
        setPreferredSize(new Dimension(450,450));
        setMinimumSize(new Dimension(450,450));

        displayNumbers(Main.bingoHome.getBoardNums());
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        drawGrid(g);

        //Draws Free Spot
        g.drawString("Free", 210, 225);
        g.drawString("Free", 35, 50);
    }

    public void drawGrid(Graphics g)
    {
        int num = 90;
        for(int i = 0; i < 4; i++)
        {
            //Draws Columns
            g.drawLine(num, 0, num, 450);

            //Draws Rows
            g.drawLine(0, num, 450, num);

            num += 90;
        }
    }

    private void displayNumbers(String[][] nums)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {

            }
        }
    }
}
