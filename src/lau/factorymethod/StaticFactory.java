package lau.factorymethod;

/**
 * 静态工厂模式
 * @author zWX810514
 *
 */

public class StaticFactory {

	public static void main(String[] args) {
		Bacco bacco1 = BaccoFactory.getBaisha();
		bacco1.BaccoType();
		Bacco bacco2 = BaccoFactory.getShuangxi();
		bacco2.BaccoType();
	}

}

interface Bacco{
	public void BaccoType();
}

class Baisha implements Bacco{
	@Override
	public void BaccoType() {
		System.out.println("吸烟有害健康！这个是白沙烟！");
	}
}

class Shuangxi implements Bacco{
	@Override
	public void BaccoType() {
		System.out.println("吸烟有害健康！这个是红双喜烟！");
	}
}

class BaccoFactory{
	public static Bacco getBaisha(){
		return new Baisha();
	}
	
	public static Bacco getShuangxi(){
		return new Shuangxi();
	}
}
