package com.caddocareer.bingo;

import com.caddocareer.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BingoHome {
    private JPanel jPanel;
    private JButton startGameButton;
    private JButton settingsButton;
    private JButton adminLoginButton;

    public static JFrame adminFrame = new JFrame();

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public BingoHome()
    {
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                adminFrame.setTitle("Admin Login");
                adminFrame.setResizable(false);
                adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                adminFrame.setVisible(true);
                adminFrame.setSize(200, 200);
                adminFrame.setLocationRelativeTo(null);

                adminFrame.setContentPane(Main.adminPageLogin.getjPanel());
            }
        });

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
