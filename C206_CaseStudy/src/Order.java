/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19001631, 22 Aug 2020 9:20:42 pm
 */

/**
 * @author 19001631
 *
 *
 */
import java.time.LocalDate;
import java.util.ArrayList;
public class Order {
	
	private String studentid;
	private String orderDate;
	private ArrayList<MenuItem> items;
	
	
	public Order(String studentid, String orderDate, ArrayList<MenuItem> items) {
		this.studentid = studentid;
		this.orderDate = orderDate;
		this.items = items;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
}
