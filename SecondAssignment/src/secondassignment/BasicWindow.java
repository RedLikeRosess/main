package secondassignment;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class BasicWindow extends PopupWindows{    
    
    private List<Window> gameWindows = new ArrayList<>();
    
    public BasicWindow() {
        Border bd = new LineBorder(Color.BLUE, 1);
        JLabel text = new JLabel("                     Choose your destiny!!!");
        text.setPreferredSize(new Dimension(250, 40));
        text.setMaximumSize(new Dimension(250, 40));
        
        JButton small = new JButton();
        small.setText("Fast game(8x5). Fun mode is active...");
        small.addActionListener(getActionListener(8, 6)); 
        small.setBackground(Color.ORANGE);
        small.setPreferredSize(new Dimension(250, 100));
        small.setMaximumSize(new Dimension(250, 100));
        small.setBorder(bd);
        
        JButton medium = new JButton();
        medium.setText("Medium game(10x6). If you ready...");
        medium.addActionListener(getActionListener(10, 7));
        medium.setBackground(Color.YELLOW);
        medium.setPreferredSize(new Dimension(250, 100));
        medium.setMaximumSize(new Dimension(250, 100));
        medium.setBorder(bd);

        JButton large = new JButton();
        large.setText("Long game(12x7). oooh...Good night...");
        large.addActionListener(getActionListener(12, 8));
        large.setBackground(Color.CYAN);
        large.setPreferredSize(new Dimension(250, 100));
        large.setMaximumSize(new Dimension(250, 100));
        large.setBorder(bd);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(text);
        getContentPane().add(small); 
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
