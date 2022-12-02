package pattern.template_method.example;

public class Main {
	public static void main(String[] args) {
		AbstAuthenticationHelper helper = new DefaultAuthenticationHelper();
		try {
			helper.requestConnection("test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
