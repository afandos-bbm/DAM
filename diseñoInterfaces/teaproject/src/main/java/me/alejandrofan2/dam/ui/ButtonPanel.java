package me.alejandrofan2.dam.ui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JPanel {

    private ButtonGroup list = new ButtonGroup();
    private JRadioButton verde = new JRadioButton("Té Verde");
    private JRadioButton negro = new JRadioButton("Té Negro");
    private JRadioButton rojo = new JRadioButton("Té Rojo");

    public ButtonPanel() {
        super();

        setLayout(new BoxLayout(this, 1));

        verde.setFont(new Font("Arial", Font.BOLD, 25));
        rojo.setFont(new Font("Arial", Font.BOLD, 25));
        negro.setFont(new Font("Arial", Font.BOLD, 25));

        verde.setBorder(BorderFactory.createEmptyBorder(20,20,10,5));
        rojo.setBorder(BorderFactory.createEmptyBorder(20,20,10,5));
        negro.setBorder(BorderFactory.createEmptyBorder(20,20,10,5));
        list.add(verde);
        add(verde);
        list.add(rojo);
        add(rojo);
        list.add(negro);
        add(negro);
    }

    public String getSelected() {
        if (verde.isSelected()) {
            return "v";
        } else if (rojo.isSelected()) {
            return "r";
        } else if (negro.isSelected()) {
            return "n";
        } else {
            return "0";
        }
    }

}
