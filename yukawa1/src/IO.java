// This class defines I/O variables and functions used by the compiler/interpreter.

import java.io.*;

public abstract class IO
{
	public static BufferedReader inStream;
	public static PrintWriter outStream;
        public static PrintWriter outStream2;

	public static int a; // the current input character on "inStream"
	public static char c; // used to convert the variable "a" to the char type whenever necessary

	public static int getNextChar()

	// Returns the next character on the input stream.

	{
		try
		{
			return inStream.read();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return -1;
		}
	}

	public static int getChar()

	// Returns the next non-whitespace character on the input stream.
	// Returns -1, end-of-stream, if the end of the input stream is reached.

	{
		int i = getNextChar();
		while ( Character.isWhitespace((char) i) )
			i = getNextChar();
		return i;
	}

	public static void display(String s)
	{
		outStream.print(s);
	}

	public static void displayln(String s)
	{
		outStream.println(s);
	}

	//The following are to be used with args2 file. Simply change identifies name. 
        public static void display2(String s)
	{
		outStream2.print(s);
	}

	public static void displayln2(String s)
	{
		outStream2.println(s);
	}
        
	public static void setIO(String inFile, String outFile, String outFile2)

	// Sets the input and output streams to "inFile" and "outFile", respectively.
	// Sets the current input character "a" to the first character on the input stream.

	{
		try
		{
			inStream = new BufferedReader( new FileReader(inFile) );
			outStream = new PrintWriter( new FileOutputStream(outFile) );
            outStream2 = new PrintWriter( new FileOutputStream(outFile2) );  //for args2
			
            a = inStream.read();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeIO()
	{
		try
		{
			inStream.close();
			outStream.close();
            outStream2.close();  //for args2
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
} 