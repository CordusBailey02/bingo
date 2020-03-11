package com.caddocareer.bingo;

import com.caddocareer.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private ArrayList<Integer> xs = new ArrayList<Integer>();
    private ArrayList<Integer> ys = new ArrayList<Integer>();

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
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        drawGrid(g);

        displayNumbers(Main.bingoHome.getBoardNums(), g);

        markSpot(g, xs.get(0), ys.get(1));
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
                g.drawString(String.valueOf(Main.bingoHome.getBoardNum(j, row)), x, y);
                xs.add(x);
                ys.add(y);
                y += 90;
            }
            row++;
            x += 90;
            y = 50;
        }
    }

    public int getXCord(int column)
    {
        return xs.get(column);
    }

    public int getYCord(int row)
    {
        return ys.get(row);
    }

    public void markSpot(Graphics g, int x, int y)
    {
        g.setColor(Color.RED);
        g.fillOval(x - 25, y - 40, 70, 70);
    }
}
