package chapter14.exception;

public class IDFormatTest {
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String id) throws IDFormatException{
        if(id == null) {
            throw new IDFormatException("아이디는 null 알 수 없습니다.");
        }
        else if(id.length() < 8 || id.length() > 20) {
            throw new IDFormatException("아이디 길이가 맞지 않습니다.");
        }
        userID = id;
    }

    static public void main(String[] args) {
        IDFormatTest idTest = new IDFormatTest();
        try {
            idTest.setUserID(null);
        } catch(IDFormatException e) {
            System.out.println(e);
        }

        try {
            idTest.setUserID("daniel");
        } catch(IDFormatException e) {
            System.out.println(e.getMessage());
        };
    }
}
