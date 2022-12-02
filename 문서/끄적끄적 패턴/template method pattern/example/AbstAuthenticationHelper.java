package pattern.template_method.example;

public abstract class AbstAuthenticationHelper {
	protected abstract String doDecode(String encode);
	protected abstract boolean authentication(String id, String password);
	protected abstract int authorization(String id);
	protected abstract String connection(String info);
	
	public String requestConnection(String encode) throws Exception {
		String decodedData = doDecode(encode);
		
		// decodedData에서 추출했다고 가정하자.
		String id = "daniel";
		String password = "password";
		if(!authentication(id, password)) {
			throw new Exception("아이디와 비밀번호를 확인해주세요.");
		}
		
		int userType = authorization(id);
		switch(userType) {
			case 0:
				// 무료
				break;
			case 1:
				// 유료 
				break;
			case 2:
				// 미성년자(타임제)
				break;
			case 3:
				// 비활성화
				break;
			default:
				// 체험
				break;
		}
		
		// decodedData와 기타 정보가 종합됐다고 가정
		String metaInfo = "";
		return connection(metaInfo);
		
	}
}
