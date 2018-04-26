package com.hasu.abstractfactory.Usage;
import com.hasu.abstractfactory.PhoneFactory;
import com.hasu.abstractfactory.apple.Apple;
import com.hasu.abstractfactory.samsung.Samsung;

public class AbstractFactoryMain {
	public static void main(String[] args) {
		PhoneFactory samsungFactory = new Samsung();
		PhoneOutlet samsungOutlet = new PhoneOutlet(samsungFactory);
		System.out.println(samsungOutlet);
		
		PhoneFactory appleFactory = new Apple();
		PhoneOutlet appleOutlet = new PhoneOutlet(appleFactory);
		System.out.println(appleOutlet);
	}
}
