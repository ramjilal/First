/*
 * Code by __E18/1025__
 * Stack implementation using Array and Handle Overflow
 */

public class Stack {
	
	//  size >= 0
	private final int size ;
	private final int arr[];
	private int topElementIndex ;
	
	Stack(int size){
		this.size = size;
		this.topElementIndex = -1;
		this.arr = new int[size];
	}
	
	/*
	 * @param   Integer value
	 * @return  nothing
	 * Add value at end of the Stack
	 */
	public void push(int value) {
		if (topElementIndex == size-1)
			System.out.println("Stack Overflow or Stack is Full.");
		else{
			topElementIndex ++;
			arr[topElementIndex] = value;
		}
	}
	
	/*
	 * @param   nothing
	 * @return  nothing
	 * Remove top element of the Stack
	 */
	public void pop() {
		if (topElementIndex == -1)
			System.out.println("Stack Underflow or Stack is Empty");
		else 
			topElementIndex --;
	}
	
	/*
	 * @param   nothing
	 * @return  top element of the Stack
	 */
	public int top() {
		return arr[topElementIndex];
	}
	
	/*
	 * @param   nothing
	 * @return  true if Stack is Empty otherwise false
	 */
	public boolean isEmpty() {
		if (topElementIndex == -1)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]) {
		Stack s = new Stack(3);
		s.push(100);
		s.push(10);
		s.push(1);
		//s.push(11);
		s.pop();
		s.push(1000);
		s.pop();
		s.pop();
		//s.pop();
		//s.pop();
		if (!s.isEmpty())
			System.out.println(s.top());
		
	}
}
