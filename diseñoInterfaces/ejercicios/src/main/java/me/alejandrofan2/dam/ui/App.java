package me.alejandrofan2.dam.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Hello world!
 *
 */
public class App extends JFrame {
    JPanel panel;
    JButton botoncitoOk;

    public App() {
        setTitle("Botoncito");
        setLayout(null);
        setBounds(200, 300, 200, 300);
        setVisible(true);

        panel = new JPanel();

        setContentPane(panel);

        botoncitoOk = new JButton("Ok");
        botoncitoOk.setBounds(50, 80, 100, 30);
        panel.add(botoncitoOk);
    }

    public static void main(String[] args) {
        new App();
    }
}
