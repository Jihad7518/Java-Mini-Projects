package Try;

import java.lang.*;
import java.util.*;
import java.io.*;

public class DriverClass{
	public static void main(String args[]) { //throws FileNotFoundException
	/*{
		try 
		{ 
            File obj = new File("Registration.txt");   
            obj.createNewFile();
            File obj1 = new File("Registration1.txt");
            obj1.createNewFile();      
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred");
            e.printStackTrace();      
        }
//Organization o = new Organization();*/
 
		 
		ComputerAccessoriseOreder g1 = new ComputerAccessoriseOreder("Biscuit",1,30.5,"",""); 
		ComputerAccessoriseOreder g2 = new ComputerAccessoriseOreder("Cheaps",1,10.5,"","");
		ComputerAccessoriseOreder g3 = new ComputerAccessoriseOreder("Chocklet",1,40.5,"","");
		ComputerAccessoriseOreder g4 = new ComputerAccessoriseOreder("Milk",1,90.5,"","");
		ComputerAccessoriseOreder g5 = new ComputerAccessoriseOreder("Rice",1,70.5,"","");
		ComputerAccessoriseOreder g6 = new ComputerAccessoriseOreder("Oil",1,180.5,"","");
		ComputerAccessoriseOreder g7 = new ComputerAccessoriseOreder("Soap",1,120.5,"","");
		ComputerAccessoriseOreder g8 = new ComputerAccessoriseOreder("Shampoo",1,700.5,"","");
		ComputerAccessoriseOreder g9 = new ComputerAccessoriseOreder("Bread",1,7.5,"",""); 
		ComputerAccessoriseOreder g10 = new ComputerAccessoriseOreder("Ice creame",1,80.5,"","");
		
		Shop.addComputerAccessoriseOreder(g1);
		Shop.addComputerAccessoriseOreder(g2);
		Shop.addComputerAccessoriseOreder(g3);
		Shop.addComputerAccessoriseOreder(g4);
		Shop.addComputerAccessoriseOreder(g5);
		Shop.addComputerAccessoriseOreder(g6);
		Shop.addComputerAccessoriseOreder(g7);
		Shop.addComputerAccessoriseOreder(g8);
		Shop.addComputerAccessoriseOreder(g9);
		Shop.addComputerAccessoriseOreder(g10);

        System.out.println("\nWelcome to Grocery Shop");
        Scanner sc = new Scanner(System.in);
        boolean choice = true;
        while(choice)
        {
            System.out.println("\nHere are Some Options for You:");
            System.out.println("    1.  Store Owner");
            System.out.println("    2. Customer");
            System.out.println("    3. About this Application.");
            System.out.println("    4. Exit the Application.");
            System.out.println("Enter your Choice:");
            
            int first=sc.nextInt();

            switch(first)
            {
                case 1:
                    System.out.println("\nYou have Selected Store Owner");
                    System.out.println("\nHere are Some Options for You:");
                    System.out.println("    1. Admin Registration.");
                    System.out.println("    2. Admin Login.");
                    System.out.println("    3. Go Back.");           
                    System.out.println("Enter your Choice:");
            
                    int second=sc.nextInt();

                    switch(second)
                    {
                        case 1:
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("\nYou have Selected Admin Registration");
                            System.out.println("Enter User Name: ");
                            String uName1=sc1.nextLine();        
                            System.out.println("Enter Password: ");
                            String pass1=sc1.nextLine();         
                            System.out.println("Confirm Password: ");
                            String conPass1=sc1.nextLine();

                            uName1=uName1.trim();
                            pass1=pass1.trim();
                            conPass1=conPass1.trim();
                            String combine1= uName1+" "+pass1;

                            if(pass1.equals(conPass1))
                            {
                                try
                                {
                                    File f = new File("Registration.txt");
                                    Scanner content1 = new Scanner(f);
                                    int flag = 0;
                                    while (content1.hasNextLine()) 
                                    {
                                        if(content1.nextLine().equals(combine1))
                                        {
                                            System.out.println("\nAlready Registered");
                                            flag = 1;
                                            break;
                                        }          
                                    }
                                    if(flag == 0)
                                    {
                                       try 
                                        {
                                            BufferedWriter out1 = new BufferedWriter(new FileWriter("Registration.txt", true)); 
                                            out1.write(uName1+" "+pass1+"\n");
                                            out1.close();
                                        }
                                        catch (IOException ioe1) 
                                        {
                                            System.out.println("An error occurred");
                                            ioe1.printStackTrace();
                                        }
                                        System.out.println("Successfully Registered");
                                        break;
                                    }        
                                }
                                catch (IOException ioe11)
                                {
                                    System.out.println("An error occurred");
                                    ioe11.printStackTrace();
                                }
                                break;
                            }
                            else
                            {
                                System.out.println("The Password Confirmation and Password must Match");
                            }
                            break;

                        case 2:
                            Scanner sc2=new Scanner(System.in);
                            System.out.println("\nYou have Selected Admin Login");
                            System.out.println("Enter User Name: ");
                            String uName2=sc2.nextLine();       
                            System.out.println("Enter Password: ");
                            String pass2=sc2.nextLine();

                            uName2=uName2.trim();
                            pass2=pass2.trim();
                            String combine2= uName2+" "+pass2;
                  
                            try 
                            {
                                File f = new File("Registration.txt");
                                Scanner content2 = new Scanner(f);
                                int flag = 0;
                                while (content2.hasNextLine()) 
                                {        
                                    if(content2.nextLine().equals(combine2))
                                    {
                                        System.out.println("Admin Login Successful");
                                        System.out.println("\nWelcome to Grocey Shop");
                                        System.out.println("\nHere are Some Options for You:");
                                        System.out.println("    1.Manage Items");
                                        System.out.println("    2.Search for Items");
                                        System.out.println("    3.Go back");
                                        System.out.println("Enter your Choice");

                                        int third=sc.nextInt();
                                        switch(third)
                                        {
                                            case 1:
                                                System.out.println("\nYou have selected Grocery Items");
                                                System.out.println("\nHere are Some Options for You:");
                                                System.out.println("    1.Add Items");
                                                System.out.println("    2.Remove Items");
                                                System.out.println("    3.Go Back");
                                                System.out.println("Enter your Choice:");

                                                int fourth=sc.nextInt();
                                                switch(fourth)
                                                {
                                                    case 1:
                                                        Scanner sc3 = new Scanner(System.in);
                                                        System.out.println("\nYou have selected Add Items.");
                                                        System.out.println("Enter Item name : ");
                                                        String name = sc3.next();
                                                        System.out.println("Enter Quantity  : ");
                                                        int quantity = sc3.nextInt();
                                                        System.out.println("Enter Price : ");
                                                    
                                                    double unitPrice = sc3.nextDouble();
                                                String customerName = sc3.nextLine();
                                             System.out.println("Enter Cell Phone Number : ");
                                                String cellPhone = sc3.nextLine();
                                                  
                                            
                                                ComputerAccessoriseOreder g= new ComputerAccessoriseOreder(name,quantity,unitPrice,customerName,cellPhone);
                            
                                                       
                                                   
                                                        break;

                                                    case 2:
                                                        Scanner sc4 = new Scanner(System.in);
                                                        System.out.println("\nYou have selected Remove Items");                                           
                                                        System.out.println("Enter book Items : ");
                                                        String name2 = sc4.nextLine();
                                                        System.out.println("Enter Quantity : ");
                                                        int quantity2 = sc4.nextInt();
                                                        System.out.println("Enter Price : ");
                                                        double unitPrice2 = sc4.nextDouble();
                                                     
                                            
                                                        //Organization.removeGroceryItemOrder1(Organization.getGroceryItemOrder1(name2));
                                                       break;

                                                    case 3:
                                                        System.out.println("\nYou have Selected Go Back");
                                                        break;
                                                    
                                                    default:
                                                        System.out.println("Invalid Input");
                                                        break;
                                                }

                                            case 2:
                                                Scanner sc5 = new Scanner(System.in);
                                                System.out.println("\nYou have selected Search for Items.");
                                                System.out.println("Enter Item name : ");
                                                String name = sc5.nextLine();
                                                System.out.println("Enter Quantiy : ");
                                                int quantity = sc5.nextInt();
                                                System.out.println("Enter Price : ");
                                               double unitPrice = sc5.nextDouble();
                                            System.out.println( "Total Bill:"+quantity*unitPrice);                                          
                                             System.out.println("Enter Customer Name : ");
                                                String customerName = sc5.nextLine();
                                             System.out.println("Enter Cell Phone Number : ");
                                                String cellPhone = sc5.nextLine();
                                            
                                              
                                             
                                             
                                    System.out.println(" Thank you for buying our products.");
                                            
                                                //Organization.getGroceryItemOrder1(name);                                    
                                                break;

                                            case 3:
                                                System.out.println("You have Selected to Go Back");
                                                break;

                                            default:
                                                System.out.println("Invalid Input");
                                                break;

                                        }
                                        flag = 1;
                                        break;
                                    }
                                    
                                }
                                if(flag == 0)
                                {
                                    System.out.println("Login Failed");
                                    content2.close();
                                    break;
                                }                            
                            } 
                            catch (IOException ioe2) 
                            {
                                System.out.println("An error occurred");
                                ioe2.printStackTrace();
                            }
                            break;

                        case 3:
                            System.out.println("\nYou have Selected Go Back");
                            break;

                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                    break;


                case 2:
                    System.out.println("\nYou have Selected Customer");
                    System.out.println("\nHere are Some Options for You:");
                    System.out.println("    1. Customer Registration.");
                    System.out.println("    2. Customer Login.");
                    System.out.println("    3. Go Back.");           
                    System.out.println("Enter your Choice");

                    int second1=sc.nextInt();

                    switch(second1)
                    {
                        case 1:
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("\nYou have Selected Customer Registration");
                            System.out.println("Enter User Name: ");
                            String uName1=sc1.nextLine();        
                            System.out.println("Enter Password: ");
                            String pass1=sc1.nextLine();         
                            System.out.println("Confirm Password: ");
                            String conPass1=sc1.nextLine();

                            uName1=uName1.trim();
                            pass1=pass1.trim();
                            conPass1=conPass1.trim();
                            String combine1= uName1+" "+pass1;

                            if(pass1.equals(conPass1))
                            {
                                try
                                {
                                    File f = new File("Registration1.txt");
                                    Scanner content1 = new Scanner(f);
                                    int flag = 0;
                                    while (content1.hasNextLine()) 
                                    {
                                        if(content1.nextLine().equals(combine1))
                                        {
                                            System.out.println("\nAlready Registered");
                                            flag = 1;
                                            break;
                                        }          
                                    }
                                    if(flag == 0)
                                    {
                                        try 
                                        {
                                            BufferedWriter out1 = new BufferedWriter(new FileWriter("Registration1.txt", true)); 
                                            out1.write(uName1+" "+pass1+"\n");
                                            out1.close();
                                        }
                                        catch (IOException ioe1) 
                                        {
                                            System.out.println("An error occurred");
                                            ioe1.printStackTrace();
                                        }
                                        System.out.println("Successfully Registered");
                                        break;
                                    }        
                                }
                                catch (IOException ioe11)
                                {
                                    System.out.println("An error occurred");
                                    ioe11.printStackTrace();
                                }
                                break;
                            }
                            else
                            {
                                System.out.println("The Password Confirmation and Password must Match");
                            }
                            break;

                        case 2:
                            Scanner sc2=new Scanner(System.in);
                            System.out.println("\nYou have Selected Customer Login");
                            System.out.println("Enter User Name: ");
                            String uName2=sc2.nextLine();       
                            System.out.println("Enter Password: ");
                            String pass2=sc2.nextLine();

                            uName2=uName2.trim();
                            pass2=pass2.trim();
                            String combine2= uName2+" "+pass2;
                  
                            try 
                            {
                                File f = new File("Registration1.txt");
                                Scanner content2 = new Scanner(f);
                                int flag = 0;
                                while (content2.hasNextLine()) 
                                {        
                                    if(content2.nextLine().equals(combine2))
                                    {
                                        System.out.println("Customer Login Successful");
                                        System.out.println("\nWelcome to Grocery Shop.");
                                        //..........................................................................................................
                                        flag = 1;
                                        break;
                                    }
                                    
                                }
                                if(flag == 0)
                                {
                                    System.out.println("Login Failed");
                                    content2.close();
                                    break;
                                }                            
                            } 
                            catch (IOException ioe2) 
                            {
                                System.out.println("An error occurred");
                                ioe2.printStackTrace();
                            }
                            break;

                        case 3:
                            System.out.println("\nYou have Selected Go Back");
                            break;

                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                    break;
            
                case 3:
                    System.out.println("You have Selected About this Application");
                    break;
                
                case 4:
                    System.out.println("\nYou have selected to exit the application");
                    System.out.println("\nThank you ");
                    choice = false;
                    break;
                
                default:
                    System.out.println("Invalid Input");
                    break;

            }
        } 
        
    }
}
