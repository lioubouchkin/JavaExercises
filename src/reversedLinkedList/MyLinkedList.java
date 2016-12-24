package reversedLinkedList;

import java.util.Iterator;

public class MyLinkedList implements Iterable<Integer>{
	private ListNode node;
	
	public MyLinkedList() {
		super();
	}
	
	public void add (int value) {
		if ( this.node == null ) {
			this.node = new ListNode(value);
		} else {
			this.add(value, this.node);
		}
	}
	
	private void add (int value, ListNode node) {
		if ( node.next == null ) {
			ListNode next = new ListNode(value);
			node.next = next;
		} else {
			this.add(value, node.next);
		}
	}
	
	public MyLinkedList reverseList () {
		MyLinkedList rList = new MyLinkedList();
		rList = this.reverseNode(this.node, rList);
		return rList;
	}
	
	private MyLinkedList reverseNode (ListNode n, MyLinkedList rList) {
		if ( n.next != null ) {
			rList = this.reverseNode(n.next, rList);
			rList.add(n.item);
			return rList;
		} else {
			rList.add(n.item);
			return rList;
		}
	}
	
	
	static class ListNode {
		int item;
		ListNode next;
		
		public ListNode(int i) {
			this.item = i;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new LinkedListIterator(this.node);
	}
	
	private class LinkedListIterator implements Iterator<Integer> {
		ListNode next;
		
		public LinkedListIterator(ListNode node) {
			this.next = node;
		}
		@Override
		public boolean hasNext() {
			return next != null;
		}
	
		@Override
		public Integer next() {
			ListNode current;
			if ( hasNext() ) {
				current = new ListNode( this.next.item );
				this.next = this.next.next == null
						? null
						: this.next.next;
				return Integer.valueOf(current.item);
			} else {
				return null;
			}
		}
	}
} 
