package lau.container;

public class ContainerTest {

	public static void main(String[] args) {
		BlockContainer<String> container = new BlockContainer<String>();
		//����һ ��������ʱ�����޷����������ݽ�ȥ
//		container.put("����");
//		container.put("����");
//		container.put("����");
//		System.out.println("get:"+container.toString());
//		container.put("����");
//		System.out.println(container.toString());
		
		//���Զ� ������û������ʱ�޷���������
//		System.out.println(container.get());
		
		//������ ��һ������һ������
		Producer p = new Producer(container);
		Consumer c = new Consumer(container);		
		p.start();
		c.start();
	}

}

class Producer extends Thread{
		
	private BlockContainer<Integer> container;
	
	public Producer(BlockContainer container) {
		this.container = container;
	}	
	public void run() {
		int i = 0;
		while(true) {
			container.put(++i);
			System.out.println("put:"+container.toString());
			try {
				this.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}	
}
class Consumer extends Thread{
	
	private BlockContainer<Integer> container;
	
	public Consumer(BlockContainer container) {
		this.container = container;
	}	
	public void run() {
		while(true) {
			System.out.println("get:"+container.get());
			try {
				this.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}	
}
