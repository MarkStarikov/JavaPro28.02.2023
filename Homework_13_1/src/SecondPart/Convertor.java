package SecondPart;
import java.util.Iterator;
public  class Convertor<V> implements Iterable<V>{
    ListLink<V> head;
    ListLink<V> tail;
        @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            ListLink<V> current = head;
            @Override
            public boolean hasNext() {
                return current !=null;
            }

            @Override
            public V next() {
                V data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    public static class ListLink<V>{
        V data;
        ListLink<V> next;
    }
   public boolean isEmpty(){
        return head == null;
    }
   public void add(V content){
       ListLink<V> newAdded = new ListLink<>();
       newAdded.data =content;
       if(isEmpty()){
            head = newAdded;
       }else {
           tail.next = newAdded;
       }
       tail = newAdded;
   }
   public void reverseRivers(){
       if(!isEmpty() && head.next != null){
           tail = head;
           ListLink<V> current = head.next;
           head.next = null;
           while (current != null){
               ListLink<V> temp = current.next;
               current.next = head;
               head = current;
               current = temp;
           }
       }
   }
}
