Description of the assignment


/*Respective time complexities are mentioned inside the methods*/


********************TRIE********************
insert()
{
	Checking for the last common node and adding successive character nodes later.
	Add the data element at the end node
	O(length of name)
}
search()
{
	Traverse character-wise down the trie; the last character node corresponds to the data element.
	At any moment the character is not found, the element does not exist.
	O(length of name)
}
delete()
{
	First check if the element exists.
	Traverse from bottom up; if no character is shared after the current character, delete that character which implies the characters can be deleted further up else the deletion process stops.
	O(length of name)
}


********************REDBLACKTREE***************
//n nodes...balanced tree...height~logn
insert()
{
	Insert red node using standard BST process.
	If root colour it black.
	If black parent: no restructuring required
	If red parent and black uncle: restructure
	If red parent and red uncle: recolour and follow the above steps in order.
	O(logn)
}
search()
{
	Standard BST search
	Compare current node with the key and search accordingly in left subtree or right subtree.
	O(logn)
}


******************MAXHEAP*****************
//n number of elements
insert()
{
	Insert at the bottom of the heap
	Bubble up the value according to its priority.
	O(logn)
}
extractMax()
{
	Extract the topmost element; replace it with the bottommost element
	Bubble down according to the priority.
	O(logn)
}
//if same priority, second priority(time stamp) is compared



****************PROJECTMANAGEMENT*****************
//Job contain the attributes of its corresponding Project and User which can be accessed

Current jobs are stored in MaxHeap and evaluated according to their priority, unfinished jobs go to another priorityqueue.
Unfinished jobs are also stored in a MaxHeap and extracted if the budget is increased.
Users are stored in Trie.
Projects are stored in Trie.
All jobs are stored in RedBlackTree for searching purpose.
Completed jobs are stored in an ArrayList in the order in which they are executed.


/****************public interface SchedulerInterface***********/
void handle_project(String[] cmd)
{
	//adding project in trie
	//making another RBtree to store corresponding jobs
}
void handle_job(String[] cmd)
{
	//adding jobs in RBtrees
	//adding jobs in Maxheap
}
void handle_user(String name)
{
	//adding users in trie
	//making another RBtree to store corresponding jobs
}
void handle_query(String key)
{
	//searching job in the RBtree
}
void handle_empty_line()
{
	//executing job by extracting from the maxheap
	//adding the jobs with insufficient budget in incomplete jobs’ list
}
void schedule()
{
	//execute a job unless a job with sufficient budget is obtained
}
void handle_add(String[] cmd)
{
	//Adding budget of a project and adding corresponding unfinished jobs to the maxheap
}
void run_to_completion()
{
	//execute the remaining jobs
}
void print_stats()
{ 	
	//print the finished and unfinished jobs
}
// Timed queries for the old queries. These are equivalent to their untimed parts
// Only they should not print anything so the real code is timed
default void timed_handle_user(String name){}
default void timed_handle_job(String[] cmd){}
default void timed_handle_project(String[] cmd){}
default void timed_run_to_completion(){}
private ArrayList<JobReport_> handle_new_priority(String s)
{
	//all elements in the joblist is searched for “REQUESTED” and returned
}
private ArrayList<JobReport_> handle_new_projectuser(String[] cmd)
{
	//elements common to both user and project are returned in the given order
}
private ArrayList<JobReport_> handle_new_user(String[] cmd)
{
	//RBTree is searched (with key as username) and all its elements with T are inserted
}
private ArrayList<JobReport_> handle_new_project(String[] cmd)
{
	//RBTree is searched (with key as projectname) and all its elements with T are inserted
}
default ArrayList<JobReport_> timed_report(String[] cmd)
{
	//handles the new queries
}
default ArrayList<UserReport_>timed_top_consumer(int top)
{
	//uses user msxheap to print in order of consumption
}
default void timed_flush(int waittime)
{
	//execute low priority jobs
	//searching in the maxheap; bumping the priority; extracting according to budget requirement; restoring priority
}