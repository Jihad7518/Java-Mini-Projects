 public class GroceryItemOrder1 {
	
	 private String name; 
	 private int quantity; 
	 private double unitPrice; 
	 private String customerName;
	 private String cellPhone;
	//private int size = 10;

	 //int[] items = new int[size];

	 
	public double getCost(){
     double total = unitPrice * quantity;
	 return total;
	}

	 
	int getQuantity(){
		return this.quantity;
	}
	public void setQuantity(int quantity){

		this.quantity = quantity;
	}

	 
	double getUnitPrice(){
		return this.unitPrice;
	}
	public void setUnitPrice(double unitPrice){

		this.unitPrice = unitPrice;
	}
     
	String getName(){
		return this.name;
	}
	public void setName(String name){

		this.name = name;
	}
	
	String getCustomerName(){
		return this.customerName;
	}
	public void setCustomerName(String customerName){

		this.customerName = customerName;
	}
	
	String getCellPhone(){
		return this.cellPhone;
	}
	public void setCellPhone(String cellPhone){

		this.cellPhone = cellPhone;
	}

	public GroceryItemOrder1(String name, int quantity, double unitPrice,String customerName,String cellPhone){

		this.setName(name);
		this.setQuantity(quantity);
		this.setUnitPrice(unitPrice);
		this.setCustomerName(customerName);
		this.setCellPhone(cellPhone);
	}
	 
	/*public String toString(){
		return String.format("%s: %d @ $%.2f",name,quantity,getCost());
	}
	
	  public  double getTotalCost()
   {
      double dblTotalCost = 0;

      for(int i=0; i< items.length; i++)
      {
         dblTotalCost += this.getCost();
      }

      return dblTotalCost;
   } */
  
   
   public void showGroceryItemOrder1Details(){
		System.out.println("Grocery Item Name: " + this.getName());
		System.out.println("Number of Item " + this.getQuantity());
		System.out.println("Price of Item: " + this.getUnitPrice());
	   System.out.println("Customer Name:"+this.getCustomerName());
	   System.out.println("Cell Phone:"+this.getCellPhone());
		System.out.println("Total Cost: " + this.getCost());
		//this.getTotalCost();
	 
	}
}