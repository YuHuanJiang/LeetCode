package minStack;

public class MinStack {
	private volatile int[] stack;
	private volatile int[] minIndex;
	private static final int default_size = 8;
	private int current = -1;
	private int min = Integer.MAX_VALUE;
	private int min_index = -1;
	
	public MinStack() {
		this(default_size);
	}
	
	public MinStack(int size) {
		stack = new int[size];
		minIndex = new int[size];
	}
	
	public void push(int x) {
		current++;
		
		if(current >= stack.length) {
			int[] tmp = new int[current * 2];
			System.arraycopy(stack, 0, tmp, 0, stack.length);
			stack = tmp;
			
			tmp = new int[current * 2];
			System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
			minIndex = tmp;
		}
		
		stack[current] = x;
		
		if(x < min) {
			min = x;
			min_index = current;
		}
		
		minIndex[current] = min_index;
	}
	
	public void pop() {
		current--;
		if(current >= 0) {
			min = stack[minIndex[current]];
			min_index = minIndex[current];
		}
	}
	
	public int top() {
		if(current < 0) throw new RuntimeException("no more data");
		
		return stack[current];
	}
	
	public int getMin() {
		if(current < 0) throw new RuntimeException("no data");
		
		return stack[minIndex[current]];
	}
}
