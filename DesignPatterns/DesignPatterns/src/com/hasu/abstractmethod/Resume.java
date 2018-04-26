package com.hasu.abstractmethod;

import java.util.ArrayList;

public class Resume extends Document{

	@Override
	protected ArrayList<Page> createPages() {
		ArrayList<Page> pages = new ArrayList<Page>();
		IntroPage ip = new IntroPage();
		ip.addContent("This is intro page content\n");
		EducationPage ep = new EducationPage();
		ep.addContent("This is education page content\n");
		SkillsPage sp = new SkillsPage();
		sp.addContent("This is skills page content\n");
		pages.add(ip);
		pages.add(ep);
		pages.add(sp);
		return pages;
	}

}
