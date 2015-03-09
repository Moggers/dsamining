// Unit tests for the OrePile class

import org.junit.*;
import static org.junit.Assert.*;

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
		opCopy.setOreType( OreType.NICKEL );
		assertNotEquals( op, opCopy ); // Copy is not the same as original now that the OreType has been changed
	}

	// Check that we're correctly computing the metal weight from the ore weight and the grade
	@Test
	public void testCalcMetalWeight()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op.calcMetalWeight(), 30 * 0.6, 0 ); // Weight of 30, grade of 60%
	}
}
