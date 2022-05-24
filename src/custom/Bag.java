package custom;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

	private ArrayList<T> data;

	public Bag() {
		super();
		this.data = new ArrayList<T>();
	}

	public void add(T e) {
		data.add(e);
	}

	@Override
	public Iterator<T> iterator() {
		return new BagIterator<T>();
	}

	public String toString() {
		return data.toString();
	}

	public class BagIterator<T> implements Iterator<T> {

		private int index;

		public BagIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < data.size();
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			// TODO Auto-generated method stub
			return (T) data.get(index++);
		}

		public void remove() {
			if (index > 0) {
				data.remove(index - 1);
				index = data.size();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bag<Integer> bagList = new Bag<>();

		bagList.add(1);
		bagList.add(2);
		bagList.add(3);
		bagList.add(4);

		for (Iterator<Integer> it = bagList.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

		Iterator<Integer> iter = bagList.iterator();
		iter.next();
		iter.remove();

		for (Iterator<Integer> it = bagList.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
