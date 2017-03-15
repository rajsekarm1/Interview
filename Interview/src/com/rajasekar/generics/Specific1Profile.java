package com.rajasekar.generics;

public class Specific1Profile extends GenericProfile {
	
	
	private String spec1Property;

	public Specific1Profile(int id, String name, String spec1Property) {
		super(id,name);
		this.spec1Property = spec1Property;
	}

	public String getSpec1Property() {
		return spec1Property;
	}

	@Override
	public String toString() {
		return "Specific1Profile [spec1Property=" + spec1Property + ", getSpec1Property()=" + getSpec1Property() + "]";
	}

	public void setSpec1Property(String spec1Property) {
		this.spec1Property = spec1Property;
	}

}
