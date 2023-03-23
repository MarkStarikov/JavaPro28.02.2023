public class Cat extends Participant {


    public Cat(int maxParameterDistance, int maxParameterJump, String name) {
        super(maxParameterDistance, maxParameterJump, name);
    }

    @Override
    public void toJump (){
        System.out.println("Cat can jump highly");
    }
    @Override
    public void toRun (){
        System.out.println("Cat can run quickly");
    }
}
