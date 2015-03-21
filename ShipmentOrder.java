import java.io.*;

// A class representing a customer's request for ore BY REFINABLE METAL
public class ShipmentOrder
{
	private int orderID;
	private static int nextOrderID;
	private OreType oreType;
	private float unitPrice;
	private String customerName;
	private String shippingDest;
	private float orderedMetalWt;
	private float shippedOreWt;
	private boolean isPending;

	// Create an order with the type, customer name, shipping address, amount and cost of ore. OrderID is generated from static nextOrderID.
	// Validate oreType, customerName, shippingDest, and orderedMetalWt to not be null/0
	public ShipmentOrder( OreType oreType, float unitPrice, String customerName, String shippingDest, float orderedMetalWt ) throws IllegalArgumentException
	{
		if( oreType == null )
		{
			throw new IllegalArgumentException( "No ore type" );
		}
		if( customerName.equals( "" ) )
		{
			throw new IllegalArgumentException( "No customer name" );
		}
		if( shippingDest.equals( "" ) )
		{
			throw new IllegalArgumentException( "No shipping destination" );
		}
		if( orderedMetalWt <= 0 )
		{
			throw new IllegalArgumentException( "No shippping destination" );
		}

		this.orderID = this.nextOrderID++;
		this.oreType = oreType;
		this.unitPrice = unitPrice;
		this.customerName = customerName;
		this.shippingDest = shippingDest;
		this.orderedMetalWt = orderedMetalWt;
		this.isPending = true;
	}

	// Constructor, create an order reading the contents from a file
	public ShipmentOrder( String sourceLocation ) throws IOException
	{
		DataInputStream dis = new DataInputStream( new FileInputStream( sourceLocation ) );

		oreType = OreType.lookupEnum( dis.readUTF() );
		unitPrice = dis.readFloat();
		customerName = dis.readUTF();
		shippingDest = dis.readUTF();
		orderedMetalWt = dis.readFloat();
		shippedOreWt = dis.readFloat();
		isPending = dis.readFloat() == 1;
		dis.close();
	}

	// Write the current class to a binary file
	public void saveToBinary( String writeLocation ) throws IOException
	{
		DataOutputStream dos = new DataOutputStream( new FileOutputStream( writeLocation ) );
		writeToFile( dos );
		dos.close();
	}

	// Throw the members at an already open fileWriter
	public void writeToFile( DataOutputStream dos ) throws IOException
	{
		dos.writeUTF( oreType.toString() ); // If I rewrite the enum to be closer to a traditional C enum where it's stored as a byte, then write helper functions to turn it into a usable string, can I treat it as a first class variable? Should do some tests
		dos.writeFloat( unitPrice );
		dos.writeUTF( customerName );
		dos.writeUTF( shippingDest );
		dos.writeFloat( orderedMetalWt );
		dos.writeFloat( shippedOreWt );
		dos.writeInt( isPending == true ? 1 : 0 ); // Really? Do I really have to do this? (converts a bool to an int)
	}

	// orderID boilerplate
	public int getOrderID()
	{
		return  orderID;
	}

	// oreType boilerplate
	public OreType getOreType()
	{
		return oreType;
	}

	public void setOreType( OreType oreType )
	{
		this.oreType = oreType;
	}

	// customerName boilerplate
	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName( String customerName )
	{
		this.customerName = customerName;
	}

	// shippingDest boilerplate
	public String getShippingDest()
	{
		return shippingDest;
	}

	public void setShippingDest( String shippingDest )
	{
		this.shippingDest = shippingDest;
	}

	// orderedMetalWt boilerplate
	public float getOrderedMetalWt()
	{
		return orderedMetalWt;
	}

	public void setOrderedMetalWt( float orderedMetalWt )
	{
		this.orderedMetalWt = orderedMetalWt;
	}

	// unitPrice boilerplate
	public float getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice( float unitPrice )
	{
		this.unitPrice = unitPrice;
	}

	// shippedOreWt boilerplate
	public float getShippedOreWt()
	{
		return shippedOreWt;
	}

	public void setShippedOreWt( float shippedOreWt )
	{
		this.shippedOreWt = shippedOreWt;
	}

	// isPending boilerplate
	public boolean getIsPending()
	{
		return isPending;
	}

	public void setIsPending( boolean isPending ) 
	{
		this.isPending = isPending;
	}

	// Product of value and metal weight representing cumulative value
	public float calcShipmentValue()
	{
		return getUnitPrice() * getOrderedMetalWt();
	}

	// Return the ratio of metal weight to ore weight representing the quality of the ore as a scalar from 0 to 100
	public float calcAverageGrade() throws Exception
	{
		if( isPending == true )
		{
			throw new Exception( "Tried to calculate average grade of an unshipped order" );
		}
		return getOrderedMetalWt() / getShippedOreWt() * 100;
	}

	// Check that unique ID is equivialent, impossible for two instances to share an order ID after all.
	// NOTE: Could really just do a straight forward == check if we're going to be so strict
	@Override
	public boolean equals( Object obj )
	{
		boolean equals = false;
		if( obj == null ) // Comparing object is null, not equal
		{
			equals = false;
		}
		else if( obj.getClass() != this.getClass() ) // Comparing object is not a ShipmentOrder, not equal
		{
			equals = false;
		}
		else
		{
			ShipmentOrder cmpShipmentOrder = (ShipmentOrder)obj;
			if( cmpShipmentOrder.getOrderID() == this.getOrderID() ) // Comparing object (which we have now confirmed to be a ShipmentOrder) has the same OrderID, equal
			{
				equals = true;
			}
			else // Otherwise it's not equal
			{
				equals = false;
			}
		}
		return equals;
	}
}
