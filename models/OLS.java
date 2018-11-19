package models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;

public class OLS{
	//Attributes
	private int lines;

	//Constructor
	public OLS(){}

	public int getLines(){
		return lines;
	}

	public List<String> getLine() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("D:\\Second desktop\\git\\models\\OompaLoompaSong.txt"));
		String line;
        List<String> list = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        return list;
	}
}