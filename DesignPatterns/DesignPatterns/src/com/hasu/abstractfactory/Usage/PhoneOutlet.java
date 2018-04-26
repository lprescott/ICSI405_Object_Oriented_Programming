package com.hasu.abstractfactory.Usage;

import com.hasu.abstractfactory.DumbPhone;
import com.hasu.abstractfactory.PhoneFactory;
import com.hasu.abstractfactory.SmartPhone;

public class PhoneOutlet {
	private DumbPhone dumbPhone;
	private SmartPhone smartPhone;
	
	public PhoneOutlet(PhoneFactory phoneFactory){
		dumbPhone = phoneFactory.getDumbPhone();
		smartPhone = phoneFactory.getSmartPhone();
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", dumbPhone, smartPhone);
	}
}
