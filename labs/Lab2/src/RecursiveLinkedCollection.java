 
/**
 * @author Ander Swartz
 *
 * 
 */
public class RecursiveLinkedCollection<T> implements CollectionInterface<T> {

	protected LLNode<T> front;
	protected int size;

	public RecursiveLinkedCollection() {
		size = 0;
		front = null;
	}

	private LLNode<T> recAdd(LLNode<T> node, T element){
		if(node!=null)
			node.setLink(recAdd(node.getLink(),element));
		else {
			node = new LLNode<T>(element);
		}
		System.out.println("node is now: "+node.getInfo());
		return node;
	}


	public boolean add(T element) {
		front = recAdd(front, element);
		System.out.println("front is "+front.getInfo());
		return true;
	}

	private T recGet(LLNode<T> node, T target){
		if(node!=null) {
			if(node.getInfo().equals(target)) {
				return node.getInfo();
			}
			return recGet(node.getLink(), target);
		}
		return null;
	}

	public T get(T target) { //returns the element that contains the target
		return recGet(front, target);
	}


	private LLNode<T> recRemove(LLNode<T> node, T element){
		if(node!=null) {
			if(node.getInfo().equals(element)) {
				node=node.getLink();
				size--;
			}
			if(node!=null)
				node.setLink(recRemove(node.getLink(),element));
		}
		return node;
	}

	public boolean remove(T element) {
		int tempSize = size-1;
		front = recRemove(front, element);
		if(size==tempSize)
			return true;
		return false;
	}

	private boolean recContains(LLNode<T> node, T target) {
		if(node!=null){
			if(node.getInfo().equals(target))
				return true;
			return recContains(node.getLink(), target);
		}
		return false;
	}


	public boolean contains(T target) {
		return recContains(front, target);
	}


	public boolean isFull() {
		return false;
	}


	public boolean isEmpty() {
		return false;
	}

	private int recSize(LLNode<T> node) {
		if(node!=null)
			return 1 + recSize(node.getLink());
		return 0;
	}

	public int size() {
		return recSize(front);
	}


	public String toString() {
		String ret = "";
		LLNode<T> temp = front;
		if(temp!=null) {
			ret+=temp.getInfo();
			temp = temp.getLink();
		}
		while(temp!=null) {
			ret+="," +temp.getInfo(); //ret+="," + temp.getInfo();
			temp = temp.getLink();
		}
		return ret;
	}



}
