class 09InOrderSuccessor{
    Node findPredecessor(Node root, Node p) {
		Node predecessor = null;
		while(root!=null){
			if(root.data>=p.data){
				root=root.left;
			}
			else if(root.data<p.data>){
				predecessor = root;
				root=root.right;
			}
			else {
				break;
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
            } else {
                break;
            }
        }
        return (successor != null) ? successor.data : -1;
    }
}