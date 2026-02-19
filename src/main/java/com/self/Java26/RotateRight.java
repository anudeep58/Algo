package com.self.Java26;


public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
      ListNode tail = head;
      if(tail == null || tail.next == null || k ==0){
          return head;
      }
      int length =1 ;
      while (tail.next != null){
          tail = tail.next;
          length++;
      }
      tail.next = head;
      k = k%length;
      ListNode newTail = tail;
        for (int i = 0; i < length-k ; i++) {
            newTail = newTail.next;
        }
        ListNode neeHead = newTail.next;
        newTail.next =null;
        return neeHead;
    }

    public int fibonachi(int n) {
        if(n <= 1){
            return n;
        }
        return fibonachi(n-1) + fibonachi(n-2);
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5}; // 4,5,1,2,3

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
//        new RotateRight().rotateRight(head,2);
        System.out.println(new RotateRight().fibonachi(6));
    }
}
