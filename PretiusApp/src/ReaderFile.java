import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.ObjectInputStream.GetField;
import java.math.BigDecimal;


public class ReaderFile
{

	private BufferedReader br;
//	private  sum;
	
	public ReaderFile(String filePath) throws FileNotFoundException, UnsupportedEncodingException
	{
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF8"));
	}

	public void closeFile() throws IOException
	{
		br.close();
	}
	
	public BigDecimal sumAmounts() throws IOException
	{
		BigDecimal sum = new BigDecimal("0.0");
		String textLine;
		textLine = br.readLine();
		
		while (textLine !=null)
		{
			
			int position_amount = textLine.indexOf("@amount");
			int position_currency = textLine.indexOf("PLN", position_amount);
			if (position_amount!=-1)//(textLine.contains("@amount"))
			{
				BigDecimal currentAmount = new BigDecimal(textLine.substring
						(position_amount + "@amount".length()+1, position_currency).replace(",", "."));
				sum = sum.add(currentAmount);
			}
			textLine = br.readLine();
			
			
		}
		closeFile();
		return sum;
	}


	

	
}

