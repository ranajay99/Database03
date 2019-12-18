package RedBlack;

import Util.RBNodeInterface;

import java.util.List;
import java.util.ArrayList;

public class RedBlackNode<T extends Comparable, E> implements RBNodeInterface<E> 
{
	RedBlackNode<T,E> left;
	RedBlackNode<T,E> right;
	RedBlackNode<T,E> parent;
	
	private T key;
	private List<E> items=new ArrayList<E>();
	//private int length=0;
	private int colour;
	
	RedBlackNode(T key,E data)
	{
		left=null;
		right=null;
		parent=null;
		
		this.key=key;
		items.add(data);
		
		colour=0;
	}
	
	public int getColour()
	{
		return colour;
	}
	public void setColour(int cc)
	{
		colour=cc;
	}
	public void add(E data)
	{
		items.add(data);
	}
	
	public T getKey()
	{
		return key;
	}

    @Override
    public E getValue() 
    {
        return items.get(0);
    }

    @Override
    public List<E> getValues() 
    {
    	if(items.size()==0 || items.get(0)==null)
    		return null;
    	return items;
    }
}
