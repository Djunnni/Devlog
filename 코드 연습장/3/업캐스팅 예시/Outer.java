package chapter8;

public class Outer extends Clothes{

    Outer(String src) {
        System.out.println("Outer(src) 호출");
    }
    public void waterproof() {
        System.out.println("비를 막습니다.");
    }


    static public void main(String[] args) {
        Clothes x = new Outer("견");
        x.waterproof();
        System.out.println(x.source);
    }
}
