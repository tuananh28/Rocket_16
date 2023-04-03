package com.vti.entity.Access_Modifier;
public class Position {
    int PositionID;
    PositionName PositionName;
    
    public Position() {
    	
    };
     
    public Position(int PositionID, PositionName PositionName) {
    	this.PositionID = PositionID;
    	this.PositionName = PositionName;
    }

	public int getPositionID() {
		return PositionID;
	}

	public void setPositionID(int positionID) {
		PositionID = positionID;
	}

	public PositionName getPositionName() {
		return PositionName;
	}

	public void setPositionName(PositionName positionName) {
		PositionName = positionName;
	}
}

