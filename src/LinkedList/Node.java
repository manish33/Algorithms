package LinkedList;

public class Node<T> {

    T value;
    Node<T> next;

    Node(){
       this.next=null;
    }
    Node(T value, Node<T> next){
        this.value=value;
        this.next=next;
    }

    void setValue(T value){
        this.value=value;
    }
    void  setNext(Node<T> next){
        this.next=next;
    }

    Node<T> getNext(){
        return this.next;
    }
    T getValue(){
        return  this.value;
    }

}
