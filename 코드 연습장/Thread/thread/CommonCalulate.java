package thread;

public class CommonCalulate {
    private int amount;

    public CommonCalulate() {
        amount = 0;
    }

    public synchronized void plus(int value) {
        // 문제점: plus연산이 좌측항에 업데이트가 수행되기전에 다른 스레드에서 접근을 할 수 있다.
        // 이러기 때문에 한 스레드에서 처리한 좌측항이 1이라면 다른 항에서는 2가 될 수도 1이 될 수도 있는상황이 발생
        // 해결: synchronized를 통해서 하나씩 처리시킨다.
        amount += value;
    }

    public synchronized void minus(int value) {
        // 문제점: 메소드 전체를 synchronized로 감싸게 되면 불필요한 N줄에서 대기시간이 발생한다. 이 경우에는 메서드 전체를 감싸기보다.
        // 처리하는 부분에만 synchronized 처리를 해줘야 한다.
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }
}
