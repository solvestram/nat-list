import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@ContractImport("java.util.ArrayList")
//Add an invariant here.
@Invariant("numbers != null && !numbers.contains(null)")
public class NaturalList {
	private ArrayList<Natural> numbers;

	// No contracts required for the following methods.
	public NaturalList(NaturalList o) {
		numbers = new ArrayList<Natural>();
		for (Natural n : o.numbers)
			numbers.add(new Natural(n));
	}

	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NaturalList))
			return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	// Add contracts to all following methods.

	@Requires("n != null")
	@Ensures("numbers.get(numbers.size() - 1).equals(old(new Natural(n)))")
	public void push(Natural n) {
		numbers.add(n);
	}

	@Requires("i >= 0 && i < numbers.size()")
	@Ensures("result == numbers.get(old(i))")
	public Natural get(int i) {
		return numbers.get(i);
	}

	@Requires("n != null && i >= 0 && i < numbers.size()")
	@Ensures("numbers.get(old(i)).equals(old(new Natural(n)))")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}

	@Ensures("isSorted()")
	public void sort() {
		Collections.sort(numbers);
	}

	@Requires("isSorted()")
//	@Ensures("numbers.get(result).equals(old(new Natural(n)))")
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}

	// Contract methods

	// checks whether a list is sorted or not
	private boolean isSorted() {
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i).compareTo(numbers.get(i + 1)) > 0) {
				return false;
			}
		}

		return true;
	}
}
