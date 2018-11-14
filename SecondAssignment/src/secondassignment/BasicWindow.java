package secondassignment;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class BasicWindow extends PopupWindows{    
    
    private List<Window> gameWindows = new ArrayList<>(); 
    
    public BasicWindow() {
        
        JButton small = new JButton();
        small.setText("8 x 5");
        small.addActionListener(getActionListener(8, 6)); 
        
        JButton medium = new JButton();
        medium.setText("10 x 6");
        medium.addActionListener(getActionListener(10, 7));

        JButton large = new JButton();
        large.setText("12 x 7");
        large.addActionListener(getActionListener(12, 8));
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  
        getContentPane().add(small);    //getContentPane???
        getContentPane().add(medium);
        getContentPane().add(large);
    }
    
    private ActionListener getActionListener(final int sizeX, final int sizeY) {
        return new ActionListener() { 

            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = new Window(sizeY, sizeX, BasicWindow.this);
                window.setVisible(true);
                gameWindows.add(window);
            }            
        };
    }
    
    public List<Window> getWindowList() {
        return gameWindows;
    }
    
    @Override
    protected void doUponExit() {   
        System.exit(0);
    }
}
