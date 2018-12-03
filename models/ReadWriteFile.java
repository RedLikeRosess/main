package models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFile{

	public ReadWriteFile(){}

	public static List<String> readFile(String file) throws Exception{  //make it static
	       FileReader fr = new FileReader(file);
                Scanner sc = new Scanner(fr);
                List<String> list = new ArrayList<String>();
 		
                while (sc.hasNextLine()) {
                        list.add(sc.nextLine());
                }
                fr.close();
                return list;
	        }
        
        public static void writeFile(String file, String content) throws Exception{   //make it static
	       	FileWriter fw = new FileWriter(file);
                fw.write(content);
                fw.close();
	}
}