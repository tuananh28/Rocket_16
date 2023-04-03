package com.vti.entity;

public class CPU {
	@SuppressWarnings("unused")
	private double price;

	public CPU(double price) {
		super();
		this.price = price;
	}

	public class Processor {
		@SuppressWarnings("unused")
		private int coreAmount;
		@SuppressWarnings("unused")
		private String menufacturer;

		public Processor(int coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}

		public Float getCache() {
			return 4.3f;
		}
	}

	public class Ram {
		@SuppressWarnings("unused")
		private int memory;
		@SuppressWarnings("unused")
		private String menufacturer;

		public Ram(int memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		public Float getClockSpeed() {
			return 5.5f;
		}
	}
}
