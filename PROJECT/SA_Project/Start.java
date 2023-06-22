import java.lang.*;
import classes.*;
import interfaces.*;
import file.*;
import java.util.*;

public class Start
{	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		FoodCourt b = new FoodCourt();
		
		FileReadWriteDemo frwd = new FileReadWriteDemo();

		boolean choice = true;

		while(choice)
		{
			System.out.println("Please Choose from the Main Menu: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Employee Management");
			System.out.println("2. Restaurant Management");
			System.out.println("3. Restaurant FoodItem Management");
			System.out.println("4. FoodItem Quantity Add-Sell");
			System.out.println("5. Exit");
			System.out.println("--------------------------------------\n");

			System.out.print("Enter Your Choice: ");
			int option = sc.nextInt();

			switch(option)
			{
				case 1:
					System.out.println("\n--------------------");
					System.out.println("EMPLOYEE MANAGEMENT\n");
					System.out.println("What do you want to do?\n");
					System.out.println("--------------------------------------\n");
					System.out.println("1. Insert New Employee");
					System.out.println("2. Remove Existing Employees");
					System.out.println("3. Show All Employees");
                    System.out.println("4. Search An Employee");
					System.out.println("5. Go Back");
					System.out.println("--------------------------------------\n");
					System.out.print("Enter your option: ");

					int choice1 = sc.nextInt();

					switch(choice1)
					{
						case 1:
							System.out.println("\n--------------------");
							System.out.println("INSERT NEW EMPLOYEE\n");
							
							System.out.print("Enter Employee ID: ");
							String empId1 = sc.next();

							System.out.print("Enter Employee Name: ");
							String name1 = sc.next();

							System.out.print("Enter Salary: ");
							double salary = sc.nextDouble();

							Employee e1 = new Employee();
							e1.setEmpId(empId1);
							e1.setName(name1);
							e1.setSalary(salary);

							if(b.insertEmployee(e1)) {System.out.println("Employee Inserted... ID: "+empId1);}
							else{System.out.println("Oops... Something is Wrong...");}

							System.out.println("\n--------------------\n");

							break;

						case 2:
							System.out.println("\n--------------------\n");
                            System.out.println("REMOVE EXISTING EMPLOYEE\n");

                            System.out.print("Enter Employee ID: ");
                            String empId3 = sc.next();

                            Employee e3 = b.searchEmployee(empId3);

                            if(e3 != null)
							{
                            	if(b.removeEmployee(e3)) { System.out.println("Employee Removed... ID: " + e3.getEmpId()); }
								else{System.out.println("Oops... Something is Wrong...");}
							}
							else { System.out.println("Sorry... No Employee Found to Remove..."); }

                            System.out.println("----------------------\n");
							
                            break;

						case 3:
							System.out.println("\n--------------------\n");
                            System.out.println("SHOW ALL EMPLOYEE");

                            b.showAllEmployees();
                            System.out.println("--------------------\n");
							
                            break;

						case 4:
							System.out.println("\n--------------------\n");
                            System.out.println("SEARCH AN EMPLOYEE");

                            System.out.print("Enter Employee ID: ");
                            String empId2 = sc.next();

                            Employee e2 = b.searchEmployee(empId2);

                            if(e2 != null)
                            {
								System.out.println("Employee Found...........");
                                System.out.println("Employee ID: "+ e2.getEmpId());
                                System.out.println("Employee Name: "+ e2.getName());
                                System.out.println("Employee Salary: "+ e2.getSalary());
                            }
                            else { System.out.println("Sorry... No Employee Found....."); }
                            System.out.println("\n--------------------\n");
                            
							break;

						case 5:
							System.out.println("\n--------------------\n");
							System.out.println("Going Back..............");
							System.out.println("\n--------------------\n");
							break;

						default:
							System.out.println("#####################");
							System.out.println("Invaild Option");
							System.out.println("#####################");
							break;
					}
					
					System.out.println("\n-------------------------\n");
					break;
					
                case 2:
					System.out.println("********************");
                    System.out.println("RESTURANT MANAGEMENT\n");
                    System.out.println("What are your options?\n");
                    System.out.println("--------------------------------------");
                    System.out.println("1. Insert New Restaurant");
                    System.out.println("2. Remove Existing Restaurant");
                    System.out.println("3. Show All Restaurants");
                    System.out.println("4. Search a Restaurant");
                    System.out.println("5. Go Back");
                    System.out.println("--------------------------------------\n");
                   
				   System.out.print("Enter your option: ");
                    int choice2 = sc.nextInt();

                    switch(choice2)
                    {
                        case 1:
							System.out.println("\n----------------------\n");
                            System.out.println("INSERT NEW RESTURANT");
							System.out.println("\n----------------------\n");

                            System.out.print("Enter Restaurant ID: ");
                            String rid1 = sc.next();

                            System.out.print("Enter Restaurant Name: ");
                            String name1 = sc.next();

                            Restaurant r1 = new Restaurant();
                            r1.setRid(rid1);
                            r1.setName(name1);

                            if(b.insertRestaurant(r1)) { System.out.println("Restaurant Inserted... ID: "+rid1); }
							else{ System.out.println("Oops... Something is Wrong..."); }

                            System.out.println("\n----------------------\n");
                            
							break;

                        case 2:
                            System.out.println("\n----------------------\n");
                            System.out.println("REMOVE EXISTING RESTURANT");
							System.out.println("\n----------------------\n");

                            System.out.print("Enter Restaurant ID: ");
                            String rid3 = sc.next();

                            Restaurant c3 = b.searchRestaurant(rid3);

							if(c3 != null){
								if( b.removeRestaurant(c3) ) { System.out.println("Restaurant Removed... ID: " + c3.getRid()); }
								else { System.out.println("Oops... Something is Wrong..."); }
							}

                            System.out.println("\n----------------------\n");
                            
							break;

                        case 3:
                            System.out.println("\n----------------------\n");
                            System.out.println("Show All Restaurants");

                            b.showAllRestaurants();
                            System.out.println("\n----------------------\n");
						   
                            break;

                        case 4:
							System.out.println("\n----------------------\n");
							System.out.println("SEARCH A RESTAURANT");
							System.out.println("\n----------------------\n");

							System.out.print("Enter Restaurant ID: ");
							String rid4 = sc.next();
							
							Restaurant c4 = b.searchRestaurant(rid4);

							if(c4 != null)
							{
								System.out.println("Restaurant Found...........");
								System.out.println("Restaurant ID: "+ c4.getRid());
								System.out.println("Restaurant Name: "+ c4.getName());
							}
							else { System.out.println("Restaurant Does Not Exist"); }
							System.out.println("\n----------------------\n");
							
							break;

                        case 5:
							System.out.println("#####################");
                            System.out.println("Go Back");
                            System.out.println("#####################");
                            break;


                        default:
                            System.out.println("#####################");
                            System.out.println("Invalid Choice");
                            System.out.println("#####################");
                            break;
                    }
                    System.out.println("\n----------------------\n");
                    break;

				case 3:
					System.out.println("\n----------------------\n");
					System.out.println("RESTAURANT FOOD ITEM MANAGEMENT\n");
					System.out.println("\n----------------------\n");

					System.out.println("Here are your options:\n");
					System.out.println("----------------------\n");
					System.out.println("1. Insert New FoodItem");
                    System.out.println("2. Remove Existing FoodItem");
                    System.out.println("3. Show All FoodItems");
					System.out.println("4. Search a FoodItem");
					System.out.println("5. Go Back");
					System.out.println("--------------------------------------\n");
					
					System.out.print("Please enter your option: ");
					int choice3 = sc.nextInt();

					switch(choice3)
					{
						case 1:
							System.out.println("\n----------------------\n");
							System.out.println("INSERT NEW FOODITEM\n");
							System.out.println("\n----------------------\n");

							System.out.println("Which Type of FoodItem Do you Want to Create?");
							System.out.println("1. Main Dish");
							System.out.println("2. Appetizers");
							System.out.println("3. Go Back");

							System.out.print("Your Selected Type: ");
							int type = sc.nextInt();

							FoodItem a = null;

							if(type == 1)
							{
								System.out.print("Enter Dish Number: ");
								String dn1 = sc.next();
								
								System.out.print("Enter Dish Name: ");
								String nameItem = sc.next();

								System.out.print("Enter Available Quantity: ");
								int ir1 = sc.nextInt();

								System.out.print("Enter Dish Category: ");
								String dishType = sc.next();

								System.out.print("Enter Dish Price: ");
								double dishPrice = sc.nextDouble();

								MainDish md = new MainDish();

								md.setFid(dn1);
								md.setName(nameItem);
								md.setAvailableQuantity(ir1);
								md.setCategory(dishType);
								md.setPrice(dishPrice);

								a = md;
							}
							else if(type == 2)
							{
								System.out.print("Enter Appetizer Number: ");
								String appetizerNumber = sc.next();
								
								System.out.print("Enter Appetizer Name: ");
								String appetizerName = sc.next();
								
								System.out.print("Enter Available Quantity: ");
								int appetizerQuantity = sc.nextInt();
								
								System.out.print("Enter Appetizer Size: ");
								String appetizerSize = sc.next();
								
								System.out.print("Enter Appetizer Price: ");
								double appetizerPrice = sc.nextDouble();

								Appetizers apObj = new Appetizers();

								apObj.setFid(appetizerNumber);
								apObj.setName(appetizerName);
								apObj.setAvailableQuantity(appetizerQuantity);
								apObj.setSize(appetizerSize);
								apObj.setPrice(appetizerPrice);

								a = apObj;
							}
							else if(type == 3) { System.out.println("Going Back...."); }
							else
							{ System.out.println("Invalid Type"); }

							if(a != null)
							{
									System.out.print("Enter Restaurant ID: ");
									String rid1 = sc.next();

									if(b.searchRestaurant(rid1).insertFoodItem(a)) { System.out.println("FoodItem inserted....");}
									else{System.out.println("FoodItem Not Inserted");}
							}
							else { System.out.println("Oops Someting is Worng"); }

							System.out.println("\n----------------------\n");
							
							break;

						case 2:
								System.out.println("\n----------------------\n");
								System.out.println("REMOVE A FOODITEM OF A RESTAURANT");
								System.out.println("\n----------------------\n");

								System.out.print("Enter Restaurant ID: ");
								String rid3 = sc.next();

								System.out.print("Enter Food Item Number: ");
								String foodItemNumber3 = sc.next();

								Restaurant cc = b.searchRestaurant(rid3);
								FoodItem aa = cc.searchFoodItem(foodItemNumber3);

								if (aa != null) { cc.removeFoodItem(aa);
								System.out.println("FoodItem removed...."); }
								else{ System.out.println("Account Not Inserted"); }

								System.out.println("\n----------------------\n");
 
							break;

						case 3:
                            System.out.println("\n----------------------\n");
                            System.out.println("Show All Food Items of a Restaurant");
							System.out.println("\n----------------------\n");

                            System.out.print("Enter Restaurant ID: ");
                            String rid4 = sc.next();

                            b.searchRestaurant(rid4).showAllFoodItems();

                            System.out.println("\n----------------------\n");

							break;

						case 4:
							System.out.println("\n----------------------\n");
                            System.out.println("Search a Food Item");
							System.out.println("\n----------------------\n");

                            System.out.print("Enter Restaurant ID: ");
                            String rid2 = sc.next();

                            System.out.print("Enter Food Item Number: ");
                            String foodNumber = sc.next();

                            FoodItem fSObj = b.searchRestaurant(rid2).searchFoodItem(foodNumber);

                            if(fSObj != null)
                            {
                                fSObj.showInfo();
                            }

                            System.out.println("\n----------------------\n");
                            
							break;

						case 5:

							System.out.println("#####################");
							System.out.println("Going Back ....");
							System.out.println("#####################");
							
							break;

						default:

							System.out.println("#####################");
							System.out.println("Invalid Option");
							System.out.println("#####################");
							
							break;
					}

					System.out.println("\n----------------------\n");
					break;

				case 4:
					System.out.println("\n----------------------\n");
					System.out.println("FOODITEM QUANTITY ADD/ SELL MANAGEMENT\n");
					System.out.println("\n----------------------\n");

					System.out.println("Here are the Options:\n");
					System.out.println("--------------------------------------");
					System.out.println("1. Add FoodItem Quantity");
					System.out.println("2. Sell FoodItem Quantity");
					System.out.println("3. Show Add/Sell History");
					System.out.println("4. Go Back");
					System.out.println("--------------------------------------\n");

					System.out.print("Enter your option: ");
					int choice4 = sc.nextInt();

					switch(choice4)
					{
						case 1:

							System.out.println("\n----------------------\n");
							System.out.println("ADD FOODITEM\n");
							System.out.println("\n----------------------\n");

							System.out.print("Enter Restaurant ID: ");
							String rid1 = sc.next();

							System.out.print("Enter Food Item Number: ");
							String an1 = sc.next();

							System.out.print("Enter Add Quantity: ");
							int amount1 = sc.nextInt();

							if(amount1>0)
							{
								b.searchRestaurant(rid1).searchFoodItem(an1).addQuantity(amount1);
								frwd.writeInFile("Quantity Added : " + amount1 + " in Food Item ID: " + an1);
							}

							if(b.searchRestaurant(rid1)== null){ System.out.println("Restaurant ID Not Found!"); } 
							else{ System.out.println("Food Item ID Not Found!"); }

							System.out.println("\n----------------------\n");

							break;

						case 2:
							System.out.println("\n----------------------\n");
							System.out.println("SELL FOODITEM");
							System.out.println("\n----------------------\n");

							System.out.print("Enter Restaurant ID: ");
							String rid2 = sc.next();
							
							System.out.print("Enter Food Item Number: ");
							String an2 = sc.next();
							
							System.out.print("Enter Sell Quantity: ");
							int amount2 = sc.nextInt();

								if (amount2 > 0 && amount2 <= b.searchRestaurant(rid2).searchFoodItem(an2).getAvailableQuantity()) 
								{
									b.searchRestaurant(rid2).searchFoodItem(an2).sellQuantity(amount2);
									frwd.writeInFile("Quantity Sold	: " + amount2 + " from Food Item ID: " + an2);
								}
							System.out.println("\n----------------------\n");
							
							break;

						case 3:
							System.out.println("\n----------------------\n");
							System.out.println("SHOW ADD/ SELL HISTORY");
							frwd.readFromFile();

							System.out.println("\n----------------------\n");
							
							break;

						case 4:
							System.out.println("#####################");
							System.out.println("Going Back..");
							System.out.println("#####################");
							
							break;

						default:
							System.out.println("#####################");
							System.out.println("Invalid Option");
							System.out.println("#####################");
							break;
					}

					System.out.println("\n----------------------\n");
					break;

				case 5:

					System.out.println("********************");
					System.out.println("Exit");
					choice = false;
					System.out.println("********************");
					break;

					default:
					System.out.println("Invalid");
					break;
        }
      }

	}
}
