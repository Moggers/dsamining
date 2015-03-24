// First in first out stack
// Matthew Kramara
// 24th of March 2015

import java.io.*;
public class DSAStack
{
	private Object[] data; // Contents of the stack
	private final static int MAX_COUNT = 512; // Maximum size of stack
	private int count; // Current index
	private int size;

	// Standard constructor, takes a size clamped to MAX_COUNT, throws IAE if requested size exceeds bounds
	public DSAStack( int size ) throws IllegalArgumentException
	{
		if( size > MAX_COUNT )
		{
			throw new IllegalArgumentException( "Attempted to create an array larger than the compiletime limit" );
		}

		data = new Object[size];
		count = 0;
		this.size = size;
	}

	// Insert element to the top of the stack, throws OOBE when filled
	// NOTE: Should this check for null? Ie. should we allow null entries?
	public void push( Object obj ) throws IndexOutOfBoundsException
	{
		if( count == size )
		{
			throw new IndexOutOfBoundsException( "Array size reached" );
		}
		data[count++] = obj; // Post increment
	}
	
	// Remove element from the top of the stack
	public Object pop() throws IndexOutOfBoundsException
	{
		if( count == 0 )
		{
			throw new IndexOutOfBoundsException( "Tried to pop off of an empty stack" );
		}

		return data[--count]; // Predecrement return, will definitely have to unit test this because it sounds wanky as hell
	}

	// Check the top element without removing it from the stack
	public Object peek()
	{
		return data[count];
	}

	// Retrieve current count
	public int getCount()
	{
		return count;
	}

	// Retrieve size of array
	public int getSize()
	{
		return size;
	}

	// Helper function, checks whether stack is full
	public boolean getIsFull()
	{
		return ( getSize() == getCount() ) ? true: false; // Filthy ternary operator because we hate having extra lines
	}

	// Helper function, checks whether stack is empty
	public boolean getIsEmpty()
	{
		return ( getSize() == 0 ) ? true: false;
	}
}
