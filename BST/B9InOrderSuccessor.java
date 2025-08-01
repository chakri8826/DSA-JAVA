class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}
class B9InOrderSuccessor{
    Node findPredecessor(Node root, Node p) {
		Node predecessor = null;
		while(root!=null){
			if(root.data>=p.data){
				root=root.left;
			}
			else if(root.data<p.data){
				predecessor = root;
				root=root.right;
			}
			
		}
		return predecessor;
	}

    public int inorderSuccessor(Node root, Node x) {
        Node successor = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data>x.data) {
                successor = curr; // potential successor
                curr = curr.left;
            } else if (curr.data <= x.data) {
                curr = curr.right;
            }
        }
        return (successor != null) ? successor.data : -1;
    }
}