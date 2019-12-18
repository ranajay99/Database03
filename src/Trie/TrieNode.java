package Trie;


import Util.NodeInterface;


public class TrieNode<T> implements NodeInterface<T> 
{
	//private String allchars="ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
	
	private TrieNode<T> allnodes[]=new TrieNode[128];
	private T data;
	private boolean endofword;
	
	TrieNode()
	{
		endofword=false;
		data=null;
		
		for(int i=0;i<128;i++)
		{
			allnodes[i]=null;
		}
	}
	public void setValue(T value)
	{
		data=value;
	}
	public void setEndWord(boolean b)
    {
    	endofword=b;
    }
	public TrieNode<T> getNode(char ch)
	{
		return allnodes[ch];
	}
	public void setNode(char ch)
	{
		allnodes[ch]=new TrieNode<T>();
	}
	public void setNodeVoid(char ch)
	{
		allnodes[ch]=null;
	}
	public int filled()
	{
		int s=0;
		for(int i=0;i<128;i++)
			if(allnodes[i]!=null) s++;
		return s;
	}
	
    @Override
    public T getValue() 
    {
        return data;
    }
    public boolean getEndWord()
    {
    	return endofword;
    }
}