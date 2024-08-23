package LcDaily;

public class ConvertMin {
	
	static int numSteps(String s) {

		int count = 0;
		while (s.charAt(0) != 1) {
			if (s.charAt(s.length() - 1) == 0) {
				count++;

			} else {
				// parseInt+=1;
				count++;

			}
		}
		return count;

	}

	public static void main(String[] args) {
		String s = "1101";

		System.out.println(numSteps(s));
	}
}
