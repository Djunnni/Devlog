package http.dto;

public class RequestDto {
    private String requestMethod = "GET";
    private String uri = "/";
    private String httpVersion = "HTTP/1.1";

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "requestMethod='" + requestMethod + '\'' +
                ", uri='" + uri + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                '}';
    }
}
