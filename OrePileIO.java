import java.io.*;
import java.util.*;

public class OrePileIO
{
	public static void main( String args[] )
	{
		System.out.println( "Hi!\nwrite <filename> <type> <weight> <grade>\nread <filename>\nexit\n" );

		Console console = System.console();
	
		String input;
		while( !( input = console.readLine() ).equals( "exit" ) )
		{
			StringTokenizer inputStrings = new StringTokenizer( input );
			String tok = inputStrings.nextToken();
			if( tok.equals( "write" ) )
			{
				if( inputStrings.countTokens() != 4 )
				{
					System.out.println( "Incorrect use. You need four variables, a filename, a type, a weight, and a grade\n" );
				}
				else
				{
					String filename = inputStrings.nextToken();
					OrePile op = new OrePile( 	OreType.lookupEnum( inputStrings.nextToken() ), 
												Float.valueOf( inputStrings.nextToken() ), 
												Float.valueOf( inputStrings.nextToken() ) );

					try
					{
						op.saveToBinary( filename );
						System.out.println( "Wrote a file with the name " + filename + " containing the following members \nType: " + op.getOreType().toString() + "\nWeight: " + op.getWeight() + "\nGrade: " + op.getGrade() + "\n" );
					}
					catch( IOException ioe )
					{
						System.out.println( "Failed: " + ioe.getMessage() );
					}
				}
			}
			else if( tok.equals( "read" ) )
			{
				if( inputStrings.countTokens() != 1 )
				{
					System.out.println( "Ioncorrect use, you need one variable, a filename\n" );
				}
				else
				{
					try
					{
						String filename = inputStrings.nextToken();
						OrePile op = OrePile.readFromBinary( filename );
						System.out.println( "Read a file with the name " + filename + " containing the following members \nType: " + op.getOreType().toString() + "\nWeight: " + op.getWeight() + "\nGrade: " + op.getGrade() + "\n" );
					}
					catch( IOException ioe )
					{
						System.out.println( "Failed: " + ioe.getMessage() + "\n" );
					}
					finally
					{
					}
				}
			}
			else
			{
				System.out.println( "write <filename> <type> <weight> <grade>, read <filename>, exit only, please\n" );
			}
		}
		System.out.println( "Goodnight!" );
	}
}
