/*
 * Code by __E18/1025__
 * Stack implementation using Linked List and Time Complexity for all operation is O(1)
 */

public class LinkedList {
	Node root;
	
	LinkedList(){
		root = null;
	}
	
	// Node class 
	static class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	/*
	 * @param   integer type d
	 * @return  nothing
	 * Add d at end of the Stack
	 */
	public void push(int d) {
		Node node = new Node(d);
		if(root == null) {
			root = node;
		}
		else {
			node.next = root;
			root = node;
		}
	}
	
	/*
	 * @param   nothing
	 * @return  popped element
	 * Remove top of the element 
	 */
	public int pop() {
		int d = root.data;
		Node temp = root;
		root = root.next;
		temp = null;
		return d;
	}
	
	/*
	 * @param   nothing
	 * @return  top of the element
	 */
	public int top() {
		return root.data;
	}
	
	/*
	 * @param  nothing
	 * @return true if Stack is empty otherwise false
	 */
	public boolean isEmpty() {
		if(root ==  null)
			return true;
		return false;
	}

	
	public static void main(String args[]) {
		LinkedList stack = new LinkedList();
		System.out.println(stack.isEmpty());
		stack.push(10);
		stack.push(15);
		stack.push(20);
		stack.push(25);
		System.out.println(stack.top());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.top());
	}
}
