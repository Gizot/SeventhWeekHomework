package model;

public class SpecialPower {
    private int id;
    private String name;
    private int extraDamage;
    private int remainingRights;


    public SpecialPower(int id, String name, int extraDamage, int remainingRights) {
        this.id = id;
        this.name = name;
        this.extraDamage = extraDamage;
        this.remainingRights = remainingRights;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    public int getRemainingRights() {
        return remainingRights;
    }

    public void setRemainingRights(int remainingRights) {
        this.remainingRights = remainingRights;
    }


    @Override
    public String toString() {
        return "SpecialPower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extraDamage=" + extraDamage +
                ", remainingRights=" + remainingRights +
                '}';
    }
}
