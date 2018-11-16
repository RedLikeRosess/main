package secondassignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends PopupWindows{
    private final int sizeX;
    private final int sizeY;
    private int cnt;
    private final Process process;
    private final JLabel label;
    private final BasicWindow basicWindow;
    private JButton[][] buttons;
    
    
    public Window(int sizeX, int sizeY, BasicWindow basicWindow){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.basicWindow = basicWindow;
        basicWindow.getWindowList().add(this);
        process = new Process(sizeX, sizeY);

        JPanel top = new JPanel();
        
        buttons = new JButton[sizeX][sizeY];
        cnt = 0;
        label = new JLabel();
        updateLabelText();
        
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.addActionListener(e -> newGame());
        
        top.add(label);
        top.add(newGameButton);    
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(sizeX, sizeY));
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                addButton(mainPanel, i, j);
            }
        }
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
    
    private void addButton(JPanel panel, final int i, final int j) {
        final JButton button = new JButton();
        buttons[i][j] = button;
        System.out.println(j);
        if((sizeY-1) < 8){
            if (i == 0 && j == 0){ button.setText("Push me"); }
            if (i == 0 && j == 1){ button.setText("And then"); }
            if (i == 0 && j == 2){ button.setText("just touch me"); }
            if (i == 0 && j == 3){ button.setText("Till I can"); }
            if (i == 0 && j == 4){ button.setText("get my"); }
            if (i == 0 && j == 5){ button.setText("Satisfaction"); }
            if (i == 0 && j == 6){ button.setText("Satisfaction"); }
            if (i == 0 && j == 7){ button.setText("Satisfaction"); }
        }
        else{
            if(i == 0){
            button.setText(""+(j+1));
            }   
        }
        if (i == 0){
            button.addActionListener(e -> {
            process.step(i, j);
            if((sizeY-1) < 8){
                switch(j){
                    case 0:
                        player.play(0);
                        break;
                    case 1:
                        player.play(1);
                        break;
                    case 2:
                        player.play(2);
                        break;
                    case 3:
                        player.play(3);
                        break;
                    case 4:
                        player.play(4);
                        break;
                    case 5:
                        player.play(5);
                        break;
                    case 6:
                        player.play(5);
                        break;
                    case 7:
                        player.play(5);
                        break;
                }
            }
            
            for (int r = process.getRows(); r > 0; r--){
                refreshButton(buttons[r][j], r, j);
            }
            
            updateLabelText();
            boolean win = false;
            Gamer winner = process.findWinner();
            if (winner != Gamer.NOBODY) {
                showGameOverMessage(winner);
                win = true;
            }
            cnt++;
            if (cnt == ((sizeX-1)*(sizeY)) && win == false){
                showGameOverMessageDraw();
            }
            });
        }
        panel.add(button);
    }
    
    private void refreshButton(JButton button,int r ,int j) {
        if(process.table[r][j]==Gamer.O){
            button.setText("O");
            button.setBackground(Color.RED);
        }
        if(process.table[r][j]==Gamer.X){
            button.setText("X");
            button.setBackground(Color.YELLOW);
        }
    }
    
    private void showGameOverMessage(Gamer winner) {
        JOptionPane.showMessageDialog(this,"Game is over. Winner: " + winner.name());
        newGame();
    }
    
    private void showGameOverMessageDraw() {
        JOptionPane.showMessageDialog(this,"Game is over. It's a draw.");
        newGame();
    }
    
    private void newGame() {
        Window newWindow = new Window(sizeX, sizeY, basicWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        basicWindow.getWindowList().remove(this);
    }
    
    private void updateLabelText() {
        label.setText("Current player: " + process.getActualPlayer().name());
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        basicWindow.getWindowList().remove(this);
    }
}
