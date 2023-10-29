package com.aurionpro.model;

public class Boy implements IMannerable,IEmotionerable{

	@Override
	public void Laugh() {
		System.out.println("Boy is Laughing");
		
	}

	@Override
	public void cry() {
		System.out.println("Boy is Crying");
		
		
	}

	@Override
	public void wish() {
		System.out.println("Boy is Wishing");
		
		
	}

	@Override
	public void deport() {
		System.out.println("Boy is deport");
		
	}

}
