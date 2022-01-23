package backend;

public class War {
	private Team teamA = null;
	private Team teamB = null;

	public War(Team teamA, Team teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	public Team combat() {
		Soldier ally = null;
		Soldier enemy = null;
		while (!(teamA.isLost() || teamB.isLost())) {
			if (ally == null) {
				ally = teamA.next();
			}
			if (enemy == null) {
				enemy = teamB.next();
			}
			if (ally.compare(enemy)) {
				ally.attacked();
				enemy.setDeath(true);
				enemy = null;
			} else {
				ally.setDeath(true);
				ally = null;
				enemy.attacked();
			}
		}
		if(teamA.isLost()) {
			teamB.getSoldiers().add(enemy);
		} else {
			teamA.getSoldiers().add(ally);
		}
		return teamA.isLost() ? teamB : teamA;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

}
