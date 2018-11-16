package secondassignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class player {
    
    public static void player(String args[]){        
    }

    protected static void play(int i) {
        try{
            FileInputStream f1 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\pushMe.mp3");
            FileInputStream f2 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\andThen.mp3");
            FileInputStream f3 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\justTouchMe.mp3");
            FileInputStream f4 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\till1Can.mp3");
            FileInputStream f5 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\getMy.mp3");
            FileInputStream f6 = new FileInputStream("D:\\Second desktop\\git\\SecondAssignment\\src\\secondassignment\\satisfaction.mp3");
            try{
                switch (i){
                    case 0:
                        Player player = new Player(f1);
                        player.play();
                        break;
                    case 1:
                        Player player2 = new Player(f2);
                        player2.play();
                        break;
                    case 2:
                        Player player3 = new Player(f3);
                        player3.play();
                        break;
                    case 3:
                        Player player4 = new Player(f4);
                        player4.play();
                        break;
                    case 4:
                        Player player5 = new Player(f5);
                        player5.play();
                        break;
                    case 5:
                        Player player6 = new Player(f6);
                        player6.play();
                        break;
                }
            }
            catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}