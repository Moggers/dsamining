import org.junit.*;
import static org.junit.Assert.*;

public class ShipmentOrderTest
{
	@Test
	public void testShipmentOrderConstructor()
	{
		try
		{
			ShipmentOrder shipOrder1, shipOrder2;
			shipOrder1 = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			shipOrder2 = new ShipmentOrder( OreType.IRON, 50, "Timothy McDonald", "My heart ;_;", 600 );
			assertEquals( shipOrder1, shipOrder1 );
			assertNotEquals( shipOrder1, shipOrder2 );
		}
		catch( IllegalArgumentException iae )
		{
			assertTrue( false );
		}
		finally
		{
		}
	}

	@Test
	public void testCalcAverageGrade()
	{
		try
		{
			ShipmentOrder shipOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 100 );
			shipOrder.setShippedOreWt( 100 );
			assertEquals( shipOrder.calcAverageGrade(), 100, 0 );
			shipOrder.setShippedOreWt( 200 );
			assertEquals( shipOrder.calcAverageGrade(), 50, 0 );
			assertNotEquals( shipOrder.calcAverageGrade(), 1337, 0 );
		}
		catch( IllegalArgumentException iae )
		{
		}
		finally
		{
		}
	}

	@Test
	public void testCalcShipmentValue()
	{
		try
		{
			ShipmentOrder shipOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			assertEquals( shipOrder.calcShipmentValue(), 30000, 0 );
			assertNotEquals( shipOrder.calcShipmentValue(), 1337, 0 );
		}
		catch( IllegalArgumentException iae )
		{
		}
		finally
		{
		}
	}
}
