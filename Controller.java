import models.GoldenTicket;
import models.OLS;
import models.TicketsBase;
import models.Kid;
import models.Creature;
import models.OompaLoompa;
import models.ReadWriteFile;
import models.Product;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat; 
import java.io.LineNumberReader;
import java.io.File;
import java.io.FileReader;

public class Controller{    
    Scanner sc = new Scanner(System.in);
    TicketsBase ticketsBase;
    ArrayList<Kid> kids;
    ArrayList<Kid> winners;
    ArrayList<OompaLoompa> oompaLoompas;
    String ticketsString = "";
    String productString = "";
    String listOfKids = "";
    String listOfOL = "";
    ArrayList<Integer> codesOfBeings;
    ArrayList<Product> products;
    ArrayList<GoldenTicket> raffledTickets;
    ArrayList<GoldenTicket> allTickets;

    public Controller() throws Exception {
        ticketsBase = new TicketsBase();
        allTickets = new ArrayList<>();
        startTicketsBase();
        products = new ArrayList<>();
        startProducts();
        kids = new ArrayList<>();
        startKids();
        oompaLoompas = new ArrayList<>(); 
        codesOfBeings = new ArrayList<>();
        raffledTickets = new ArrayList<>();
        winners = new ArrayList<>();
    }
    
    private void startTicketsBase() throws Exception{
        try{
            ticketsBase.addTicket(new GoldenTicket("111", "2000/02/02"));
            ticketsBase.addTicket(new GoldenTicket("222", "2005/02/02"));
            ticketsBase.addTicket(new GoldenTicket("333", "2010/02/02"));
        }catch(Exception ex){
            System.out.println("Adding tickets error!!!");
        }
        
        ArrayList <GoldenTicket> goldenTickets = ticketsBase.getGoldenTickets();
        for(GoldenTicket goldT : goldenTickets){
            allTickets.add(goldT);
            ticketsString = ticketsString + goldT + "\n";
        }

        try{
            String pathToFile = "D:\\Second desktop\\git\\models\\txts\\ListOfGoldenTickets.txt";
            ReadWriteFile.writeFile(pathToFile, ticketsString);
        }catch(Exception ex){
            System.out.println("Can't write to the file");
        }
    }

    private void startProducts() throws Exception{
        try{
            products.add(new Product("banana", 123L, "1231"));
            products.add(new Product("banana", 123L, "1232"));
            products.add(new Product("banana", 123L, "1233"));
        }catch(Exception ex){
            System.out.println("Adding products error!!!");
        }

        for(Product prod : products){
            productString = productString + prod + "\n";
        }

        try{
            String pathToFile = "D:\\Second desktop\\git\\models\\txts\\GeneralProducts.txt";
            ReadWriteFile.writeFile(pathToFile, productString);
        }catch(Exception ex){
            System.out.println("Can't write to the file");
        }
    }

    private void startKids() throws Exception{
        try{
            kids.add(new Kid(111, "Alex", "2000/02/02", "Kursk"));
            kids.add(new Kid(222, "Peter", "1990/02/02", "London"));
            kids.add(new Kid(333, "Nick", "1995/02/02", "Paris"));
        }catch(Exception ex){
            System.out.println("Adding kids error!!!");              
        }
    }

    public void addTicket() throws Exception{
        int check = 1;
        String code = "";
            do{
                System.out.println("Write the ticket's code");
                code = sc.next();
                for (int i = 0; i < ticketsBase.getGoldenTickets().size(); i++){
                    if (ticketsBase.getGoldenTickets().get(i).getCode().equals(code)){
                        System.out.println("This code is already exist");
                        check = 0;
                        break;
                    } else{ check = 1; }
                }
            }while(check == 0);

        System.out.println("Write the ticket's raffled date");
        String raffled = sc.next();

        try{
            GoldenTicket gt = new GoldenTicket(code, raffled);
            ticketsBase.addTicket(gt);
            allTickets.add(gt);
            ticketsString = ticketsString + gt + "\n";
        }catch(Exception ex){
            System.out.println("Golden Ticket alarm");
        }

        try{
            String pathToFile = "D:\\Second desktop\\git\\models\\txts\\ListOfGoldenTickets.txt";
            ReadWriteFile.writeFile(pathToFile, ticketsString);
        }catch(Exception ex){
            System.out.println("Can't write to the file");
        }
    }
        
