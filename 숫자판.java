import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] map;
	static int N; // 수열의 길이
	static int [] arr;
	static int M; // 숫자판의 가로 세로 크기
	static int [][]used;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			N = sc.nextInt();
			arr = new int [N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			M = sc.nextInt();
			map = new int [M][M];
			used = new int [M][M];
			for(int i = 0; i<M; i++)
				for(int j = 0; j<M; j++)
					map[i][j] = sc.nextInt();
			// 첫번째 숫자 자리 찾기..
			int r=0;
			for(int i = 0; i<M; i++)
			{
				for(int j = 0; j<M; j++)
				{
					if(map[i][j]==arr[0])
					{
						r = find(i, j, 1, N);
						if(r==1)
							break;
					}
				}
				if(r==1)
					break;
			}
			System.out.println("#"+tc+" "+r);
		}
	}
	public static int find(int r, int c, int n, int k)
	{
		int [] dr = { 0, 1, 0, -1};
		int [] dc = { 1, 0, -1, 0};
		if(n==k)
		{
			return 1;
		}
		else
		{
			used[r][c] = 1;
			for(int i=0; i<4; i++)
			{
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<M && nc>=0 && nc<M)
				{
					if(map[nr][nc] == arr[n]&&used[nr][nc]==0)
						if(find(nr, nc, n+1, k)==1)
							return 1;
				}
			}
			return 0;
		}
	}
}
