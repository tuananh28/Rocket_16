package backend;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name = "";
	private ArmyGeneral armyGeneral = null;
	private List<Soldier> soldiers = new ArrayList<Soldier>();

	public Team(String name, ArmyGeneral armyGeneral, List<Soldier> soldiers) {
		super();
		this.name = name;
		this.armyGeneral = armyGeneral;
		this.soldiers = soldiers;
		applyExperience();
	}

	private void applyExperience() {
		double value = armyGeneral.getEperienceValue();
		for (Soldier soldier : soldiers) {
			soldier.applyExperience(value);
		}
	}
	
	public Soldier next() {
		if (soldiers.isEmpty()) {
			return armyGeneral;
		} else {
			return soldiers.remove(0);
		}
	}
	
	public boolean isLost() {
		return soldiers.isEmpty() && armyGeneral.isDeath();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArmyGeneral getArmyGeneral() {
		return armyGeneral;
	}

	public void setArmyGeneral(ArmyGeneral armyGeneral) {
		this.armyGeneral = armyGeneral;
	}

	public List<Soldier> getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(List<Soldier> soldiers) {
		this.soldiers = soldiers;
	}

}
