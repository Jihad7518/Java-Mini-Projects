 class Organization{
 
	//GroceryItemOrder1 g;
 private static GroceryItemOrder1[] groceryList = new GroceryItemOrder1[1000];
	private static int count = 0;
	
		 static void addGroceryItemOrder1(GroceryItemOrder1 grocery){
		groceryList[count] = grocery;
		count++;
	 
	}
	
	static void showAll(){
		for(int index=0; index < count; index++){
			if(groceryList[index] != null){
				groceryList[index]. showGroceryItemOrder1Details();
				System.out.println();
			}			
		}
	}
	
	static int searchGroceryItem(int info){
		boolean found = false;
		for(int index=0; index < count; index++){
			int value = groceryList[index].getQuantity();
			if(info == value){
				found = true;
				System.out.println("Grocery Item Found");
				groceryList[index].showGroceryItemOrder1Details();
				return index;
				 
			}
		}
		
		if(!found)
			System.out.println("Grocery Item Not Found");

		return -1;
	}
	 
	 	static void removeGroceryItem(int info){
		int decision = searchGroceryItem(info);
		if(decision >= 0){
			groceryList[decision] = null;
			System.out.println("Grocery Item Deleted\n");
			showAll();
		}
	}
		 
}