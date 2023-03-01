public class Main {
    public static void main( String [] args) {
        MineralIndustry open_method = new OpenMethod();
        System.out.println(open_method.createExcavation());
        open_method.createExcavation().obtainNaturalResources();
        System.out.println(open_method.newMessage());
        open_method.createExcavation();

        MineralIndustry close_method = new CloseMethod();
        System.out.println(close_method.createExcavation());
        close_method.createExcavation().obtainNaturalResources();
        System.out.println(close_method.newMessage());
        close_method.createExcavation();

    }
}

