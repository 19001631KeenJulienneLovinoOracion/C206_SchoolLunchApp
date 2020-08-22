import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		assertNotNull("Test if Menu ArrayList exists", menuTest);
		
		//Given an empty Menu list, after adding 1 Menu item, the size of the list is 1
		Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList);
		menuTest.add(testMenu);
		assertEquals("Test if that Menu ArrayList size is 1", 1, menuTest.size());
		
		//Item added matches the object that was entered as parameter
		assertSame("Test if Object added matches object passed in", testMenu, menuTest.get(0));
	}

	@Test
	public void viewAllMenuTest() {
		// Menu List is not null and can contain Menu Objects
		assertNotNull("Test if Menu ArrayList exists", menuTest);
		
		//test if Menu ArrayList is empty
		assertEquals("Check if Menu ArrayList is empty", 0, menuTest.size());
				
		//Given an empty Menu list, after adding 1 Menu item, the size of the list is 1
		Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList);
		menuTest.add(testMenu);
		assertEquals("Test if that Menu ArrayList size is 1", 1, menuTest.size());
		
		//test if the expected output string same as the list of Menu Items retrieved from menuTest ArrayList
		String allMenus="";
		String mItems="";
		for(Menu i:menuTest) {
			for(MenuItem e:i.getItems()) {
				mItems+=e.getName()+", ";
			}
			allMenus+=String.format("%-20s %-10d %-10d %s\n", i.getDisplayName(),i.getMonth(),i.getNumberOfItems(),mItems);
		}

		String testOutput=String.format("%-20s %-10d %-10d %s\n", "January Asia",1,2,"Chicken Rice, Nasi Lemak, ");
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allMenus);
		
	}
	@Test
	public void deleteMenuTest() {
		// Menu List is not null and can contain Menu Objects
		assertNotNull("Test if Menu ArrayList exists", menuTest);
		
		//Given an empty Menu list, after adding 1 Menu item, the size of the list is 1
		Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList);
		menuTest.add(testMenu);
		assertEquals("Test if that Menu ArrayList size is 1", 1, menuTest.size());
		
		//Given an item in Menu List, after deleting the Menu Item, the size of the list is 0
		menuTest.remove(testMenu);
		assertEquals("Test if that Menu ArrayList size is 0", 0, menuTest.size());
	
	}

}
