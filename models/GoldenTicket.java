package models;

//Import the Date package
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoldenTicket {
    
    private String code;
	private Date raffled;
	private SimpleDateFormat SimpRaffled = new SimpleDateFormat("yyyy/MM/dd");
    public boolean wasRaffled;

        //Constructors
	public GoldenTicket(){}

	public GoldenTicket(String code, String raffled) throws Exception {
		this.code = code;
		this.raffled = SimpRaffled.parse(raffled);
	}
        
    public void setIsRaffled(boolean WR){
        this.wasRaffled = WR;
    }
    
    public boolean isRaffled(){
        return wasRaffled;
    }

	@Override
            public String toString(){
                return "Code of this ticket: " + code + " It was raffled: " + raffled;
            }
}