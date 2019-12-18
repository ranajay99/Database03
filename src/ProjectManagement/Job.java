package ProjectManagement;

public class Job implements Comparable<Job>,JobReport_{
	private String name;
	private String projectname;
	private String username;

	private Project project;
	private User user;
	
	private String jobstatus;
	
	private int runtime;
	private int createtime;
	private int arrivaltime;
	private int endtime;

	private int priority;
	
	Job(String name,String project,String user,String run)
	{
		this.name=name;
		this.username=user;
		this.projectname=project;
		jobstatus="REQUESTED";
		endtime=0;
		arrivaltime=0;
		priority=0;
		createtime++;
		
		runtime=Integer.parseInt(run);
		project=null;
		user=null;
	}
	
	public String jobName()
	{
		return name;
	}
	public String projectName()
	{
		return projectname;
	}
	public String userName()
	{
		return username;
	}
	public void setCreatetime(int a) { createtime = a;}
	public int getCreatetime() { return createtime;}
	
	public int getRunTime()
	{
		return runtime;
	}
	public int getEndtime() { return endtime; }
	
	public void setUser(User u)
	{
		user=u;
	}
	public User getUser() { return user; }

	public void setProject(Project p)
	{
		priority=p.getPriority();
		project=p;
	}
	public Project getProject()
	{
		return project;
	}
	public void setPriority(int a) { priority=a; }
	public int getPriority() { return priority; }

	public void setStatus()
	{
		jobstatus="COMPLETED";
	}
	public String getStatus()
	{
		return jobstatus;
	}

	public void setArrivalTime(int gt) { arrivaltime=gt; }
	public void setEndTime(int g)
	{
		endtime=g;
	}

	
    @Override
    public int compareTo(Job job)
    {
    	int y=this.getPriority()-job.getPriority();
    	if(y==0)
    		y=job.getCreatetime()-this.getCreatetime();
    	return y;
    }
    public String toString()
    {
    	String end="null";
    	if(endtime>0)
    		end=endtime+"";
    	String ss=("Job{user='"+user.name()+"', project='"+project.projectName()+"', jobstatus="+jobstatus+
    			", execution_time="+runtime+", end_time="+end+", name='"+name+"'}");
    	return ss;
    }


	@Override
	public String user() {
		return username;
	}

	@Override
	public String project_name() {
		return projectname;
	}

	@Override
	public int budget() {
		return project.getBudget();
	}

	@Override
	public int arrival_time() {
		return arrivaltime;
	}

	@Override
	public int completion_time() {
		return endtime;
	}
}