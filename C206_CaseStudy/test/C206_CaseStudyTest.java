import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList); fields for testing, for Menu Items enter Chicken rice
//and Nasi Lemak in ORDER
public class C206_CaseStudyTest {
	public MenuItem chknRice;
	public MenuItem nasiLemak;
	public MenuItem menuitem;
	public Account account1;
	public Account account2;
	public Account accountCheck;
	public ArrayList<Menu> menuTest=new ArrayList<Menu>();
	public ArrayList<MenuItem> menuItemTest=new ArrayList<MenuItem>();

	@Before
	public void setUp() throws Exception {
		chknRice=new MenuItem("Asian","Chicken Rice",true,3.50); 
		nasiLemak=new MenuItem("Asian","Nasi Lemak",true,3.80);
		account1=new Account("test123", "password1", "T1234567A", 12345678);
		account2=new Account("test456", "password2", "T1234567B", 23456789);
		C206_CaseStudy.MenuItemList.add(chknRice);
		C206_CaseStudy.MenuItemList.add(nasiLemak);
		C206_CaseStudy.accountList.add(account1);
		C206_CaseStudy.accountList.add(account2);
		
	}

	@After
	public void tearDown() throws Exception {
		chknRice=null;
		nasiLemak=null;
		menuitem = null;
		account1 = null;
		account2 = null;
		C206_CaseStudy.MenuItemList.clear();
		C206_CaseStudy.accountList.clear();
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void addMenuItemTest() {
		// Menu Item List is not null and can contain Menu item Objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.MenuItemList);
		
		//Given an empty Menu list, after adding 3rd Menu item, the size of the list is 3
		C206_CaseStudy.addMenuItem(C206_CaseStudy.MenuItemList);
		assertEquals("Test if menu item arraylist size is 1", 3, C206_CaseStudy.MenuItemList.size());
		
		//assigned menu item added to item object, check where its the same.
		menuitem = C206_CaseStudy.MenuItemList.get(2);
		assertEquals("Check if Menu item ArrayList is empty", menuitem.getName(), C206_CaseStudy.MenuItemList.get(2).getName());
	}

	
	@Test	
	public void deleteMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.MenuItemList);

		//Given an empty Menu list, after adding 3rd Menu item, the size of the list is 3
		C206_CaseStudy.addMenuItem(C206_CaseStudy.MenuItemList);
		assertEquals("Test if menu item arraylist size is 1", 3, C206_CaseStudy.MenuItemList.size());
				
