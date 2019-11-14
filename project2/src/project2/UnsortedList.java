package project2;

/*This is the unsorted list class, where when called every word is pushed to this list in the order
 * that it is read from the file. This class is mostly copied from the text book with a few additions.
 * The add method had to be changed in order to check for duplicate words and when a duplicate word is 
 * found the count within that word is increased by one. There are also methods added to count the number
 * of comparisons, reference changes, vocabulary, unique words in the list. Which when these numbers are found, 
 * if the method was called by main, returns that number that was calculated.*/

public class UnsortedList<T extends Comparable<T>>
{
	protected int numElements;
	protected Node<T> currentPos;
	protected boolean found;
	protected Node<T> location;
	protected Node <T> previous;
	protected Node<T> list;
	protected long counter;
	protected long refChanges;
	protected long comparison;
	protected long vocab;
		
	public UnsortedList()
	{
		numElements= 0;
		list = null;
		currentPos = null;
	}
	@SuppressWarnings("unchecked")
	public void add(T element)
	/*Takes the word sent from main and sets it to element. Sets location to the complete unsorted 
	 * list. Then while the location which is linked to main is not null, it runs through the while
	 * loop. Gets the info from the first node of the location list and sets it to list element so 
	 * we can compare it to the element word. If it is the same word, then the count within the node
	 * is increased by one and returns back to main. If it is not the same word the location grabs the
	 * next word in the list and does the same comparisons until the end of the list is reached. If the 
	 * end of the list is reached without returning back to main, then the word must be a new one in the
	 * list and a new node is created for the word and added to the first position in the list.*/
	{
		Node<T> location;
		T listElement;
		location = list;
		while(location != null)
		{
			listElement = location.getInfo();
			comparison++;
			if(listElement.compareTo(element) == 0)
			{
				location.incCount();
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
		numElements++;
	}
	
	public long vocab()
	/*This method finds the total number of words that are in the node. This method performs
	 * this action by taking the count within each node and adding them together to find the
	 * total number of words. This sets location to the complete list so the list is not changed
	 * when it is searching for the count in each node of the list. Once the count has been added
	 * to the total counter for words, the location list finds the next word in the list and performs
	 * the same action by adding it to the total number until there are no more words in the list.*/
	{
		location = list;
		while(location != null)
		{
			vocab = vocab + location.getCount();
			location = location.getLink();
		}
		return vocab;
	}
	
	public long comparisons()
	/*This method returns the number that is counted within the add class whenever a word is compared 
	 * to another word for similarity.*/
	{
		return comparison;
	}
	
	public long refChanges()
	/*This method also is counted in the add method for whenever a node has to change its reference from
	 * one node to another one. Then this method returns the number back to whomever called it.*/
	{
		return refChanges;
	}
	
	@SuppressWarnings("unchecked")
	public long getNodes()
	/*This method is very similar to the previous method vocab(), where the location is set to list to insure
	 * that list is not changed in any way, but can still be searched for nodes. This method searches for how
	 * many unique words there are in the list. This method */
	{
		location = list;
		while(location != null)
		{
			location = location.getLink();
			counter++;
		}
		return counter;
	}
	
	@SuppressWarnings("unchecked")
	protected void find(T target)
	/*Searches list for an occurrence of an element e such that e.equals(target). If successful, sets instance variables 
	 * found to true, location to node containing e, and previous to the node that links to location. If not successful, 
	 * sets found to false.*/
	{
		location = list;
		found = false;
		while(location != null)
		{
			if (location.getInfo().equals(target))
			{
				found = true;
				return;
			}
			else
			{
				previous = location;
				location = location.getLink();
			}
		}
	}
	
	public int size()
	//Returns the number of elements on this list.
	{
		return numElements;
	}
	
	public boolean contains (T element)
	//Returns true if this list contains an element e such that e.equals(element); otherwise, returns false.
	{
		find(element);
		return found;
	}
	
	@SuppressWarnings("unchecked")
	public boolean remove (T element)
	//Removes an element e from this list such that e.equals(element) and returns true; if no such element exists, returns false.
	{
		find(element);
		if(found)
		{
			if(list == location)
			{
				list = list.getLink();
			}
			else
				previous.setLink(location.getLink());
			numElements--;
		}
		return found;
	}
	
	public T get(T element)
	//Returns an element e from this list such that e.equals(element); if no such element exists, returns null.
	{
		find(element);
		if(found)
			return location.getInfo();
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	//Returns a nicely formatted string that represents this list.
	{
		Node<T> currNode = list;
		String listString = "List:\n";
		while(currNode != null)
		{
			listString = listString + " "  + currNode.getInfo() + " " + currNode.getCount() + "\n";
			currNode = currNode.getLink();
		}
		return listString;
	}
	
	public void reset()
	//Initializes current position for an iteration through this list, to the first element on this list.
	{
		currentPos = list;
	}
	
	@SuppressWarnings("unchecked")
	public T getNext()
	/*Returns the element at the current position on this list. If the current position is the last element, then it 
	 * advances the value of the next current position to the first element; otherwise, it advances the value of the 
	 * current position to the next element.*/
	{
		T next = currentPos.getInfo();
		if(currentPos.getLink() == null)
			currentPos = list;
		else
			currentPos = currentPos.getLink();
		return next;
	}
}
