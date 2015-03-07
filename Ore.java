// Ore class contains type as an enum of IRON and NICKEL, and a measurement stored in the float units.

public class Ore extends Object
{
	public enum OreType
	{
		IRON, NICKEL
	}

	private OreType oreType;
	private float units; 

	public Ore( OreType type, float units )
	{
		this.setOreType( type );
		this.setUnits( units );
	}

	public Ore( Ore ore )
	{
		this.setOreType( ore.oreType );
		this.setUnits( ore.units );
	}

	public float getUnits()
	{
		return this.units;
	}

	public OreType getOreType()
	{
		return this.oreType;
	}

	public void setUnits( float units )
	{
		this.units = units;
	}

	// System spec defines this as impossible use case. But we need it for the constructor. Better to make it private than not implement it.
	private void setOreType( OreType oreType )
	{
		this.oreType = oreType;
	}

	// Check if obj is instantiated, check if it is an Ore, check if it has equivalent units and oreType.
	// NOTE: This seems like an argument for multiple returns, as each condition defines a separate, terminating branch.
	@Override
	public boolean equals( Object obj )
	{
		boolean equal;
		if( obj == null )
		{
			equal = false;
		}
		else if( obj.getClass() != this.getClass() )
		{
			equal = false;
		}
		else
		{
			Ore compOre = (Ore)obj;
			if( this.oreType == compOre.oreType && this.units == compOre.units )
			{
				equal = true;
			}
			else
			{
				equal = false;
			}
		}
		return equal;
	}
}
