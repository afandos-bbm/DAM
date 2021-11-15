package me.alejandrofan2.dam.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager2;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    public MainFrame(Dimension dimension, LayoutManager2 layout, JPanel mainPanel) {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(getContentPane(), 1));
        this.setResizable(false);

        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(layout);
        mainPanel.setBorder(new EmptyBorder(10, 25, 0, 10));
        add(new FooterAlejandrofan2(), BorderLayout.SOUTH);
    }
}