
/**
 * 문자열 비교 방법
 * equals(Object object)
 * equalsIgnoreCase(String anotherStr)
 * compareTo(String anotherStr)
 * compareToIgnoreCase(String str)
 * contentEquals(CharSequence cs)
 * contentEquals(StringBuffer sb)
 * @Djunnni
 */
public class StringCompare {
    public static void main(String[] args) {
    	StringCompare sc = new StringCompare();
    	sc.checkCompare3();
    }
    public void checkCompare() {
        String text = "Check Value";
        String text2 = "Check Value"; 

        if(text == text2) { // Constant Pool에 의해 같다고 판단(다르게 하려면 new String()해주기)
            System.out.println("text1 == text2 is same");
        } else {
        	System.out.println("text1 == text2 is different");
        }
        if(text.equals(text2)) {
        	System.out.println("text.equals(text2) result is same.");
        }
    }
    public void checkCompare2() {
        String text = "Check Value";
        String text2 = new String("Check Value"); 

        if(text == text2) {
            System.out.println("text1 == text2 is same");
        } else {
        	System.out.println("text1 == text2 is different");
        }
        if(text.equals(text2)) {
        	System.out.println("text.equals(text2) result is same.");
        }
    }
    public void checkCompare3() {
        String text = "Check Value";
        String text3 = "check value"; 
        
        if(text.equalsIgnoreCase(text3)) {
        	System.out.println("text.equals(text3) result is same.");
        }
    }
}