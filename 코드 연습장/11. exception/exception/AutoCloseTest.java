package chapter14.exception;

public class AutoCloseTest {
    public static void main(String[] args) {
        try(AutoCloseObj obj = new AutoCloseObj()) {
            throw new Exception("aa");
        }catch(Exception e) {
            System.out.println("exception");
        }
    }
}
