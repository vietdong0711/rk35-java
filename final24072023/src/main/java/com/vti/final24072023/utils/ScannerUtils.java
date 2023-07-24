package com.vti.final24072023.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	// Nhập int
	// Tất cả đều nhập sc.next() ==> nhập ký tự
	// Convert sang kiểu dữ liệu phù hợp
	// trong trường hợp mà convert lỗi ==> nhảy vào catch ==> bắt người dùng lại
	public static int inputInt() {
		while (true) {
			try {
				// Nhập vào 1 chuỗi ký tự
				// Integer.parseInt ==> convert từ String sang Interger
				// TH1: Nếu nhập vào chuỗi là số nguyên ==> convert thành công
				// TH2: Nếu nhập vào chuỗi là ko số nguyên ==> có exception ==> Nhập lại
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.out.println("Nhập lại...");
			}
		}
	}

	// Nhập float
	public static Float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static Double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	// Chọn chức năng
	public static int inputIntPositive() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(sc.nextLine());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.err.println("Nhập lại:");
				}
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String string = sc.nextLine();
			if (!string.isEmpty()) {// isEmty ==> rỗng ; !isEmpty() ==> không rỗng
//				System.out.println(string);
				return string;
			} else {
				System.err.println("Nhập lại:");
			}
		}
	}

//	public static String inputStringStream() {
//		while (true) {
//			String string = sc.nextLine().trim();
//			if (!string.isEmpty()) {
//				System.out.println(string);
//				return string;
//			} else {
//				System.err.println("Nhập lại:");
//			}
//		}
//	}

	public static String inputPassword() {
		while (true) {
			String password = ScannerUtils.inputString();
			if (password.length() < 6 || password.length() > 12) {
				System.out.print("Nhập lại: ");
				continue;
			}
			boolean hasAtLeast1Character = false;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}

			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.out.print("Mời bạn nhập lại password: ");
			}
		}
	}

	// Ctrl + Shift + O ==> import thư viện
	public static LocalDate inputLocalDate() {
		System.out.println("Nhập theo định dạng yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.next().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static String inputEmail() {
		while (true) {
			String email = sc.nextLine();
			if (email == null || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {// a@b
				System.out.print("Nhập lại: ");
			} else {
				return email;
			}
		}
	}

	// Hàm nhập fullName chỉ chứa chữ, không chứa bất kì ký tự đặc biệt nào
	public static String inputFullName() {
		while (true) {
			String fullName = ScannerUtils.inputString();
			if (fullName == null
					|| !fullName.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
							+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨú"
							+ "ÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ \\\\ _-]{3,25}$")) {

				System.out.println("Nhập lại: ");

			} else {
				return fullName;
			}
		}
	}

	public static int inputFunction(int a, int b) {
		while (true) {
			int number = ScannerUtils.inputInt();
			if (number >= a && number <= b) {
				return number;
			} else {
				System.err.println("chỉ được nhập từ " + a + " đến " + b);
			}
		}
	}

	public static String inputPhoneNumber() {

		System.out.println("Nhập vào số điện thoại");
//		sc.nextLine();
		while (true) {
			String number = ScannerUtils.inputString();

			if (number.length() > 12 || number.length() < 9) {
				continue;
			}
			if (number.charAt(0) != '0') {
				continue;
			}
			boolean isNumber = true;
			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.print("Nhập lại: ");
			}
		}
	}

}
