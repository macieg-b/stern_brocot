package mba;

import mba.model.SternBrocot;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		int x, y, n;
		System.out.println("Fraction: x/y, depth: n");

		Scanner in = new Scanner(System.in);
		System.out.println("x: ");
		x = in.nextInt();
		System.out.println("y: ");
		y = in.nextInt();
		System.out.println("n: ");
		n = in.nextInt();
		SternBrocot sternBrocot = new SternBrocot();
		sternBrocot.setMaxLevel(n);
		sternBrocot.build(0, 1, 1, 0, 1, n);
		System.out.println(String.format("Fraction: %d/%d, depth: %d", x, y, n));
		System.out.printf(sternBrocot.toString());
		System.out.printf("\n\nPath from root 1/1 to solution: " + sternBrocot.find(x, y, 0, 1, 1, 0, 1, n));
	}

}
