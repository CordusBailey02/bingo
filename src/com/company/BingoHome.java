package com.company;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BingoHome {
    private JPanel jPanel;
    private JPanel header;
    private JButton startButton;
    public JComboBox comboBoxDiff;

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public BingoHome()
    {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.setContentPane(Main.bingo.getjPanel());
                Main.bingo.getChosenSpot().setText(Main.bingo.useChosenNum(String.valueOf(comboBoxDiff.getSelectedItem())));
                Main.frame.revalidate();
            }
        });
    }
}
