package models;

import java.util.ArrayList;

public class TicketsBase{
	ArrayList<GoldenTicket> gt;
	
	public TicketsBase(){
		gt = new ArrayList<GoldenTicket>();
	}
	
	public void addTicket(GoldenTicket t){
		gt.add(t);
	}
        
    public ArrayList<GoldenTicket> getGoldenTickets(){
		return this.gt;
	}
}