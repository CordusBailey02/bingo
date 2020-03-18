package com.caddocareer.bingo;

import com.caddocareer.Main;
import com.caddocareer.Randomizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    String colSel = "";

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
                checkMatch();
            }
        });
        jPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    System.out.println(x + " " + y);
                    getSelected(x, y);
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

    private void getSelected(int x, int y)
    {
        int xCord = 67;
        int yCord = 29;

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++) {
                if ((x > xCord && x < xCord + 90) && (y > yCord && y < yCord + 90)) {
                    checkMatch();
                    System.out.println(colSelectCord);
                    System.out.println(rowSelectCord);
                }
                xCord += 90;
                colSelectCord++;
            }
            xCord = 90;
            colSelectCord = 0;
            yCord += 90;
            rowSelectCord++;
        }
        rowSelectCord = 0;
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
            Main.board.markSpot(board.getGraphics(), 215, 230);
        }
        else if(diff.equalsIgnoreCase("normal"))
        {
            difficulty = 50;
            Main.board.markSpot(board.getGraphics(), 215, 230);
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
                System.out.println("Test");
                Main.board.markSpot(board.getGraphics(), (colNum * 90) + 35, (i * 90) + 50);
                break;
            }
        }
    }
}
