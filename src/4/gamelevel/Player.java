package chapter9.gamelevel;

public class Player {
    private PlayerLevel level;

    public Player() {
        level = new BeginnerLevel();
        level.showLevelMessage();
    }
    public PlayerLevel getLevel() {
        return level;
    }
    public void upgradeLevel(PlayerLevel level) {
        this.level = level;
        this.level.showLevelMessage();
    }
    public void play(int count) {
        this.level.go(count);
    }
}
