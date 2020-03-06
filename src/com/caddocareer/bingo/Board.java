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
    }

    @Override
    public void paintComponent(Graphics g)
    {
        markSpot(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        drawGrid(g);

        displayNumbers(Main.bingoHome.getBoardNums(), g);
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

    private void displayNumbers(String[][] nums, Graphics g)
    {
        int row = 0;
        int x = 35;
        int y = 50;
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
//                g.drawString(String.valueOf(Main.bingoHome.getBoardNum(j, row)), x, y);
                JLabel spot = new JLabel(Main.bingoHome.getBoardNum(j, row))
                this.add(spot);
//                spot.set

                y += 90;
            }
            row++;
            x += 90;
            y = 50;
        }
    }

    public void markSpot(Graphics g, int x, int y)
    {
        g.setColor(Color.RED);
        g.drawOval(90 * , 70, 70, 70);
        g.fillOval(70, 70, 70, 70);
    }
}
