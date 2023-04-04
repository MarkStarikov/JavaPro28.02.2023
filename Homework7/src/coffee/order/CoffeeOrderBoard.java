package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {

    private Queue<Order> sundayOrders;
    private int queueNumber;

    public CoffeeOrderBoard() {
            this.sundayOrders = new LinkedList<>();
    }

    public void add (String name){
        queueNumber++ ;
        sundayOrders.add(new Order(queueNumber, name));


    }
    public Order deliver (){
        Order order = sundayOrders.remove();
        return order;
    }
    public Order deliver (int numOrder){
         for (Order sundayOrder : sundayOrders) {
            if (sundayOrder.getNumOrder() == numOrder) {
             sundayOrders.remove(sundayOrder);
                return sundayOrder;
            }
        }
       return null;
    }
    public void draw (){
        System.out.println("Num | Name");
        for (Order sundayOrder : sundayOrders) {
            System.out.println(sundayOrder);
        }
    }

    public Queue<Order> getSundayOrders() {
        return sundayOrders;
    }

    public void setSundayOrders(Queue<Order> sundayOrders) {
        this.sundayOrders = sundayOrders;
    }


}
