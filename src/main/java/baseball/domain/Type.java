package baseball.domain;

public enum Type {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ;

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
