package review;

import java.util.Scanner;

import utils.ReaderUtils;

import static java.lang.System.out;

public class XPrint {

	private XPrint() {
		try (Scanner scanner = new Scanner(System.in)) {
			final int toCenter = ReaderUtils.readFromUser(scanner, "What is the arm length?", 
									(input) -> {
										final int parsed = Integer.parseInt(input);
										if (parsed % 2 == 0)
											throw new ReaderUtils.InvalidInput("Number must be odd");
										return parsed;
									});
			final int length = toCenter - 1;

			for (int i = toCenter; i > 0; i--) printFromIndex(length, i);

			for (int i = 0; i < toCenter; i++) out.print(" ");
			out.println("X");

			for (int i = 0; i < toCenter; i++) printFromIndex(length, i + 1);
		}
	}

	private void printFromIndex(int length, int i) {
		for (int x = 0; x <= length - i; x++)
			out.print(" ");
		out.print("X");
		for (int x = 0; x < (i * 2) - 1; x++)
			out.print(" ");
		out.println("X");
	}

	public static void main(String[] args) {
		new XPrint();
	}

}
