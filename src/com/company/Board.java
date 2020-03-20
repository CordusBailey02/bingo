package com.company;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private String[][] boardNums = new String[5][5];
    private boolean[][] tracker = new boolean[5][5];
    private int difficulty;
    private int[][] xs = new int[5][5];
    private int[][] ys = new int[5][5];

    public String getBoardNums(int col, int row)
    {
        return boardNums[col][row];
    }
    public void setTracker(int col, int row, boolean value)
    {
        tracker[col][row] = value;
    }
    public boolean getTracker(int col, int row) { return tracker[col][row]; }
    public int getNumXCord(int col, int row) { return xs[col][row]; }
    public int getNumYCord(int col, int row) { return ys[col][row]; }

    public Board()
    {
        super();
        setVisible(true);
        setPreferredSize(new Dimension(500,600));
        setMinimumSize(new Dimension(500,600));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(0, 75, getWidth() - 1, getHeight() - 101);

        drawGrid(g);

        header(g);

        createBoardNums(String.valueOf(Main.bingoHome.comboBoxDiff.getSelectedItem()));
        displayNums(boardNums, g);
    }

    //Draws Board Grid
    private void drawGrid(Graphics g)
    {
        int num = 100;
        for(int i = 0; i < 4; i++)
        {
            //Draws Columns
            g.drawLine(num, 75, num, 575);

            //Draws Rows
            g.drawLine(0, num + 75, 500, num + 75);
            num += 100;
        }
    }

    //Generates Numbers Based on difficulty
    public void createBoardNums(String diff)
    {
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
        for(int col = 0; col < 5; col++)
        {
            for(int row = 0; row < 5; row++)
            {
                boardNums[col][row] = String.valueOf(Randomizer.nextInt(0, difficulty));
                tracker[col][row] = false;

                //Prevents repeated numbers in each column
                for(int i = 0; i < 5; i++)
                {
                    if(boardNums[col][row].equals(boardNums[col][i]))
                    {
                        boardNums[col][row] = String.valueOf(Randomizer.nextInt(0, difficulty));
                        continue;
                    }
                }

            }
        }
        if(difficulty < 75)
        {
            boardNums[2][2] = "Free";
        }
    }

    int displayX = 45;
    int displayY = 125;
    private void displayNums(String[][] nums, Graphics g)
    {
        for(int col = 0; col < 5; col++)
        {
            for(int row = 0; row < 5; row++)
            {
               g.drawString(String.valueOf(nums[col][row]), displayX, displayY);
               xs[col][row] = displayX;
               ys[col][row] = displayY;
               displayY += 100;
            }
            displayY = 125;
            displayX += 100;
        }
        displayX = 45;
    }

    public void markSpot(Graphics g, int x, int y)
    {
        g.setColor(Color.RED);
        g.fillOval(x + 30, y - 25, 80, 80);
        revalidate();

    }

    private void header(Graphics g)
    {
        //Draws B
        g.fillRect(10, -25, 13, 90);
//        g.setFont();

        //Draws I
        g.fillRect(100, -25, 100, 90);
    }
}
