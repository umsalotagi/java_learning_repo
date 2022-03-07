package com.example.designpattern;

public class BuilderDesign {
	
	private String name;
	private int age;
	private String address;
	private int salary;
	
	private BuilderDesign(String name, int age, String address, int salary) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	
	public static BuilderDesignBuilder builder() {
		return new BuilderDesignBuilder();
	}
	
	@Override
	public String toString() {
		return String.format("Data - name : %s, age = %d, address = %s, salary=%d", name, age, address, salary);
	}
	
	public static class BuilderDesignBuilder {
		private String name;
		private int age;
		private String address;
		private int salary;
		
		public BuilderDesignBuilder name(String name) {
			this.name = name;
			return this;
		}
		public BuilderDesignBuilder age(int age) {
			this.age = age;
			return this;
		}
		public BuilderDesignBuilder address(String address) {
			this.address = address;
			return this;
		}
		public BuilderDesignBuilder salary(int salary) {
			this.salary = salary;
			return this;
		}
		public BuilderDesign build() {
			return new BuilderDesign(name, age, address, salary);
		}
		
	}

}
