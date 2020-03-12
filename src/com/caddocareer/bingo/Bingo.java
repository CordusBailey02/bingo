package com.caddocareer.bingo;

import com.caddocareer.Main;
import com.caddocareer.Randomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.Objects;

public class Bingo {
    private JPanel jPanel;
    private JPanel board;
    private JButton buttonPlay;
    private JLabel labelChosenNum;
    private JButton button1;
    private static boolean[][] tracker = new boolean[5][5];
    private Board boardGraph = new Board();
    int colSelectCord = 0;
    int rowSelectCord = 0;

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
                int x = 120;
                int y = 120;
//                public void mouseClicked(MouseEvent e) {
//                    x = e.getX();
//                    y = e.getY();
                    int xCord = 90;
                    int yCord = 90;

                    for(int i = 0; i < 5; i++)
                    {
                        for(int j = 0; j < 5; j++) {
                            if ((x > xCord && x < xCord * 2) && (y < yCord && y > yCord * 2)) {
                                checkMatch();
                            }
                            xCord += 90;
                            colSelectCord++;
                        }
                        yCord += 90;
                        rowSelectCord++;
                    }
//                }
            }
        });
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
        for(int i = 0; i < 5; i++)
        {
            if(Integer.parseInt(Main.bingoHome.getBoardNum(colSelectCord, rowSelectCord)) == Integer.parseInt(Main.bingoHome.getBoardNum(colNum, i)))
            {
                tracker[colNum][i] = true;
                Main.board.markSpot(new Graphics() {
                    @Override
                    public Graphics create() {
                        return null;
                    }

                    @Override
                    public void translate(int i, int i1) {

                    }

                    @Override
                    public Color getColor() {
                        return null;
                    }

                    @Override
                    public void setColor(Color color) {

                    }

                    @Override
                    public void setPaintMode() {

                    }

                    @Override
                    public void setXORMode(Color color) {

                    }

                    @Override
                    public Font getFont() {
                        return null;
                    }

                    @Override
                    public void setFont(Font font) {

                    }

                    @Override
                    public FontMetrics getFontMetrics(Font font) {
                        return null;
                    }

                    @Override
                    public Rectangle getClipBounds() {
                        return null;
                    }

                    @Override
                    public void clipRect(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void setClip(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public Shape getClip() {
                        return null;
                    }

                    @Override
                    public void setClip(Shape shape) {

                    }

                    @Override
                    public void copyArea(int i, int i1, int i2, int i3, int i4, int i5) {

                    }

                    @Override
                    public void drawLine(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void fillRect(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void clearRect(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void drawRoundRect(int i, int i1, int i2, int i3, int i4, int i5) {

                    }

                    @Override
                    public void fillRoundRect(int i, int i1, int i2, int i3, int i4, int i5) {

                    }

                    @Override
                    public void drawOval(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void fillOval(int i, int i1, int i2, int i3) {

                    }

                    @Override
                    public void drawArc(int i, int i1, int i2, int i3, int i4, int i5) {

                    }

                    @Override
                    public void fillArc(int i, int i1, int i2, int i3, int i4, int i5) {

                    }

                    @Override
                    public void drawPolyline(int[] ints, int[] ints1, int i) {

                    }

                    @Override
                    public void drawPolygon(int[] ints, int[] ints1, int i) {

                    }

                    @Override
                    public void fillPolygon(int[] ints, int[] ints1, int i) {

                    }

                    @Override
                    public void drawString(String s, int i, int i1) {

                    }

                    @Override
                    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i1) {

                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, int i2, int i3, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, Color color, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, int i2, int i3, Color color, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public boolean drawImage(Image image, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, Color color, ImageObserver imageObserver) {
                        return false;
                    }

                    @Override
                    public void dispose() {

                    }
                }, colNum, i);
            }
        }
    }
}
