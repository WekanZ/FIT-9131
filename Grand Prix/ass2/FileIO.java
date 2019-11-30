package ass2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	public FileIO() {
		
	}
	
	public static ArrayList<String> input(String fileName) throws IOException
	{
		FileReader input = new FileReader(fileName);
		Scanner sc = new Scanner(input);
		ArrayList<String> info = new ArrayList<String>();
		try
		{
			while(sc.hasNext()) {
				info.add(sc.nextLine());
			}
			return info;
		}
		finally
		{
			input.close();				
		}
	}
}
