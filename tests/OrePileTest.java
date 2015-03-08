
import org.junit.*;
import static org.junit.Assert.*;

public class OrePileTest
{
	@Test
	public void testEquals()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op, op );
		OrePile opCopy = new OrePile( op );
		opCopy.setWeight( 100 );
		assertNotEquals( op, opCopy );
	}

	@Test
	public void testConstructor()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op.getOreType(), OreType.IRON );
		assertEquals( op.getWeight(), 30, 0 );
		assertEquals( op.getGrade(), 60, 0 );
	}

	@Test
	public void testCopyConstructor()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		OrePile opCopy = new OrePile( op );
		assertEquals( op, opCopy );
		opCopy.setOreType( OreType.NICKEL );
		assertNotEquals( op, opCopy );
	}

	@Test
	public void testCalcMetalWeight()
	{
		OrePile op = new OrePile( OreType.IRON, 30, 60 );
		assertEquals( op.calcMetalWeight(), 30 * 0.6 , 0 );
	}
}
