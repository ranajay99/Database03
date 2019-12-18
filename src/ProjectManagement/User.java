package ProjectManagement;

public class User implements Comparable<User>,UserReport_ {

	private String name;
	private int consumption;
	private int latest;

	User(String name)
	{
		consumption=0;
		this.name=name;
		latest=0;
	}
	
	public String name()
	{
		return name;
	}

    @Override
    public int compareTo(User user)
	{
        int y=this.consumed()-user.consumed();
        if(y==0)
        	y=this.getLatest()-user.getLatest();
        return y;
    }

	public void consumed(int a)
	{
		consumption+=a;
	}

	@Override
	public int consumed() {
		return consumption;
	}

	@Override
	public String user() {
		return name;
	}

	public void setLatest(int a)
	{
		latest=a;
	}
	public int getLatest()
	{
		return latest;
	}
}
