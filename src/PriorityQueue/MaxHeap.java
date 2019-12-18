package PriorityQueue;

import java.util.List;
import java.util.ArrayList;

public class MaxHeap<T extends Comparable> implements PriorityQueueInterface<T> 
{
	private List<T> list;
	private List<Integer> priority2;
	private int length;
	private int inserts;
	
	public MaxHeap()
	{
		list=new ArrayList<T>();
		priority2=new ArrayList<Integer>();
		inserts=0;
		length=0;
	}

	public List<T> list()
	{
		return list;
	}
	
    /*
    public void setParent(int index,T element)
    {
    	list.set((index-1)/2,element);
    }
    public void setLeftChild(int index,T element)
    {
    	list.set(2*index+1,element);
    }
    public void rightChild(int index,T element)
    {
    	list.set(2*index+1+1,element);
    }
    */
    
    public T parent(int index)
    {
    	if(index<1)
    		return null;
    	return list.get((index-1)/2);
    }
    public T leftChild(int index)
    {
    	if(2*index+1>length-1)
    		return null;
    	return list.get(2*index+1);
    }
    public T rightChild(int index)
    {
    	if(2*index+1+1>length-1)
    		return null;
    	return list.get(2*index+1+1);
    }
    
    @Override
    public void insert(T element) 
    {
    	list.add(element);
    	inserts++;
    	priority2.add(new Integer(inserts));
    	length++;
    	
    	int index=length-1;
    	while(index>0 && list.get(index).compareTo(parent(index)) > 0)
    	{
    		int p=(index-1)/2;
    		swap(index,p);
    		swap2(index,p);
    		
    		index=p;
    	}
		//System.out.println(list);
    }

    @Override
    public T extractMax() 
    {
    	if(length<1)
    		return null;
    	
    	T element=list.get(0);
    	//Integer element2=priority2.get(0);
    	
    	list.set(0,list.get(length-1));
    	priority2.set(0,priority2.get(length-1));
    	
    	//best case O(1)
    	list.remove(length-1);
    	priority2.remove(length-1);
    	length--;
    	
    	int index=0;
    	while(true)
    	{
    		if(leftChild(index)==null)
    			break;
    		int l=2*index+1,r=2*index+1+1;
    		int x=list.get(index).compareTo(leftChild(index));
    		if(rightChild(index)==null)
    		{
    			if(x<0)
    			{
    				swap(index,l);
    				swap2(index,l);
    			}
    			if(x==0)
    				if(priority2.get(index)>priority2.get(2*index+1))
    				{
    					swap(index,l);
        				swap2(index,l);
    				}
    					
    			break;
    		}
    		int y=list.get(index).compareTo(rightChild(index));
    		int z=leftChild(index).compareTo(rightChild(index));

			int a=priority2.get(index);
			int b=priority2.get(2*index+1);
			int c=priority2.get(2*index+1+1);

			if(z<0)
			{
				if(y<0)
				{
					swap(index,r);
					swap2(index,r);
					index=r;
				}
				else if(y==0)
				{
					if(a<c) break;
					swap(index,r);
					swap2(index,r);
					index=r;
				}
				else
					break;
			}
			else if(z>0)
			{
				if(x<0)
				{
					swap(index,l);
					swap2(index,l);
					index=l;
				}
				else if(x==0)
				{
					if(a<b) break;
					swap(index,l);
					swap2(index,l);
					index=l;
				}
				else
					break;
			}
			else
			{
				if(x>0)
					break;
				if(x==0)
				{
					if(a<b && a<c) break;
					if(b<c)
					{
						swap(index,l);
						swap2(index,l);
						index=l;
					}
					else if(c<b)
					{
						swap(index,r);
						swap2(index,r);
						index=r;
					}
				}
				else
				{
					if(b<c)
					{
						swap(index,l);
						swap2(index,l);
						index=l;
					}
					else if(c<b)
					{
						swap(index,r);
						swap2(index,r);
						index=r;
					}
				}
			}

    		/*
    		if(x<0 || y<0)
    		{	
    			if(z>0)
    			{
    				swap(index,l);
    				swap2(index,l);
    				index=l;
    			}
    			else if(z<0)
    			{
    				swap(index,r);
    				swap2(index,r);
    				index=r;
    			}
    			else 
    			{
    				if(priority2.get(2*index+1)<priority2.get(2*index+1+1))
    				{
    					swap(index,l);
        				swap2(index,l);
        				index=l;
    				}
    				else
    				{
    					swap(index,r);
        				swap2(index,r);
        				index=r;
    				}
    			}
    		}
    		else if(x==0 || y==0)
    		{
    			if(x==0 && y==0)
    			{
    				int a=priority2.get(index);
    				int b=priority2.get(2*index+1);
    				int c=priority2.get(2*index+1+1);
    				
    				if(a<b && a<c) break;
    				if(b<c)
    				{
    					swap(index,l);
        				swap2(index,l);
        				index=l;
    				}
    				else if(c<b)
    				{
    					swap(index,r);
        				swap2(index,r);
        				index=r;
    				}
    			}
    			else if(x==0)
    			{
    				swap(index,r);
    				swap2(index,r);
    				index=r;
    			}
    			else if(y==0)
    			{
    				swap(index,l);
    				swap2(index,l);
    				index=l;
    			}
    		}
    		else
    			break;*/
    	}
    	//System.out.println(list);
    	return element;
    	
    }
    public int min(int a ,int b,int c)
	{
		int mm=a;
		if(b<a)
			mm=b;
		if(c<b)
			mm=c;
		return mm;
	}
    public void swap(int a,int b)
    {
    	T temp=list.get(a);
    	list.set(a,list.get(b));
    	list.set(b,temp);
    }
    public void swap2(int a,int b)
    {
    	Integer temp=priority2.get(a);
    	priority2.set(a,priority2.get(b));
    	priority2.set(b,temp);
    }
    public int length()
    {
    	return length;
    }

}