package model;

public enum StageEnum {
    VOLCANO ("Volcano") ,
    OCEAN ("Ocean"),
    HURRICANE ("Hurricane"),
    FOREST ("Forest"),
    CANYON ("Canyon");
    private String name;

    StageEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StageEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
