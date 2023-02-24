import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * JsonProperty를 설정해두면 Client에게 json 객체 반환시 camelCase에서 snakeCase로 변환됩니다.
 * @author Djunnni
 */
@Getter
@ToString
@NoArgsConstructor
public class Response {

	@JsonProperty("access_token")
	String accessToken;
	String scope;
	@JsonProperty("token_type")
	String tokenType;

	@JsonProperty("redirect_uri")
	String redirectUri;
    
	@Builder
	public Response(String accessToken, String scope, String tokenType, String redirectUri) {
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.scope = scope;
		this.redirectUri = redirectUri;
	}
}