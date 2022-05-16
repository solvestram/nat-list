import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.java.contract.PreconditionError;

class NaturalTest {

	@Nested
	class testNatural {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(-1);
			});
		}

		@Test
		void testPost() {
			new Natural(10);
		}

	}

	@Nested
	class testIncrement {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(Integer.MAX_VALUE).increment();
			});
		}

		@Test
		void testPost() {
			new Natural(1).increment();
		}

	}

	@Nested
	class testDecrement {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(0).decrement();
			});
		}

		@Test
		void testPost() {
			new Natural(5).decrement();
		}

	}

	@Nested
	class testAdd {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(Integer.MAX_VALUE - 20).add(new Natural(100));
			});
		}

		@Test
		void testPost() {
			new Natural(132).add(new Natural(55));
		}

	}

	@Nested
	class testSubtract {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(123).subtract(new Natural(200));
			});
		}

		@Test
		void testPost() {
			new Natural(146).subtract(new Natural(32));
		}

	}

	@Nested
	class testMultiply {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(Integer.MAX_VALUE / 2).multiply(new Natural(3));
			});
		}

		@Test
		void testPost() {
			new Natural(5).multiply(new Natural(5));
			
			new Natural(9).multiply(new Natural(0));
		}

	}

	@Nested
	class testDivide {

		@Test
		void testPre() {
			assertThrows(PreconditionError.class, () -> {
				new Natural(234).divide(new Natural(0));
			});
		}

		@Test
		void testPost() {
			new Natural(81).divide(new Natural(9));
		}

	}

}
