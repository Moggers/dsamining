import org.junit.*;
import static org.junit.Assert.*;

public class OreTest
{
	@Test
	public void testConstructor()
	{
		Ore ore = new Ore( Ore.OreType.IRON, 10 );
		assertEquals( ore.getUnits(), 10, 0 );
		assertEquals( ore.getOreType(), Ore.OreType.IRON );
	}

	@Test
	public void testCopyConstructor()
	{
		Ore oreOrig = new Ore( Ore.OreType.IRON, 10 );
		Ore oreCopy = new Ore( oreOrig );
		assertEquals( oreOrig, oreCopy );
	}
}
