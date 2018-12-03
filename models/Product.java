package models;

public class Product{
	private String description;
	private Long barcode;
	private String serialNumber;
	private GoldenTicket prizeTicket;

	public Product(){}

	public Product(String description, Long barcode, String serialNumber){
		this.description = description;
		this.barcode = barcode;
		this.serialNumber = serialNumber;
		prizeTicket = null;
	}

	public String getDescription(String description){
		return description;
	}

	public void setDescription(){
		this.description = description;
	}

	public Long getBarcode(){
		return barcode;
	}

	public void setBarcode(Long barcode){
		this.barcode = barcode;
	}

	public String getSerialNumber(){
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;
	}

	public GoldenTicket getPrizeTicket(){
		return prizeTicket;
	}

	public void setPrizeTicket(GoldenTicket prizeTicket){
		this.prizeTicket = prizeTicket;
	}

	@Override
	public String toString(){
		return "description: " + description + "; barcode: " + barcode + "; serialNumber: " + serialNumber + "; prizeTicket: " + prizeTicket;		
	}
}