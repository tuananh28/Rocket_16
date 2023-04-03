package com.vti.entity;

public class Car {
	private String Name;
	private String Type;

	public Car(String name, String type) {
		super();
		Name = name;
		Type = type;
	}

	@Override
	public String toString() {
		return "Car [Name=" + Name + ", Type=" + Type + "]";
	}

	public class Engine {
		private String engineType;

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}

		@Override
		public String toString() {
			return "Engine [engineType=" + engineType + "]";
		}

	}
}
