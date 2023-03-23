public abstract class Participant {
    private int maxParameterDistance;
    private int maxParameterJump;
    private String name;

    public Participant(int maxParameterDistance, int maxParameterJump, String name) {
        this.maxParameterDistance = maxParameterDistance;
        this.maxParameterJump = maxParameterJump;
        this.name = name;
    }

    public int getMaxParameterDistance() {
        return maxParameterDistance;
    }

    public void setMaxParameterDistance(int maxParameterDistance) {
        this.maxParameterDistance = maxParameterDistance;
    }

    public int getMaxParameterJump() {
        return maxParameterJump;
    }

    public void setMaxParameterJump(int maxParameterJump) {
        this.maxParameterJump = maxParameterJump;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void toRun ();
    public abstract void toJump ();
}
