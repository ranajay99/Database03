package PriorityQueue;

public class Student implements Comparable<Student> {
    private String name;
    private Integer marks;

    public Student(String trim, int parseInt) 
    {
    	name=trim;
    	marks=(Integer)parseInt;
    }


    @Override
    public int compareTo(Student student) 
    {
    	int k = this.getMarks() - student.getMarks();
        return k;
    }

    public String getName() 
    {
        return name;
    }
    public int getMarks()
    {
    	return (int)marks;
    }
    public String toString()
    {
    	String ss="Student{name='"+name+"', marks="+marks+"}" ;
    	return ss;
    }
}
