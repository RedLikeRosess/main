package models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;

public class OLS{
	//Attributes
	private int lines;

	//Constructor
	public OLS(int lines){
		this.lines = lines;
	}

	public int getLines(){
		return lines;
	}

	public void setLines(int lines){
		this.lines = lines;
	}
}