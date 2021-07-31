
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
