package com.caddocareer.bingo;

import javax.swing.*;
import java.awt.*;

public class BoardGraphics extends JPanel {

    public BoardGraphics()
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

        drawColumns(g);
        drawRows(g);

        test(g);
    }

    public void drawColumns(Graphics g)
    {
        //Draws B column
        g.drawLine(90, 0, 90, 450);

        //Draws I column
        g.drawLine(180, 0, 180, 450);

        //Draws N column
        g.drawLine(270, 0, 270, 450);

        //Draws G column
        g.drawLine(360, 0, 360, 450);

        //Column O isn't needed since there is a border
    }

    public void drawRows(Graphics g)
    {
        //Draws 1st row
        g.drawLine(0, 90, 450, 90);

        //Draws 2nd row
        g.drawLine(0, 180, 450, 180);

        //Draws 3rd row
        g.drawLine(0, 270, 450, 270);

        //Draws 4th row
        g.drawLine(0, 360, 450, 360);

        //5th line not needed, because of border
    }

    public void test(Graphics g)
    {
        g.drawString("Free", 225, 225);
    }
}
