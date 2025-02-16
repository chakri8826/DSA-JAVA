class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
        data = a;
        next = null;
	}
}

class Q2QUsingLL
{
    QueueNode front, rear;
    //Function to push an element into the queue.
	void push(int a)
	{
	    QueueNode node = new QueueNode(a);
        if(front==null && rear==null){
            front=rear=node;
        }
        else{
            rear.next=node;
            rear=node;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(front==null && rear==null) return -1;

        // ONE ELE UNTE RENDU DANIKI POINT CHESTU UNTAY SO REMOVE IT AND SET BOTH TO START
        else if(front==rear){
            int ele = front.data;
            front=rear=null;
            return ele;
        }
        else{
            int ele = front.data;
            front=front.next;
            return ele;
        }
	}
}


