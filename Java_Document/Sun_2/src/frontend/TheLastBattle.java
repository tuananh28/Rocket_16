package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.Archer;
import backend.ArmyGeneral;
import backend.Knight;
import backend.Soldier;
import backend.Team;
import backend.Valiant;
import backend.War;

public class TheLastBattle {

	public static void main(String[] args) {
		Team teamA = generateTeamA();
		Team teamB = generateTeamB();
		War war = new War(teamA, teamB);
		Team winner = war.combat();
		displayWinner(winner);
	}

	public static void displayWinner(Team winner) {
		System.out.println(winner.getName() + " Win");
		System.out.println(winner.getArmyGeneral());
		for (Soldier soldier : winner.getSoldiers()) {
			System.out.println(soldier);
		}
	}

	private static Team generateTeamA() {
		ArmyGeneral armyGeneral = new ArmyGeneral("AG1", 70, 70, true, 30, 3.5);
		List<Soldier> soldiers = new ArrayList<Soldier>();
		soldiers.add(new Valiant("V001", 20, 10, true, 15));
		soldiers.add(new Archer("A001", 10, 50, false, 14));
		soldiers.add(new Knight("K001", 30, 35, true, 20));
		return new Team("Team A", armyGeneral, soldiers);
	}

	private static Team generateTeamB() {
		ArmyGeneral armyGeneral = new ArmyGeneral("AG001", 100, 100, true, 50, 6);
		List<Soldier> soldiers = new ArrayList<Soldier>();
		soldiers.add(new Valiant("V002", 20, 30, true, 20));
		soldiers.add(new Knight("K002", 50, 50, true, 30));
		return new Team("Team B", armyGeneral, soldiers);
	}
}
