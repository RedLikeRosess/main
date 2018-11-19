import models.GoldenTicket;
import models.OLS;
import models.TicketsBase;

import java.util.Scanner;
import java.util.ArrayList;

public class Controller{	
	Scanner sc = new Scanner(System.in);
	GoldenTicket goldenTickets;

	public Controller(){
		ArrayList<GoldenTicket> goldenTickets = new ArrayList<>();
	}

	public void addTicket(){
		System.out.println("Write the ticket's code");
		String code = sc.next();			
		
		System.out.println("Write the ticket's raffled date");
		String raffled = sc.next();
		
		GoldenTicket gt = new GoldenTicket(code, raffled);
		
		goldenTickets.addTicket(gt);
	}	
}