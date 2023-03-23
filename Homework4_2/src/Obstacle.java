public abstract class Obstacle {
    private int Length;
    private int Hight;
    private String Name;

    public Obstacle(int length, int hight, String name) {
        Length = length;
        Hight = hight;
        Name = name;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public int getHight() {
        return Hight;
    }

    public void setHight(int hight) {
        Hight = hight;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public abstract boolean toOvercome(Participant participant);
    public abstract int chekingObstacle(Participant participant);
}