		//Given an item in Menu List, after deleting the Menu Item, the size of the list is 0
		C206_CaseStudy.deleteMenuItem(C206_CaseStudy.MenuItemList);
		assertEquals("Test if that Menu ArrayList size is 0", 2 , C206_CaseStudy.MenuItemList.size());
		
	}
	
	@Test	
	public void viewMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.MenuItemList);
		
		//test if Menu item ArrayList is size 2
		assertEquals("Check if Menu item ArrayList is empty", 2, C206_CaseStudy.MenuItemList.size());
		
		//Given an empty Menu list, after adding 3rd Menu item, the size of the list is 3
		C206_CaseStudy.addMenuItem(C206_CaseStudy.MenuItemList);
		assertEquals("Test if menu item arraylist size is 1", 3, C206_CaseStudy.MenuItemList.size());
		menuitem = C206_CaseStudy.MenuItemList.get(2);
		assertEquals("Check if Menu item added is the same ",menuitem.getName(), C206_CaseStudy.MenuItemList.get(2).getName());
		
		//test if menu item list can display
		C206_CaseStudy.viewAllMenuItem(C206_CaseStudy.MenuItemList);	
	}
	
	@Test	
	public void searchMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.MenuItemList);
		
		//test if Menu item ArrayList is size 2
		assertEquals("Check if Menu item ArrayList is empty", 2, C206_CaseStudy.MenuItemList.size());
		
		// implement search method
		C206_CaseStudy.searchMenuItem(C206_CaseStudy.MenuItemList);
	}
	
	@Test	
	public void updateMenuItemTest() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.MenuItemList);
		
		//test if Menu item ArrayList is size 2
		assertEquals("Check if Menu item ArrayList is empty", 2, C206_CaseStudy.MenuItemList.size());
				
		//implements update method
		C206_CaseStudy.updateMenuItem(C206_CaseStudy.MenuItemList);
		
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
	
	
	@Test	
	public void updateMenuTest() {
		// Test if menu list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", C206_CaseStudy.menuList);
		
		//Add menu to menuList
				Menu testMenu=new Menu("January Asia",1,2,C206_CaseStudy.MenuItemList);
			C206_CaseStudy.menuList.add(testMenu);
		String newName="January Western";
		int newMonth=13;
		//test that update method can demy invalid parameter i.e invalid month value
		assertEquals(C206_CaseStudy.doUpdateMenu(newName, newMonth, C206_CaseStudy.menuList.get(0)),"Month value is invalid!");
				
		
	}
	
	@Test
	public void addOrder() {
		// Test if menu item list is not null and can contain menu item objects
		assertNotNull("Test if menu item array list exists", menuItemTest);
		
		//given an empty menu item list, after adding 1 menu item object, the size of the list is 1
		menuItemTest.add(chknRice);
		assertEquals("Test if menu item arraylist size is 1", 1, menuItemTest.size());
		
		// test if object added is the same as the first object in menu item array list
		assertSame("Test if object added matches object passed in", chknRice, menuItemTest.get(0));
	}
	
	@Test
	public void createAccountTest() {
		//Test if account list is not null and can contain account objects
		assertNotNull("Test if account array list exists", C206_CaseStudy.accountList);
		
		//Given an empty account list, after adding 1 account object, the size of the list is 1
		C206_CaseStudy.createAccount(C206_CaseStudy.accountList);
		assertEquals("Test if account arraylist size is 2", 2, C206_CaseStudy.accountList.size());
		
		//Test if object added is the same in the arrayList
		assertSame("test if object matches the object passed in", account1, C206_CaseStudy.accountList.get(0));
	}
	
	@Test
	public void viewAccountTest() {
		//Test if account list is not null and can contain account objects
		assertNotNull("Test if account array list exists", C206_CaseStudy.accountList);
				
		//Test if Account array list is size 2
		assertEquals("Check if account array list is empty", 2, C206_CaseStudy.accountList.size());
				
		//Given an empty Account array list, after adding third Account , the size of the list is 3
		C206_CaseStudy.createAccount(C206_CaseStudy.accountList);
		assertEquals("Test if account array list size is 2",2, C206_CaseStudy.accountList.size());
		accountCheck = C206_CaseStudy.accountList.get(2);
		assertEquals("Check if Menu item added is the same ",accountCheck.getUsername(), C206_CaseStudy.accountList.get(2).getUsername());
				
		//test if Account list can display
		C206_CaseStudy.viewAccount(C206_CaseStudy.accountList);	
	}
	
	@Test
	public void deleteAccountTest() {
		//Test if account list is not null and can contain account objects
		assertNotNull("Test if account array list exists", C206_CaseStudy.accountList);
		
		//Given an empty account list, after adding 1 account object, the size of the list is 1
		C206_CaseStudy.createAccount(C206_CaseStudy.accountList);
		assertEquals("Test if account arraylist size is 2", 2, C206_CaseStudy.accountList.size());
		
		//Given an item in account list, after deleting the Account, the size of the list is 0
		C206_CaseStudy.delAccount(C206_CaseStudy.accountList);
		assertEquals("Test if that Account ArrayList size is 0", 0, C206_CaseStudy.accountList.size());
		
	}
	
	@Test
	public void updateAccountTest() {
		//Test if account list is not null and can contain account objects
		assertNotNull("Test if account array list exists", C206_CaseStudy.accountList);
							
		//Test update method
		C206_CaseStudy.updateAccount(C206_CaseStudy.accountList);
		;
				
		
	}
	
	@Test
	public void delAccountTest() {
		//Test if account list is not null and can contain account objects
		assertNotNull("Test if account array list exists", C206_CaseStudy.accountList);
		
		//Given an empty account list, after adding 1 account object, the size of the list is 1
		C206_CaseStudy.createAccount(C206_CaseStudy.accountList);
		assertEquals("Test if account arraylist size is 2", 2, C206_CaseStudy.accountList.size());
		
	}
}
