import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;


public class C206_CaseStudy {
	//define ArrayList variables as global here, Menu methods need MenuItem Arraylists to work
	static ArrayList<MenuItem> MenuItemList = new ArrayList<MenuItem>();
	static ArrayList<Menu> menuList = new ArrayList<Menu>();
	static ArrayList<Order> orderList = new ArrayList<Order>();
	static ArrayList<Account> accountList = new ArrayList<Account>();
	public static String menuName;
	public static int menuSize;
	public static int menuMonth;
	
	//Code re-factoring for order options
	private static final int ORDER_OPTION = 10;
	private static final int ORDER_ADD = 1;
	private static final int ORDER_DELETE = 2;
	private static final int ORDER_VIEW = 3;
	private static final int ORDER_UPDATE_DATE = 4;
	private static final int ORDER_QUIT = 5;

	
	public static void main(String[] args) throws CloneNotSupportedException {

		MenuItemList.add(new MenuItem("Western", "Fish and Chips", false, 4.00));
		MenuItemList.add(new MenuItem("Western", "Carbonara", false, 4.00));
		MenuItemList.add(new MenuItem("Asian", "Wanton Noodles", false, 3.00));
		MenuItemList.add(new MenuItem("Asian", "Chicken Rice", false, 3.00));
		MenuItemList.add(new MenuItem("Vegetarian", "Salad", true,6.00 ));
		MenuItemList.add(new MenuItem("Vegetarian", "Vegetable Fried Rice", true,6.00 ));
		
		int option = 0;
		
		while (option !=16) {
			C206_CaseStudy.optionMenu();
			option = Helper.readInt("Enter Option > ");
			
			if(option == 1) {
				// add menu item
				C206_CaseStudy.addMenuItem(MenuItemList);
			}else if(option == 2) {
				//delete menu item
				C206_CaseStudy.deleteMenuItem(MenuItemList);
			} else if (option == 3) {
				// view menu item
				C206_CaseStudy.viewAllMenuItem(MenuItemList);
			}
			else if(option == 4) {
				//search menu item 
				C206_CaseStudy.searchMenuItem(MenuItemList);
				
			}else if(option == 5) {
				//update menu item 
				C206_CaseStudy.updateMenuItem(MenuItemList);
				
			}else if(option == 6) {
				//create menu object
				createMenuFields();

				
			}else if(option == 7) {
				//delete menu object
				C206_CaseStudy.getDeleteMenuField();
				
			}else if(option == 8) {
				//view all Menu objects
				System.out.println(C206_CaseStudy.viewAllMenu(menuList));			
			}else if(option == 9) {
				//update menu object
				C206_CaseStudy.getUpdateMenuField();
			}				

			else if (option == ORDER_OPTION) {
				C206_CaseStudy.orderMenu();
				int choice = Helper.readInt("Enter order choice: ");				

				if (choice == ORDER_ADD) {
					C206_CaseStudy.addOrder(orderList);
				}						
				else if (choice == ORDER_DELETE) {
					C206_CaseStudy.deleteOrder(orderList);
				}
				else if (choice == ORDER_VIEW) {
					C206_CaseStudy.viewOrder(orderList);
				}
				else if (choice == ORDER_UPDATE_DATE) {
					C206_CaseStudy.updateOrderDate(orderList);
				}
				else if (choice == ORDER_QUIT) {
					System.out.println("Thank you for ordering!");
					C206_CaseStudy.optionMenu();
				}						
				else {
					System.out.println("You have entered an invalid order choice");
				}	
			}
			else if (option == 11) {
				C206_CaseStudy.createAccount(accountList);
			}
			else if (option == 12) {
				C206_CaseStudy.viewAccount(accountList);
			}
			else if (option == 13) {
				C206_CaseStudy.delAccount(accountList);
			}
			else if (option == 14) {
				C206_CaseStudy.updateAccount(accountList);
			}
			else if (option == 15) {
				C206_CaseStudy.searchAccount(accountList);
			}
			
			else {
				if(option!=16) {
					System.out.println("Invalid Option");
				}
			}
		}
		System.out.println("Thank You");
	}
				
	
	public static void optionMenu() {
		Helper.line(60,"=");
		System.out.println("School Lunch App");
		Helper.line(60,"=");
		System.out.println("1. Add Menu Item");
		System.out.println("2. Delete Menu Item");
		System.out.println("3. View Menu Item");
		System.out.println("4. Search Menu Item");
		System.out.println("5. Update Menu Item");
		System.out.println("6. Create Menu");
		System.out.println("7. Delete Menu");
		System.out.println("8. View All Menus");
		System.out.println("9. Update A Menu");
		System.out.println("10. Create Order");
		System.out.println("11. Create Account");
		System.out.println("12. View Account");
		System.out.println("13. Delete Account");
		System.out.println("14. Update Account");
		System.out.println("15. Search Account");
		System.out.println("16. Quit");
	}
	
