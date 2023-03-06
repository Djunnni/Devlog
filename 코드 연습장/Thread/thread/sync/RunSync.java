package thread.sync;

import thread.CommonCalulate;
import thread.CommonCalulate2;
import thread.CommonCalulate3;
import thread.ModifyAmountThread;

public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();

        for(int i = 0; i < 5; i++) {
            runSync.runCommonCalculate();
        }
    }

    private void runCommonCalculate() {
        CommonCalulate3 calc = new CommonCalulate3();
        ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
        ModifyAmountThread thread2 = new ModifyAmountThread(calc, false);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // join => 쓰레드가 종료될 때까지 기다린다.
            thread2.join();
            System.out.println("final value is " + calc.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
