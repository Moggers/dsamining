import org.junit.*;
import static org.junit.Assert.*;

public class OreTest
{
	@Test
	public void testConstructor()
	{
		Ore ore = new Ore( Ore.OreType.IRON, "kg" );
		assertEquals( ore.getUnits(), "kg", "kg" );
		assertEquals( ore.getOreType(), Ore.OreType.IRON );
	}

	@Test
	public void testCopyConstructor()
	{
		Ore oreOrig = new Ore( Ore.OreType.IRON, "kg" );
		Ore oreCopy = new Ore( oreOrig );
		assertEquals( oreOrig, oreCopy );
	}

	@Test 
	public void testEquals()
	{
		Ore oreOrig = new Ore( Ore.OreType.IRON, "kg" );
		assertEquals( oreOrig, oreOrig );
		Ore oreCopy = new Ore( oreOrig );
		oreCopy.setUnits( "ton" );
		assertNotEquals( oreOrig, oreCopy );
	}
}
