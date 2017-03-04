import java.util.Scanner;
import java.io.FileInputStream;

public class Soluition {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		char [][] board;
		String palindrome;
		int k = 0;
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			board = new char[N][N];
			palindrome = new String();
			for(int i = 0; i<N; i++)
			{
				board[i] = sc.next().toCharArray();
			}
			// User Code
      
      //
			System.out.println("#"+tc+" "+palindrome);
		}
	}

}
