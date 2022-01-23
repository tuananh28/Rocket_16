package backend;

public class ArmyGeneral extends Soldier {

	private double m_Experience = 0;

	public ArmyGeneral(String m_Code, double m_Attack, double m_Defend, boolean m_Equipment, int m_Strength,
			double m_Experience) {
		super(m_Code, m_Attack, m_Defend, m_Equipment, m_Strength);
		this.m_Experience = m_Experience;
	}
	
	public double getEperienceValue() {
		double value = 0;
		if (this.getM_Experience() <= 0) {
			value = 0.5;
		} else if (this.getM_Experience() <= 2) {
			value = 0.8;
		} else if (this.getM_Experience() <= 5) {
			value = 1.5;
		} else {
			value = 2.0;
		}
		return value;
	}

	public double getM_Experience() {
		return m_Experience;
	}

	public void setM_Experience(double m_Experience) {
		this.m_Experience = m_Experience;
	}
	
	public String toString() {
		return super.toString() + " " + this.getM_Experience();
	}

}