	//Sub menu for the order method
	
	public static void orderMenu() {
		Helper.line(60,"=");
		System.out.println("Choose order option");
		Helper.line(60,"=");
		System.out.println("1. Add Order");
		System.out.println("2. Delete Order");
		System.out.println("3. View Order");
		System.out.println("4. Exit Order Option");
		
	}
	
	// ==================================== Add menu item ==============================================
	public static void addMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("ADD MENU ITEM");
		Helper.line(60,"=");
		
		boolean existed = false;
		boolean invalid = false;
		String category = Helper.readString("Enter Item's Category: ");
		String name = Helper.readString("Enter Item's Name: ");
		boolean healthyChoice = Helper.readBoolean("Is The Item A Healthier Choice? (Y/N) ");
		double price = Helper.readDouble("Enter Item's Price: ");
		
		for (MenuItem mi : MenuItemList) {
			if (mi.getName().equalsIgnoreCase(name)) {
				existed = true;
			} else if (existed == false && price <=0) {
				invalid = true;
			} else{
				existed = false;
			}
		}
		if (existed == false && price > 0 ) {
			MenuItem menuItem = new MenuItem(category, name, healthyChoice, price);
			MenuItemList.add(menuItem);
			System.out.println("Menu Item Added");
		}else if (invalid == true) {
			System.out.println("invalid price value");
		}else{
			System.out.println("item exist");
		}
	}
	//===================================== delete menu item ===========================================
	public static void deleteMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("DELETE MENU ITEM");
		Helper.line(60,"=");
		
		boolean delete = false;
		String itemDelete = Helper.readString("Enter Item's Name To Delete: ");		
		
		for (int i = 0; i < MenuItemList.size(); i++) {
			if (MenuItemList.get(i).getName().equals(itemDelete)){
				MenuItemList.remove(i);
				delete = true;
			}
		}
			if(delete = true) {
				System.out.println("Item Deleted");
			}else {
				System.out.println("Item Not Deleted");
			}				
		}

	//===================================== view menu item group by category =============================================
	public static void viewAllMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("VIEW MENU ITEM");
		Helper.line(60,"=");
		
		String output = "";
		
		MenuItemList.sort(new CategorySorter());
		
		output += String.format("%-20s %-20s %-30s %-30s\n", "CATEGORY", "NAME", "HEALTHY CHOICE", "PRICE");
		for(int i = 0; i < MenuItemList.size(); i++) {
			output += String.format("%-20s %-20s %-30b %-30s\n", MenuItemList.get(i).getCategory(), MenuItemList.get(i).getName(), 
					MenuItemList.get(i).isHealthyChoice(),MenuItemList.get(i).getPrice());
			
		}
		System.out.println(output);
	}

	//===================================== search menu item =============================================
	public static void searchMenuItem(ArrayList<MenuItem> MenuItemList) {		
		Helper.line(60,"=");
		System.out.println("SEARCH MENU ITEM");
		Helper.line(60,"=");
		
		String output = "";
		
		String search = Helper.readString("Enter Item's Name You Looking For: ");
		
		Helper.line(60,"-");
		System.out.println(String.format("%-10s %-10s %-20s %-10s", "CATEGORY", "NAME", "HEALTHY CHOICE", "PRICE"));
		Helper.line(60,"-");
		
		for (int i = 0; i < MenuItemList.size(); i++) {
			if (MenuItemList.get(i).getName().equalsIgnoreCase(search)){
				output += String.format("%-10s %-10s %-20b %-10s\n", MenuItemList.get(i).getCategory(), MenuItemList.get(i).getName(), 
						MenuItemList.get(i).isHealthyChoice(),MenuItemList.get(i).getPrice());
			}
		}
		System.out.println(output);
	}
		
	//===================================== update menu item =============================================
	public static void updateMenuItem(ArrayList<MenuItem> MenuItemList) {
		boolean updated = false;
		boolean exist = false;
		boolean invalid = false;
		C206_CaseStudy.viewAllMenuItem(MenuItemList);
		
		Helper.line(60,"=");
		System.out.println("UPDATE MENU ITEM");
		Helper.line(60,"=");
	
		String searchName = Helper.readString("Enter Item's Name You Want To Update: ");
		String newName = Helper.readString("Enter Item's New Name: ");
		double newPrice = Helper.readDouble("Enter Item's New Price: ");
		
		for (MenuItem mi : MenuItemList) {
			if (!mi.getName().equals(searchName)) {
				exist = false;
			}
			if (mi.getName().equals(searchName)&& newPrice >0){
				updated = true;
				exist = true;
				mi.setName(newName);
				mi.setPrice(newPrice);
			}
			if (!mi.getName().equals(searchName) && newPrice <=0){
				exist = true;
				invalid = true;
			}
		}
		
		if(exist == true && updated == true) {
			System.out.println("Menu Item Updated");
		}else if (exist == false) {
			System.out.println("Menu Item does not exist");
		} else if(invalid == true) {
			System.out.println("Cannot Update. Invalid price value");
		}
		
		// results after updating 
		String output = "";
		
		Helper.line(20,"-");
		System.out.println("UPDATED MENU ITEM LIST");
		Helper.line(20,"-");
		
		for (int i = 0; i < MenuItemList.size(); i++) {
			output += String.format("%-20s %-20s %-30b %-30s\n", MenuItemList.get(i).getCategory(), MenuItemList.get(i).getName(), 
					MenuItemList.get(i).isHealthyChoice(),MenuItemList.get(i).getPrice());
			
		}
		System.out.println(output);
	}

	
	//Initialize Menu object fields
			public static void createMenuFields() {
		Helper.line(60,"=");
		System.out.println("CREATE NEW MENU");
		Helper.line(60,"=");
		
		menuName=Helper.readString("Enter Name of Menu >");
		menuMonth=Helper.readInt("Please enter Menu's month >");
		Random ranMenuItem=new Random();
		if(menuMonth>=1 && menuMonth<=12) {
		 menuSize=Helper.readInt("Please enter amount of items in Menu >");
		if(menuSize<=MenuItemList.size()) {
			int choice=0;
			while(choice!=1 && choice!=2)
			{
				choice=Helper.readInt("Would You like to randomly generate the menu items or manually select them?\nEnter 1 for manual selection,2 for automatic generation >");
			}
			int count=0;
			ArrayList<MenuItem> menuContent=new ArrayList<MenuItem>();
			while(count<menuSize) {
				if(choice==1) {
				boolean exists=false;
				MenuItem selectedMenuItem=null;
				viewAllMenuItem(MenuItemList);
				String selected=Helper.readString("Please enter the name of the menu item to be added to the menu >");
				for(MenuItem i:MenuItemList) {
					if(i.getName().equalsIgnoreCase(selected)) {
						exists=true;
						selectedMenuItem=i;
					}
				}
				if(exists) {
					if(menuContent.size()>0) {
					boolean alreadyAdded=false;
					if(menuContent.contains(selectedMenuItem)) {
						alreadyAdded=true;
					}
					if(alreadyAdded) {System.out.println("The following item is already added to the Menu Item list!");}
					else {
						menuContent.add(selectedMenuItem);	
						count++;
					}
					}
					else if (menuContent.size()==0) {
						menuContent.add(selectedMenuItem);
					count++;
					}
				}
				else {System.out.println("This menu item does not exist");}
			}
			
			else if (choice==2){

				int random=ranMenuItem.nextInt(MenuItemList.size());
				if(!menuContent.contains(MenuItemList.get(random))) {
					menuContent.add(MenuItemList.get(random));
					count++;
			
				}

			}

		}
		C206_CaseStudy.createMenuObject(menuList, menuName, menuMonth, menuSize, menuContent);
		}
		else {
			System.out.println("Not enough unqiue items in Menu Item List!");
		}
		}
		else {
			System.out.println("Please enter a valid month integer (1-12).");
		}
		}
		// View All Menu objects from Menu Array global variable
		public static String viewAllMenu(ArrayList<Menu> menuList) {
			if(menuList.size()==0) {
				return "Menu bank is empty.";
			}
			else {
				Helper.line(60,"=");
				System.out.println("VIEWING ALL MENUS");
				Helper.line(60,"=");
				
				String output = String.format("%-20s %-10s %-10s %s\n", "NAME", "MONTH", "NO. OF ITEMS", "ITEMS");
				for(Menu i:menuList) {
					output+=i.toString();
				}
				return output;
			}
		}
		//create Menu with fields as parameter
			public static void createMenuObject(ArrayList<Menu> menuList,String displayName,int month,int numberOfItems,ArrayList<MenuItem> menuSelection) {
				Menu newMenu=new Menu(displayName,month,numberOfItems,menuSelection);
				menuList.add(newMenu);
				System.out.println("Menu added!");
			}

			public static void getDeleteMenuField() {
			Helper.line(60,"=");
			System.out.println("DELETE MENU");
			Helper.line(60,"=");
			System.out.println(viewAllMenu(menuList));
			
			String selectedMenu = Helper.readString("Enter Menu Name to Delete: ");
			 deleteMenu(menuList ,selectedMenu);
			}
			// Delete a Menu Object from Menu Array global variable
			public static String deleteMenu(ArrayList<Menu> menuList,String menuName) {

				if(menuList.size()>0) {
					boolean foundMenu=false;
			
			for (int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getDisplayName().toLowerCase().equalsIgnoreCase(menuName)) {
					menuList.remove(i);
					foundMenu=true;

					return "Menu deleted.";

				} 
			}
			if(!foundMenu) {

					return "Menu not found!";

			}
				
		}
				return "Menu array is empty!";

			}	
			
			public static void getUpdateMenuField() {
				Helper.line(60,"=");
				System.out.println("UPDATE MENU");
				Helper.line(60,"=");
				System.out.println(viewAllMenu(menuList));

				String selectedMenu = Helper.readString("Enter Menu Name to Update: ");
				 System.out.println(updateMenu(menuList ,selectedMenu));
				}
				// Delete a Menu Object from Menu Array global variable
				public static String updateMenu(ArrayList<Menu> menuList,String menuName) {

					if(menuList.size()>0) {
						boolean foundMenu=false;

				for (int i = 0; i < menuList.size(); i++) {
					if(menuList.get(i).getDisplayName().toLowerCase().equalsIgnoreCase(menuName)) {
						String newName=Helper.readString("Enter new Menu Name >");
						int newMonth=Helper.readInt("Enter the month for this menu>");

						foundMenu=true;

						return doUpdateMenu(newName,newMonth,menuList.get(i));

					} 
				}
				if(!foundMenu) {

						return "Menu not found!";

				}

			}
					return "Menu array is empty!";

				}
				
				public static String doUpdateMenu(String name,int month,Menu target) {

					if(month<=12 && month>=1) {
						target.setDisplayName(name);
						target.setMonth(month);		
						return "Menu Updated.";
					}
					else {return "Month value is invalid!";}
				}
	
		//-----------------------------------ORDER METHODS------------------------------------------------------------------------
		public static void addOrder(ArrayList<Order> orderList) {
		//Create a fixed ID pattern
		String pattern = "[PS][0-9]{4}";
		boolean isFound = false;
					
		//Call the view all menu items for user to choose from
		C206_CaseStudy.viewAllMenuItem(MenuItemList);
					
		//userChoices saves the order details of the student
		ArrayList <MenuItem> userChoices = new ArrayList<MenuItem>();
					
		String studentID = Helper.readStringRegEx("Enter your student ID(P/S followed by your 4 digit unique ID) > ", pattern);
		if (studentID.matches(pattern)) {
			String orderDate = Helper.readString("Enter the order date in the format dd/mm/yyyy > ");
			//num of Meals is how many food items the student or parents wants to order
			int numOfMeals = Helper.readInt("Enter the amount of meals to order > ");
					
			for (int orderObject = 1; orderObject <= numOfMeals; orderObject++) {
				String mealchoice = Helper.readString("Enter the name of the food > ");
				for (MenuItem mealObject : MenuItemList) {
					if (mealObject.getName().equalsIgnoreCase(mealchoice)) {
						isFound = true;
						userChoices.add(mealObject);
						System.out.println("Your order of "+ mealchoice +" is successful!");
						System.out.println("You have ordered a total of " + orderObject + " meal(s).");
						}
					}
			}
			
			if (isFound == false) {
				System.out.println("The menu item you entered could not be found");
			}
				Order newOrder=new Order(studentID, orderDate, userChoices);
				orderList.add(newOrder);
			}
		}
				
				public static void updateOrderDate (ArrayList<Order> orderList) {
					//Create Student ID pattern 
					String pattern = "[PS][0-9]{4}";
					String studentID = Helper.readStringRegEx("Enter your student ID > ", pattern);

					if (studentID.matches(pattern)) {
						//Cycle through the orderList to find the student ID and date
						for (int i = 0; i < orderList.size(); i ++) {
							if(studentID.equalsIgnoreCase(orderList.get(i).getStudentid())) {
								String updateDate = Helper.readString("Enter the date you want to update > ");
								
								if (updateDate.equalsIgnoreCase(orderList.get(i).getOrderDate())) {
									String newDate = Helper.readString("Enter the new date > ");
									orderList.get(i).setOrderDate(newDate);
									System.out.println("The date has been updated!");
								}
								else {
									System.out.println("The date cannot be found");
								}
							}
							
							else {
								System.out.println("The Student ID cannot be found");
							}
						}
					}
				}
				
				
				
				//DELETE ORDER
				public static void deleteOrder(ArrayList<Order> orderList) {
				
					boolean isDeleted = false;
					String pattern = "[PS][0-9]{4}";
					String deleteUser = Helper.readStringRegEx("Enter your student ID > ", pattern);
					
					if (deleteUser.matches(pattern)) {
						
						String deleteItem = Helper.readString("Enter the date for order you wish to delete> ");
						
						for (int i=0; i<orderList.size(); i++ ) {
							
							if (deleteUser.equalsIgnoreCase(orderList.get(i).getStudentid())) {
								if (deleteItem.equalsIgnoreCase(orderList.get(i).getOrderDate())) {
									orderList.remove(i);
									isDeleted = true;
									System.out.println("The order has been successfully deleted");
								}
							}
						}
						
						if (isDeleted == false) {
							System.out.println("An error has occured when deleting the menu item.");
						}
					}
					
					else {
						System.out.println("You have entered an invalid student ID. ");
					}

				}
				
				//VIEW ORDER Keen
				public static void viewOrder(ArrayList<Order> orderList) {

					boolean isFoundDate = false;
					String pattern = "[PS][0-9]{4}";
					String studentID = Helper.readStringRegEx("Enter your student ID to view your order > ", pattern);
					
					if (studentID.matches(pattern)) {
					
						String dateView = Helper.readString("Enter the date of the order you want to view > ");
						String output = "";
						output += String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "MENU ITEM");
						
						for (int i=0; i<orderList.size(); i ++) {
				
							if (dateView.equalsIgnoreCase(orderList.get(i).getOrderDate())) {
								output += String.format("%-20s %-20s %-20s\n", orderList.get(i).getStudentid(), orderList.get(i).getOrderDate(), orderList.get(i).getItems());
								isFoundDate = true;
								System.out.println(output);
							}
						}
						
					}
					
					if (isFoundDate == false) {
						System.out.println("The order date specified could not be found. ");
					}

					
				}
	//Create Account
	public static void createAccount(ArrayList<Account> accountList) {
		Helper.line(60,"=");
		System.out.println("CREATE NEW ACCOUNT");
		Helper.line(60,"=");
		boolean existing = false;
		
		String username = Helper.readString("Enter Username: ");
		String pw = Helper.readString("Enter Password: ");
		int cn = Helper.readInt("Enter Contact Number: ");
		String id = Helper.readString("Enter ID: ");
		
		for (Account acc : accountList) {
			if (acc.getUsername().equalsIgnoreCase(username)) {
				existing = true;
			}
		}
		if (existing == false) {
			Account account = new Account(username,pw,id,cn);
			accountList.add(account);
			System.out.println("Account Created!");
		}else {
			System.out.println("Username Exists!");
		}
		
	}
	
	//View Account
	public static void viewAccount(ArrayList<Account> accountList) {
		Helper.line(60,"=");
		System.out.println("VIEW ACCOUNTS");
		Helper.line(60,"=");
		
		String output = "";
		
		output += String.format("%-10s %-10s %10s\n", "USERNAME","STUDENT ID", "CONTACT NUMBER");
		for (int i = 0; i < accountList.size(); i++) {
			output += String.format("%-10s %-10s %10s\n", accountList.get(i).getUsername(), accountList.get(i).getStudentid(), accountList.get(i).getContactnumber());
		}
		System.out.println(output);
	}
	
	//Delete Account
	public static void delAccount(ArrayList<Account> accountList) {
		Helper.line(60,"=");
		System.out.println("DELETE ACCOUNT");
		Helper.line(60,"=");
		
		String userDelete = Helper.readString("Enter Username To Delete: ");
		
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getUsername().toLowerCase().equalsIgnoreCase(userDelete)) {
				accountList.remove(i);
				System.out.println("Account Deleted");
				break;
				
			} else {
				System.out.println("Account Deleted");
			}
		}
	}
	
	//Update Account
	public static void updateAccount(ArrayList<Account> accountList) {
		Helper.line(60,"=");
		System.out.println("UPDATE ACCOUNT");
		Helper.line(60,"=");
		boolean exists = false;
		boolean existing = false;
		
		String userUpdate = Helper.readString("Enter Username To Update: ");
		
		String newusername = Helper.readString("Enter New Username: ");
		int newcn = Helper.readInt("Enter New Contact Number: ");
		String newpw = Helper.readString("Enter New Password: ");
		
		for (Account acc : accountList) {
			if (acc.getUsername().equalsIgnoreCase(userUpdate)) {
				exists = true;
			}
		
			
		if(exists == true) {
			for (Account acct : accountList) {
				if (acct.getUsername().equalsIgnoreCase(newusername)) {
					existing = true;
				}
			}
			if(existing == false) {
				for (int i = 0; i < accountList.size(); i++) {
					if(accountList.get(i).getUsername().toLowerCase().equalsIgnoreCase(userUpdate)) {
						accountList.get(i).setUsername(newusername);
						accountList.get(i).setPassword(newpw);
						accountList.get(i).setContactnumber(newcn);
						System.out.println("Account Updated");
						break;
					}
				}
			}
			else {
				System.out.println("Username already exists");
			}
			
			}
		else {
			System.out.println("Username does not exist");
			}
		}
	}
	
	//Search Account
	public static void searchAccount(ArrayList<Account> accountList) {
		Helper.line(60,"=");
		System.out.println("SEARCH ACCOUNTS");
		Helper.line(60,"=");
		
		String id = Helper.readString("Enter ID: ");
		
		String output = "";
		
		output += String.format("%-10s %-10s %10s %10s\n", "USERNAME", "PASSWORD","STUDENT ID", "CONTACT NUMBER");
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getStudentid().equalsIgnoreCase(id)) {
				output += String.format("%-10s %-10s %10s %10s\n", accountList.get(i).getUsername(), accountList.get(i).getPassword(), accountList.get(i).getStudentid(), accountList.get(i).getContactnumber());
			}
			else if(id == ""){
				System.out.println("Field is empty");
			}
			else {
				System.out.println("Account cannot be found ");
			}
		}
		System.out.println(output);
	}
		
		
		
	
	
}


