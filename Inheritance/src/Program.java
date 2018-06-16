//Gal Tabecka 201668001
import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {
	final static int MAX = 11;

	public static void main(String[] args) throws Exception{
		//variables
		double id = 0;
		boolean fExit = false;
		Customer arr[] = new Customer[MAX];
		Scanner s = new Scanner(System.in);
		
		//initializing the array with all kinds of customer as instructed
		arr[0] = new GoldCustomer(1, "Rothschild", 500000, 30);
		arr[1] = new GoldCustomer(2, "Bill Gates", 300000, 10);
		arr[2] = new Customer(3, "Tali", 20);
		arr[3] = new PreferredCustomer(4, "James Bond", 3000, 20);
		arr[4] = new Customer(5, "Rothschild", 500000);
		arr[5] = new PreferredCustomer(6, "Tali", 20, 20);
		arr[6] = new GoldCustomer(7, "Tali", 20, 20);
		arr[7] = new GoldCustomer(8, "Rothschild", 500000, 30);
		arr[8] = new PreferredCustomer(9, "Rothschild", 500000, 30);
		arr[9] = new Customer(10, "Rothschild", 500000);
		arr[10] = new PreferredCustomer(11, "Tali", 20, 20);
		//arr[10] = new GoldCustomer(-2, "Bill Gates", 300000, 10) - replace this line with line 27 to check negative id number
		
		
		//calling the various functions
		printDuplicate(arr);
		System.out.println("----------------------------------------");
		print(arr);
		System.out.println("----------------------------------------");
		payments(arr);
		System.out.println("----------------------------------------");
		totalRevenues(arr);
		System.out.println("----------------------------------------");
		
		
		//do while loop for repeating id input
		do{
			try{
				fExit = true;
				System.out.println("Please enter an ID to search: ");
				id = s.nextDouble();
				if(id < 1){
					throw new Exception();
				}
			}
			
			catch(InputMismatchException ex){
				System.out.println("==> ID has to be an Integer");
				s.nextLine();
				fExit = false;
			}
			
			catch (Exception ex) {
				System.out.println("==> ID can't be less than 1");
				fExit = false;
			}
		
		}while(!fExit);
		
		//calling 'search' function
		search(arr, id);
		
	}
	
	
	//this first function gets an array of customers and prints the details of each one
	public static void printDuplicate(Customer arr[]){
	
		int i;
		System.out.println("All Customers:");
		for(i = 0; i < MAX; i++){
			System.out.println(arr[i].toString());
		}	
	}
	
	//second function that prints details without duplications
	public static void print(Customer arr[]){
		
		Customer arr2[] = new Customer[MAX];//arr2 is sort of a helper array that i created which will hold just one unique copy of each customer
		int i, j, k = 0, count = 0;//variables and count 
		System.out.println("All customers without duplications:");
		
		for(i = 0; i < MAX; i++){
			for(j = i+1; j < MAX; j++){
				if(arr[i].equals(arr[j])){//if this condition is met, meaning is that there are two identical customers and count will increase by 1
					count++;
					break;	
				}
			}
			if(count == 0){//if count is 0 by this point, the customer in arr[i] is unique and this enters the helper array - arr2.
				arr2[k] = arr[i];
				k++;
			}
			count = 0;//resetting count
		}
		for(i = 0; i < k; i++){//printing unique customers held in arr2
			System.out.println(arr2[i].toString());
		}
	}
	
	public static void payments(Customer arr[]){
		
		//pretty much did the same 'trick' as in the print function in order to end up with an array that holds all unique customers
		Customer arr2[] = new Customer[MAX];
		int i, j, k = 0, count = 0;
		System.out.println("Customers and their payments (without duplications):");
		
		for(i = 0; i < MAX; i++){
			for(j = i+1; j < MAX; j++){
				if(arr[i].equals(arr[j])){
					count++;
					break;	
				}
			}
			if(count == 0){
				arr2[k] = arr[i];
				k++;
			}
			count = 0;
		}
		for(i = 0; i < k; i++){
			System.out.print(arr2[i].toString());//printing the customers
			arr2[i].payments();//printing the payment each customer had to pay to the bank
		}
	}
	
	public static void totalRevenues(Customer arr[]){
	
		//same 'trick' here - after the nested for loops has ended i'm left with an array that holds all unique customers
		Customer arr2[] = new Customer[MAX];
		int i, j, k = 0, count = 0;
		
		for(i = 0; i < MAX; i++){
			for(j = i+1; j < MAX; j++){
				if(arr[i].equals(arr[j])){
					count++;
					break;	
				}
			}
			if(count == 0){
				arr2[k] = arr[i];
				k++;
			}
			count = 0;
		}
		
		//this is a helper array that will hold the calculated payment each unique customer has to pay the bank
		int helper[] = new int[k];
		int total = 0;//initializing total revenues count
		for(i = 0; i < k; i++){
			arr2[i].revenues(helper, i);//each time i'm sending the array if integers and an index to the correct spot within the array
			total += helper[i];//adding each iteration
		}
		System.out.println("Total revenues from all customers (without duplications): "+total);
	}
	
	public static void search(Customer arr[], double id){
		//variables
		int fixedId = (int)id;
		boolean outcome = false;
		int i;
		
		for(i = 0; i < MAX; i++){
			if(arr[i].equals(fixedId)){//if condition is met, outcome becomes true
				outcome = true;
				break;
			}
		}
		if(outcome){//if, after for loop, the outcome is true then print the corresponding customer's details
			System.out.println(arr[i].toString());
		}
		else{//print output in the event of a false outcome
			System.out.println("ID doesn't match any customer.");
		}
		
	}
}
