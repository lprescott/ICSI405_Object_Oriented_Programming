package com.hasu.abstractfactory.apple;

import com.hasu.abstractfactory.DumbPhone;
import com.hasu.abstractfactory.PhoneFactory;
import com.hasu.abstractfactory.SmartPhone;

public class Apple extends PhoneFactory{

	@Override
	public SmartPhone getSmartPhone() {
		return new iPhone();
	}

	@Override
	public DumbPhone getDumbPhone() {
		// TODO Auto-generated method stub
		return null;
	}

}
