// Unit tests for the ShipmentOrder class

import org.junit.*;
import static org.junit.Assert.*;

public class ShipmentOrderTest
{
	// Check that ShipmentOrder's constructor is properly building instances
	// NOTE: Have to add some validation validation (unit test the validation, that is)
	@Test
	public void testShipmentOrderConstructor()
	{
		try
		{
			ShipmentOrder shipOrder1, shipOrder2;
			shipOrder1 = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			shipOrder2 = new ShipmentOrder( OreType.IRON, 50, "Timothy McDonald", "My heart ;_;", 600 );
			assertEquals( shipOrder1, shipOrder1 ); // First shipment and first shipment share ID obviously
			assertNotEquals( shipOrder1, shipOrder2 ); // First shipment and second shipment were never meant to be
		}
		catch( IllegalArgumentException iae )
		{
			assertTrue( false ); // Something went horribly wrong
		}
		finally
		{
		}
	}

	// Test that we're correctly retrieving the average grade of the shipped metal.
	// NOTE: Have to add some checks for retrieving the grade of an unshipped order
	@Test
	public void testCalcAverageGrade()
	{
		try
		{
			ShipmentOrder shipOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 100 );
			shipOrder.setShippedOreWt( 100 );
			assertEquals( shipOrder.calcAverageGrade(), 100, 0 ); // Customer requests 100, we ship 100, that implies 100% quality
			shipOrder.setShippedOreWt( 200 );
			assertEquals( shipOrder.calcAverageGrade(), 50, 0 ); // Customer requests 100, we ship 200, that implies 50% quality
		}
		catch( IllegalArgumentException iae )
		{
		}
		finally
		{
		}
	}

	//Retrieve the value of the shipment
	@Test
	public void testCalcShipmentValue()
	{
		try
		{
			ShipmentOrder shipOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			assertEquals( shipOrder.calcShipmentValue(), 30000, 0 ); // With a value per unit of 50 and 600 units, we have $30'000 dollary doos
		}
		catch( IllegalArgumentException iae ) // There's no assert here because the exception thrown by ShipmentOrder( ... ) Has a test further up
		{
		}
		finally
		{
		}
	}
}
