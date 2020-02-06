package LinkedList;

import sun.security.x509.InvalidityDateExtension;

public class LinkedList<T> {

    Node<T> head;
    Node<T> tail;


    boolean add(T value) {
        Node<T> temp = new Node<T>();
        temp.value = value;
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        return true;
    }

    boolean addAt(int position, T value) {

        if (position <= 0) {
            return false;
        }


        Node<T> temp = new Node<T>();
        temp.value = value;

        if (head == null && position > 1) {
            return false;
        } else if (head == null && position == 1) {
            head = temp;
            tail = temp;
            return true;
        } else if (head != null && position == 1) {
            temp.next = head;
            tail = head;
            head = temp;
            return true;
        } else {
            Node<T> temphead = head;
            for (int i = 1; i <= position - 2; i++) {
                if (temphead.next == null) {
                    return false;
                }
                temphead = temphead.next;

            }


            temp.next = temphead.next;
            temphead.next = temp;

        }


        return true;
    }

    void print() {
        print(this.head);
    }

    private void print(Node<T> head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        print(head.next);
    }


    void printReverse() {
        printReverse(this.head);
    }

    private void printReverse(Node<T> head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.println(head.value);

    }

    void printHead() {
        System.out.println(head.value);
    }

    void printTail() {
        System.out.println(tail.value);
    }

    void reverseIterative() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;

    }

    void reverseRecursive() {
        reverseRecursive(head);
    }

    private void reverseRecursive(Node<T> head) {

        if (head.next == null) {
            this.head = head;
        } else {
            reverseRecursive(head.next);
            head.next.next = head;
            head.next = null;
        }

    }

    boolean deletefromFront(){
        if(head==null){
            return  false;
        }
        else  if(head==tail){
            head=tail=null;
            return  true;
        }
         Node<T> tempHead = head;
         head = head.next;
         tempHead=null;
         return  true;
    }

    boolean deletefromEnd(){
        if(head==null || tail==null){
            return  false;
        }
        else if(head==tail){
            head=tail=null;
            return true;
        }
        else
        {
            Node<T> tempHead = head;
            while(tempHead.next!=tail){
                tempHead=tempHead.next;
            }

            tail = tempHead;
            tail.next =null;
            return  true;

        }

    }

    boolean deleteAtPosition(int position){

        if(position<1){
            return false;
        }
        else if(head==null && position>=1){
            return  false;
        }
        else if(head==tail && position==1){
            head=tail=null;
            return  true;
        }
        else if(head!=null && position==1){
            Node<T> tempHead= head;
            head=head.next;
            tempHead=null;
            return true;
        }
        else {
            Node<T> tempHead= head;

            for(int i=1; i<=position-2;i++){
                if(tempHead.next==null){
                    return  false;
                }
                tempHead=tempHead.next;
            }
        tempHead.next = tempHead.next.next;
        if(tempHead.next==tail){
            tail=tempHead;

        }

        return  true;
        }


    }

    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<Integer>();
        ls.add(100);
        ls.add(10);
        ls.add(15);


        ls.addAt(-1, 5);
        //   ls.reverseIterative();
       //  ls.reverseRecursive();
        ls.print();
       // ls.printReverse();
        System.out.println("----delete----");
//        ls.deletefromEnd();
//        ls.deletefromFront();
//        ls.deletefromEnd();
        ls.deleteAtPosition(1);
        ls.deleteAtPosition(1);
        ls.print();


    }

}
