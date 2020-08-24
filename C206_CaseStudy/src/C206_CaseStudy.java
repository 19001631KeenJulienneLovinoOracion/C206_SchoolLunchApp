import java.util.ArrayList;

public class C206_CaseStudy {
	//define ArrayList variables as global here, Menu methods need MenuItem Arraylists to work

	static ArrayList<MenuItem> MenuItemList = new ArrayList<MenuItem>();
	static ArrayList<Menu> menuList = new ArrayList<Menu>();
	static ArrayList<Order> orderList = new ArrayList<Order>();
	public static String menuName;
	public static int menuSize;
	public static int menuMonth;
	public static ArrayList<MenuItem> menuContent=new ArrayList<MenuItem>();
	public static void main(String[] args) {

		
		int option = 0;
		
		while (option !=8) {
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
			
			}else if(option == 4) {
				//create menu object
				createMenuFields();
				C206_CaseStudy.createMenuObject(menuList, menuName, menuSize, menuMonth, menuContent);
				
			}else if(option == 5) {
				//delete menu object
				C206_CaseStudy.getDeleteMenuField();
				
			}else if(option == 6) {
				//view all Menu objects
				System.out.println(C206_CaseStudy.viewAllMenu(menuList));
			
			}
			
			else if (option == 7) {
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
				
				else {
					System.out.println("You have entered an invalid order choice");
				}
				
			}
			else {
				if(option!=7) {
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
		System.out.println("4. Create Menu");
		System.out.println("5. Delete Menu");
		System.out.println("6. View All Menus");
		System.out.println("7. Create Order");
		System.out.println("8. Quit");
	}
	
	//Sub menu for the order method
	
	public static void orderMenu() {
		Helper.line(60,"=");
		System.out.println("Choose order option");
		Helper.line(60,"=");
		System.out.println("1. Add Order");
		System.out.println("2. Delete Order");
		System.out.println("3. View Order");
		
	}
	

	
	// ==================================== Add menu item ==============================================
	public static void addMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("ADD MENU ITEM");
		Helper.line(60,"=");
		
		boolean existed = false;
		
		String category = Helper.readString("Enter Item's Category: ");
		String name = Helper.readString("Enter Item's Name: ");
		boolean healthyChoice = Helper.readBoolean("Is The Item A Healthier Choice? (Y/N) ");
		double price = Helper.readDouble("Enter Item's Price: ");
		
		for (MenuItem mi : MenuItemList) {
			if (mi.getName().equalsIgnoreCase(name)) {
				existed = true;
			}
		}
		if (existed == false) {
			MenuItem menuItem = new MenuItem(category, name, healthyChoice, price);
			MenuItemList.add(menuItem);
			System.out.println("Menu Item Added");
		}else {
			System.out.println("item exist");
		}
		
	}

	//===================================== delete menu item ===========================================
	public static void deleteMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("DELETE MENU ITEM");
		Helper.line(60,"=");
		
		boolean deleted = false;
		String itemDelete = Helper.readString("Enter Item's Name To Delete: ");
		
		for (int i=0; i<MenuItemList.size();i++) {
			if(MenuItemList.get(i).getName().toLowerCase().equalsIgnoreCase(itemDelete)) {
				deleted = true;
			}
			
			if (deleted == true) {
				MenuItemList.remove(i);
				System.out.println("Menu Item Deleted");
			}else if (deleted == false){
				System.out.println("Menu Item Not Deleted");
			} else {
				System.out.println("Menu Item Does Not Exist");
		}
		}
	}

	
	//===================================== view menu item =============================================
	public static void viewAllMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("VIEW MENU ITEM");
		Helper.line(60,"=");
		
		String output = "";
		
		output += String.format("%-10s %-10s %-20s %-10s\n", "CATEGORY", "NAME", "HEALTHY CHOICE", "PRICE");
		for (int i = 0; i < MenuItemList.size(); i++) {
			output += String.format("%-10s %-10s %-20b %-10s\n", MenuItemList.get(i).getCategory(), MenuItemList.get(i).getName(), 
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
	
	if(menuMonth>=1 && menuMonth<=12) {
	 menuSize=Helper.readInt("Please enter amount of items in Menu >");
	if(menuSize<=MenuItemList.size()) {
		int count=0;

		while(count<menuSize) {
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
	
	//create Menu with fields
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

	
	//ADD ORDER
	
	
	public static void addOrder(ArrayList<Order> orderList) {
		
		ArrayList <MenuItem> userChoices = new ArrayList<MenuItem>();
		
		String studentID = Helper.readString("Enter your student ID: ");
		String orderDate = Helper.readString("Enter the order date in the format dd/mm/yyyy: ");
		int numOfMeals = Helper.readInt("Enter the amount of meals to order > ");
		
		for (int orderObject = 0; orderObject < numOfMeals; orderObject++) {
			String mealchoice = Helper.readString("Enter your meal choice: ");
			for (MenuItem mealObject : MenuItemList) {
				if (mealObject.getName().equalsIgnoreCase(mealchoice)) {
					userChoices.add(mealObject);
				}
			}
		}
	
		Order newOrder=new Order(studentID, orderDate, MenuItemList); 
		orderList.add(newOrder);
		
	}
	
	//DELETE ORDER
	public static void deleteOrder(ArrayList<Order> orderList) {
		
		boolean isDeleted = false;
		String deleteItem = Helper.readString("Enter the date for order you wish to delete: ");
		
		for (int i=0; i<orderList.size(); i++ ) {
			
			if (deleteItem.equalsIgnoreCase(orderList.get(i).getOrderDate())) {
				orderList.remove(i);
				isDeleted = true;
				System.out.println("The order has been successfully deleted");
			}
			
			else {
				System.out.println("The date could not be found. ");
			}
		}
	}
	
	//VIEW ORDER
	public static void viewOrder(ArrayList<Order> orderList) {
		
		String output = "";
		output += String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "MENU ITEM");
		
		for (int i=0; i<orderList.size(); i ++) {
			output += String.format("%-20s %-20s %-20s\n", orderList.get(i).getStudentid(), orderList.get(i).getOrderDate(), orderList.get(i).getItems());
		}
		
		System.out.println(output);
		
	}
}


