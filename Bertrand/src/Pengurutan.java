import java.util.Comparator;

public class Pengurutan implements Comparator<data> {

	public int compare(data o1, data o2) {
		return o1.getNama().compareToIgnoreCase(o2.getNama());
	}
}
