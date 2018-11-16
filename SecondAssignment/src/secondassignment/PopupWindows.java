package secondassignment;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class PopupWindows extends JFrame{
    
    public PopupWindows() {
        setTitle("Connect Four");
        setSize(950, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
        URL url = Window.class.getResource("icon.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));

    }
    
    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Are you sure?", "Check your decision", JOptionPane.YES_NO_OPTION); // showConfirmDialog???
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }
    
    protected void doUponExit() {
        this.dispose();
    }
}
