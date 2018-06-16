//Gal Tabecka 201668001
public class Customer {
	
	//variables
	private int id;
	private String name;
	private int amountPurchases; 
	
	//empty constructor
	public Customer(){
		
	}
	
	//constructor 
	public Customer(int id, String name, int amountPurchases) throws Exception{
		
		this.name = name;
		this.amountPurchases = amountPurchases;
		this.setId(id);
	}

	//set id method which 
	public void setId(int id) throws Exception{
		
		try {
			this.id = id;
			if (id < 1)
				throw new Exception();	
		} catch (Exception ex) {
			System.out.println(this.toString());
			System.out.println("==> Id can't be less than 1");
			System.out.close();
		}
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public void setAmountPurchases(int amountPurchases) {
		
		this.amountPurchases = amountPurchases;
	}
	
	public int getAmountPurchases(){
		
		return this.amountPurchases;
	}
	
	public String toString(){
		
		String str = String.format("%2d - %-12s %8d", id, name, amountPurchases);
		return str;
	}
	
	public boolean equals(Object o){
		
		boolean result = false;
		//if both customers are preferred customers
		if(this instanceof PreferredCustomer && o instanceof PreferredCustomer){
			Customer c = (Customer)o;
			result = (this.id == c.id || (this.name == c.name && this.amountPurchases == c.amountPurchases));
			return result;
		}
		//if 'this' customer is not preferred and 'o' customer is a preferred one then there's no way that they match - so return false
		else if(!(this instanceof PreferredCustomer) && o instanceof PreferredCustomer){
			return result;
		}
		//if the object 'o' is an integer (for the search() function)
		else if(o instanceof Integer){
			int x = (int)o;
			return this.id == x;
		}
		//if the code reaches here then both customers ('this' and 'o') are not preferred customers, so just check the fields and return true or false accordingly
		Customer c = (Customer)o;
		result = this.id == c.id || (this.name == c.name && this.amountPurchases == c.amountPurchases);
		return result;
	}
	
	public void payments(){
			//aligning the text and printing the amount
			System.out.println("\t\t\t\t\t"+this.getAmountPurchases());
	}
	
	public void revenues(int helper[], int index){
		//putting the amount value in the correct index in helper array
		helper[index] = this.getAmountPurchases();
	}
}
