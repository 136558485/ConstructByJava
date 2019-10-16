package lau.abstractfactory;

/**
 * 抽象工厂模式
 * 不用的类使用不同的工厂，这样后面如果要新加入一类新的产品，只要相应的添加相应的工厂即可。
 * 这样可以防止对工厂类本身的改动，遵循的设计模式的闭包原则
 * @author zWX810514
 */

public class AbstractFactory {

	public static void main(String[] args) {
		//用工厂类的统一接口创建一个指定工厂实现类
		Provider provider1 = new QQFactory();
		//用指定工厂的实现类获取指定的产品实现类
		Sender sender1 = provider1.getSender();
		//实现类实现方法
		sender1.sendSth();
		
		Provider provider2 = new WXFactory();
		Sender sender2 = provider2.getSender();
		sender2.sendSth();

	}

}

interface Sender{
	public void sendSth();
}

class QQSender implements Sender{
	@Override
	public void sendSth() {
		System.out.println("您正在用qq发送消息！");		
	}
}

class WXSender implements Sender{
	@Override
	public void sendSth() {
		System.out.println("您正在用微信发送消息！");	
	}
}

interface Provider{
	public Sender getSender();
}

class QQFactory implements Provider{
	@Override
	public Sender getSender() {
		return new QQSender();
	}
}

class WXFactory implements Provider{
	@Override
	public Sender getSender() {
		return new WXSender();
	}
}
