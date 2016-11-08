package net.sevecek;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JKeyboard klavesnice;
    JLabel labZralok;
    JLabel labRyba;
    JTimer casovac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    Integer posunX;
    Integer posunY;

    int delkaSmrti;

    public HlavniOkno() {
        initComponents();
    }

    private void srazka() {
        delkaSmrti = 25;
        labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/mrtvyNemo-vpravo.png")));

    }

    private void novyZacatek() {
        labRyba.setLocation(0, 0);
        labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vpravo.png")));
    }

    private void priOtevreniOkna(WindowEvent e) {
        casovac.start();
        posunX = -5;
        posunY = -5;
    }

    private void priZavreniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void priTiknutiCasovace(ActionEvent e) {
        if (delkaSmrti > 0) {
            delkaSmrti--;

            if (delkaSmrti == 0) {
                novyZacatek();
            }

            return;
        }

        Point poziceZraloka;
        Point poziceRyba;
        Integer xRyba;
        Integer yRyba;
        Integer rybaSirka;
        rybaSirka = labRyba.getWidth();
        Integer rybaVyska;
        rybaVyska = labRyba.getHeight();
        Integer xZralok;
        Integer yZralok;
        Integer zralokSirka;
        zralokSirka = labZralok.getWidth();
        Integer zralokVyska;
        zralokVyska = labZralok.getHeight();
        poziceZraloka = labZralok.getLocation();
        xZralok = poziceZraloka.x;
        yZralok = poziceZraloka.y;

        if (xZralok < 0) {
            posunX = 5;
        }
        if (xZralok + zralokSirka > contentPane.getWidth()) {
            posunX = -5;
        }
        if (yZralok < 0) {
            posunY = 5;
        }
        if (yZralok + zralokVyska > contentPane.getHeight()) {
            posunY = -5;
        }

        xZralok = xZralok + posunX;
        yZralok = yZralok + posunY;

        poziceZraloka.x = xZralok;
        poziceZraloka.y = yZralok;

        labZralok.setLocation(poziceZraloka);

        poziceRyba = labRyba.getLocation();

        xRyba = poziceRyba.x;
        yRyba = poziceRyba.y;
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            if (yRyba > 0) {
                yRyba = yRyba - 5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            if (yRyba + rybaVyska < contentPane.getHeight()) {
                yRyba = yRyba + 5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vlevo.png")));
            if (xRyba > 0) {
                xRyba = xRyba - 5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vpravo.png")));
            if (xRyba + rybaSirka < contentPane.getWidth()) {
                xRyba = xRyba + 5;
            }
        }
        poziceRyba.x = xRyba;
        poziceRyba.y = yRyba;
        labRyba.setLocation(poziceRyba);

        Integer AX;
        AX = xRyba;
        Integer AY;
        AY = yRyba;
        Integer BX;
        BX = xRyba + rybaSirka;
        Integer BY;
        BY = yRyba + rybaVyska;
        Integer CX;
        CX = xZralok;
        Integer CY;
        CY = yZralok;
        Integer DX;
        DX = xZralok + zralokSirka;
        Integer DY;
        DY = yZralok + zralokVyska;

        if (BX > CX && BX < DX && BY > CY && BY < DY) {
            srazka();
        }
        if (AX < DX && AX > CX && AY < DY && AY > CY) {
            srazka();
            labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vlevo.png")));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        klavesnice = new JKeyboard();
        labZralok = new JLabel();
        labRyba = new JLabel();
        casovac = new JTimer();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moje nov\u00e1 aplikace");
        setBackground(new Color(102, 204, 255));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                priZavreniOkna(e);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        contentPane.add(klavesnice);
        klavesnice.setBounds(new Rectangle(new Point(0, 0), klavesnice.getPreferredSize()));

        //---- labZralok ----
        labZralok.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/zralok.png")));
        contentPane.add(labZralok);
        labZralok.setBounds(new Rectangle(new Point(505, 15), labZralok.getPreferredSize()));

        //---- labRyba ----
        labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vlevo.png")));
        contentPane.add(labRyba);
        labRyba.setBounds(new Rectangle(new Point(310, 215), labRyba.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(700, 455);
        setLocationRelativeTo(null);

        //---- casovac ----
        casovac.setDelay(50);
        casovac.setInitialDelay(50);
        casovac.addActionListener(e -> priTiknutiCasovace(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
