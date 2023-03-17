import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		PredicateExample example = new PredicateExample();

		Predicate<String> predicateLength5 = (a) -> {
			System.out.println("CALL predicateLength5");
			return a.length() > 5;
		};
		Predicate<String> predicateContains = a -> {

			System.out.println("CALL predicateContains");
			return a.contains("GOD");
		};
		Predicate<String> predicateStart =(a) ->  {
			System.out.println("CALL predicateStart");
			return a.startsWith("GOD");
		};

		String godOfJAVA = "GODofJAVA";
		String goodOfJAVA = "GOODofJAVA";

		// example.predicateTest(predicateLength5, godOfJAVA);
		// example.predicateTest(predicateLength5, goodOfJAVA);
		//
		// example.predicateNegate(predicateLength5, godOfJAVA);
		// example.predicateNegate(predicateLength5, goodOfJAVA);

		example.predicateOr(predicateStart, predicateLength5, godOfJAVA);
		example.predicateAnd(predicateStart, predicateLength5, godOfJAVA);
	}

	private void predicateAnd(Predicate<String> predicateStart, Predicate<String> predicateLength5, String goodOfJAVA) {
		System.out.println(predicateStart.and(predicateLength5).test(goodOfJAVA));
	}

	private void predicateOr(Predicate<String> predicateStart, Predicate<String> predicateLength5, String goodOfJAVA) {
		System.out.println(predicateStart.or(predicateLength5).test(goodOfJAVA));
	}

	private void predicateTest(Predicate<String> predicateLength5, String godOfJAVA) {
		System.out.println(predicateLength5.test(godOfJAVA));
	}

	private void predicateNegate(Predicate<String> pre, String test) {
		System.out.println(pre.negate().test(test));
	}


}
