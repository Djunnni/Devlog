package chapter8;

public class Clothes {
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    protected String source;

    Clothes() {
        super();
        System.out.println("Clothes() 호출");
    }
    Clothes(String src) {
        this.source = src;
        System.out.println("Clothes(src) 호출");
    }
}
