/*
	This is BinaryHeap class for practice assignment 6 from CS 245 section I.
	@author Tingbin Huang 
	
	Class methods:

	int parent(int child)
    int leftChild(int parent)
    int rightChild(int parent)
	void swap(int pos1, int pos2)
	void add( int input)
	int remove()
	void shiftdown(int position)

*/ 

public class BinaryHeap {
	private int size;
	private int[] data; 
	private int current_size; 
	
	public BinaryHeap(){
		size = 100010;
		data = new int[size]; 
		current_size = 0; 
	}
	
	/**
	 * return the parent of the node. 
	 * @return int 
	 */
	public int parent(int child){
		return (child-1)/2; 
	}
	
	/**
	 * return its left child.
	 * @param parent
	 * @return int 
	 */
	public int leftChild(int parent){
		return (2 * parent) + 1; 
	}
	
	/**
	 * return its right child.
	 * @param parent
	 * @return int
	 */
	public int rightChild(int parent){
		return (2*parent) + 2; 
	}
	
	/**
	 * swap two position in array. 
	 * @param pos1 int 
	 * @param pos2 int 
	 */
	public void swap(int pos1, int pos2){
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}
	
	/**
	 * insert item to the array. 
	 * @param item
	 */
	public void add( int input){
		
		int temp = current_size;
		data[current_size++] = input;
		
		while(data[temp] < data[parent(temp)]){
			swap(temp,parent(temp));
			temp = parent(temp);
		}
		
	}
	
	/**
	 * remove item from array. 
	 * @return int 
	 */
	public int remove(){
		
		int item = data[0];
		swap(0,--current_size);
	
		if(current_size != 0){
			shiftdown(0);
		}
		return item; 
	}
	
	/**
	 * push number down, and re-arrange position of tree. 
	 * @param int position
	 */
	private void shiftdown(int position){
		if(leftChild(position) >= current_size ){
			return;
		}
		int child = leftChild(position);
		if(rightChild(position) < current_size && data[rightChild(position)] < data[child]){
			child = (rightChild(position));
		}
		if(data[child] < data[position]){
			swap(child,position);
			shiftdown(child);
		}
	}
	
	


	
	
}
