package secondassignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends PopupWindows{
    private final int sizeX;
    private final int sizeY;
    private final Process process;
    private final JLabel label;
    private final BasicWindow basicWindow;
    
    public Window(int sizeX, int sizeY, BasicWindow basicWindow) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.basicWindow = basicWindow;
        basicWindow.getWindowList().add(this);
        process = new Process(sizeX, sizeY);

        JPanel top = new JPanel();
        
        label = new JLabel();
        updateLabelText();
        
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.addActionListener(e -> newGame());   //newGame
        
        top.add(label);
        top.add(newGameButton);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, sizeY));
        for (int j = 0; j < sizeY; ++j) {
            addControlButton(controlPanel, 1, j);
        }        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(sizeX, sizeY));
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                addButton(mainPanel, i, j);
            }
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.SOUTH);
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
    
    private void addControlButton(JPanel panel, final int i, final int j) {
        final JButton button = new JButton();
        for (int s = 0; s <= j; s++){
            button.setText(""+(s+1));
        }
        /*button.addActionListener(e -> {                       // -> ????
            Gamer newValue = process.step(i, j);
            button.setText(newValue.name());
            
            updateLabelText();
            
            Gamer winner = process.findWinner();
            if (winner != Gamer.NOBODY) {
                showGameOverMessage(winner);
            }
        });*/
        panel.add(button);
    }
    
    private void addButton(JPanel panel, final int i, final int j) {
        final JButton button = new JButton();

        /*button.addActionListener(e -> {
            Gamer newValue = process.step(i, j);
            button.setText(newValue.name());
            
            s();
            
            Gamer winner = process.findWinner();
            if (winner != Gamer.NOBODY) {
                showGameOverMessage(winner);
            }
        });*/
        panel.add(button);
    }

    private void showGameOverMessage(Gamer winner) {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + winner.name());
        newGame();
    }
    
    private void newGame() {
        Window newWindow = new Window(sizeX, sizeY, basicWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        basicWindow.getWindowList().remove(this);
    }
    
    private void updateLabelText() {
        label.setText("Current player: "
                + process.getActualPlayer().name());
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        basicWindow.getWindowList().remove(this);
    }
}
