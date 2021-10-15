package me.alejandrofan2.dam.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import me.alejandrofan2.dam.ui.util.CustomTimer;

public class TimerPanel extends JPanel {

    private JToggleButton startStopButton = new JToggleButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JLabel timerLbl = new JLabel();

    private JPanel crono;

    public TimerPanel(ActionListener listener) {
        super();

        setLayout(new BoxLayout(this, 1));

        crono = new CustomTimer(this);
        add(crono);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 0));
        buttonPanel.setLayout(new FlowLayout());

        startStopButton.addActionListener(listener);
        buttonPanel.add(startStopButton);

        resetButton.addActionListener(listener);
        buttonPanel.add(resetButton);

        add(buttonPanel);
    }

    /**
     * @return JButton return the resetButton
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * @param resetButton the resetButton to set
     */
    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    /**
     * @return JLabel return the timerLbl
     */
    public JLabel getTimerLbl() {
        return timerLbl;
    }

    /**
     * @param timerLbl the timerLbl to set
     */
    public void setTimerLbl(JLabel timerLbl) {
        this.timerLbl = timerLbl;
    }

    /**
     * @return JPanel return the crono
     */
    public JPanel getCrono() {
        return crono;
    }

    /**
     * @param crono the crono to set
     */
    public void setCrono(JPanel crono) {
        this.crono = crono;
    }

    /**
     * @return JToggleButton return the startStopButton
     */
    public JToggleButton getStartStopButton() {
        return startStopButton;
    }

    /**
     * @param startStopButton the startStopButton to set
     */
    public void setStartStopButton(JToggleButton startStopButton) {
        this.startStopButton = startStopButton;
    }

}
