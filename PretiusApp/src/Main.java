import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Main
{

	
	
	public static void main(String[] args)
	{
		ReaderFile readerFile = null;
		String filePath = null;
		
		if (args.length == 0)
		{
			filePath = "./Plik z danymi.txt";
		}
		else if (args.length == 1)
		{
			filePath = args[0];
		}
		else System.out.println("Niepoprawna liczba argumentów"); 
			
		try
		{
			readerFile = new ReaderFile(filePath);
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			System.out.println("Unsupported encoding.");
			e.printStackTrace();
		}
		try
		{
			System.out.println(readerFile.sumAmounts());
			
		} catch (IOException e)
		{
			System.out.println("Cant open file.");
			e.printStackTrace();
		}
		
		
	}

}
