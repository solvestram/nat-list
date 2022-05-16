import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
@Invariant("data >= 0")
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Natural))
			return false;
		Natural n = (Natural) o;
		return data == n.data;
	}

	public int compareTo(Natural n) {
		return Integer.compare(data, n.data);
	}

	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data);
	}

	// Add contracts to all following methods.

	@Requires("d >= 0")
	@Ensures("data == d")
	public Natural(int d) {
		data = d;
	}

	@Requires("data != Integer.MAX_VALUE")
	@Ensures("data == old(data) + 1")
	public void increment() {
		data++;
	}

	@Requires("data != 0")
	@Ensures("data == old(data) - 1")
	public void decrement() {
		data--;
	}

	@Requires("data <= Integer.MAX_VALUE - n.data")
	@Ensures("data == old(data) + n.data")
	public void add(Natural n) {
		data += n.data;
	}

	@Requires("data >= n.data")
	@Ensures("data == old(data) - n.data")
	public void subtract(Natural n) {
		data -= n.data;
	}

	@Requires("n.data == 0 || data <= Integer.MAX_VALUE / n.data")
	@Ensures("data == old(data) * n.data")
	public void multiply(Natural n) {
		data *= n.data;
	}

	@Requires("n.data != 0")
	@Ensures("data == old(data) / n.data")
	public void divide(Natural n) {
		data /= n.data;
	}
}
