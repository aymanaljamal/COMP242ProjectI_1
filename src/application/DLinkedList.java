package application;

public class DLinkedList<A extends Comparable<A>> {
    private DNode<A> head;

    public DLinkedList() {
        this.head = new DNode<A>(null);
        head.setNext(null);
        head.setPrev(null);
    }

    public DNode<A> getHead() {
		return head;
	}

	public void setHead(DNode<A> head) {
		this.head = head;
	}

	public void insert(A data) {
        DNode<A> newNode = new DNode<>(data);
        DNode<A> current = head.getNext();
        DNode<A> prev = head;

        while (current != null && current.getData().compareTo(data) < 0) {
            prev = current;
            current = current.getNext();
        }

        newNode.setNext(current);
        prev.setNext(newNode);
        newNode.setPrev(prev);
        if (current != null) {
            current.setPrev(newNode);
        }
    }

    public DNode delete(A data) {
        if (head.getNext() == null) {
            return null;
        }

        DNode<A> current = head.getNext();
        while (current != null && !current.getData().equals(data)) {
            current = current.getNext();
        }

        if (current == null) {
            return null;
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
        current.getPrev().setNext(current.getNext());

        return current;
    }

    public int length() {
        int length = 0;
        DNode<A> current = head.getNext();
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

   
    public DNode<A> find(A data) {
        DNode<A> current = head.getNext(); 
        while (current != null && !current.getData().equals(data)) {
            current = current.getNext(); 
        }
        
        return current; 
    }
    public void traverse() {
        DNode<A> current = head.getNext(); 
        System.out.print("Head-->");
        while (current != null) {
            System.out.print("[" + current.getData() + "]--");
            current = current.getNext();
        }
        System.out.println("NULL");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Head-->");
        DNode<A> current = head.getNext();
        while (current != null) {
            result.append("[").append(current.getData().toString()).append("]");
            current = current.getNext();
            if (current != null) {
                result.append("<=>");
            }
        }
        return result.append("-->NULL").toString();
    }
}
