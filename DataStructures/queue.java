
// class Queueexample {
	
// 		int queue[]=new int[5];
// 		int front;
// 		int rear;
// 		int size;
// 		public void enQueue(int data) {
// 			if(!isFull()) {
// 			queue[rear]=data;
// 			rear=(rear+1)%5;
// 			size+=1;
// 			}
// 			else
// 				System.out.println("Queue is Full");
			
// 		}
// 		public void show() {
// 			for(int i=0;i<size;i++) {
// 				System.out.print(queue[(front+i)%5]+" ");
// 			}
// 			System.out.println();
// 			for(int n : queue) {
// 				System.out.print(n + " ");
// 			}
// 		}
// 		public void deQueue() {
// 			if(!isEmpty()) {
// 			// int data=queue[front];
// 			front=(front+1)%5;
// 			size-=1;
// 			}
// 			else
// 				System.out.println("Queue is Empty");
// 		}
// 		public boolean isFull() {
// 			return size==5;
// 		}
// 		public boolean isEmpty() {
// 			return size==0;
// 		}

// }
// public class Queue{
// 	public static void main(String[] args) {
// 		Queueexample q=new Queueexample();
// 		q.enQueue(5);
// 		q.enQueue(10);
// 		q.enQueue(1);
// 		q.enQueue(2);
// 		q.enQueue(3);
// 		q.deQueue();
// 		q.deQueue();
// 		q.enQueue(4);
// 		q.enQueue(5);
// 		// q.enQueue(6);
		
// 		q.show();
		
// 	}
// }


public class queue{

	private class Node{
		private int data;
		private Node next;
		public Node(int data){
			this.data=data;
		}
	}

	private Node front;
	private Node rear;
	private int length;

	public int length(){
		System.out.println(length);
		return length;
	}

	public boolean isEmpty(){
		return length==0;
	}

	public void show(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}else{
			Node temp=front;
			while(temp.next!=null){
				System.out.print(temp.data+" --> ");
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
	}

	public void enQueue(int data){
		Node temp=new Node(data);
			if(isEmpty()){
				front=temp;
			}else{
				rear.next=temp;
			}
			rear=temp;
			length++;
	}

	public void deQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}else{
			front=front.next;
			if(front==null){
				rear=null;
			}
			length--;
		}
	}

	public static void main(String[] args) {
		queue queue=new queue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);

		queue.deQueue();

		queue.show();
		queue.length();
	}
}