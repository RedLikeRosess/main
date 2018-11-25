package models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFile{

	public ReadWriteFile(){}

	public List<String> readFile(String file) throws Exception{
		//"D:\\Second desktop\\git\\models\\OompaLoompaSong.txt"
		/*BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
		String line;
        List<String> list = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        return list;*/
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);
        List<String> list = new ArrayList<String>();
 		
        while (sc.hasNextLine()) {
        	list.add(sc.nextLine());
        }
        fr.close();
        return list;
	}
}