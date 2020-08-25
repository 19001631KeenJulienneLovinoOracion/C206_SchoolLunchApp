import java.util.ArrayList;

public class C206_CaseStudy {
	//define ArrayList variables as global here, Menu methods need MenuItem Arraylists to work

	static ArrayList<MenuItem> MenuItemList = new ArrayList<MenuItem>();
	static ArrayList<Menu> menuList = new ArrayList<Menu>();
	static ArrayList<Order> orderList = new ArrayList<Order>();
	public static void main(String[] args) {

		//camcorderList.add(new Camcorder("CC001", "Sony HDR-CX405", 35));
		//String category, String name, boolean healthyChoice, double price
		MenuItemList.add(new MenuItem("Western", "Fish and Chips", false, 4.00));
		MenuItemList.add(new MenuItem("Asian", "Wanton Noodles", false, 3.00));
		MenuItemList.add(new MenuItem("Vegetarian", "Salad", true,6.00 ));
		int option = 0;
		
		while (option !=10) {
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
				C206_CaseStudy.createMenu(menuList);
				
			}else if(option == 7) {
				//delete menu object
				C206_CaseStudy.deleteMenu(menuList);
				
			}else if(option == 8) {
				//view all Menu objects
				C206_CaseStudy.viewAllMenu(menuList);				
			}			
			else if (option == 9) {
				C206_CaseStudy.orderMenu();
				int choice = Helper.readInt("Enter order choice: ");				

				if (choice == 1) {
					C206_CaseStudy.addOrder(orderList);
				}						
				else if (choice == 2) {
					C206_CaseStudy.deleteOrder(orderList);
				}
				else if (choice == 3) {
					C206_CaseStudy.viewOrder(orderList);
				}			
				else if (choice ==4) {
					System.out.println("Thank you for ordering!");
					C206_CaseStudy.optionMenu();
				}						
				else {
					System.out.println("You have entered an invalid order choice");

				}	

			}
			else {
				if(option!=9) {
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
		System.out.println("9. Create Order");
		System.out.println("10. Quit");
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

	//===================================== view menu item =============================================
	public static void viewAllMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("VIEW MENU ITEM");
		Helper.line(60,"=");
		
		String output = "";

		output += String.format("%-20s %-20s %-30s %-30s\n", "CATEGORY", "NAME", "HEALTHY CHOICE", "PRICE");
		for (int i = 0; i < MenuItemList.size(); i++) {
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

	
	//create a Menu object and append to Menu Arraylist global variable, checks for duplicate MenuItem entries and validates MenuItem actually 
	//exists in MenuItem global ArrayList variable
	public static void createMenu(ArrayList<Menu> menuList) {
	Helper.line(60,"=");
	System.out.println("CREATE NEW MENU");
	Helper.line(60,"=");
	
	String displayName=Helper.readString("Enter Name of Menu >");
	int month=Helper.readInt("Please enter Menu's month >");
	
	if(month>=1 && month<=12) {
	int numberOfItems=Helper.readInt("Please enter amount of items in Menu >");
	if(numberOfItems<=MenuItemList.size()) {
		int count=0;
		ArrayList<MenuItem> menuSelection=new ArrayList<MenuItem>();
		while(count<numberOfItems) {
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
				if(menuSelection.size()>0) {
				boolean alreadyAdded=false;
				if(menuSelection.contains(selectedMenuItem)) {
					alreadyAdded=true;
				}
				if(alreadyAdded) {System.out.println("The following item is already added to the Menu Item list!");}
				else {
					menuSelection.add(selectedMenuItem);	
				}
				}
				else if (menuSelection.size()==0) {
				menuSelection.add(selectedMenuItem);	
				count++;
				}
			}
			else {System.out.println("This menu item does not exist");}
		}
		Menu newMenu=new Menu(displayName,month,numberOfItems,menuSelection);
		menuList.add(newMenu);
		System.out.println("Menu added!");
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
	public static void viewAllMenu(ArrayList<Menu> menuList) {
		if(menuList.size()==0) {
			System.out.println("Menu bank is empty.");
		}
		else {
			Helper.line(60,"=");
			System.out.println("VIEWING ALL MENUS");
			Helper.line(60,"=");
			
			String output = String.format("%-20s %-10s %-10s %s\n", "NAME", "MONTH", "NO. OF ITEMS", "ITEMS");
			for(Menu i:menuList) {
				output+=i.toString();
			}
			System.out.println(output);
		}
	}
	// Delete a Menu Object from Menu Array global variable
	public static void deleteMenu(ArrayList<Menu> menuList) {
		Helper.line(60,"=");
		System.out.println("DELETE MENU");
		Helper.line(60,"=");
		viewAllMenu(menuList);
		
		String selectedMenu = Helper.readString("Enter Menu Name to Delete: ");
		
		
		for (int i = 0; i < menuList.size(); i++) {
			if(menuList.get(i).getDisplayName().toLowerCase().equalsIgnoreCase(selectedMenu)) {
				menuList.remove(i);
				System.out.println("Menu deleted.");
				break;
			} else {
				System.out.println("Cannot find Menu.");
			}
		}
			
	}
	
	
	public static void addOrder(ArrayList<Order> orderList) {
		
		boolean isFound = false;
		
		//Call the view all menu items for user to choose from
		C206_CaseStudy.viewAllMenuItem(MenuItemList);
		
		ArrayList <MenuItem> userChoices = new ArrayList<MenuItem>();
		
		String studentID = Helper.readString("Enter your student ID> ");
		String orderDate = Helper.readString("Enter the order date in the format dd/mm/yyyy > ");
		//num of Meals is how many food items the student or parents wants to order
		int numOfMeals = Helper.readInt("Enter the amount of meals to order > ");
	
		//
		for (int orderObject = 0; orderObject < numOfMeals; orderObject++) {
			String mealchoice = Helper.readString("Enter the name of the food > ");
			for (MenuItem mealObject : MenuItemList) {
				if (mealObject.getName().equalsIgnoreCase(mealchoice)) {
					isFound = true;
					userChoices.add(mealObject);
					System.out.println("Your order is successful!");
				}
			}
			
			if (isFound == false) {
				System.out.println("The menu item you entered could not be found");
			}
		}
		Order newOrder=new Order(studentID, orderDate, userChoices); 
		orderList.add(newOrder);
	}
	
	//DELETE ORDER
	public static void deleteOrder(ArrayList<Order> orderList) {
	
		boolean isDeleted = false;
		String deleteUser = Helper.readString("Enter your student ID > ");
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
	
	//VIEW ORDER Keen
	public static void viewOrder(ArrayList<Order> orderList) {
	
		boolean isFoundID = false;
		boolean isFoundDate = false;
		String studentID = Helper.readString("Enter your student ID to view your order > ");
		String dateView = Helper.readString("Enter the date of the order you want to view > ");
		String output = "";
		output += String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "MENU ITEM");
		
		for (int i=0; i<orderList.size(); i ++) {
			
			if (studentID.equalsIgnoreCase(orderList.get(i).getStudentid())) {
				isFoundID = true;
				
				if (dateView.equalsIgnoreCase(orderList.get(i).getOrderDate())) {
					output += String.format("%-20s %-20s %-20s\n", orderList.get(i).getStudentid(), orderList.get(i).getOrderDate(), orderList.get(i).getItems());
					isFoundDate = true;
				}
			}
			
		}
		System.out.println(output);
		
		if (isFoundID == false) {
			System.out.println("Your student ID cannot be found.");
		}
		
		if (isFoundDate == false ) {
			System.out.println("The date you specified could not be found.");
		}
		
	}
}


