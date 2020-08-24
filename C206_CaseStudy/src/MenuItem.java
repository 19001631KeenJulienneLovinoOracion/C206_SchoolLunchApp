public class MenuItem {
	private String category;
	private String name;
	private boolean healthyChoice;
	private double price;
	
	public MenuItem (String category, String name, boolean healthyChoice, double price) {
		this.category=category;
		this.name=name;
		this.healthyChoice=healthyChoice;
		this.price=price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public  void setCategory(String category) {
		this.category=category;
	}
	
	public boolean isHealthyChoice() {
		return healthyChoice;
	}
	public void setHealthyChoice(boolean healthyChoice) {
		healthyChoice = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice() {
		this.price=price;
	}
	
	public String toString() {
		String output ="";
		output += "Category: " + category + "" + "Name: " + name + "" + "Healthy Choice: " + healthyChoice + "" + "Price: " + price;
		return output;
	}
	
}
