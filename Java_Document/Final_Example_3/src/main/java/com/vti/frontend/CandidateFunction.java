package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Ultis.ScannerUltis;
import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateFunction {
	CandidateController candidateController;

	public CandidateFunction() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		candidateController = new CandidateController();
	}

	public void getLogin() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập Email : ");
		String emailLogin = ScannerUltis.inputEmail();
		System.out.print("Mời bạn nhập Password : ");
		String passwordLogin = ScannerUltis.inputString();
		if (candidateController.loginCandidate(emailLogin, passwordLogin)) {
			System.out.println("Xin chào bạn " + emailLogin + " chúc bạn ngày mới làm việc vui vẻ !!");
		} else {
			System.err.println("Email hoặc Password sai , Vui lòng thử lại !!");
		}
	}

	public void getRegister() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("\t 1. Register ExperienceCandidate ");
			System.out.println("\t 2. Register FresherCandidate ");
			System.out.println("\t 3. Exit ");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				System.out.print("FirstName : ");
				String fnameExp = ScannerUltis.inputString();
				System.out.print("LastName : ");
				String lnameExp = ScannerUltis.inputString();
				System.out.print("Phone : ");
				String phoneExp = ScannerUltis.inputPhoneNumber();
				System.out.print("Email : ");
				String EmailExp = ScannerUltis.inputEmail();
				if (candidateController.isCandidateIfExists(EmailExp)) {
					System.err.println("Email đã tồn tại, vui lòng thử lại");
					break;
				}
				System.out.print("ExpInYear : ");
				int ExpInYear = ScannerUltis.inputInt();
				System.out.print("ProSkill : ");
				ProSkill proSkill = getProSkill();
				if (candidateController.createExperienceCandidate(fnameExp, lnameExp, phoneExp, EmailExp, ExpInYear,
						proSkill)) {
					System.out.println("Create Experience Success !!");
				} else {
					System.out.println("Create Experience False !!");
				}
				break;
			case 2:
				System.out.print("FirstName : ");
				String fnameFre = ScannerUltis.inputString();
				System.out.print("LastName : ");
				String lnameFre = ScannerUltis.inputString();
				System.out.print("Phone : ");
				String phoneFre = ScannerUltis.inputPhoneNumber();
				System.out.print("Email : ");
				String EmailFre = ScannerUltis.inputEmail();
				if (candidateController.isCandidateIfExists(EmailFre)) {
					System.err.println("Email đã tồn tại, vui lòng thử lại");
					break;
				}
				System.out.println("GraduationRank : ");
				GraduationRank graduationRank = getGraduationRank();
				if (candidateController.createFresherCandidate(fnameFre, lnameFre, phoneFre, EmailFre, graduationRank)) {
					System.out.println("Create Fresher Success !!");
				} else {
					System.out.println("Create Fresher False !!");
				}
				break;
			case 3:
				System.exit(lc);
				return;
			default:
				System.err.println("Mời bạn nhập lại !!");
				break;
			}
		}
	}

	private GraduationRank getGraduationRank() {
		while (true) {
			System.out.println("\t\t --- GraduationRank --- \t\t");
			System.out.println("\t 1.EXCELLENCE");
			System.out.println("\t 2.GOOD");
			System.out.println("\t 3.FAIR");
			System.out.println("\t 4.POOR");
			System.out.print("Mời bạn chọn GraduationRank : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				return GraduationRank.EXCELLENCE;
			case 2:
				return GraduationRank.GOOD;
			case 3:
				return GraduationRank.FAIR;
			case 4:
				return GraduationRank.POOR;
			default:
				System.err.println("Bạn phải nhập đúng lựa chọn !!!");
				break;
			}
		}
	}

	private ProSkill getProSkill() {
		while (true) {
			System.out.println("\t\t --- ProSkill --- \t\t");
			System.out.println("\t 1.DEV");
			System.out.println("\t 2.TEST");
			System.out.println("\t 3.JAVA");
			System.out.println("\t 4.SQL");
			System.out.print("Mời bạn chọn ProSkill : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				return ProSkill.DEV;
			case 2:
				return ProSkill.TEST;
			case 3:
				return ProSkill.JAVA;
			case 4:
				return ProSkill.SQL;
			default:
				System.err.println("Bạn phải nhập đúng lựa chọn !!!");
				break;
			}
		}
	}
}
