package SecondPartRebuild;
public class ListNode {
    int data;
    ListNode next;
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
    class Conversion {
        public static ListNode reversLinkedList (ListNode multiplesOfFive){
            ListNode revers = null;
            ListNode current = multiplesOfFive;
            while (current != null){
                ListNode temp = current.next;
                current.next = revers;
                revers = current;
                current = temp;
            }
            return revers;
        }
    }
}
