//Gal Tabecka 201668001
public class PreferredCustomer extends Customer {

	private int discount;
	
	//constructor
	public PreferredCustomer(int id, String name, int amountPurchases, int discount) throws Exception {
		
		super(id, name, amountPurchases);
		this.discount = discount;
	}

	public void setDiscount(int discount) {
		
		this.discount = discount;
	}
	
	//this function uses attributes of inheritance and polymorphism to print the details of a preferred customer 
	public String toString(){
		
		return super.toString() + " (discount " + discount + "%) " + getClass().getName();
	}
	
	//this function overrides the equals function found in the 'Object' class
	public boolean equals(Object o){
		
		boolean result = false;
		//if both customers are gold customers
		if(this instanceof GoldCustomer && o instanceof GoldCustomer){
			PreferredCustomer c = (PreferredCustomer)o;
			result = super.equals(c) && this.discount == c.discount;
		}
		//if both customers are preferred but not gold
		else if(this instanceof PreferredCustomer && o instanceof PreferredCustomer){
			PreferredCustomer c = (PreferredCustomer)o;
			result = super.equals(c) && this.discount == c.discount;
		}
		//if the object 'o' is an integer (for the search() function)
		else if(o instanceof Integer){
			int x = (int)o;
			return super.equals(x);
		}
		//if all conditions are unmet - return false
		return result;
	}
	
	public void payments(){
		
		//variables
		final int MAX = 50000;
		final int CRITERIA = 10000;
		int payment = this.getAmountPurchases();
		
		if(this.getAmountPurchases() > CRITERIA){//if payment is above the minimum required for a discount
			//some math to calculate payment after discount
			double percentage = 1-((double)this.discount/100);
			payment =(int)(this.getAmountPurchases()*percentage);
		}
		if(payment >= MAX){//if payments is above 50000 - payment becomes 50000
			if(this instanceof GoldCustomer){
				payment = MAX;
			}
		}
		System.out.println("\t"+payment);	
	}
	
	public void revenues(int helper[], int index){
		
		//variables
		final int MAX = 50000;
		final int CRITERIA = 10000;
		int payment = this.getAmountPurchases();
		
		if(this.getAmountPurchases() > CRITERIA){//if payment is above the minimum required for a discount
			double percentage = 1-((double)this.discount/100);
			payment =(int)(this.getAmountPurchases()*percentage);
		}
		//if payment after discount is above 50000 AND the customer is a gold customer then put the max amount of 50000 in the array of integers
		if(payment >= MAX){
			if(this instanceof GoldCustomer){
				payment = MAX;
				helper[index] = payment;
			}
			else{//if payment after discount is above 50000 but the customer is not a gold one
				helper[index] = payment;
			}
		}
		else{//if all of the above conditions are false, just put the value of payment in the correct index in helper array
			helper[index] = payment;
		}
	}
	
}
