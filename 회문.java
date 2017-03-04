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
			for(int i = 0; i<N; i++)
			{
				for(int j = 0; j<=N-M; j++ )
				{
					for(k=0; k<M/2; k++)
					{
						if(board[i][j+k]!=board[i][j+M-k-1])
							break;
					}
					if(k==M/2)
					{
						for(int l=0; l<M; l++)
							palindrome += board[i][j+l];
						break;
					}
					for(k=0; k<M/2; k++)
					{
						if(board[j+k][i]!=board[j+M-k-1][i])
							break;
					}
					if(k==M/2)
					{
						for(int l=0; l<M; l++)
							palindrome += board[j+l][i];
						break;
					}
				}
				if(k==M/2)
					break;
			}
				System.out.println("#"+tc+" "+palindrome);
		}
	}

}
