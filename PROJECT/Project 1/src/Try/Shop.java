package Try;

public class Shop {
	 private static ComputerAccessoriseOreder[] ComputerAccessoriseList = new ComputerAccessoriseOreder[1000];
		private static int count = 0;
		
			 static void addGroceryItemOrder1(ComputerAccessoriseOreder ComputerAccessorise){
				 ComputerAccessoriseList[count] = ComputerAccessorise;
			count++;
		 
		}
		
		static void showAll(){
			for(int index=0; index < count; index++){
				if(ComputerAccessoriseList[index] != null){
					ComputerAccessoriseList[index]. showGroceryItemOrder1Details();
					System.out.println();
				}			
			}
		}
		
		static int searchGroceryItem(int info){
			boolean found = false;
			for(int index=0; index < count; index++){
				int value = ComputerAccessoriseList[index].getQuantity();
				if(info == value){
					found = true;
					System.out.println("Grocery Item Found");
					ComputerAccessoriseList[index].showGroceryItemOrder1Details();
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
				ComputerAccessoriseList[decision] = null;
				System.out.println("Grocery Item Deleted\n");
				showAll();
			}
		}

			public static void addComputerAccessoriseOreder(ComputerAccessoriseOreder g8) {
				// TODO Auto-generated method stub
				
			}

}
