import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class DSAStackTest
{
	@Test
	public void testConstructor()
	{
		try
		{
			DSAStack testStack = new DSAStack( 32 );
		}
		catch( IndexOutOfBoundsException ioobe )
		{
			assertTrue( false );
		}
	}
}
