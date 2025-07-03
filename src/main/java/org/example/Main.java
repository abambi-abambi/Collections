package org.example;

public class Main {
	public static void main (String[] args)
	{

		// MyStack stack = new MyStack();
		// stack.push(9);
		// stack.push(19);
		// System.out.println(stack.pop());
		MyQueue queue = new MyQueue();
		queue.offer(1);
		queue.offer(2);
		 queue.offer(3);
		 queue.offer(4);
		 queue.offer(5);
		 queue.offer(6);
		 queue.offer(7);
		 queue.offer(8);
		 queue.offer(9);
		// queue.offer(10);
		// queue.offer(11);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		// queue.peek();
		// queue.element();
	}
}
