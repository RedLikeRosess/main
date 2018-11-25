package models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Kid extends Creature{
	private Date birthday;
	private SimpleDateFormat SimpBirthday = new SimpleDateFormat("yyyy/MM/dd");
	//ArrayList<Product> listOfProducts;
	private String placeOfBirth;

	public Kid(int code, String name, String birthday, String placeOfBirth)throws Exception{
		super(code, name);
		this.placeOfBirth = placeOfBirth;
		this.birthday = SimpBirthday.parse(birthday);
		//listOfProducts = new ArrayList<Product>();
	}

	public String getPlaceOfBirth(){
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth){
		this.placeOfBirth = placeOfBirth;
	}

	public Date getBirthday(){
		return birthday;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	@Override
	public String toString(){
		return "code " + code + " name " + name + " place " + placeOfBirth + " date " + birthday;		
	}
}