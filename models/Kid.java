package models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Kid extends Creature{
	private Date birthday;
	private SimpleDateFormat SimpBirthday = new SimpleDateFormat("yyyy/MM/dd");
	protected ArrayList<Product> listOfProducts;
	private String placeOfBirth;

	public Kid(int code, String name, String birthday, String placeOfBirth)throws Exception{
		super(code, name);
		this.placeOfBirth = placeOfBirth;
		this.birthday = SimpBirthday.parse(birthday);
		listOfProducts = new ArrayList<Product>();
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

	public ArrayList<Product> getProducts(){
		return this.listOfProducts;
	}

	public void setProducts(Product product){
		this.listOfProducts.add(product);
	}

	@Override
	public String toString(){
		return "code: " + code + "; name: " + name + ";\nplace: " + placeOfBirth + "; date: " + birthday + ";\nproducts: " + listOfProducts;		
	}
}