package me.alejandrofan2.dam.ui.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.io.FileNotFoundException;

import org.apache.tomcat.util.net.URL;

import me.alejandrofan2.dam.ui.TimerPanel;

public class CustomTimer extends JPanel {

    private Font timerFont;

    private TimerPanel parent;
    private Timer timerCron = new Timer();
    private boolean init = false;
    private boolean pause = false;
    private boolean finished = false;
    private JLabel tiempoLbl;
    private Integer minutos = 0;
    private Integer segundos = 0;
    private Integer milesimas = 0;

    public CustomTimer(JPanel parent) {
        setSize(300, 200);
        setLayout(new BorderLayout());

        this.parent = (TimerPanel) parent;

        tiempoLbl = new JLabel("00:00:000");
        tiempoLbl.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        tiempoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tiempoLbl.setForeground(Color.RED);
        tiempoLbl.setBackground(new Color(255, 255, 255, 0));
        tiempoLbl.setOpaque(true);
        tiempoLbl.setBorder(new CompoundBorder(new LineBorder(Color.RED, 4, true), new EmptyBorder(-10, 30, -10, 30)));

        add(tiempoLbl, BorderLayout.CENTER);
        setVisible(true);

    }

    public void run() {
        timerCron.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (pause || !init || finished) {
                    cancel();
                }

                if (segundos == 0 && minutos > 0) {
                    minutos--;
                    segundos = 59;
                }
                if (milesimas <= 0 && segundos > 0) {
                    segundos--;
                    milesimas = 999;
                }

                if (minutos == 0 && segundos == 0 && milesimas == 0) {
                    finished = true;
                    tiempoLbl.setText(format(minutos, segundos, milesimas));
                    cancel();
                }

                milesimas -= 4;

                tiempoLbl.setText(format(minutos, segundos, milesimas));
                parent.repaint();
            }
        }, 0, 4);
    }

    public void setTime(Integer minutos, Integer segundos, Integer milesimas) {
        this.minutos = minutos;
        this.segundos = segundos;
        this.milesimas = milesimas;
    }

    public String format(Integer minutos, Integer segundos, Integer milesimas) {
        String min = "", seg = "", mil = "";
        if (minutos < 10)
            min = "0" + minutos;
        else
            min = minutos.toString();
        if (segundos < 10)
            seg = "0" + segundos;
        else
            seg = segundos.toString();

        if (milesimas <= 9)
            mil = "00" + milesimas;
        else if (milesimas <= 99)
            mil = "0" + milesimas;
        else
            mil = milesimas.toString();
        return min + ":" + seg + ":" + mil;
    }

    public void startCrono() {
        init = true;
        pause = false;
        run();
    }

    public void stopCrono() {
        pause = true;
    }

    public void resetCrono() {
        setTime(0, 0, 0);
        tiempoLbl.setText("00:00:000");
        init = false;
    }

    /**
     * @return JLabel return the tiempoLbl
     */
    public JLabel getTiempoLbl() {
        return tiempoLbl;
    }

    /**
     * @param tiempoLbl the tiempoLbl to set
     */
    public void setTiempoLbl(JLabel tiempoLbl) {
        this.tiempoLbl = tiempoLbl;
    }

    /**
     * @return boolean return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * @return boolean return the init
     */
    public boolean isInit() {
        return init;
    }

    /**
     * @param init the init to set
     */
    public void setInit(boolean init) {
        this.init = init;
    }

    /**
     * @return boolean return the pause
     */
    public boolean isPause() {
        return pause;
    }

    /**
     * @param pause the pause to set
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }

}