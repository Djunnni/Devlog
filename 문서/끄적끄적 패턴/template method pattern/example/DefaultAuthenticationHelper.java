package pattern.template_method.example;

public class DefaultAuthenticationHelper extends AbstAuthenticationHelper {

	@Override
	protected String doDecode(String encode) {
		String decode = encode; // decode 처리를 했다고 하자.
		System.out.println("문자열 decode 처리");
		return decode;
	}

	@Override
	protected boolean authentication(String id, String password) {
		// 인증 절차를 처리
		System.out.println("인증 절차 처리");
		return true;
	}

	@Override
	protected int authorization(String id) {
		// 유저가 무슨 타입인지 확인
		System.out.println("유저 타입 검증");
		return 0;
	}

	@Override
	protected String connection(String info) {
		// 연결처리
		System.out.println("연결중..");
		return null;
	}

}
