package ProjectManagement;


public class Project implements Comparable<Project>
{
	private String name;
	private int priority;
	private int budget;
	
	Project(String name,int p,int b)
	{
		this.name=name;
		priority=p;
		budget=b;
	}
	public int getPriority()
	{
		return priority;
	}
	public int getBudget()
	{
		return budget;
	}
	public String projectName()
	{
		return name;
	}
	public void setBudget(int a)
	{
		budget=a;
	}
	
	public int compareTo(Project p)
	{
		return this.priority-p.getPriority();
	}

}
