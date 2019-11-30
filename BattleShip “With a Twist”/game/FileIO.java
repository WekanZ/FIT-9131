import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class read and write files
 * @author Weikan
 * @version 4.4
 */
public class FileIO 
{
	private String fileName;
	
	/**
	 * This is a default constructor
	 */
	public FileIO()
	{
		this.fileName = "";
	}
	
	/**
	 * This is a non-default constructor
	 * @param (String)fileName
	 */
	public FileIO(String fileName) 
	{
		this.fileName = fileName;
	}

	/**
	 * This method get the file name
	 * @return (String)fileName
	 */
	public String getFileName() 
	{
		return fileName;
	}

	/**
	 * This method reads the setting file and return setting as ArrayList
	 * @return (ArrayList<String>)setting
	 * @throws IOException
	 */
	public String[] input() throws IOException
	{
		FileReader input = new FileReader(this.fileName);
		Scanner sc = new Scanner(input);
		try
		{
			return sc.nextLine().split(",");
		}
		finally
		{
			input.close();				
		}
	}

	/**
	 * This method writes the game outcome in the file
	 * @param (String)winner
	 * @param (int)scoreP1
	 * @param (int)scoreCom
	 * @throws IOException
	 */
	public void output(String winner,
					   int scoreP1,
					   int scoreCom) throws IOException
	{
		PrintWriter output = new PrintWriter(fileName);
		try 
		{
			output.write(winner + " wins!!!\n");
			output.write("Player Score: " + scoreP1);
			output.write("\nComputer Score: " + scoreCom);
		}
		finally
		{
			output.close();			
		}
	}
	
	/**
	 * This method set the fileName
	 * @param (String)fileName
	 */
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
}
