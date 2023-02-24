/**
 * enum example 예시를 올립니다.
 */
public enum HealthInsurance {
	LEVEL_ONE(1_000, 0.01),
	LEVEL_TWO(2_000, 0.02),
	LEVEL_THREE(3_000, 0.032),
	LEVEL_FOUR(4_000, 0.045),
	LEVEL_FIVE(5_000, 0.056),
	LEVEL_SIX(6_000, 0.071);

	private final int salary;
	private final double ratio;
	HealthInsurance(int salary, double ratio) {
		this.salary = salary;
		this.ratio = ratio;
	}

	public int getSalary() {
		return salary;
	}

	public double getRatio() {
		return ratio * 100;
	}

	public static HealthInsurance getHealthInsurance(int salary) {
		if(salary <= 1_000) {
			return HealthInsurance.LEVEL_ONE;
		} else if(salary <= 2_000) {
			return HealthInsurance.LEVEL_TWO;
		} else if(salary <= 3_000) {
			return HealthInsurance.LEVEL_THREE;
		} else if(salary <= 4_000) {
			return HealthInsurance.LEVEL_FOUR;
		} else if(salary <= 5_000) {
			return HealthInsurance.LEVEL_FIVE;
		} else {
			return HealthInsurance.LEVEL_SIX;
		}
	}
}