    public void listGoldenTickets(){
        for(int i = 0; i < allTickets.size(); i++){
            System.out.println(allTickets.get(i));
        }
    }

    public void getSong() throws Exception{
        System.out.println("Write the number of lines");
        int lines = sc.nextInt();
        OLS olSong = new OLS(lines);
        String pathToFile = "D:\\Second desktop\\git\\models\\txts\\OompaLoompaSong.txt";
        String pathForFile = "D:\\Second desktop\\git\\models\\txts\\GeneratedSong.txt";
        String song = ""; 
        try{
            for (int i = 0; i < olSong.getLines(); i++){
                Random rand = new Random();
                int randLine = rand.nextInt(ReadWriteFile.readFile(pathToFile).size());
                System.out.println(ReadWriteFile.readFile(pathToFile).get(randLine));
                song = song + ReadWriteFile.readFile(pathToFile).get(randLine) + "\n";
            }
            ReadWriteFile.writeFile(pathForFile, song);
        }catch(Exception ex){
            System.out.println("Can't create a song");
        }
    }

    public void createBeing(){
        int option = 0;
        int check = 1;
        String pathToFile = "";
        System.out.println("Who do you want to create?\n 1 - Kid\n 2 - OompaLoompa");
        option = sc.nextInt();
        try{
            switch(option){
                case 1:
                    int codeK = 0;
                    do{
                        System.out.println("Write a code");
                        codeK = sc.nextInt();
                        for (int i = 0; i < codesOfBeings.size(); i++){
                            if (codesOfBeings.get(i) == codeK){
                                System.out.println("This code is already exist");
                                check = 0;
                                break;
                            } else{ check = 1; }
                        }
                    }while(check == 0);                    
                    codesOfBeings.add(codeK);
                    sc.nextLine();
                    System.out.println("Write a name");
                    String nameK = sc.next();
                    System.out.println("Write a date of birth(format: yyyy/MM/dd)");
                    String birthday = sc.next();
                    System.out.println("Write a place of birth");
                    String placeOfBirth = sc.next();
                    Kid kid = new Kid(codeK, nameK, birthday, placeOfBirth);
                    kids.add(kid);                  
                    break;                  
                case 2:
                    int codeO = 0;
                    do{
                        System.out.println("Write a code");
                        codeO = sc.nextInt();
                        for (int i = 0; i < codesOfBeings.size(); i++){
                            if (codesOfBeings.get(i) == codeO){
                                System.out.println("This code is already exist");
                                check = 0;
                                break;
                            } else{ check = 1; }
                        }
                    }while(check == 0);                    
                    codesOfBeings.add(codeO);
                    sc.nextLine();
                    System.out.println("Write a name");
                    String nameO = sc.next();
                    System.out.println("Write a height");
                    float height = sc.nextFloat();
                    System.out.println("Write a favorite food");
                    String favoriteFood = sc.next();
                    OompaLoompa oompaL = new OompaLoompa(codeO, nameO, height, favoriteFood);
                    oompaLoompas.add(oompaL);
                    
                    listOfOL = listOfOL + oompaL + "\n";    
                    pathToFile = "D:\\Second desktop\\git\\models\\txts\\ListOP.txt";
                    ReadWriteFile.writeFile(pathToFile, listOfOL);
                    break;
                default:
                    System.out.println("Wrong option!!!");
            }
        }catch(Exception ex){
                System.out.println("Something is wrong");
        }        
    }

