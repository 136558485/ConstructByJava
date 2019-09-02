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
	
	//���Ԫ�ص�����
	public synchronized void put(T t){
		//��sizeΪ0��˵�������Ѿ����ˣ���ʱ�߳�����
		while(this.size == 0)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//�����Ƚ��ȳ�ԭ�򣬴�ǰ�������������Ԫ��
		array[array.length-size] = t;
		size--;
		//����������getԪ��
		this.notify();
		
	}
	
	public synchronized T get() {
		//��sizeΪ����ĳ��ȣ�˵����ʱ����û��ֵ����ʱ�߳�����
		while(this.size == array.length)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//�����Ƚ��ȳ�ԭ�򣬻�ȡ��һ��Ԫ��
		Object t = array[0];
		//��ȡ�󣬽���������Ԫ����ǰŲһ��λ��
		System.arraycopy(array, 1, array, 0, array.length-1);
		array[array.length-1] = null;
		size++;
		//�����������߳�putԪ��
		this.notify();
		return (T)t;
	}
	
	
	@Override
	public String toString() {
		return "BlockContainer [array=" + Arrays.toString(array) + "]";
	}

}
