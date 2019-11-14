package project2;

/*This the sorted list class that that puts every word that is read from the file into
 * alphabetical order. This class is an extension of the unsorted list class where most 
 * of the methods are the same, with the exception of the add method which had to be adjusted
 * in order to sort the words alphabetically and to take into account if the word is a duplicate.
 * Some of this class is also copied from the text book but needed modification in order to account
 * for duplicate words. This class also returns the statistics of the list being implemented 
 * returning the numbers to where ever the method was called.*/

public class SortedList <T extends Comparable<T>> extends UnsortedList<T>
{
	public SortedList()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	/*This method takes the word sent from main and sets it to element to compare to the other
	 * words in the complete list like in the unsorted list class. If the element word is already
	 * found in the list the counter in that node is increased by one and then returns back to main.
	 * Otherwise if the word is a new and not found in the list, the word is compared to the first
	 * word in the complete list until it finds where it should be inserted alphabetically.*/
	public void add(T element)
	{
		Node<T> prevLoc;
		Node<T> location;
		T listElement;
		
		location = list;
		prevLoc = null;
		
		while(location != null)
		{
			listElement = location.getInfo();
			comparison++;
			if(listElement.compareTo(element) == 0)
			{
				location.incCount();
				return;
			}
			comparison++;
			if(listElement.compareTo(element) < 0)
			{
				prevLoc = location;
				location = location.getLink();
			}
			else 
				break;
		}
		
		Node<T> newNode = new Node<T>(element);
		
		if(prevLoc == null)
		{
			newNode.setLink(list);
			refChanges++;
			list = newNode;
			refChanges++;
		}
		else
		{
			newNode.setLink(location);
			refChanges++;
			prevLoc.setLink(newNode);
			refChanges++;
		}
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
