import java.util.Comparator;

public class CategorySorter implements Comparator<MenuItem> {
		@Override
		public int compare(MenuItem o1, MenuItem o2) {
	        return o1.getCategory().compareToIgnoreCase(o2.getCategory());
		}
}
