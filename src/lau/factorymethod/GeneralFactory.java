package lau.factorymethod;

/**
 * 23种设计模式-普通工厂模式
 * 
 */
public class GeneralFactory {
	
	public static void main(String[] args) {
		SenderFactory factory = new SenderFactory();
		Sender sender1 = factory.getSender("qq");
		sender1.sendSomething();
		Sender sender2 = factory.getSender("wx");
		sender2.sendSomething();
		Sender sender3 = factory.getSender("no");
		sender3.sendSomething();
	} 

}

interface Sender{
	public void sendSomething();
}

class QQSender implements Sender{
	public void sendSomething(){
		System.out.println("这里是用qq发送消息！");
	}
}

class WXSender implements Sender{
	public void sendSomething(){
		System.out.println("这里是用微信发送消息！");
	}
}

class SenderFactory{
	
	public Sender getSender(String sender){
		if("qq".equals(sender)){
			return new QQSender();
		}else if("wx".equals(sender)){
			return new WXSender();
		}else{
			System.out.println("您想要的类本工厂不制造！请联系管理人员改进工厂！");
			return null;
		}
	}
}
