package backend;

public abstract class Soldier {
	private String m_Code = "";
	private double m_Attack = 0;
	private double m_Defend = 0;
	private boolean m_Equipment = false;
	private int m_Strength = 0;

	private boolean isDeath = false;

	public Soldier(String m_Code, double m_Attack, double m_Defend, boolean m_Equipment, int m_Strength) {
		super();
		this.m_Code = m_Code;
		this.m_Attack = m_Attack;
		this.m_Defend = m_Defend;
		this.m_Equipment = m_Equipment;
		this.m_Strength = m_Strength;
	}

	public void applyExperience(double value) {
		this.setM_Attack(this.getM_Attack() * value);
		this.setM_Defend(this.getM_Defend() * value);
	}
	
	public boolean compare(Soldier enemy) {
		if (this.getM_Defend() > enemy.getM_Attack() && this.getM_Attack() >= enemy.getM_Defend()) {
			return true;
		} else if (enemy.getM_Defend() > this.getM_Attack() && enemy.getM_Attack() >= this.getM_Defend()) {
			return false;
		} else {
			if (this.getM_Strength() > enemy.getM_Strength()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void attacked() {
		this.setM_Attack(this.getM_Attack() - 20);
		this.setM_Defend(this.getM_Defend() - 20);
	}

	public String getM_Code() {
		return m_Code;
	}

	public void setM_Code(String m_Code) {
		this.m_Code = m_Code;
	}

	public double getM_Attack() {
		return m_Attack;
	}

	public void setM_Attack(double m_Attack) {
		this.m_Attack = m_Attack;
	}

	public double getM_Defend() {
		return m_Defend;
	}

	public void setM_Defend(double m_Defend) {
		this.m_Defend = m_Defend;
	}

	public boolean isM_Equipment() {
		return m_Equipment;
	}

	public void setM_Equipment(boolean m_Equipment) {
		this.m_Equipment = m_Equipment;
	}

	public int getM_Strength() {
		return m_Strength;
	}

	public void setM_Strength(int m_Strength) {
		this.m_Strength = m_Strength;
	}

	public boolean isDeath() {
		return isDeath;
	}

	public void setDeath(boolean isDeath) {
		this.isDeath = isDeath;
	}

	public String toString() {
		return this.getM_Code() + " " + this.getM_Attack() + " " + this.getM_Defend() + " "
				+ (this.isM_Equipment() ? "YES" : "NO") + " " + this.getM_Strength();
	}

}
