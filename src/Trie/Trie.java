package Trie;

public class Trie<T> implements TrieInterface<T>
{
	private TrieNode<T> root;
	public Trie()
	{
		root=new TrieNode<T>();
	}

    @Override
    public boolean delete(String word) 
    {
    	if(search(word)==null)
    	{
    		//System.out.println("ERROR DELETING");
    		return false;
    	}
    	
    	delete(root,word,0);
    	//System.out.println("DELETED");
    	return true;
    }
    public boolean delete(TrieNode<T> root,String word,int index)
    {
    	char ch=word.charAt(index);
    	if(index == word.length()-1)
    	{
    		//System.out.println(ch);
    		root.getNode(ch).setEndWord(false);
			root.getNode(ch).setValue(null);
			
    		if(root.getNode(ch).filled()==0)
    			return true;
    		else
	    		return false;
       	}
    	boolean b=delete(root.getNode(ch),word,index+1);
    	//System.out.println(ch+" "+b);
    	if(b==true)
    	{
    		root.setNodeVoid(ch);
    		if(root.filled()==0 && root.getEndWord()==false)
    			return true;
    		return false;
    	}
    	else
    		return false;
    	
    }

    @Override
    public TrieNode<T> search(String word) 
    {
    	TrieNode<T> start=root;
    	int l=word.length();
		for(int i=0;i<l;i++)
		{
			char ch=word.charAt(i);
			
			if(start.getNode(ch)==null)
				return null;
			
			//System.out.println(ch);
			
			start=start.getNode(ch);
		}
		if(start.getEndWord())
			return start;
		return null;
    }

    @Override
    public TrieNode<T> startsWith(String prefix) 
    {
    	TrieNode<T> start=root;
    	int l=prefix.length();
		for(int i=0;i<l;i++)
		{
			char ch=prefix.charAt(i);
			
			if(start.getNode(ch)==null)
				return null;
			
			//System.out.println(ch);
			start=start.getNode(ch);
		}
		return start;
    }

    @Override
    public void printTrie(TrieNode trieNode) 
    {
    	if(trieNode==null)
    		return;
    	if(trieNode.getEndWord())
    		System.out.println(trieNode.getValue().toString());    	
    	for(int i=0;i<128;i++)
    	{
    		printTrie(trieNode.getNode((char)i));
    	}
    }
    
    @Override
	public boolean insert(String word, T value)
	{
    	TrieNode<T> start=root;
		int l=word.length();
		
		for(int i=0;i<l;i++)
		{
			char ch=word.charAt(i);
						
			if(start.getNode(ch)==null)
			{
				//System.out.println(ch);
				start.setNode(ch);
			}
			start=start.getNode(ch);
		}
		if(start.getEndWord())
			return false;
		start.setEndWord(true);
		start.setValue(value);
		//System.out.println("success");
		return true;
	}

    @Override
    public void printLevel(int level) 
    {
    	//TrieNode<T> temp=findFirstNode(level,root,1);
    	String ss=printLevel(level,1,root,"");
    	//lexographic
    	int l=ss.length();
    	String st="";
    	int dd[]=new int[128];
    	for(int i=0;i<l;i++)
    	{
    		if(ss.charAt(i)==' ')
    			continue;
    		dd[ss.charAt(i)]++;
    	}
    	for(int i=0;i<128;i++)
    		while(dd[i]-->0)
    			st=st+(char)i+",";
    	
    	System.out.println("Level "+level+": "+st.substring(0,st.length()-1));

    }
    
    public String printLevel(int level,int currentlevel,TrieNode<T> root,String st)
    {
    	if(currentlevel==level)
    	{
        	for(int i=0;i<128;i++)
        	{
        		//System.out.println("currentlevel");
        		if(root.getNode((char)i)!=null)
        		{
        			String ss=st+(char)i;
        			st=ss;
        			//System.out.println("currentlevel");
        		}
        	}
        	return st;
    	}
    	for(int i=0;i<128;i++)
    	{
    		TrieNode<T> temp=root.getNode((char)i);
    		if(temp==null)
    			continue;
    		st=printLevel(level,currentlevel+1,temp,st);
    	}
    	return st;
    }
    

    @Override
    public void print() 
    {
    	System.out.println("-------------\nPrinting Trie");
    	int level=1;
    	try
    	{
	    	while(true)
	    	{
	    		printLevel(level);
	    		level++;
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Level "+level+": ");
    	}
    	System.out.println("-------------");
    }
}