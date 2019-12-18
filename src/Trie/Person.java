package Trie;

public class Person {

	private String name;
	private String phone_number;
	
    public Person(String name, String phone_number) 
    {
    	this.name=name;
    	this.phone_number=phone_number;
    }

    public String getName() 
    {
        return name;
    }
    
    public String getNumber() 
    {
        return phone_number;
    }
    public String toString()
    {
    	String ss="[Name: "+name+", Phone="+phone_number+"]";
    	return ss;
    }
}
