package application;

public class DNode<A extends Comparable<A>> {
	private A data;
	private DNode<A> next;
	private DNode<A> prev;

	public DNode(A data) {
		this.data = data;
	}

	public A getData() {
		return data;
	}

	public DNode getNext() {
		return next;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

	public String toString() {
		return this.data.toString();
	}
}