    public void createProduct() throws Exception{
        int check = 1;
        System.out.println("Write a description");
        String description = sc.next();
        System.out.println("Write a barcode");
        Long barcode = sc.nextLong();

        String serialNumber = "";
        do{
            System.out.println("Write a serialNumber");
            serialNumber = sc.next();
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getSerialNumber().equals(serialNumber)){
                    System.out.println("This serial number is already exist");
                    check = 0;
                    break;
                }else { check = 1; }
            }
        }while(check == 0);

        Product prod = new Product(description, barcode, serialNumber);
        products.add(prod);

        productString = productString + prod + "\n";  
        try{
            String pathToFile = "D:\\Second desktop\\git\\models\\txts\\GeneralProducts.txt";
            ReadWriteFile.writeFile(pathToFile, productString);
        }catch(Exception ex){
            System.out.println("Can't write new product to the file");
        }
    }

    public void createSale() throws Exception{
        int check = 1;
        int code = 0;
        Long barcode = 0L;
        Product addProd = new Product();
        do{
            System.out.println("Write a code");
            code = sc.nextInt();
            for (int i = 0; i < kids.size(); i++){
                if (kids.get(i).getCode() == code){
                    check = 1;
                    break;
                } else{ check = 0; }
            }
            if (check == 0){ System.out.println("This code doesn't exist"); }
        }while(check == 0); 

        do{
            System.out.println("Write a barcode");
            barcode = sc.nextLong();
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getBarcode() == barcode){
                    check = 1;
                    break;
                } else { check = 0; }
            } 
            if (check == 0){ System.out.println("This barcode doesn't exist"); }  
        }while(check == 0);

        ArrayList<Product> prodForRand = new ArrayList<>();
        for(Product prod : products){
            if(prod.getBarcode() == barcode){
                prodForRand.add(prod);
            }
        }

        Random rand = new Random();
        int randProd = rand.nextInt(prodForRand.size());
        addProd = prodForRand.get(randProd);
        
        for(Kid kid : kids){
            if(kid.getCode() == code){
                kid.setProducts(addProd);
                if(addProd.getPrizeTicket() != null){
                    winners.add(kid);
                }
            }
        }
        products.remove(addProd);

        productString = "";
        for(Product prod : products){
            productString = productString + prod + "\n";
        }

        try{
            String pathToFile = "D:\\Second desktop\\git\\models\\txts\\GeneralProducts.txt";
            ReadWriteFile.writeFile(pathToFile, productString);
        }catch(Exception ex){
            System.out.println("Can't change product file");
        }
    }

    public void ruffleTickets() throws Exception{
        int check = 1;
        int randProd = 0;
        System.out.println("Write a number of tickets for raffle");
        int number = sc.nextInt();
        sc.nextLine();
        if (number > products.size()){
            System.out.println("You don't have enough products, I'm gouing to ruffle only " +  products.size() + " tickets");
            number = products.size();
        }
        if(number <= ticketsBase.getGoldenTickets().size()){
            for(int i = 0; i < number; i++){
                do{
                    Random rand = new Random();
                    randProd = rand.nextInt(products.size());
                    if (products.get(randProd).getPrizeTicket() == null) {
                        check = 1;
                        break;
                    } else { check = 0; }
                } while(check == 0);
                products.get(randProd).setPrizeTicket(ticketsBase.getGoldenTickets().get(0));
                ticketsBase.getGoldenTickets().get(0).setCheck(true);
                productString = "";
                for(int j = 0; j < products.size(); j++){
                    productString = productString + products.get(j) + "\n";            
                    try{
                        String pathToFile = "D:\\Second desktop\\git\\models\\txts\\GeneralProducts.txt";
                        ReadWriteFile.writeFile(pathToFile, productString);
                    }catch(Exception ex){
                        System.out.println("Can't ruffle tickets to product file");
                    }
                }

                raffledTickets.add(ticketsBase.getGoldenTickets().get(0));
                ticketsBase.getGoldenTickets().remove(ticketsBase.getGoldenTickets().get(0));
            }
        } else { System.out.println("You don't have enough ticketes"); }
    }

    public void listRaffledTickets(){
        if (raffledTickets.size() == 0){
            System.out.println("No ruffled tickets");
        }else{
            for(int i = 0; i < raffledTickets.size(); i++){
                System.out.println(raffledTickets.get(i));
            }
        }
    }

    public void listWinners() throws Exception{
        for(int i = 0; i < winners.size(); i++){
            System.out.println("Name: " + winners.get(i).getName());
            listOfKids = listOfKids + winners.get(i) + "\n";
            
            try{
                String pathToFile = "D:\\Second desktop\\git\\models\\txts\\ListKids.txt";
                ReadWriteFile.writeFile(pathToFile, listOfKids);
            }catch(Exception ex){
                System.out.println("Can't change product file");
            }
        }
    }
}