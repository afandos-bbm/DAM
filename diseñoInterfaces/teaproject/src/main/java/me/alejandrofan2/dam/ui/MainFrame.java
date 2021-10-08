package me.alejandrofan2.dam.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.LayoutManager2;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainFrame extends JFrame {
    public MainFrame(Dimension dimension, LayoutManager2 layout) {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel());
        this.setLayout(layout);

        this.add(new FooterAlejandrofan2(), BorderLayout.PAGE_END);
    }
}