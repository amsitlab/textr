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

import java.util.Scanner;


/**
 * TextRunner is class action for runing text.
 *
 * @author Amsit <dezavue3@gmail.com>
 */
public class StdoutTextRunner extends TextRunner
{



	/**
	 * Constructor 
	 *
	 * @param long sleep
	 */
	public StdoutTextRunner(long sleep)
	{
		this(new Scanner(System.in), sleep);
	}


	/**
	 * Constructor 
	 *
	 * @param java.util.Scanner scanner
	 * @param long sleep
	 */
	public StdoutTextRunner(Scanner scanner, long sleep)
	{
		while(scanner.hasNextLine())
		{
			mTextList.add(scanner.nextLine());
		}
		mSleep = sleep;
	}

}
