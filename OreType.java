import java.io.*;
// Enumaerator representing types of ore
public enum OreType implements Serializable
{
	IRON("iron"), NICKEL("nickel");

	String type;

	OreType( String type )
	{
		this.type = type;
	}
	
	// Return type as a string for interfaces.
	@Override
	public String toString()
	{
		return type;
	}

	// Search the enum list by a string.
	public static OreType lookupEnum( String type ) throws IllegalArgumentException
	{
		for( OreType loopType : values() )
		{
			if( type.equalsIgnoreCase( loopType.type ) )
			{
				return loopType;
			}
		}

		// Throw an exception if the loop ends without finding the requested enum.
		throw new IllegalArgumentException( "Input type does not correspond to an ore type" ); 
	}
}
