import models.GoldenTicket;
import models.OLS;
import models.TicketsBase;
import models.Kid;
import models.Creature;
import models.OompaLoompa;
import models.ReadWriteFile;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller{    
    Scanner sc = new Scanner(System.in);
    ReadWriteFile rf = new ReadWriteFile();
    TicketsBase ticketsBase;
    ArrayList<Kid> kids;

    public Controller() throws Exception {
            ticketsBase = new TicketsBase();
            startTicketsBase();
            kids = new ArrayList<>();
    }
    
    private void startTicketsBase() throws Exception{
        ticketsBase.addTicket(new GoldenTicket("111", "2000/02/02"));
        ticketsBase.addTicket(new GoldenTicket("222", "2005/02/02"));
        ticketsBase.addTicket(new GoldenTicket("333", "2010/02/02"));
    }

    public void addTicket() throws Exception{
            System.out.println("Write the ticket's code");
            String code = sc.next();            

            System.out.println("Write the ticket's raffled date");
            String raffled = sc.next();

            GoldenTicket gt = new GoldenTicket(code, raffled);

            ticketsBase.addTicket(gt);
    }
        
    public void listGoldenTickets(){
        ArrayList <GoldenTicket> goldenTickets = ticketsBase.getGoldenTickets();
        for(GoldenTicket goldT : goldenTickets){
            System.out.println(goldT);
        }
    }

    public void getSong() throws Exception{
        System.out.println("Write the number of lines");
        int lines = sc.nextInt();
        OLS olSong = new OLS(lines);
        String pathToFile = "D:\\Second desktop\\git\\models\\OompaLoompaSong.txt";
        for (int i = 0; i < olSong.getLines(); i++){
            Random rand = new Random();
            int randLine = rand.nextInt(rf.readFile(pathToFile).size());
            System.out.println(rf.readFile(pathToFile).get(randLine));
        }
    }

    public void createBeing(){
        int option = 0;
        System.out.println("Who do you want to create?\n 1 - Kid\n 2 - OompaLoompa");
        option = sc.nextInt();
        try{
            switch(option){
                case 1:
                    System.out.println("Write a code");
                    int codeK = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Write a name");
                    String nameK = sc.next();
                    System.out.println("Write a date of birth(format: yyyyMMdd)");
                    String birthday = sc.next();
                    System.out.println("Write a place of birth");
                    String placeOfBirth = sc.next();
                    Kid kid = new Kid(codeK, nameK, birthday, placeOfBirth);
                    System.out.println(kid);
                    break;                  
                case 2:
                    System.out.println("Write a code");
                    int codeO = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Write a name");
                    String nameO = sc.next();
                    System.out.println("Write a height");
                    float height = sc.nextFloat();
                    System.out.println("Write a favorite food");
                    String favoriteFood = sc.next();
                    OompaLoompa oompaL = new OompaLoompa(codeO, nameO, height, favoriteFood);
                    System.out.println(oompaL);
                    break;
                default:
                    System.out.println("Wrong option!!!");
            }
        }catch(Exception ex){
                System.out.println("Something is wrong");
        }
    }

    public ArrayList<Kid> getKids(){
        return kids;
    }
}