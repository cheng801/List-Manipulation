package project2;

/*Most of this code is copied from the text book LLNode class. There are a few altercations to it allowing 
 * a string and an int to be added to the same node. There are two methods added to this class that was not 
 * originally in the book's Node class. The getCount method returns the count that is stored in each node when 
 * the method is called. And the second added method that was added was an increment count method that when called
 * it increases the integer in that node by one.*/

public class Node<T>
{
	@SuppressWarnings("rawtypes")
	private Node link;
	private T info;
	int count;
	
	public Node(T info)
	{
		this.info = info;
		this.count = 1;
		link = null;
	}
	
	public void setInfo(T info)
	{
		this.info = info;
	}
	
	public T getInfo()
	{
		return info;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void incCount()
	{
		count++;
	}
	
	@SuppressWarnings("rawtypes")
	public void setLink(Node link)
	{
		this.link = link;
	}
	
	@SuppressWarnings("rawtypes")
	public Node getLink()
	{
		return link;
	}
}