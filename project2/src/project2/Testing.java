package project2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*This is the main class that takes the txt file and performs operations on it. The file is found in the source 
 * folder of the project2 folder. Then it is scanned to have the operating system be familiarized with what is 
 * being read. Then the overhead time is calculated by checking how long it takes for the file to be read and 
 * then take each word and remove the punctuation contained within the word. Then the overhead time is subtracted
 * from the time it takes for each list to run. When each list is instantiated and operated on, the file is reopened
 * and closed to ensure that there are as little differences between each iteration. In each of the four iterations
 * a list is created with its own specific properties, then a the scanner searches through the file for words and 
 * adds the word to the list while parsing all the punctuation from the word. The time it took to push all the parsed
 * words to the list is printed out. Followed by: the total number of words, the total number of unique words, the 
 * number of comparisions that were made within that specific list class, and how many times references were changed
 * from one node to another. This class gives the statistics of how each list runs the given text file that is provided.*/

public class Testing
{
	public static void main(String[] args) throws FileNotFoundException
	{
		double startTime;
		double stopTime;
		double startOverHead;
		double stopOverHead;
		double overHead;
		
		File file = new File("Bleak House - Dickens.txt");
		Scanner script = new Scanner(file);
		script.close();
		
		script = new Scanner(file);
		startOverHead = System.currentTimeMillis();
		while(script.hasNext())
		{
			String word = script.next().toLowerCase();
			word = word.replaceAll("[\\p{P}&&[^-]&&[^']]", "");
		}
		stopOverHead = System.currentTimeMillis();
		overHead = stopOverHead - startOverHead;
		script.close();
			
	
		script = new Scanner(file);
		UnsortedList<String> unsorted = new UnsortedList<String>();
		startTime = System.currentTimeMillis();
		while(script.hasNext())
		{
			String word = script.next().toLowerCase();
			word = word.replaceAll("[\\p{P}&&[^-]&&[^']]", "");
			unsorted.add(word);		
		}
		script.close();
		stopTime = System.currentTimeMillis();
		System.out.println("The time for the Unsorted List is: " + (stopTime - startTime - overHead)/1000);
		System.out.println("The total number of words in the list are: " + unsorted.vocab());
		System.out.println("The total number of distinct words are: " + unsorted.getNodes());
		System.out.println("The total number of comparisons made between words are: " + unsorted.comparisons());
		System.out.println("The total number of reference changes are: " + unsorted.refChanges());
		System.out.println();
		
		
		
		script = new Scanner(file);
		SortedList<String> sorted = new SortedList<String>();
		startTime = System.currentTimeMillis();
		while(script.hasNext())
		{
			String word = script.next().toLowerCase();
			word = word.replaceAll("[\\p{P}&&[^-]&&[^']]", "");
			sorted.add(word);
		}
		script.close();
		stopTime = System.currentTimeMillis();
		System.out.println("The time for the Alphabetically Sorted list is: " + (stopTime - startTime - overHead)/1000);
		System.out.println("The total number of words in the list are: " + sorted.vocab());
		System.out.println("The total number of distinct words are: " + sorted.getNodes());
		System.out.println("The total number of comparisons made between words are: " + sorted.comparisons());
		System.out.println("The total number of reference changes are: " + sorted.refChanges());
		System.out.println();
		
		script = new Scanner(file);
		SelfAdjust<String> selfAdjust = new SelfAdjust<String>();
		startTime = System.currentTimeMillis();
		while(script.hasNext())
		{
			String word = script.next().toLowerCase();
			word = word.replaceAll("[\\p{P}&&[^-]&&[^']]", "");
			selfAdjust.add(word);
		}
		script.close();
		stopTime = System.currentTimeMillis();
		System.out.println("The time for the First Self Adjusting list is: " + (stopTime - startTime - overHead)/1000);
		System.out.println("The total number of words in the list are: " + selfAdjust.vocab());
		System.out.println("The total number of distinct words are: " + selfAdjust.getNodes());
		System.out.println("The total number of comparisons made between words are: " + selfAdjust.comparisons());
		System.out.println("The total number of reference changes are: " + selfAdjust.refChanges());
		System.out.println();
		
		script = new Scanner(file);
		SelfAdjustTwo<String> selfAdjustTwo = new SelfAdjustTwo<String>();
		startTime = System.currentTimeMillis();
		while(script.hasNext())
		{
			String word = script.next().toLowerCase();
			word = word.replaceAll("[\\p{P}&&[^-]&&[^']]", "");
			selfAdjustTwo.add(word);
		}
		script.close();
		stopTime = System.currentTimeMillis();
		System.out.println("The time for the Second Self Adjusting list is: " + (stopTime - startTime - overHead)/1000);
		System.out.println("The total number of words in the list are: " + selfAdjustTwo.vocab());
		System.out.println("The total number of distinct words are: " + selfAdjustTwo.getNodes());
		System.out.println("The total number of comparisons made between words are: " + selfAdjustTwo.comparisons());
		System.out.println("The total number of reference changes are: " + selfAdjustTwo.refChanges());
	}
}
