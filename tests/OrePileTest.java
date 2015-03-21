// Unit tests for the OrePile class

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class OrePileTest
{
	// Check that OrePiles with eqivalent fields are equal, and that OrePiles with fields which are not equivalent, are not equal
	@Test
	public void testEquals()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op, op ); // I'd bloody well hope it's equal to itself
		OrePile opCopy = new OrePile( op );
		opCopy.setWeight( 100 );
		assertNotEquals( op, opCopy ); // And I'd hope that piles with different weight are not
	}

	// Test that the constructor is properly building OrePiles
	@Test
	public void testConstructor()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op.getOreType(), OreType.IRON ); // Correctly parsed IRON
		assertEquals( op.getWeight(), 30, 0 ); // Correctly parse weight
		assertEquals( op.getGrade(), 60, 0 ); // Correctly parse grade
	}

	// Check that using one OrePile to build another OrePile will give you equivalent OrePiles
	@Test
	public void testCopyConstructor()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		OrePile opCopy = new OrePile( op );
		assertEquals( op, opCopy ); // Copy is the same as the original
		opCopy.setWeight( 100 );
		assertNotEquals( op, opCopy ); // Copy is not the same as original now that the OreType has been changed
	}

	// Check that we're correctly computing the metal weight from the ore weight and the grade
	@Test
	public void testCalcMetalWeight()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op.calcMetalWeight(), 30 * 0.6, 0 ); // Weight of 30, grade of 60%
	}

	// Check that the file writing does not throw exceptions
	@Test
	public void testSaveToBinary()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		try
		{
			op.saveToBinary( "testpile.dat" );
			assertTrue( true );
		}
		catch( IOException ioe )
		{
			assertTrue( ioe.getMessage(), false );
		}
		finally
		{
		}

	}

	// Check that the previously saved file can be read
	@Test
	public void testReadFromBinary()
	{
		try
		{
			OrePile op = OrePile.readFromBinary( "testpile.dat" );
			assertEquals( op.getOreType(), OreType.IRON );
			assertEquals( op.getWeight(), 30, 0 );
			assertEquals( op.getGrade(), 60, 0 );
		}
		catch( IOException ioe )
		{
			assertTrue( ioe.getMessage(), false );
		}
		try
		{
			OrePile op = OrePile.readFromBinary( "Mary had a little lamb, His fleece was white as snow, And everywhere that Mary went, The lamb was sure to go" );
			assertTrue( "false );
		}
		catch( IOException ioe )
		{
			assertTrue( ioe.getMessage(), true );
		}
	}
}
