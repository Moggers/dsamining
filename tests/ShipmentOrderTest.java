// Unit tests for the ShipmentOrder class

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class ShipmentOrderTest
{
	// Check that ShipmentOrder's constructor is properly building instances
	// NOTE: Most of this should be move out to an equals() test case
	@Test
	public void testShipmentOrderConstructor()
	{
		ShipmentOrder soTestConstructor, soTestValidation;
		try
		{
			soTestConstructor = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			assertTrue( true );
		}
		catch( IllegalArgumentException iae )
		{
			assertTrue( false ); // Something went horribly wrong
		}
		finally
		{
		}

		try
		{
			soTestValidation = new ShipmentOrder( null, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			assertTrue( false );
		}
		catch( IllegalArgumentException iae )
		{
			assertTrue( true ); // Was considering checking that we're throwing the correct exception but they all throw IAEs and I don't want to check the message in case it's changed.
		}
		finally
		{
		}
	}

	@Test
	public void testWrite()
	{
		try
		{
			ShipmentOrder writeTestOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			writeTestOrder.saveToBinary( "testfile.dat" );
			assertTrue( true );
		}
		catch( IllegalArgumentException iae )
		{
		}
		catch( IOException iae )
		{
			assertTrue( false );
		}
		finally
		{
		}
	}

	@Test
	public void testRead()
	{
		try
		{
			ShipmentOrder readTestOrder = new ShipmentOrder( "testfile.dat" );
			assertTrue( true );
			assertEquals( readTestOrder.getOreType(), OreType.IRON );
			assertEquals( readTestOrder.getUnitPrice(), 50, 0 );
			assertEquals( readTestOrder.getCustomerName(), "Matthew Kramara" );
			assertEquals( readTestOrder.getShippingDest(), "53 Poincaire st" );
		}
		catch( IOException ioe )
		{
			assertTrue( false );
		}
		finally
		{
		}
		try
		{
			ShipmentOrder readTestOrder = new ShipmentOrder( "humpty dumpty sat on a wall humpty dumpty had a great fall all the kings horses and all thek ings men couldn't put humpty together again" );
			assertTrue( false );
		}
		catch( IOException ioe )
		{
			assertTrue( true );
		}
		finally
		{
		}
	}

	@Test
	public void testEquals()
	{
		try
		{
			ShipmentOrder shipOrder1, shipOrder2;
			shipOrder1 = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 600 );
			shipOrder2 = new ShipmentOrder( OreType.IRON, 50, "Tomothy McDonald", "53 Poincaire st", 600 );

			assertEquals( shipOrder1, shipOrder1 );
			assertNotEquals( shipOrder1, shipOrder2 );
			shipOrder1.setCustomerName( "Matthew Kramara" );
			assertNotEquals( shipOrder1, shipOrder2 );

		}
		catch( IllegalArgumentException iae )
		{
		}
		finally
		{
		}
	}

	// Test that we're correctly retrieving the average grade of the shipped metal.
	@Test
	public void testCalcAverageGrade()
	{
		try
		{
			ShipmentOrder shipOrder = new ShipmentOrder( OreType.IRON, 50, "Matthew Kramara", "53 Poincaire st", 100 );
			shipOrder.setIsPending( false );
			shipOrder.setShippedOreWt( 100 );
			assertEquals( shipOrder.calcAverageGrade(), 100, 0 ); // Customer requests 100, we ship 100, that implies 100% quality
			shipOrder.setShippedOreWt( 200 );
			assertEquals( shipOrder.calcAverageGrade(), 50, 0 ); // Customer requests 100, we ship 200, that implies 50% quality
			shipOrder.setIsPending( true );
			shipOrder.calcAverageGrade();
			assertTrue( false ); // Should have thrown an exception one line up
		}
		catch( IllegalArgumentException iae )
		{
		}
		catch( Exception e )
		{
			assertTrue( true ); // Threw an exception when we calc'd grade of a reportedly unshipped shipment 
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
		catch( IllegalArgumentException iae )
		{
		}
		finally
		{
		}
	}
}
