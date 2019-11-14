package project2;

/*This is the second self adjusting list that when a duplicate word is found the count in the node
 * containing that word is increased by one and then moved up one node. If the word does not exist
 * in the list then the word is added to a new node and inserted into the first position of the node.
 * For this method to work the two words before the targeted word must be saved in empty nodes to 
 * be able to change the references correctly. If the word is the first word in the list then the two
 * previous references are not needed and the count is increased by one and then returns back to main.
 * If the word is the second word in the list then the third reference is not needed. Otherwise the list
 * sets the third reference to the location word and then the second reference to what the location word
 * was pointed.*/

public class SelfAdjustTwo <T extends Comparable<T>> extends UnsortedList<T>
{
	public SelfAdjustTwo()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void add(T element)
	{
		Node<T> location;
		Node<T> prevLocation = null;
		Node<T> prevPrevious = null;
		T listElement;
		location = list;
		
		while(location != null)
		{
			listElement = location.getInfo();
			comparison++;
			if(list.getInfo().compareTo(element) == 0 && prevLocation == null && prevPrevious == null)
			{
				location.incCount();
				return;
			}
			
			else
			comparison++;
			if(listElement.compareTo(element) == 0 && prevPrevious == null)
			{
				location.incCount();
				prevLocation.setLink(location.getLink());
				refChanges++;
				location.setLink(prevLocation);
				refChanges++;
				list = location;
				return;
			}	
			else
			comparison++;
			if(listElement.compareTo(element) == 0)
			{
				location.incCount();
				prevLocation.setLink(location.getLink());
				refChanges++;
				prevPrevious.setLink(location);
				refChanges++;
				location.setLink(prevLocation);
				refChanges++;
				return;
			}
			else
			{
				prevPrevious = prevLocation;
				prevLocation = location;
				location = location.getLink();
			}
		}
		Node<T> newNode = new Node<T>(element);
		newNode.setLink(list);
		refChanges++;
		list = newNode;
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
