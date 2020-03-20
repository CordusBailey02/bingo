package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Bingo {
    private JPanel jPanel;
    private JPanel boardSpaces;
    private JLabel chosenSpot;
    private JButton playButton;
    private JButton button1;
    private int colSelect = 0;
    private int rowSelect = 0;
    private Board board = new Board();

    public JPanel getjPanel()
    {
        return jPanel;
    }
    public JLabel getChosenSpot() { return chosenSpot; }
    public String useChosenNum(String diff) { return chooseNum(diff); }

    public Bingo()
    {
        boardSpaces.add(board);
        //Chooses First Spot

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenSpot.setText(chooseNum(String.valueOf(Main.bingoHome.comboBoxDiff.getSelectedItem())));
            }
        });
        boardSpaces.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                checkWin();
                selectSquare(x, y);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    private void selectSquare(int x, int y)
    {
        rowSelect = 0;
        colSelect = 0;

        int xStart = 100;
        int yStart = 75;
        for(int col = 0; col < 5; col++)
        {
            for(int row = 0; row < 5; row++)
            {
                if((x > xStart && x < xStart + 100) && (y > yStart && y < yStart + 100))
                {
                    checkMatch();
                    break;
                }
                yStart += 100;
                rowSelect++;
            }
            xStart += 100;
            yStart = 75;
            rowSelect = 0;
            colSelect++;
        }
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
        if(board.getBoardNums(colSelect, rowSelect).equalsIgnoreCase("Free"))
        {
            board.markSpot(boardSpaces.getGraphics(), board.getNumXCord(colSelect, rowSelect), board.getNumYCord(colSelect, rowSelect));
            return;
        }
        for(int i = 0; i < 5; i++)
        {
            if (Integer.parseInt(board.getBoardNums(colSelect, rowSelect)) == Integer.parseInt(board.getBoardNums(colNum, i)) && rowSelect == i)
            {
                board.setTracker(colNum, i, true);
                board.markSpot(boardSpaces.getGraphics(), board.getNumXCord(colNum, i), board.getNumYCord(colNum, i));
                break;
            }
        }
    }

    private void checkWin()
    {
        //Checks for wins up/down
        int rowCount = 0;
        for(int col = 0; col < 5; col++)
        {
            for(int row = 0; row < 5; row++)
            {
                //Checks columns
                if(board.getTracker(col, row))
                {
                    rowCount++;
                    if(rowCount == 5)
                    {
                        //Winner
                        chosenSpot.setText("You Won!");
                    }
                }
            }
            rowCount = 0;
        }
        //checks rows
        int colCount = 0;
        for(int row = 0; row < 5; row++)
        {
            for(int col = 0; col < 5; col++)
            {
                if(board.getTracker(row, col))
                {
                    colCount++;
                    if(colCount == 5)
                    {
                        //Winner
                        chosenSpot.setText("You Won!");
                    }
                }
            }
            colCount = 0;
        }

        //Checks Diagnol 1
        int diagCount1 = 0;
        for(int i = 0; i < 5; i++)
        {
            if(board.getTracker(i, i))
            {
                diagCount1++;
                if(diagCount1 == 5)
                {
                    //Winner
                }
            }
        }
        //Checks Diagnol 2
        int diagCount2 = 0;
        int difference = 4;
        for(int i = 0; i < 5; i++)
        {
            if(board.getTracker(i, i + difference))
            {
                difference -= 1;
                diagCount2++;
                if(diagCount2 == 5)
                {
                    //Winner
                }
            }
        }
    }
}
