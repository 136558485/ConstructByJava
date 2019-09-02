package lau.container;

public class ContainerTest {

	public static void main(String[] args) {
		BlockContainer<String> container = new BlockContainer<String>();
		//测试一 ：容器满时阻塞无法在生产数据进去
//		container.put("张三");
//		container.put("李四");
//		container.put("王五");
//		System.out.println("get:"+container.toString());
//		container.put("赵六");
//		System.out.println(container.toString());
		
		//测试二 ：容器没有数据时无法消费数据
//		System.out.println(container.get());
		
		//测试三 ：一边生产一边消费
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
