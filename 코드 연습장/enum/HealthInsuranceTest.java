public class HealthInsuranceTest {
	public static void main(String[] args) {
		int salaryArr[] = new int[] {1500, 5500, 8000};
		HealthInsurance[] insurances = new HealthInsurance[3];
		insurances[0] = HealthInsurance.getHealthInsurance(salaryArr[0]);
		insurances[1] = HealthInsurance.getHealthInsurance(salaryArr[1]);
		insurances[2] = HealthInsurance.getHealthInsurance(salaryArr[2]);

		for(int loop = 0; loop < 3; loop++) {
			System.out.println(salaryArr[loop] + "=" + insurances[loop] + "," + insurances[loop].getRatio());
		}
	}
}
