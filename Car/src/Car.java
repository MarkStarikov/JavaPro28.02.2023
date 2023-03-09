public class Car {
    String model;
    String colour;
    int licenceNumber;

    public Car(String model, String colour, int licenceNumber) {
        this.model = model;
        this.colour = colour;
        this.licenceNumber = licenceNumber;
    }

    public void star () {
     startFuelSystem();
     startCommand();
     startElectricity();
    }

    private void startElectricity(){
    System.out.println("Need charging");
    }

    private void startCommand(){
        System.out.println("Apply command, please");
    }

    private void startFuelSystem(){
        System.out.println("Full tank");
    }
}
