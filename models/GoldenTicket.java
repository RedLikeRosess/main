package models;

//Import the Date package
import java.util.Date;
import java.text.SimpleDateFormat;

public class GoldenTicket{
		//Attributes
	private String code;
	private Date raffled;
	private SimpleDateFormat SimpRaffled = new SimpleDateFormat("yyyy/MM/dd");

		//Constructors
	public GoldenTicket(){}

	public GoldenTicket(String code, String raffled) throws Exception {
		this.code = code;
		this.raffled = SimpRaffled.parse(raffled);
	}

	@Override
		public String toString(){
			return "Code of this ticket: " + code + "\nIt was raffled: " + raffled;
		}
}