public class Bot extends Participant{


    public Bot(int maxParameterDistance, int maxParameterJump, String name) {
        super(maxParameterDistance, maxParameterJump, name);
    }

    @Override
    public void toJump (){
        System.out.println("Bot can jump highly");
    }
    @Override
    public void toRun (){
        System.out.println("Bot can run quickly");
    }
}
