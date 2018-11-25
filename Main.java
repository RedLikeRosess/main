import java.util.Scanner;

public class Main{
	
	public static void main (String args []) throws Exception{		
		int option = 0;
		int numOfLines = 0;
		Controller c = new Controller();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Select from list: \n 1 - Register prize ticket \n 2 - Show all prize tickets" +  
				"\n 3 - list raffled tickets \n 4 - Create a new Oompa Loompa song" + 
				"\n 5 - Register beings \n 6 - Register products \n 7 - Raffle tickets" +
				"\n 8 - Register sale \n 9 - List winners \n 0 - exit");
			option = sc.nextInt();			
			try{
				switch(option){
					case 1:
                        c.addTicket();
                        break;					
					case 2:
                        c.listGoldenTickets();
                        break;
					case 3:
                        //c.listRaffledTickets();
                        break;
                    case 4:
						c.getSong();
                    	break;
                    case 5:
                    	c.createBeing();
                    	break;
                    case 6:
                    	c.getKids();
                    	//c.createProduct();
                    	break;
                    case 7:
                    	//c.raffleTickets();
                    	break;
                    case 8:
                    	//c.createSale();
                    	break;
                    case 9:
                    	//c.listWinners();
                    	break;				
					case 0:				
                        break;
					default:
						System.out.println("Wrong option!!!");
				}
			}catch(Exception ex){
				System.out.println("Something is wrong");
			}
		}while(option != 0);		
	}
}