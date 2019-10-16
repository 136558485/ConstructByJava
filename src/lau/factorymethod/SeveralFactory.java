package lau.factorymethod;

/**
 * 多个工厂模式
 * @author
 *
 */

public class SeveralFactory {

	public static void main(String[] args) {
		
		TeaFactory factory = new TeaFactory();
		Tea tea1 = factory.getGreenTea();
		tea1.TeaType();
		Tea tea2 = factory.getMilkTea();
		tea2.TeaType();

	}

}

interface Tea{
	public void TeaType();
}

class MilkTea implements Tea{
	@Override
	public void TeaType() {
		System.out.println("您的奶茶！");
	}
}

class GreenTea implements Tea{
	@Override
	public void TeaType() {
		System.out.println("您的绿茶！");
	}
}

class TeaFactory{
	public Tea getMilkTea(){
		return new MilkTea();
	}
	
	public Tea getGreenTea(){
		return new GreenTea();
	}
}
