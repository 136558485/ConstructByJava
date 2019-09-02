package lau.container;

import java.util.Arrays;

public class BlockContainer<T> {
	private T[] array;
	private int size;
	
	public BlockContainer() {
		this(3);
	}
	
	public BlockContainer(int n) {
		this.array = (T[])new Object[n];
		this.size = n;
	}
	
	//添加元素到队列
	public synchronized void put(T t){
		//当size为0，说明数组已经满了，此时线程阻塞
		while(this.size == 0)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//基于先进先出原则，从前往后往数组添加元素
		array[array.length-size] = t;
		size--;
		//唤醒消费者get元素
		this.notify();
		
	}
	
	public synchronized T get() {
		//当size为数组的长度，说明此时队列没有值，此时线程阻塞
		while(this.size == array.length)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//基于先进先出原则，获取第一个元素
		Object t = array[0];
		//获取后，将数组后面的元素往前挪一个位置
		System.arraycopy(array, 1, array, 0, array.length-1);
		array[array.length-1] = null;
		size++;
		//唤醒生产者线程put元素
		this.notify();
		return (T)t;
	}
	
	
	@Override
	public String toString() {
		return "BlockContainer [array=" + Arrays.toString(array) + "]";
	}

}
