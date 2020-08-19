import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<MenuItem> MenuItemList = new ArrayList<MenuItem>();
		
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

}


