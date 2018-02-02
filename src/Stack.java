/**
 * Stack - A class for creating and manipulating a stack of nodes containing generic data of type E.
 *
 * <pre>
 *
 * Assignment:     #1
 * Course:         ADEV-3001
 * Date Created:   February 2nd 2018
 *
 * Revision Log
 * Who       When          Reason
 * --------- ------------- ---------------------------------
 *
 * </pre>
 *
 * @author Christian Wenham
 * @version 1.0
 *
 */
public class Stack<E> {
    private Node<E> head;
    private int size;

    public Stack() {
        this.size = 0;
    }

    public void push(E element) {

    }

    public E top() {
        E temp = null;
        return temp;
    }

    public E pop() {
        E temp = null;
        return temp;
    }

    /**
     * Empty all elements from the list.
     */
    public void clear(){
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    /**
     * @return true if the list is empty, else return false.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
}
