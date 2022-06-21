package chapter14.exception;

public class AutoCloseObj implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("close()");
    }
}
