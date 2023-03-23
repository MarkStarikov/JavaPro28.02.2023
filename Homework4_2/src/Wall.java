public class Wall extends Obstacle{


    public Wall(int length, int hight, String name) {
        super(length, hight, name);
    }

    @Override
    public boolean toOvercome(Participant participant){
        return super.getHight() < participant.getMaxParameterJump();
    }
    @Override
    public int chekingObstacle(Participant participant){
        return super.getHight();
    }


}
