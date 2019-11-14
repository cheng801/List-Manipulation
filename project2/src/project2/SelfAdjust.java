package project2;

/*This is the first self adjusting list class, where if a duplicate word is found the count
 * within that node is increased by one and then the node is moved to the first position in
 * the list. This class is an extension of the unsorted list class with a modification to
 * the add method in order to implement the above situation. This class also returns statistics
 * like the unsorted list class when those method are called in main. */

public class SelfAdjust <T extends Comparable<T>> extends UnsortedList<T>
{
	public SelfAdjust()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void add(T element)
	/*This method takes the word from main like the unsorted class and compares it to each word
	 * in the list until it finds the same word. If the word does not exist in the list then a
	 * new node is made and then added to the beginning of the list. If the word does exist in
	 * the list then the counter in the list and then moves the word to the front of the list.*/
	{
		Node<T> location;
		T listElement;
		
		location = list;
		
		while(location != null)
		{
			listElement = location.getInfo();
			comparison++;
			comparison++;
			if(listElement.compareTo(element) == 0 && list.getInfo().compareTo(element) == 0)
			{
				location.incCount();
				return;
			}
			else
			comparison++;	
			if(listElement.compareTo(element) == 0)
			{
				location.incCount();
				find(element);
				previous.setLink(location.getLink());
				refChanges++;
				location.setLink(list);
				refChanges++;
				list = location;
				return;
			}
			else
			{
				location = location.getLink();
			}
		}
		Node<T> newNode = new Node<T>(element);
		newNode.setLink(list);
		refChanges++;
		list = newNode;
		refChanges++;
		numElements++;
	}
	
	public long comparisons()
	{
		return comparison;
	}
	
	public long refChanges()
	{
		return refChanges;
	}
}
