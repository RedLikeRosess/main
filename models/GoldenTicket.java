package models;

//Import the Date package
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoldenTicket {
    
    private String code;
	private Date raffled;
	private SimpleDateFormat SimpRaffled = new SimpleDateFormat("yyyy/MM/dd");

        //Constructors
	public GoldenTicket(){}

	public GoldenTicket(String code, String raffled) throws Exception {
		this.code = code;
		this.raffled = SimpRaffled.parse(raffled);
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public Date getRaffled(){
		return raffled;
	}

	public void setRaffled(Date raffled){
		this.raffled = raffled;
	}

	@Override
            public String toString(){
                return "Code of this ticket: " + code + " It was raffled: " + raffled;
            }
}