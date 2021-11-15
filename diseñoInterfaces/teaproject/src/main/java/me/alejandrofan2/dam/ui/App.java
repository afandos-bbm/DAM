package me.alejandrofan2.dam.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.alejandrofan2.dam.ui.util.CustomTimer;

@SpringBootApplication
public class App implements CommandLineRunner, ActionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new ButtonPanel();
    JPanel timerPanel = new TimerPanel(this);
    JFrame appFrame = new MainFrame(new Dimension(600, 320), new BorderLayout(), mainPanel);

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false"); // Disables headless
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        while (init()){
            // TODO: Win code.
            if (((CustomTimer) (((TimerPanel) timerPanel).getCrono())).isFinished()) {
                System.out.println("test");
                mainPanel.removeAll();
                mainPanel.repaint();
            }
        }
    }

    public boolean init() {
        mainPanel.setVisible(true);
        appFrame.setVisible(true);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(timerPanel, BorderLayout.EAST);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object o = e.getSource();
        CustomTimer timer = (CustomTimer) ((TimerPanel) timerPanel).getCrono();
        if (o instanceof JButton) {
            JButton btn = (JButton) o;
            if (btn.equals(((TimerPanel) timerPanel).getResetButton()) && timer.isInit()) {
                ((CustomTimer) ((TimerPanel) timerPanel).getCrono()).resetCrono();
                JToggleButton btnStartStop = ((TimerPanel) timerPanel).getStartStopButton();
                btnStartStop.setSelected(false);
                btnStartStop.setText("Start");
                timerPanel.repaint();
            }
        } else if (o instanceof JToggleButton) {
            JToggleButton btn = (JToggleButton) o;
            if ((btn.equals(((TimerPanel) timerPanel).getStartStopButton()))) {
                if (!timer.isInit()) {
                    switch (((ButtonPanel) buttonPanel).getSelected()) {
                        case "r":
                            timer.setTime(3, 0, 0);
                            timer.startCrono();
                            break;
                        case "v":
                            timer.setTime(2, 0, 0);
                            timer.startCrono();
                            break;
                        case "n":
                            timer.setTime(5, 0, 0);
                            timer.startCrono();
                            break;
                        default:
                            JOptionPane.showMessageDialog(appFrame, "Por favor selecciona un tipo de té.", null,
                                    JOptionPane.ERROR_MESSAGE);
                            btn.setSelected(false);
                            btn.setText("Start");
                            break;
                    }
                } else {
                    if (timer.isPause()) {
                        timer.startCrono();
                    } else
                        timer.stopCrono();
                }
                if (!(((ButtonPanel) buttonPanel).getSelected().equals("0"))) {
                    if (btn.getText().equals("Start"))
                        btn.setText("Stop");
                    else
                        btn.setText("Start");
                }
            }
        }
    }

}