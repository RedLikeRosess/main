import models.GoldenTicket;
import models.OLS;
import models.TicketsBase;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Controller{	
	Scanner sc = new Scanner(System.in);
	TicketsBase ticketsBase;
    OLS OLSong;

    public Controller() throws Exception {
            OLSong = new OLS();
            ticketsBase = new TicketsBase();
            startTicketsBase();
    }
    
    private void startTicketsBase() throws Exception{
        ticketsBase.addTicket(new GoldenTicket("111", "2000/02/02"));
        ticketsBase.addTicket(new GoldenTicket("222", "2005/02/02"));
        ticketsBase.addTicket(new GoldenTicket("333", "2010/02/02"));
    }

    public void addTicket() throws Exception{
            System.out.println("Write the ticket's code");
            String code = sc.next();			

            System.out.println("Write the ticket's raffled date");
            String raffled = sc.next();

            GoldenTicket gt = new GoldenTicket(code, raffled);

            ticketsBase.addTicket(gt);
    }
        
    public void listGoldenTickets(){
        ArrayList <GoldenTicket> goldenTickets = ticketsBase.getGoldenTickets();
        for(GoldenTicket goldT : goldenTickets){
            System.out.println(goldT);
        }
    }

    public void getSong(int num) throws Exception{
		for (int i = 0; i < num; i++){
			Random rand = new Random();
			int size = OLSong.getLine().size() - 1;
			int randLine = rand.nextInt(size)+1;
			System.out.println(OLSong.getLine().get(randLine));
		}
	}
}