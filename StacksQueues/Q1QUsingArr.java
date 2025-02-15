class Q1QUsingArr{
    int front, rear;
	int arr[] = new int[100005];

    Q1QUsingArr()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
    arr[rear++]=x;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
        // THIS WORKS BECAUSE IN ARR IMPLEMENTATION REAR GOES TO FRONT AFTER ADDING NEW ELE, SO AFTER REMOVING FRONT IT COMES TO FRONT IF IT MEETS REAR ALL ELEMENTS ARE POPPED OUT.
        if(front==rear){
            return -1;
		}
		return arr[front++];
	} 
}

