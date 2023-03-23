public class Human extends Participant {


    public Human(int maxParameterDistance, int maxParameterJump, String name) {
        super(maxParameterDistance, maxParameterJump, name);
    }

    @Override
    public void toJump (){
        System.out.println("Human can jump highly");
    }
    @Override
    public void toRun (){
        System.out.println("Human can run quickly");
    }
}
