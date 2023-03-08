## I/O

자바에서의 입출력에 대해서 알아보고 정리하자

JVM 기준으로 읽을 때, Input, 파일로 쓰거나 외부로 전송할 때에는 Output을 사용한다.

읽는 작업은 주로 InputStream을 통해서, 쓰는 작업은 OutputStream을 통해서 작업하도록 되어있다.

바이트가 아닌 char의 경우 Writer, Reader로 처리한다.

### 스트림이란?

끊기지 않고 연속적인 데이터

JDK 1.4부터는 빠른 I/O 처리를 위해 NIO가 추가됐다. NIO는 스트림기반이 아니라 버퍼와 채널기반으로 만들어 졌다.

### 자바의 File, Files 클래스

java.io에는 File이라는 클래스가 있다. 클래스 이름은 File이지만 정확히 파일만 가르키는게 아니다.

**파일의 경로**도 포함한다.

File 클래스는 정체가 불분명하고, 심볼릭 링크와 같은 유닉스 계열의 파일에서 사용하는 몇몇 기능을 제대로 제공하지 못한다.

하지만 Java7부터 NIO2의 java.nio.file의 Files 클래스에서 File 클래스의 메소드들을 대체하여 제공한다.

그리고 File클래스는 객체를 생성하여 데이터를 처리하는데 반해, File 클래스는 모든 메소드가 static으로 선언되어 있기 때문에 별도의 객체를 생성할 필요가 없다는 차이가 있다.

### File 클래스를 이용해 파일 경로와 상태를 확인하자

[코드연습장 - IO / FileSample](/%EC%BD%94%EB%93%9C%20%EC%97%B0%EC%8A%B5%EC%9E%A5/IO/FileSample.java)에서 확인 가능하다.

### 파일 클래스를 이용해 파일을 처리하자

[코드연습장 - IO / FileManageClass](/%EC%BD%94%EB%93%9C%20%EC%97%B0%EC%8A%B5%EC%9E%A5/IO/FileManageClass.java)에서 확인 가능하다.

### 파일 필터 사용방법

[코드연습장 - IO / filter](/%EC%BD%94%EB%93%9C%20%EC%97%B0%EC%8A%B5%EC%9E%A5/IO/filter/)에서 확인 가능하다.
