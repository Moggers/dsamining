// Unit tests for the OreType class

import org.junit.*;
import static org.junit.Assert.*;

public class OreTypeTest
{
	// What it says on the tin
	@Test
	public void testOreTypeLookup()
	{ 
		// Check that bogus string "pants" will throw an exception
		try
		{
			OreType.lookupEnum( "pants" );
			assertTrue( false );
		}
		catch( IllegalArgumentException e )
		{
			assert( true );
		}
		finally
		{
		}

		// Check that a lookup for iron will be equal to a direct retrieval of iron
		assertEquals( OreType.lookupEnum( "iron" ), OreType.IRON );
		// Check that a lookup for iron will NOT be equal to a direct retrieval of nickel
		assertNotEquals( OreType.lookupEnum( "iron" ), OreType.NICKEL );

	}

	// Opposite of above, check that retrieving the string associated with the enum works
	@Test public void testToString()
	{
		// Check it against a constant
		assertEquals( OreType.IRON.toString(), "iron" );
		// Check it against itself (kind of redundant if not for the next test)
		assertEquals( OreType.IRON.toString(), OreType.IRON.toString() );
		// Check that iron and nickel wont return the same string
		assertNotEquals( OreType.IRON.toString(), OreType.NICKEL.toString() );
	}
}
