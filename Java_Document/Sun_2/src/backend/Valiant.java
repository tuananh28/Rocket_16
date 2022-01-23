package backend;

public class Valiant extends Soldier {

	public Valiant(String m_Code, double m_Attack, double m_Defend, boolean m_Equipment, int m_Strength) {
		super(m_Code, m_Attack, m_Defend, m_Equipment, m_Strength);
		if (m_Equipment == true) {
			this.setM_Defend(this.getM_Defend() * 2);
		}
	}

}
