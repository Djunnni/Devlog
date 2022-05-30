package reference;

public class Subject {
    String subjectName;
    int score;

    public Subject() {}
    public Subject(String name) {
        this.subjectName = name;
    }
    public void setSubjectName(String name) {
        this.subjectName = name;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return this.score;
    }
}
