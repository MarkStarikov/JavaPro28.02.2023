package SecondPartRebuild;

import SecondPart.Convertor;

public class Main {
    public static void main(String[] args) {
        ListNode multiplesOfFive = new ListNode ( 5, (new ListNode ( 10, (new ListNode (15, new ListNode(20, new ListNode(25, null)))))));
        System.out.println(ListNode.Conversion.reversLinkedList(multiplesOfFive));
    }
}
