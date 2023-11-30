package easygl;

import javax.swing.*;

public class App extends JFrame {
    public App(){
        super("EasyGL");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        EasyGLPanel panel = new EasyGLPanel();
        getContentPane().add(panel);
        setVisible(true);
    }
}
