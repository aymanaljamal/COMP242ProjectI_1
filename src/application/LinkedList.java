package application;

public class LinkedList<A extends Comparable<A>> {
	private Node<A> head;

	public Node<A> getHead() {
		return head;
	}

	public LinkedList() {
		this.head = new Node<A>(null);
		this.head.setNext(null);
	}

	public void insert(A data) {
		Node<A> newNode = new Node<>(data);
		Node<A> curr = head.getNext();
		Node<A> prev = head;
		while (curr != null && curr.getData().compareTo(data) < 0) {
			prev = curr;
			curr = curr.getNext();
		}

		newNode.setNext(curr);
		prev.setNext(newNode);
	}

	public int length() {
		int count = 0;
		Node<A> current = head.getNext();
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public Node<A> delete(A data) {
		Node<A> prev = head, curr = head.getNext();
		while (curr != null && !(curr.getData().equals(data))) {
			prev = curr;
			curr = curr.getNext();
		}

		if (curr != null) {
			prev.setNext(curr.getNext());
			return curr;
		}
		return null;
	}

	public Node<A> find(A data) {
		Node<A> current = head.getNext();
		while (current != null && !(current.getData().equals(data))) {
			current = current.getNext();
		}
		return current;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Head -> ");
		Node<A> current = head.getNext();
		while (current != null) {
			result.append(current.getData());
			if (current.getNext() != null) {
				result.append(" -> ");
			}
			current = current.getNext();
		}
		return result.append(" -> NULL").toString();
	}

	Node<A> getAt(int index) {
		Node<A> current = head.getNext();
		for (int i = 0; i < index && current != null; i++) {
			current = current.getNext();
		}
		return current;
	}
}
