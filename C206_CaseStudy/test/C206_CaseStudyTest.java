import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//		Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList); fields for testing, for Menu Items enter Chicken rice
//and Nasi Lemak in ORDER
public class C206_CaseStudyTest {
	public MenuItem chknRice;
	public MenuItem nasiLemak;
	public ArrayList<Menu> menuTest=new ArrayList<Menu>();
	public ArrayList<MenuItem> menuItemTest=new ArrayList<MenuItem>();

	@Before
	public void setUp() throws Exception {
		chknRice=new MenuItem("Asian","Chicken Rice",true,3.50); 
		nasiLemak=new MenuItem("Asian","Nasi Lemak",true,3.80);
		C206_CaseStudy.MenuItemList.add(chknRice);
		C206_CaseStudy.MenuItemList.add(nasiLemak);
		
	}

	@After
	public void tearDown() throws Exception {
		chknRice=null;
		nasiLemak=null;
		C206_CaseStudy.MenuItemList.clear();
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void addMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", menuItemTest);
		
		//given an empty menu item list, after adding 1 menu item object, the size of the list is 1
		menuItemTest.add(chknRice);
		assertEquals("Test if menu item arraylist size is 1", 1, menuItemTest.size());
		
		// test if object added is the same as the first object in menu item array list
		assertSame("Test if object added matches object passed in", chknRice, menuItemTest.get(0));
	}
	
	@Test	
	public void deleteMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", menuItemTest);
		
		//given an empty menu item list, after adding 1 menu item object, the size of the list is 1
		menuItemTest.add(chknRice);
		assertEquals("Test if menu item arraylist size is 1", 1, menuItemTest.size());
		
		//Given an item in Menu List, after deleting the Menu Item, the size of the list is 0
		menuItemTest.remove(chknRice);
		assertEquals("Test if that Menu ArrayList size is 0", 0, menuItemTest.size());
		
	}
	
	@Test	
	public void viewMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", menuItemTest);
		
		//test if Menu item ArrayList is empty
		assertEquals("Check if Menu item ArrayList is empty", 0, menuItemTest.size());
		
		//given an empty menu item list, after adding 1 menu item object, the size of the list is 1
		menuItemTest.add(chknRice);
		assertEquals("Test if menu item arraylist size is 1", 1, menuItemTest.size());
		
		//test if the expected output string same as the list of Item retrieved from menuItemTest ArrayList
		String output ="";
	
		for (MenuItem mi : menuItemTest) {
			output += String.format("%-10s %-10s %-20b %-10s\n", mi.getCategory(), mi.getName(), mi.isHealthyChoice(), mi.getPrice());
		}
		String expected1 = String.format("%-10s %-10s %-20b %-10s\n","Asian","Chicken Rice",true,3.50);
		
		assertEquals("Check that the item output is same as expected output", expected1, output);
		
	}
	
	@Test
	public void addMenuTest() {
		// Menu List is not null and can contain Menu Objects
		assertNotNull("Test if Menu ArrayList exists", C206_CaseStudy.menuList);
		
		
		//Given an empty Menu list, after adding 1 Menu item, the size of the list is 1
		Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList);
		C206_CaseStudy.createMenuObject(C206_CaseStudy.menuList,"January Asia",1,2,C206_CaseStudy.MenuItemList);
		assertEquals("Test if that Menu ArrayList size is 1", 1, C206_CaseStudy.menuList.size());
		
		//Item added matches the object that was entered as parameter
		assertEquals("Test if Object added matches object passed in via common name", testMenu.getDisplayName(), C206_CaseStudy.menuList.get(0).getDisplayName());
	}

	@Test
	public void viewAllMenuTest() {
		// Menu List is not null and can contain Menu Objects
		assertNotNull("Test if Menu ArrayList exists", C206_CaseStudy.menuList);
		C206_CaseStudy.menuList.clear();
		
		
		//Given an empty Menu list, when instructed to view all Menus, the following error String is returned and printed out
				assertEquals("Test if An empty array returns a String indicating an error from the method","Menu bank is empty.",C206_CaseStudy.viewAllMenu(C206_CaseStudy.menuList));
		
				
				C206_CaseStudy.createMenuObject(C206_CaseStudy.menuList,"January Asia",1,2,C206_CaseStudy.MenuItemList);
		//test if the expected output string same as the list of Menu Items retrieved from menuTest ArrayList
String allMenus=C206_CaseStudy.viewAllMenu(C206_CaseStudy.menuList);
String testOutput = String.format("%-20s %-10s %-10s %s\n", "NAME", "MONTH", "NO. OF ITEMS", "ITEMS");
		 testOutput+=String.format("%-20s %-10d %-10d %s\n", "January Asia",1,2,"Chicken Rice, Nasi Lemak, ");
	
		assertEquals("Check that Output matches expected details", testOutput, allMenus);
		
	}
	@Test
	public void deleteMenuTest() {
		// Menu List is not null and can contain Menu Objects
		assertNotNull("Test if Menu ArrayList exists",  C206_CaseStudy.menuList);
		//Given an incorrect menu name, the function returns an error indicating it cannot find any menus with the keyword
				assertEquals("Test if no Menus Found function works and returns error String",C206_CaseStudy.deleteMenu(C206_CaseStudy.menuList, "February Western"),"Menu not found!");
				
		

		//Given an item in Menu List, after deleting the Menu Item, the size of the list is 0
		C206_CaseStudy.deleteMenu(C206_CaseStudy.menuList,"January Asia");
		assertEquals("Test if that Menu ArrayList size is 0", 0, C206_CaseStudy.menuList.size());
		
		
		//Given an empty Menu array, the function returns an error indicating it cannot delete anything as Menu Array is empty
		assertEquals("Test if that Menu cannot delete from empty ArrayList", "Menu array is empty!", C206_CaseStudy.deleteMenu(C206_CaseStudy.menuList, "January Asia"));
		
		
	
	}

}
