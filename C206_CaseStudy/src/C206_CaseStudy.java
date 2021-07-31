
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		//========================================== ADD USER ==========================================
	public static User inputUser()
	{
		String name = Helper.readString("Enter Name >> ");
		String email = Helper.readString("Enter Email >> ");
		String password = Helper.readString("Enter Password >> ");
		String role = Helper.readString("Enter Role >> ");

		User u5 = new User(name, email, password, role);
		return u5;
	}
	public static void addUser(ArrayList<User> userList, User u5)
	{
		userList.add(u5);
		System.out.println("User added.");
	}
	
	//===================================== VIEW ALL USERS ========================================= 
	public static String retrieveAllUsers(ArrayList<User> userList)
	{
		String output = "";
		
		for(int e = 0; e < userList.size(); e++)
		{
			output += String.format(" %-10s %-30s %-10s\n", userList.get(e).getName(), userList.get(e).getEmail(), userList.get(e).getRole());
		}
		return output;
	}
	
	public static void viewAllUsers(ArrayList<User> userList)
	{
		C206_CaseStudy.setHeader("==================== USERS LIST ====================");
		String output = String.format("%-10s %-30s %-10s\n", "NAME", "EMAIL", "ROLE");
		output += retrieveAllUsers(userList);
		System.out.println(output);
	}
	
	//===================================== DELETE ALL USERS ========================================= 
	public static void deleteUser(ArrayList<User> userList)
	{
		C206_CaseStudy.viewAllUsers(userList);
		String email = Helper.readString("Enter User Email > ");
		Boolean isDeleted = doDeleteUser(userList, email);
		
		if(isDeleted == false)
		{
			System.out.println("Invalid user email");
		}
		else
		{
			System.out.println("User " + email + "deleted!");
		}
	}
	
	public static boolean doDeleteUser(ArrayList<User> userList, String email)
	{
		boolean isDeleted = false;
		deleteUser(userList, email);
		return isDeleted;
	}
	
	public static String deleteUser(ArrayList<User> userList, String email) 
	{
		boolean isDeleted = false;
		String output = "";
		for (int e = 0; e < userList.size(); e++) 
		{
			if (email == userList.get(e).getEmail())
			{
				String confirm = Helper.readString("Confirm delete user " + email + "? (Yes/No) >> ");
				if (confirm.equalsIgnoreCase("Yes")) 
				{
					userList.remove(e);
					output = "You have successfully deleted user " + email;
					System.out.println(output);
					isDeleted = true;
				}
				else if (confirm.equalsIgnoreCase("No")){
					output = "You have cancelled the deletion of user " + email;
					System.out.println(output);
					isDeleted = false;
				}				
			}
			else 
			{
				output = "Please enter valid email.";
				System.out.println(output);
				isDeleted = false;
			}
		}

		if (isDeleted != true) {
			output = "Deletion of user " + email + " failed.";
			System.out.println(output);
		}
		return output;
	}

}
/*
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args){
		
	// array list of items depending on your class 
		//---------------------------------------------------------------- USER -----------------------------------------------------------------------------------------
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("John Lim", "johnlim@C206.com", "12345", "Buyer"));
		userList.add(new User("James Tan", "jamestan@C206.com", "67890", "Buyer"));
		userList.add(new User("Susan Chan", "susanchan@C206.com", "54321", "Seller"));
		userList.add(new User("Joan Lee", "joanlee@C206.com", "09876", "Admin"));
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------
		
    // template
    int option = 0;
    
    int OPTION_QUIT = 6;
	while(option != OPTION_QUIT){
    	
    	mainmenu();
    	option = Helper.readInt("Enter your option > ");
    	
    	if(option == 1) // part 1
    	{
    		userMenu();
    		int userChoice = Helper.readInt("Enter an option > ");
    		if (userChoice == 1) // view
    		{
    			viewAllUsers(userList);
    		}
    		else if (userChoice == 2) // add
    		{
    			User newUser = inputUser();
    			addUser(userList, newUser);
    		}
    		else if (userChoice == 3) // delete
    		{
    			C206_CaseStudy.setHeader("DELETE USER");
    			C206_CaseStudy.deleteUser(userList);
    		}
    		
    	}
    	else if (option == 2)
    	{
    		categoryMenu();
    		int categoryChoice = Helper.readInt("Enter an option > ");
    		
    		if(categoryChoice == 1)
    		{
    			
    		}
    		else if (categoryChoice == 2)
    		{
    			
    		}
    		else if (categoryChoice == 3)
    		{
    			
    		}
    	}
    	else if (option == 3)
    	{
    		itemMenu();
    		int itemChoice = Helper.readInt("Enter an option > ");
    		
    		if(itemChoice == 1)
    		{
    			
    		}
    		else if(itemChoice == 2)
    		{
    			
    		}
    		else if(itemChoice == 3)
    		{
    			
    		}
    	}
    	else if (option == 4)
    	{
    		bidMenu();
    		int bidChoice = Helper.readInt("Enter an option > ");
    		
    		if(bidChoice == 1)
    		{
    			
    		}
    		else if(bidChoice == 2)
    		{
    			
    		}
    		else if(bidChoice == 3)
    		{
    			
    		}
    	}
    	else if (option == 5)
    	{
    		dealMenu();
    		int dealChoice = Helper.readInt("Enter an option > ");
    		
    		if(dealChoice== 1)
    		{
    			
    		}
    		else if(dealChoice == 2)
    		{
    			
    		}
    		else if(dealChoice == 3)
    		{
    			
    		}
    	}
    	else if ( option == OPTION_QUIT)
    	{
    		System.out.println("Goodbye");
    	}
    	else
    	{
    		System.out.println("Invalid option");
    		
    	}
    	
    }
		
				
	}
	
	// program layouts
	public static void mainmenu()
	{	
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. User functions");
		System.out.println("2. Category functions");
		System.out.println("3. Item functions");
		System.out.println("4. Bidding functions");
		System.out.println("5. Dealing functions");
		System.out.println("6. Quit App");
		Helper.line(80, "-");
	}
	public static void categoryMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all categories");
		System.out.println("2. Add an category ");
		System.out.println("3. Delete an category");
		Helper.line(80, "-");
		
	}
	public static void itemMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all items");
		System.out.println("2. Add an item");
		System.out.println("3. Delete an item");
		Helper.line(80, "-");
		
	}
	public static void bidMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all bids");
		System.out.println("2. Add a bid (based on id)");
		System.out.println("3. Delete a bid (based on id)");
		Helper.line(80, "-");
	}
	public static void dealMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all deals");
		System.out.println("2. Add a deal(based on id)");
		System.out.println("3. Delete a deal(based on id)");
		Helper.line(80, "-");
		
	}
	public static void userMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all users");
		System.out.println("2. Add a user");
		System.out.println("3. Delete a deal(based on email)");
		Helper.line(80, "-");
		
	}
	public static void LoginMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. Login");
		System.out.println("2. Register"); 	
	}
	public static void setHeader(String header)
	{
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//========================================== ADD USER ==========================================
	public static User inputUser()
	{
		String name = Helper.readString("Enter Name >> ");
		String email = Helper.readString("Enter Email >> ");
		String password = Helper.readString("Enter Password >> ");
		String role = Helper.readString("Enter Role >> ");

		User newUser = new User(name, email, password, role);
		return newUser;
	}
	public static void addUser(ArrayList<User> userList, User newUser)
	{
		userList.add(newUser);
		System.out.println("User added.");
	}
	
	//===================================== VIEW ALL USERS ========================================= 
	public static String retrieveAllUsers(ArrayList<User> userList)
	{
		String output = "";
		
		for(int e = 0; e < userList.size(); e++)
		{
			output += String.format("%-10s %-20s %-10s\n", userList.get(e).getName(), userList.get(e).getEmail(), userList.get(e).getRole());
		}
		return output;
	}
	
	public static void viewAllUsers(ArrayList<User> userList)
	{
		C206_CaseStudy.setHeader("==================== USERS LIST ====================");
		String output = String.format("%-10s %-20s %-10s\n", "NAME", "EMAIL", "ROLE");
		output += retrieveAllUsers(userList);
		System.out.println(output);
	}
	
	//===================================== DELETE USER ========================================= 
	public static void deleteUser(ArrayList<User> userList)
	{
		C206_CaseStudy.viewAllUsers(userList);
		String email = Helper.readString("Enter User Email > ");
		Boolean isDeleted = doDeleteUser(userList, email);
		
		if(isDeleted == false)
		{
			System.out.println("Invalid user email");
		}
		else
		{
			System.out.println("User " + email + "deleted!");
		}
	}
	
	public static boolean doDeleteUser(ArrayList<User> userList, String email)
	{
		boolean isDeleted = false;
		deleteUser(userList, email);
		return isDeleted;
	}
	
	public static String deleteUser(ArrayList<User> userList, String email) 
	{
		boolean isDeleted = false;
		String output = "";
		for (int e = 0; e < userList.size(); e++) 
		{
			if (email == userList.get(e).getEmail())
			{
				String confirm = Helper.readString("Confirm delete user " + email + "? (Yes/No) >> ");
				if (confirm.equalsIgnoreCase("Yes")) 
				{
					userList.remove(e);
					output = "You have successfully deleted user " + email;
					System.out.println(output);
					isDeleted = true;
				}
				else if (confirm.equalsIgnoreCase("No")){
					output = "You have cancelled the deletion of user " + email;
					System.out.println(output);
					isDeleted = false;
				}				
			}
			else 
			{
				output = "Please enter valid email.";
				System.out.println(output);
				isDeleted = false;
			}
		}

		if (isDeleted != true) {
			output = "Deletion of user " + email + " failed.";
			System.out.println(output);
		}
		return output;
	}

}

*/
