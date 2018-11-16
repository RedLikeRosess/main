package secondassignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class BasicWindow extends JFrame{    
    
    private List<Window> gameWindows = new ArrayList<>();

    static JFrame f;
    static JButton small, medium, large;
    static JLabel l;
    
    public BasicWindow() { 
        f = new JFrame("Connect Four");  
        l = new JLabel("Choose your destiny"); 
        JPanel p = new JPanel();           
        Border bd = new LineBorder(Color.BLUE, 1);
        
        small = new JButton();
        small.setText("Fast game(8x5). Fun mode is active...");
        small.addActionListener(getActionListener(8, 6)); 
        small.setBackground(Color.RED);
        small.setPreferredSize(new Dimension(250, 100));
        small.setMaximumSize(new Dimension(250, 100));
        small.setBorder(bd);
        
        medium = new JButton();
        medium.setText("Medium game(10x6). If you ready...");
        medium.addActionListener(getActionListener(10, 7));
        medium.setBackground(Color.YELLOW);
        medium.setPreferredSize(new Dimension(250, 100));
        medium.setMaximumSize(new Dimension(250, 100));
        medium.setBorder(bd);

        large = new JButton();
        large.setText("Long game(12x7). Good night...");
        large.addActionListener(getActionListener(12, 8));
        large.setBackground(Color.GREEN);
        large.setPreferredSize(new Dimension(250, 100));
        large.setMaximumSize(new Dimension(250, 100));
        large.setBorder(bd);
        
        p.add(l);
        p.add(small); 
        p.add(medium); 
        p.add(large);
        p.setBackground(Color.WHITE); 
  
        f.add(p); 
        f.setSize(250, 300); 
        f.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
  
        f.show();
        
        //getContentPane().setLayout(new BorderLayout()/*new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)*/);
        /*getContentPane().add(small, BorderLayout.CENTER); 
        getContentPane().add(medium, BorderLayout.CENTER);
        getContentPane().add(large, BorderLayout.CENTER);*/
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
    
    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Are you sure?", "Check your decision", JOptionPane.YES_NO_OPTION); // showConfirmDialog???
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }
    
    protected void doUponExit() {   
        System.exit(0);
    }
}
