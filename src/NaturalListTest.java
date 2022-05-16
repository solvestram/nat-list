import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.java.contract.PreconditionError;

class NaturalListTest {

	@Nested
	class testPush {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new NaturalList().push(null);
			});
		}

		@Test
		void testPost() {
			new NaturalList().push(new Natural(5));
		}

	}

	@Nested
	class testGet {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				NaturalList nums = new NaturalList();
				nums.push(new Natural(40));
				nums.push(new Natural(30));
				nums.push(new Natural(21));
				nums.push(new Natural(45));

				nums.get(6);
			});
		}

		@Test
		void testPost() {
			NaturalList nums = new NaturalList();
			nums.push(new Natural(40));
			nums.push(new Natural(30));
			nums.push(new Natural(21));
			nums.push(new Natural(45));

			nums.get(2);
		}

	}

	@Nested
	class testSet {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				NaturalList nums = new NaturalList();
				nums.push(new Natural(40));
				nums.push(new Natural(30));
				nums.push(new Natural(21));
				nums.push(new Natural(45));
				nums.push(new Natural(11));
				nums.push(new Natural(211));
				nums.push(new Natural(330));
				nums.push(new Natural(241));

				nums.set(43, new Natural(32));
			});
		}

		@Test
		void testPost() {
			NaturalList nums = new NaturalList();
			nums.push(new Natural(40));
			nums.push(new Natural(30));
			nums.push(new Natural(21));
			nums.push(new Natural(45));
			nums.push(new Natural(11));
			nums.push(new Natural(211));
			nums.push(new Natural(330));
			nums.push(new Natural(241));

			nums.set(3, new Natural(43));
		}

	}

	@Nested
	class testSort {

		// This method does not have preconditions

		@Test
		void testPost() {
			NaturalList nums = new NaturalList();
			nums.push(new Natural(40));
			nums.push(new Natural(30));
			nums.push(new Natural(21));
			nums.push(new Natural(45));
			nums.push(new Natural(11));
			nums.push(new Natural(211));
			nums.push(new Natural(330));
			nums.push(new Natural(241));

			nums.sort();
		}

	}

	@Nested
	class testSearch {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				NaturalList nums = new NaturalList();
				nums.push(new Natural(40));
				nums.push(new Natural(30));
				nums.push(new Natural(21));
				nums.push(new Natural(45));
				nums.push(new Natural(11));
				nums.push(new Natural(211));
				nums.push(new Natural(330));
				nums.push(new Natural(241));

				nums.search(new Natural(11));
			});
		}

		@Test
		void testPost() {
			NaturalList nums = new NaturalList();
			nums.push(new Natural(40));
			nums.push(new Natural(30));
			nums.push(new Natural(21));
			nums.push(new Natural(45));
			nums.push(new Natural(11));
			nums.push(new Natural(211));
			nums.push(new Natural(330));
			nums.push(new Natural(241));
			
			nums.sort();
			
			nums.search(new Natural(30));
			nums.search(new Natural(25));
		}

	}
}
