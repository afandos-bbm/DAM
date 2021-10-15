package me.alejandrofan2.dam.ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.vdurmont.emoji.EmojiParser;

public class FooterAlejandrofan2 extends JPanel {

    public static final String FOOTER_TEXT = EmojiParser.parseToUnicode("Developed by Alejandrofan2 🧃");
    public static final JLabel FOOTER_LABEL = new JLabel(FOOTER_TEXT);

    public FooterAlejandrofan2() {
        super();

        this.setBackground(new Color(224, 180, 0));
        FOOTER_LABEL.setBackground(Color.BLACK);
        this.add(FOOTER_LABEL);
    }
}
