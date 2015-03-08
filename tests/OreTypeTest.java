import org.junit.*;
import static org.junit.Assert.*;

public class OreTypeTest
{
	@Test
	public void testOreTypeLookup()
	{
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

		assertEquals( OreType.lookupEnum( "iron" ), OreType.IRON );
		assertNotEquals( OreType.lookupEnum( "iron" ), OreType.NICKEL );

	}

	@Test public void testToString()
	{
		assertEquals( OreType.IRON.toString(), OreType.IRON.toString() );
		assertNotEquals( OreType.IRON.toString(), OreType.NICKEL.toString() );
	}
}
