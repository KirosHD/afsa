package princiipal;

import interfaces.BaseInterface;

public class ClaseMain {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BaseInterface();
            }
        });
    }
}