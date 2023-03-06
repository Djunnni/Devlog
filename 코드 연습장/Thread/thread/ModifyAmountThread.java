package thread;

public class ModifyAmountThread extends Thread {
    private CommonCalulate3 calc;
    private boolean addFlag;

    public ModifyAmountThread(CommonCalulate3 calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
    }

    public void run() {
        for(int loop = 0; loop < 10000; loop++) {
            if(addFlag) calc.plus(1);
            else calc.minus(1);
        }
    }
}
