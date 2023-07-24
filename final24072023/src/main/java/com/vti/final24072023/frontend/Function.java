package com.vti.final24072023.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.final24072023.backend.presentationlayer.CandidateController;
import com.vti.final24072023.entity.Candidate;
import com.vti.final24072023.entity.GraduationRank;
import com.vti.final24072023.utils.ScannerUtils;

public class Function {

	private CandidateController candidateController;

	public Function() {
		candidateController = new CandidateController();
	}

	Scanner scanner = new Scanner(System.in);

	public Candidate login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("moi ban nhap Email cua account: ");
			String email = scanner.nextLine();

			System.out.print("moi ban nhap password: ");
			String password = ScannerUtils.inputPassword();

			Candidate candidate = candidateController.login(email, password);

			if (candidate != null) {
				System.out.printf("Chao mung %s (%s) \n \n \n",
						candidate.getFirstName() + " " + candidate.getLastName(), candidate.getRole());
				return candidate;
			} else {
				System.err.println("Ban xem lai Email/Password ko dung! moi dang nhap lai!");
			}
		}
	}

	public void addExperienceCandidate() throws ClassNotFoundException, SQLException {
		System.out.print("moi ban nhap firstname cua account: ");
		String firstname = scanner.nextLine();
		System.out.print("moi ban nhap lastname cua account: ");
		String lastname = scanner.nextLine();
//		System.out.print("moi ban nhap phone cua account: ");
		String phone = ScannerUtils.inputPhoneNumber();
		System.out.print("moi ban nhap password cua account: ");
		String password = ScannerUtils.inputPassword();
		System.out.print("moi ban nhap expInYear cua account: ");
		int expInYear = ScannerUtils.inputFunction(0, 10);
		scanner.nextLine();
		System.out.print("moi ban nhap proSkill cua account: ");
		String proSkill = scanner.nextLine();

		System.out.print("moi ban nhap vao Email cua account: ");
		String email = "";
		while (true) {
			email = ScannerUtils.inputEmail();// kiem tra dung dịnh dang email chua
			boolean resultExistsEmail = candidateController.isUserExistsByEmail(email); // kiem tra xem email có bi trung hayko
			// tao 2 tk giong ý chang nhau( giong email: a@gmail.com và gióng password: 123456)   tk1 và tk2 
			if (resultExistsEmail) {
				System.err.printf("\nEmail %s da ton tai! moi nhap email mail khac: ", email);
			} else {
				break;
			}
		}

		candidateController.registerE(firstname, lastname, phone, email, expInYear, proSkill, password);
		System.out.println("Tạo mới ExperienceCandidate thành công");
	}

	public void addFresherCandidate() throws ClassNotFoundException, SQLException {
		System.out.print("moi ban nhap firstname cua account: ");
		String firstname = scanner.nextLine();
		System.out.print("moi ban nhap lastname cua account: ");
		String lastname = scanner.nextLine();
//		System.out.print("moi ban nhap phone cua account: ");
		String phone = ScannerUtils.inputPhoneNumber();
		System.out.print("moi ban nhap password cua account: ");
		String password = ScannerUtils.inputPassword();

		GraduationRank graduationRank;
		System.out.print("moi ban nhap GraduationRank cua account: 1.Excellence, 2.Good, 3.Fair, Khác.Poor;");
		int key = scanner.nextInt();
		scanner.nextLine();
		switch (key) {
		case 1:
			graduationRank = GraduationRank.Excellence;
			break;

		case 2:
			graduationRank = GraduationRank.Good;
			break;

		case 3:
			graduationRank = GraduationRank.Fair;
			break;

		default:
			graduationRank = GraduationRank.Poor;
			break;

		}

		String email;
		System.out.print("moi ban nhap vao Email cua account: ");
		while (true) {
			email = ScannerUtils.inputEmail();// abc @ xyz...
			boolean resultExistsEmail = candidateController.isUserExistsByEmail(email);// kiem tra da ton tai hay chua
			if (resultExistsEmail) {
				System.err.printf("\nEmail %s da ton tai! moi nhap email mail khac: ", email);
			} else {
				break;
			}
		}

		candidateController.registerF(firstname, lastname, phone, email, graduationRank, password);
		System.out.println("Tạo mới FresherCandidate thành công");
	}

}
