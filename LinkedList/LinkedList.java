package data_structures;

import java.util.Iterator;
import java.ulti.NoSuchElementException;

//we will use generic type to linkedlist
public class LinkedList<E> implements ListI<E>{
	int currentsize;

	//Generic Programming
	class Node<E> {
		E data; 
		Node<E> next;

		public Node(E data){
			this.data = data;
			next = null;
		}
	}
	/** head: is pointed to the beginning of the list
		tail: is pointed to the end of the list
	*/
	private Node<E> head, tail;

	//constructor
	public LinkedList(){
		head = tail = null;
		this.currentsize = 0;
	}

	/**
	 * FIVE conditions to deal with LinkedList
	 * 1. Empty List
	 * 2. Single List
	 * 3. Beginning
	 * 4. End
	 * 5. Middle
	 */

	public void addFirst(E obj){
		//create a newNode
		Node <E> newNode = new Node<E>(obj);

		/**Case: Empty List and Single Linkedlist
		 * we need to assign head and tail => newNode
		*/

		if (head = null){
			head = tail = newNode;
			currentsize++;
		}
		//other case
		else {
			newNode.next = head;
			head = newNode;
			currentsize++;
		}
	}

	public void addLast(E obj){
		Node <E> newNode = new Node<E>(obj);
		/**Case: Empty List
		 * we need to assign head and tail => newNode
		*/
		if (head == null){
			head = tail = newNode;
			currentsize++;
		}
		else{
			tail.next = newNode;
			tail = newNode;
			currentsize++;
		}

	}

	public E removeFirst(){
		//Case: empty list
		if (head = null) 
			return null;
		//Case: single linkedlist
		if(head == tail){
			E tmp = head.data;
			head = tail = null;
			currentsize = 0;
			return tmp;
		}

		E tmp = head.data;
		head = head.next;
		--currentsize;
		return tmp;
	}

	public E removeLast(){
		Node<E> previous = null, current = head;

		//case : empty list
		if(head == null)
			return null;
		//or we can use removeFirst method

		//case: single linkedlist
		if(head.next = null){
			E tmp = head.data;
			head = null;
			return null;
		}

		while (current != tail){
			previous = current;
			current = current.next;
		}
		tail = previous;
		previous.next = null;
		--currentsize; 
		return current.data;
	}

	public E peekFirst(){
		//case : empty linkedlist
		if(head != null){
			return head.data;
		}
		return null;
	}

	public E peekLast(){
		while(tail == null){
			return null;
		}
		return tail.data;
	}


}