/** This file created by commadex */
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

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.ArrayList;




/**
 * Main application class.
 *
 * @author Amsit <dezavue3@gmail.com>
 */

@Command(name = App.NAME,
	mixinStandardHelpOptions = true,
	version = "textr 1.1"
	)
public class App implements Runnable 
{
	
	/**
	 * Application name
	 */
	public static final String NAME = "textr";

	/**
	 * Debug mode.
	 */
	public static final boolean DEBUG = false;


	/**
	 * List of the text(s)
	 *
	 * @var java.util.List<String> mTextList
	 */
	@Parameters(
		arity = "0..*",
		paramLabel = "[TEXT ...]",
		description = "Text(s) to render sparated by space, Space without double quote will be replace to newline."
	)
	protected List<String> mTextList = new ArrayList<String>();


	/**
	 * Long sleep time.
	 *
	 * @var long mSleep
	 */
	 @Option(
	 	names = {"-S", "--sleep"},
		description = "Sleep time. numeric type ex: 100"
	)
	protected long time = 100;

	 /**
	  * Running text from stdout pipes
	  *
	  * @var boolean fromStdout
	  */
	 @Option(
	 	names = {"--from-stdout"},
		description = "Capture stdout and run text output"
	)
	protected boolean fromStdout;

	 /**
	  * Reading file contents and running text."
	  *
	  * @var java.lamg.String filename
	  */
	 @Option(
	 	names = {"-F", "--file"},
		description = "Running text of file"
	)
	protected String filename;

	@Override
	public void run()
	{
		if(null != filename)
		{
			try {
				new FileTextRunner(filename, time).run();
			} catch(FileNotFoundException e) {
				System.err.println(e.getMessage());
				CommandLine.usage(this, System.err);
			} catch(IOException e) {
				App.error(e);
			}
		}
		else if(fromStdout)
		{
			
			new StdoutTextRunner(time).run();
		}
		else
		{
			if(mTextList.size() < 1)
			{
				CommandLine.usage(new App(), System.err);
			}
			else
			{
				new TextRunner(mTextList,time).run();
			}
		}

	}


	/**
	 * main program
	 */
	 public static void main(String ...args)
	 {
	 	CommandLine.run(new App(), System.out, args);
	 }



	 public static void error(Exception e)
	 {
		if(App.DEBUG)
		{
			if(e != null)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.err.println("Unknown error.\n"
				+ "Please contact author.\n"
				+ "\tEmail\t: dezavue3@gmail.com\n"
				+ "\tTele \t: @dezavue");
		}
	 }

}
