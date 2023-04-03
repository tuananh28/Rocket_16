package com.vti.entity.Encapsulation;

public class Student {
		private int ID;
		private String Name;
		private String HomeTown;
		private float Mark;
		
		public Student() {
			super();
		}
		public Student(int ID, String Name, String HomeTown) {
			super();
			this.setID(ID);
			this.Name = Name;
			this.setHomeTown(HomeTown);
			this.Mark = (float) 0;
			
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getHomeTown() {
			return HomeTown;
		}
		public void setHomeTown(String homeTown) {
			HomeTown = homeTown;
		}
		public void setMark(float mark) {
			Mark = mark;
		}
		
		public void plusMark(float mark) {
		this.Mark+= mark;
		}
		
		@Override
		public String toString() {
			String rank;
			if (Mark < 4.0) {
				rank = "Học lực yếu";
			}else if (Mark <6.0 ) {
				rank = "Học lực trung bình ";
			}else if (Mark < 8.0) {
				rank = "Học lực Khá";
			}else {
				rank = "Học lực giỏi";
			}
			return " Name : "+Name+
					"\nMark : "+Mark+
					"\nRank : "+rank+"";
		}
		
	}
