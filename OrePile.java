// Ore ore - type of ore; weight - how much there is; grade - real number from 0-100 representing its quality
public class OrePile extends Object
{
	private OreType oreType;
	private float weight;
	private float grade;

	// Create an OrePile with an OreType, weight, and grade.
	// NOTE: Not sure if this OreType is being copied ByVal or ByRef, do assignment operators on enums work as objects or first class vars?
	public OrePile( OreType oreType, float wt, float grade )
	{
		this.setOreType( oreType );
		this.setWeight( wt );
		this.setGrade( grade );
	}

	// Copy constructor
	// NOTE: See above, if you use a copy constructor and then change the OreType (though hypothetically, an OrePile should never change) will the change be reflceted in the original?
	public OrePile( OrePile orePile )
	{
		setWeight( orePile.getWeight() );
		setOreType( orePile.oreType );
		setGrade( orePile.getGrade() );
	}

	// OreType boilerplate
	public OreType getOreType()
	{
		return oreType;
	}
	private void setOreType( OreType oreType )
	{
		this.oreType = oreType;
	}

	// weight boilerplate
	public float getWeight()
	{
		return weight;
	}
	public void setWeight( float weight )
	{
		this.weight = weight;
	}

	// grade boilerplate
	public float getGrade()
	{
		return grade;
	}
	public void setGrade( float grade )
	{
		this.grade = grade;
	}

	// Find weight of refinable metal in the ore
	public float calcMetalWeight()
	{
		return getWeight() * ( getGrade() / 100 );
	}

	// If obj is null, return false, if obj is not an OrePile, return false, if obj is an OrePile, has the same oreType, has the same weight, and has the same grade, return true. Else return false
	// NOTE: This is horribly wrong, if you place two OrePiles in a shed on top of eachother with the same weight, type, and grade, they're going to be the same instance according to this check. I should reconsider the definition of equals()
	@Override
	public boolean equals( Object obj )
	{
		boolean equal;
		if( obj == null ) // Is it null? Then it's not equal
		{
			equal = false;
		}
		else if( getClass() != obj.getClass() ) // Is it not an OrePile? Then not equals
		{
			equal = false;
		}
		else
		{
			OrePile cmpOrePile = (OrePile)obj;
			if( cmpOrePile.getOreType().equals( getOreType() ) && cmpOrePile.getWeight() == getWeight() && cmpOrePile.getGrade() == getGrade() ) // Are the member variables equivalent? Then it is equal
			{
				equal = true;
			}
			else // If they're not, then it is not equal
			{
				equal = false;
			}
		}
		return equal;
	}
}
