package com.hasu.abstractfactory.samsung;

import com.hasu.abstractfactory.DumbPhone;
import com.hasu.abstractfactory.PhoneFactory;
import com.hasu.abstractfactory.SmartPhone;

public class Samsung extends PhoneFactory {

	@Override
	public SmartPhone getSmartPhone() {
		return new SamsungGalaxyS5();
	}

	@Override
	public DumbPhone getDumbPhone() {
		return new SamsungRugby();
	}

}
