package com.hasu.abstractmethod;

public class Resume extends Document{

	@Override
	public void createPages() {
		IntroPage ip = new IntroPage();
		EducationPage ep = new EducationPage();
		SkillsPage sp = new SkillsPage();
		pages.add(ip);
		pages.add(ep);
		pages.add(sp);
	}

}
