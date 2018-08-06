
package amsitlab.textr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileTextRunner is class action for rading file contents and then runing text .
 *
 * @author Amsit <dezavue3@gmail.com>
 */
public class FileTextRunner extends TextRunner
{


	public FileTextRunner(String filename, long sleep)
	throws FileNotFoundException, IOException
	{
		
		this(new File(filename), sleep);
	}




	public FileTextRunner(File file, long sleep)
	throws FileNotFoundException, IOException
	{
		this.mSleep = sleep;
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);

		String line;
		while((line = reader.readLine()) != null)
		{
			// Ignore doc comment
			if(line.startsWith("//"))
			{
				continue;
			}
			mTextList.add(line);
		}
	    
		reader.close();
	}

}
