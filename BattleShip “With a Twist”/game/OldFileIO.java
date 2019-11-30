import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Weikan
 * @version 3.6
 */
public class OldFileIO 
{
	private String fileName;
	
	/**
	 * This is a default constructor
	 */
	public OldFileIO()
	{
		this.fileName = "";
	}
	
	/**
	 * This is a non-default constructor
	 * @param (String)fileName
	 */
	public OldFileIO(String fileName) 
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
	public static ArrayList<String> input() throws IOException
	{
		FileReader fileReader = new FileReader("gamesettings.txt");
		BufferedReader input = new BufferedReader(fileReader);
		String line[] = new String[4];
		ArrayList<String> setting = new ArrayList<>();
		for (int index = 0; index < 4; index++)
		{
			line[index] = input.readLine();
			setting.add(line[index].split(":")[1]);
		}
		input.close();
		return setting;
	}

	/**
	 * This method writes the game outcome in the file
	 * @param (String)winner
	 * @param (int)scoreP1
	 * @param (int)scoreCom
	 * @throws IOException
	 */
	public static void output(String winner,
							  int scoreP1,
							  int scoreCom) throws IOException
	{
		FileWriter fileWriter = new FileWriter("gameoutcome.txt");
		BufferedWriter output = new BufferedWriter(fileWriter);
		output.write(winner + " wins!!!\n");
		output.write("Player Score: " + scoreP1);
		output.write("\nComputer Score: " + scoreCom);
		output.close();
	}
	
	/**
	 * This method
	 * @param (String)fileName the fileName to set
	 */
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
}
