import models.GoldenTicket;
import models.OLS;
import models.TicketsBase;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Controller{	
	Scanner sc = new Scanner(System.in);
	GoldenTicket goldenTickets;
	OLS OLSong;

	public Controller(){
		ArrayList<GoldenTicket> goldenTickets = new ArrayList<>();
		OLSong = new OLS();
	}

	/*public void addTicket(){
		System.out.println("Write the ticket's code");
		String code = sc.next();			
		
		System.out.println("Write the ticket's raffled date");
		String raffled = sc.next();
		
		GoldenTicket gt = new GoldenTicket(code, raffled);
		
		goldenTickets.addTicket(gt);
	}*/

	public void getSong(int num) throws Exception{
		for (int i = 0; i < num; i++){
			Random rand = new Random();
			int size = OLSong.getLine().size() - 1;
			int randLine = rand.nextInt(size)+1;
			System.out.println(OLSong.getLine().get(randLine));
		}
	}
}