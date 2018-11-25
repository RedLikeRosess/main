package models;

public class OompaLoompa extends Creature{
	private float height;
	private String favoriteFood;

	public OompaLoompa(int code, String name, float height, String favoriteFood){
		super(code, name);
		this.height = height;
		this.favoriteFood = favoriteFood;
	}

	public float getHeight(){
		return height;
	}

	public void setHeight(float code){
		this.height = height;
	}

	public String getFavoriteFood(){
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood){
		this.favoriteFood = favoriteFood;
	}

	@Override
	public String toString(){
		return "code " + code + " name " + name + " height " + height + " favorite food " + favoriteFood;		
	}
}