package DoublyLinkedList;

public class DoublyLinkedList<T> {

    private  Node<T> head;
    private  Node<T> tail;

    DoublyLinkedList(){
        this.head=null;
        this.tail=null;
    }


    boolean add(T value){

        Node<T> temp = new Node<T>();
        temp.value=value;

        if(head==null){
            this.head=temp;
            this.tail= temp;
        }
        else{
            tail.next = temp;
            temp.previous=tail;
            tail = temp;
        }

        return  true;
    }

    boolean addAt(int position , T value){
        if(position<=0){
            return false;
        }

        Node<T> temp = new Node<T>();
        temp.value=value;


         if(head==null && position>1){
            return  false;
        }
        else if(head==null && position==1){
            head=temp;
            tail=temp;
            return  true;
        }
        else if(head!=null && position==1){
            temp.next=head;
            head.previous= temp;
            head=temp;
            return  true;
         }
        else{
            Node<T> tempHead= head;
             for(int i=1; i<=position-2;i++){
                 if(tempHead.next==null){
                     return  false;
                 }
                 tempHead=tempHead.next;

             }
             temp.next=tempHead.next;
             temp.previous =tempHead;
             if(tempHead.next!=null){
                 tempHead.next.previous=temp;
             }

             tempHead.next=temp;
             tail=temp; //made mistake. look out!
             return  true;

        }
    }

    void print(){
        print(head);
    }

    private void print(Node<T> head) {
        if(head==null){
            return;
        }
        System.out.println(head.value);
        print(head.next);
    }

    void printReverse(){
        printReverse(tail);
    }

    private void printReverse(Node<T> tail) {
        if(tail==null){
            return;
        }
        System.out.println(tail.value);
        printReverse(tail.previous);
    }

    boolean deleteStart(){
      if(head==null){
          System.out.println("linked list is empty");
          return false;
      }
      else if(head==tail){
          head=tail=null;
          return  true;
      }
      else{
          Node<T> temp = head;
          head.next.previous =  null;
          head= head.next;
          temp = null;
          return  true;
      }

    }

    boolean deleteEnd(){
        if(tail==null){
            System.out.println("lined list is empty");
            return  false;
        }
        else if(head==tail){
            head=tail=null;
            return true;

        }
        else {
            Node<T> temp = tail;
            tail = tail.previous;
            temp.previous.next=null;
            return true;

        }
    }

    boolean  deleteAtPosition(int position){
        if(head==null && position>=1){
            return  false;
        }
        else if(head==tail && position==1){
            head=tail=null;
            return  false;
        }
        else  if(head!=null && position==1){
            head.next.previous=null;
            head=head.next;
            return  true;

        }
        else {
            Node<T> tempHead = head;

            for (int i=1; i<=position-2;i++){
                if(tempHead.next==null){
                    return false;
                }
                tempHead=tempHead.next;
            }
            if(tempHead.next.next!=null){
                tempHead.next.next.previous=tempHead;
            }
           if(tempHead.next==tail){
               tail=tempHead;
           }
            tempHead.next =tempHead.next.next;
            return true;


        }



    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<Integer>();
        dl.add(5);
        dl.add(10);
        dl.add(100);

        dl.addAt(4,90);
        dl.addAt(5,80);
        dl.addAt(1,70);
        dl.print();

        System.out.println("------after delete----");
        //dl.deleteEnd();
        //dl.deleteStart();

        dl.deleteAtPosition(6);
        dl.deleteStart();
        dl.deleteEnd();


        dl.print();
    }

}
