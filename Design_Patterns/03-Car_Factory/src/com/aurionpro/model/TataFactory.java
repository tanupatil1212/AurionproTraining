package com.aurionpro.model;

public class TataFactory implements ICarFactory {

	private static TataFactory tataFactory;

	private TataFactory() {
	}

	public static TataFactory getTataFactoryInstance() {
		if (tataFactory == null) {
			tataFactory = new TataFactory();
		}
		return tataFactory;
	}

	@Override
	public ICars makeCar() {
		return new Tata();
	}

}
