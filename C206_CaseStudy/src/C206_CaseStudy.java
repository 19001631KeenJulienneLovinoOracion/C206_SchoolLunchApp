import java.util.ArrayList;

public class C206_CaseStudy {
	//define ArrayList variables as global here, Menu methods need MenuItem Arraylists to work
	public static ArrayList<MenuItem> MenuItemList = new ArrayList<MenuItem>();
	public static ArrayList<Menu> menuList = new ArrayList<Menu>();
	public static void main(String[] args) {

		
		int option = 0;
		
		while (option !=4) {
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
			
			} else {
				System.out.println("Invalid Option");
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
		System.out.println("4. Quit");
	}
	
	// ==================================== Add menu item ==============================================
	public static void addMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("ADD MENU ITEM");
		Helper.line(60,"=");
		
		String category = Helper.readString("Enter Item's Category: ");
		String name = Helper.readString("Enter Item's Name: ");
		boolean healthyChoice = Helper.readBoolean("Is The Item A Healthier Choice? (Y/N) ");
		double price = Helper.readDouble("Enter Item's Price: ");
		
		MenuItem menuItem = new MenuItem(category, name, healthyChoice, price);
		MenuItemList.add(menuItem);
		System.out.println("Menu Item Added");
	}

	//===================================== delete menu item ===========================================
	public static void deleteMenuItem(ArrayList<MenuItem> MenuItemList) {
		Helper.line(60,"=");
		System.out.println("DELETE MENU ITEM");
		Helper.line(60,"=");
		
		String itemDelete = Helper.readString("Enter Item's Name To Delete: ");
		
		for (int i = 0; i < MenuItemList.size(); i++) {
			if(MenuItemList.get(i).getName().toLowerCase().equalsIgnoreCase(itemDelete)) {
				MenuItemList.remove(i);
				System.out.println("Item Deleted");
				break;
				
			} else {
				System.out.println("Item Not Deleted");
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
		while(count<MenuItemList.size()) {
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
				}
			}
			else {System.out.println("This menu item does not exist");}
				
			
			Menu newMenu=new Menu(displayName,month,numberOfItems,menuSelection);
			menuList.add(newMenu);
			System.out.println("Menu added!");
			
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
}


