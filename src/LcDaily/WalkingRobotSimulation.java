package LcDaily;

import sun.security.krb5.Asn1Exception;

public class WalkingRobotSimulation {
	public static void main(String[] args) {
		int[] commands = {7,-2,-2,7,5};
		int[][] obstacles = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};

		System.out.println(robotSim(commands, obstacles));
		// -2 turn left 90
		// -1 turn right 90
	}

	public static int robotSim(int[] commands, int[][] obstacles) {

		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int currdir = 1;
		int ix = 0;
		int iy = 0;
		int maxans=0;
		for (int i : commands) {
			switch (i) {

			case -2:
				currdir = Math.abs(currdir - 1+4) % 4;
				break;
			case -1:

				currdir = Math.abs(currdir + 1+4) % 4;
				break;
			default:
				int count = i;
				while (count != 0) {
					if (checkIfNextStepisSafe(ix + direction[currdir][0], iy + direction[currdir][1], obstacles))
					{
						ix = ix + direction[currdir][0];
						iy = iy + direction[currdir][1];
						count--;
					}
					else
					{
						break;
					}
					
				}
				double ansAtPoint=Math.pow(ix, 2)+Math.pow(iy, 2);
				maxans=(int) Math.max(maxans,ansAtPoint);
			}
		}
		return maxans;

	}

	private static boolean checkIfNextStepisSafe(int i, int j, int[][] obstacles) {
		for (int[] a : obstacles) {
			if (i == a[0] && j == a[1]) {
				return false;
			}
		}
		return true;
	}
}
