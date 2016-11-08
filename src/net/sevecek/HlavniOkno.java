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

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        casovac.start();
        posunX = -5;
        posunY=-5;
    }

    private void priZavreniOkna(WindowEvent e) {
        casovac.stop();
    }
    private void priTiknutiCasovace(ActionEvent e){
         Point poziceZraloka;
        poziceZraloka = labZralok.getLocation();
        Integer xZralok;
        Integer yZralok;

        xZralok = poziceZraloka.x;
        yZralok = poziceZraloka.y;

        if (xZralok < 0) {
            posunX = 5;
        }
        if (xZralok + labZralok.getWidth() > contentPane.getWidth()) {
            posunX = -5;
        }
        if (yZralok < 0) {
            posunY = 5;
        }
        if (yZralok + labZralok.getHeight() > contentPane.getHeight()) {
            posunY = -5;
        }

        xZralok = xZralok + posunX;
        yZralok = yZralok + posunY;

        poziceZraloka.x = xZralok;
        poziceZraloka.y = yZralok;

        labZralok.setLocation(poziceZraloka);

        Point poziceRyba;
        poziceRyba =labRyba.getLocation();
        Integer xR;
        Integer yR;
        xR = poziceRyba.x;
        yR = poziceRyba.y;
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)){
            if (yR>0){yR=yR-5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)){
            if (yR+labRyba.getHeight()<contentPane.getHeight()){
                yR=yR+5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)){
            labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vlevo.png")));
            if (xR>0){
                xR=xR-5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)){
            labRyba.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/Nemo-vpravo.png")));
            if (xR +labRyba.getWidth()<contentPane.getWidth()){
                xR=xR+5;
            }
        }
        poziceRyba.x = xR;
        poziceRyba.y=yR;
        labRyba.setLocation(poziceRyba);
        if (xR + labRyba.getHeight()> )
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
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
