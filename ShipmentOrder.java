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

	// Product of value and metal weight representing cumulative value
	public float calcShipmentValue()
	{
		return getUnitPrice() * getOrderedMetalWt();
	}

	// Return the ratio of metal weight to ore weight representing the quality of the ore as a scalar from 0 to 100
	public float calcAverageGrade()
	{
		return getOrderedMetalWt() / getShippedOreWt() * 100;
	}

	// Equals( Object obj ) override, unlike every other case, simply having the same field does not make it equivalent, it MUST have the same identifier (ie a ShipmentOrder can only return true from an equals() called on itself, with itself as a parameter
	@Override
	public boolean equals( Object obj )
	{
		boolean equals = false;
		if( obj == null )
		{
			equals = false;
		}
		else if( obj.getClass() != this.getClass() )
		{
			equals = false;
		}
		else
		{
			ShipmentOrder cmpShipmentOrder = (ShipmentOrder)obj;
			if( cmpShipmentOrder.getOrderID() == this.getOrderID() )
			{
				equals = true;
			}
			else
			{
				equals = false;
			}
		}
		return equals;
	}
}
