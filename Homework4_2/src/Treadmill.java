public class Treadmill extends Obstacle{


    public Treadmill(int length, int hight, String name) {
        super(length, hight, name);
    }

    @Override
    public boolean toOvercome(Participant participant){
        return super.getLength() < participant.getMaxParameterDistance();
    }
    @Override
    public int chekingObstacle(Participant participant){
        return super.getLength();
    }
}
