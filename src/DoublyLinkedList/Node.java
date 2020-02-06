package DoublyLinkedList;

public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;

    Node(){
        this.next=null;
        this.previous=null;
    }

    Node(T value, Node<T> next, Node<T> previous){
        this.value=value;
        this.next= next;
        this.previous = previous;
    }

    Node<T> getNext(){
        return  this.next;
    }

    Node<T> getPrevious(){
        return this.previous;
    }

   void setNext(Node<T> next){
          this.next=next;
    }

   void setPrevious(Node<T> previous){
         this.previous = previous;
    }



}
