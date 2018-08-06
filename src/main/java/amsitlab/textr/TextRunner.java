/**
 * Copyright 2018 Amsit.
 *
 * This file parts of amsitlab package.
 * For more information, please read LICENSE file that has been included with this file.
 *
 * @package amsitlab.textr
 * @version 1.0
 */
package amsitlab.textr;

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;

/**
 * TextRunner is class action for runing text.
 *
 * @author Amsit <dezavue3@gmail.com>
 */
public class TextRunner implements Runnable
{
	
	/**
	 * List of the text will be render.
	 *
	 * @var java.util.List<String> mTextList
	 */
	protected List<String> mTextList = new ArrayList<String>();


	/**
	 * Sleep time.
	 *
	 * @var long mSleep
	 */
	protected long mSleep = 100;



	/**
	 * Constructor
	 */
	public TextRunner()
	{
	}



	/**
	 * Constructor
	 *
	 * @param java.util.List<String> textList
	 * @param long sleep
	 */
	public TextRunner(List<String> textList, long sleep)
	{
		mTextList = textList;
		mSleep = sleep;
	}


	@Override
	public void run()
	{
		int current = 1; // text list counter
		for(String text: mTextList)
		{
			text = formatAll(text);
			int finish = text.getBytes().length;
			for(int start=0;start < finish; start++)
			{
			    out.write(text.charAt(start));
			    try
			    {
				Thread.sleep(mSleep);
			    }
			    catch( InterruptedException ie) {
					//pass
			    }
			}
			if(current != mTextList.size())
				out.println();
			current++;
			
		}
	}



	/**
	 * Set text list will be render.
	 *
	 * @param java.util.List<String> textList
	 */
	public void setTextList(List<String> textList)
	{
		mTextList = textList;
	}


	/**
	 * Get text list will be render.
	 *
	 * @return java.util.List<String>
	 */
	public List<String> getTextList()
	{
		return mTextList;
	}


	/**
	 * Set sleep time
	 *
	 * @param long time
	 */
	public void setSleepTime(long time)
	{
		mSleep = time;
	}


	/**
	 * Get sleep time
	 *
	 * @return long
	 */
	public long getSleepTime()
	{
		return mSleep;
	}




	/**
	 * Formatting/Replacing text contents before render.
	 *
	 * @return java.lang.String
	 */
	protected String formatAll(String text)
	{
		return text.replaceAll("%t","\t").
				replaceAll("%n","\n").
				replaceAll("\\(@red\\)","\033[31m").
				replaceAll("\\(@green\\)", "\033[32m").
				replaceAll("\\(@yellow\\)","\033[33m").
				replaceAll("\\(@blue\\)","\033[34m").
				replaceAll("\\(@magenta\\)","\033[35m").
				replaceAll("\\(@cyan\\)","\033[36m").
				replaceAll("\\(@end\\)","\033[0m");

		
	}
}

