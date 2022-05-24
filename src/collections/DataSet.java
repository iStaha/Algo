package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: gerard Date: 2/25/14 Time: 11:47 AM
 */
public class DataSet implements Iterable<String> {

	private String myData[] = { "1", "2", "3", "4" };

	int[] ints = { 1, 2, 3 };
	List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

	

	public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        Iterator<String> iterator = dataSet.iterator();
     

        for (String nextValue : dataSet) {
            System.out.println("The next value with the for Loop is: " + nextValue);
        }
        
        
        
        int[] ints = { 1, 2, 3 };
    	List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
    	
    	 for (int i=0; i<ints.length ; i++){		    
             list.contains(i+1);
           }
    }

	@Override
    public Iterator<String> iterator() {
        return new DataSetIterator();
    }

	private class DataSetIterator implements Iterator {
		private int position = 0;

		public boolean hasNext() {
			if (position < myData.length)
				return true;
			else
				return false;
		}

		public String next() {
			if (this.hasNext())
				return myData[position++];
			else
				return null;
		}

		@Override
		public void remove() {

		}
	}

}