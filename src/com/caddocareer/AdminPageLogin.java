package com.caddocareer;

import com.caddocareer.bingo.BingoHome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPageLogin {
    private JPanel jPanel;
    private JTextField textFieldUser;
    private JButton loginButton;
    private JTextField textFieldPass;

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public AdminPageLogin()
    {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldUser.getText().equals("Admin") && textFieldPass.getText().equals("Admin"))
                {
                    Main.frame.setContentPane(Main.adminPage.getjPanel());
                    Main.frame.setTitle("Admin Page");
                    Main.frame.revalidate();
                    BingoHome.adminFrame.dispose();
                }
            }
        });
    }
}
