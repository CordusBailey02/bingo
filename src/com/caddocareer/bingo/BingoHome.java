package com.caddocareer.bingo;

import com.caddocareer.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BingoHome {
    private JPanel jPanel;
    private JButton startGameButton;

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public BingoHome()
    {
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.setTitle("Bingo Game");
                Main.frame.setContentPane(Main.bingo.getjPanel());
                Main.frame.revalidate();
            }
        });
    }
}
