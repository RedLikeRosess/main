import java.util.Scanner;

public class Main{
	
	public static void main (String args []){		
		int option = 0;
		int numOfLines = 0;
		Controller c = new Controller();
		Scanner sc = new Scanner(System.in);
		System.out.println("Select from list: \n 1 - Register prize ticket \n 2 - Show all prize tickets \n 3 - Create a new Oompa Loompa song \n 0- exit" );
		option = sc.nextInt();			
		try{
			switch(option){
				case 1:
					break;					
				case 2:
					break;
				case 3:
					System.out.println("Write a number of lines for song: ");
					numOfLines = sc.nextInt();
					c.getSong(numOfLines);
					break;				
				case 0:				
					break;
				default:
					System.out.println("Wrong option!!!");
			}
		}catch(Exception ex){
			System.out.println("Something is wrong");
		}		
	}
}