// Ore ore - type of ore; weight - how much there is; grade - real number from 0-100 representing its quality
public class OrePile extends Object
{
	private Ore ore;
	private float weight;
	private float grade;

	public OrePile( Ore ore, float wt, float grade )
	{
		this.setOre( new Ore( ore ) );
		this.setWeight( wt );
		this.setGrade( grade );
	}

	public OrePile( OrePile orePile )
	{
		setWeight( orePile.getWeight() );
		setOre( new( orePile.getOre() ) );
		setGrade( orePile.getGrade() );
	}

	public Ore getOre()
	{
		return ore;
	}

	public float getWeight()
	{
		return weight;
	}

	public float getGrade()
	{
		return grade;
	}

	public void setOre( Ore ore )
	{
		this.ore = new Ore( ore );
	}

	public void setWeight( float weight )
	{
		this.weight = weight;
	}

	public void setGrade( float grade )
	{
		this.grade = grade;
	}

	// Find weight of refinable metal
	public float calcMetalWeight()
	{
		return getWeight() * ( getGrade() / 100 );
	}

	// Test obj is not null, test obj is an OrePile, test obj has same data within variables
	@Override
	public boolean equals( Object obj )
	{
		boolean equal;
		if( obj == null )
		{
			equal = false;
		}
		else if( getClass() != obj.getClass() )
		{
			equal = false;
		}
		else
		{
			OrePile cmpOrePile = (OrePile)obj;
			if( cmpOrePile.getOre() == getOre() && cmpOrePile.getWeight() == getWeight() && cmpOrePile.getGrade() == getGrade() )
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
