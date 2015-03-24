import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class DSAStackTest
{
	// Test that constructor doesn't fail, and that it does when it should
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
		try
		{
			DSAStack testStack = new DSAStack( 1024 );
			assertTrue( false );
		}
		catch( IllegalArgumentException iae )
		{
			assertTrue( true );
		}
	}

	// Test push with two successful inserts and one planned fail
	@Test
	public void testPush()
	{
		DSAStack testStack = new DSAStack( 2 );
		testStack.push( 52 );
		testStack.push( 31 );
		try
		{
			testStack.push( 100 );
			assertTrue( false );
		}
		catch( IndexOutOfBoundsException ioobe )
		{
			assertTrue( true );
		}
	}

	// Test pop with two planned successes and one planned failure
	@Test
	public void testPop()
	{
		DSAStack testStack = new DSAStack( 5 );
		testStack.push( 62 );
		testStack.push( 13 );

		try
		{
			assertEquals( (int)testStack.pop(), 13, 0 );
			assertEquals( (int)testStack.pop(), 62, 0 );
		}
		catch( IndexOutOfBoundsException ioobe )
		{
			assertTrue( false );
		}

		try
		{
			testStack.pop();
			assertTrue( false );
		}
		catch( IndexOutOfBoundsException ioobe )
		{
			assertTrue( true );
		}
	}

	// Test peek
	@Test
	public void testPeek()
	{
		DSAStack testStack = new DSAStack( 3 );
		testStack.push( 5 );
		testStack.push( 10 );
		testStack.push( 12 );
		assertEquals( (int)testStack.peek(), 12, 0 );
	}

	// Test count
	@Test
	public void testGetCount()
	{
		DSAStack testStack = new DSAStack( 4 );
		assertEquals( testStack.getCount(), 0, 0 );
		testStack.push( 5 );
		assertEquals( testStack.getCount(), 1, 0 );
		testStack.push( 12 );
		assertEquals( testStack.getCount(), 2, 0 );
		testStack.pop();
		assertEquals( testStack.getCount(), 1, 0 );
	}

	// Test size
	@Test
	public void testGetSize()
	{
		assertEquals( (new DSAStack( 5 )).getSize(), 5, 0 );
		assertEquals( (new DSAStack( 10 )).getSize(), 10, 0 );
	}

	// Test full status
	@Test
	public void testGetIsFull()
	{
		DSAStack testStack = new DSAStack( 3 );
		testStack.push( 1 );
		testStack.push( 1 );
		assertEquals( testStack.getIsFull(), false );
		testStack.push( 1 );
		assertEquals( testStack.getIsFull(), true );
	}

	// Testempty status
	@Test
	public void testGetIsEmpty()
	{
		DSAStack testStack = new DSAStack( 3 );
		assertEquals( testStack.getIsEmpty(), true );
		testStack.push( 5 );
		assertEquals( testStack.getIsEmpty(), false );
	}
}
