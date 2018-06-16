//Gal Tabecka 201668001
public class GoldCustomer extends PreferredCustomer {

	//constructor
	public GoldCustomer(int id, String name, int amountPurchases, int discount) throws Exception {
		
		super(id, name, amountPurchases, discount);
	}
	
	
	public boolean equals(Object o){
		
		boolean result = false;
		//if the object 'o' is a gold customer - enter here and check the other equals functions using inheritance
		if(o instanceof GoldCustomer){
			GoldCustomer c = (GoldCustomer)o;
			result = super.equals(c);
		}
		else if(o instanceof Integer){//if the object 'o' is an integer (for the search() function)
			int x = (int)o;
			return super.equals(x);
		}
		return result;
	}

	public void payments(){
		System.out.print("     ");
		super.payments();
	}
	
	public void revenues(int helper[], int index){
		
		super.revenues(helper, index);
	}
}
