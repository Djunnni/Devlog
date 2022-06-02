package chapter10.scheduler;

public interface Scheduler {
    // 클라이언트와의 약속이다.
    void getNextCallI();
    void sendCallToAgent();
}
