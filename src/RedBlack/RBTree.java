package RedBlack;


public class RBTree<T extends Comparable, E> implements RBTreeInterface<T, E>  
{
	RedBlackNode<T,E> root;
	
	public RBTree()
	{
		root=null;
	}
	
    @Override
    public void insert(T key, E value) 
    {
    	//traverse(root);
    	
    	RedBlackNode<T,E> temp=root;
    	if(temp==null)
    	{
    		root=new RedBlackNode<T,E>(key,value);
    		return;
    	}
    	while(temp!=null)
    	{
    		int comp=temp.getKey().compareTo(key);
    		
    		if(comp==0)
    		{
    			temp.add(value);
    			//temp.incrementlength();
    			return;
    		}
    		else if(comp>0)
    		{
    			if(temp.left==null)
    			{
    				temp.left=new RedBlackNode<T,E>(key,value);
    				temp.left.parent=temp;
    				temp=temp.left;
    				temp.setColour(1);
    				
    				break;
    			}
    			temp=temp.left;
    		}
    		else
    		{
    			if(temp.right==null)
    			{
    				temp.right=new RedBlackNode<T,E>(key,value);
    				temp.right.parent=temp;
    				temp=temp.right;
    				temp.setColour(1);
    				
    				break;
    			}
    			temp=temp.right;
    		}
    	}
    	////make it balanced
		outer:
    	while(temp.parent!=null && temp.parent.getColour()!=0)
    	{
    		RedBlackNode<T,E> uncle=getUncle(temp);
    		int x=0;
    		if(uncle!=null)
    			x=uncle.getColour();
    		if(x==0)
    		{
    			RedBlackNode<T,E> pp=temp.parent;
				RedBlackNode<T,E> gp=pp.parent;
    			switch(check(temp))
    			{
    				case(1):

		    			//left left
    					pp.setColour(0);
    					gp.setColour(1);
    					
    					rotateRight(pp);
    					temp=pp;
		    			break outer;

    				case(2):

		    			//left right
    					rotateLeft(temp);
    					temp=pp;
//    					pp=temp;
//    					rotateRight(pp);
//    					temp=pp;
//    					temp.setColour(0);
//    					temp.right.setColour(1);
		    			break;

    				case(3):

		    			//right right
						pp.setColour(0);
						gp.setColour(1);
						
						rotateLeft(pp);
						temp=pp;
		    			break outer;

    				case(4):

		    			//right left
    					rotateRight(temp);
    					temp=pp;
//						pp=temp;
//						rotateLeft(pp);
//						temp=pp;
//						temp.setColour(0);
//						temp.left.setColour(1);
    					break;
    			}
    			//break;
    		}
    		else
    		{
    			temp.parent.setColour(0);
    			uncle.setColour(0);
    			temp=temp.parent.parent;
    			temp.setColour(1);
    		}
    	}
    	if(temp.parent==null)
    		root=temp;
    	root.setColour(0);

//    	traverse();
//		System.out.println();
//		traversein();
    	    	
    }
    public int check(RedBlackNode<T,E> node)
    {
    	RedBlackNode<T,E> gp=node.parent.parent;
    	
    	if(gp.left!=null && gp.left.left==node)
    		return 1;
    	if(gp.left!=null && gp.left.right==node)
    		return 2;
    	if(gp.right!=null && gp.right.right==node)
    		return 3;
		if(gp.right!=null && gp.right.left==node)
			return 4;
		return 0;
    }
    public void rotateRight(RedBlackNode<T,E> node)
    {
    	RedBlackNode<T,E> p=node.parent;
    	RedBlackNode<T,E> temp=p.parent;
		RedBlackNode<T,E> tt=node.right;
    	
    	int left=0;
    	if(temp!=null)
	    	if(p==temp.left)
	    		left=1;
    	
    	p.left=node.right;
    	node.right=p;
    	p.parent=node;
    	if(tt!=null)
			tt.parent=p;
    	
    	node.parent=temp;
    	
    	if(temp!=null)
    	{
	    	if(left==1)
	    		temp.left=node;
	    	else
	    		temp.right=node;
    	}
    }
    public void rotateLeft(RedBlackNode<T,E> node)
    {
    	RedBlackNode<T,E> p=node.parent;
    	RedBlackNode<T,E> temp=p.parent;
    	RedBlackNode<T,E> tt=node.left;
    	
    	int left=0;
    	if(temp!=null)
	    	if(p==temp.left)
	    		left=1;
    	
    	p.right=node.left;
    	node.left=p;
    	p.parent=node;
		if(tt!=null)
			tt.parent=p;
    	
    	node.parent=temp;
    	
	    if(temp!=null)
	    {
	    	if(left==1)
	    		temp.left=node;
	    	else
	    		temp.right=node;
	    }
    	
    }
    public RedBlackNode<T,E> getUncle(RedBlackNode<T,E> node)
    {
    	RedBlackNode<T,E> mother=node.parent;
    	if(mother.parent.left==mother)
    		return mother.parent.right;
    	return mother.parent.left;
    }
    
    
    @Override
    public RedBlackNode<T, E> search(T key) 
    {
    	//traverse(root);
    	
    	RedBlackNode<T,E> temp=root;
    	while(temp!=null)
    	{
    		int comp=temp.getKey().compareTo(key);
    		if(comp==0)
    			return temp;
    		else if(comp>0)
    			temp=temp.left;
    		else
    			temp=temp.right;
    	}
        return new RedBlackNode<T,E>(null,null);
    }
    
    public void traverse(RedBlackNode<T, E> node)
    {
    	if(node==null)
    		return;
		System.out.println(node.getValue().toString()+" "+node.getColour());
    	traverse(node.left);
		//System.out.println(node.getValue().toString()+" "+node.getColour());
    	traverse(node.right);
    }
	public void traversein(RedBlackNode<T, E> node)
	{
		if(node==null)
			return;
		//System.out.println(node.getValue().toString()+" "+node.getColour());
		traversein(node.left);
		System.out.println(node.getValue().toString()+" "+node.getColour());
		traversein(node.right);
	}
    public void traverse()
    {
    	traverse(root);
    }
	public void traversein()
	{
		traversein(root);
	}
}