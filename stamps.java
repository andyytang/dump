/*
ID: .andy.schobo
LANG: JAVA
TASK: stamps
 */
import java.io.*;
import java.util.*;

public class stamps {

	public int solve(int maxStamps, int[] stamps) {
		Arrays.sort(stamps);
		int maxValue = stamps[stamps.length - 1] * maxStamps;

		int[] dp = new int[maxValue + 1];
		for (int i = 1; i < dp.length;i++) {
			dp[i] = maxStamps + 1; // set a big number
		}
		
		for (int i = 1; i <= maxValue; i++) {
			for (int v : stamps) {
				if (i - v < 0) continue;
				dp[i] = Math.min(dp[i], dp[i - v] + 1);
			}
			if (dp[i] > maxStamps) return i - 1;
		}
		
		return maxValue;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "stamps";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] stamps = new int[k];

		String line = f.readLine();
		int p = 0;
		while (line != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				stamps[p++] = Integer.parseInt(st.nextToken());
			}
			line = f.readLine();
		}

		int res = (new stamps()).solve(n, stamps);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}