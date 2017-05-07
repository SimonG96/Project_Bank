package gui;

/**
*
* @author d.ferber
*/

import javax.swing.*;
import java.awt.*;

public class Auszug extends JFrame {
    public static void main(String[] args) {
        new Auszug();
    }

    public Auszug() {
        setBackground(new Color(200,100,100));
        this.setTitle("Kontoauszug");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(400,400);
    }
}
