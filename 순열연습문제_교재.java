/* 교재 순열 연습 문제
1
3
13 8 10
7 10 12
12 8 10
 */


import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] t;
	static int [] p;
	static int [] used;
	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			t = new int[N][N];
			p = new int[N];
			used = new int[N];
			for(int i = 0; i<N; i++)
				for(int j= 0; j<N; j++)
					t[i][j] = sc.nextInt();
			
			npr(0, N);

		}
	}
	public static void npr(int n, int k)
	{
		if(n==k)
		{
			int sum = 0;
			for(int i = 0; i<k; i++)
			{
				sum += t[p[i]][i];
				System.out.print(p[i]);
			}
			System.out.println(" "+sum);
		}
		else
		{
			for(int i = 0; i<k;i++)
			{
				if(used[i]==0)
				{
					used[i] = 1;
					p[n] = i; // 인덱스와 사용할 값이 같으므로 i를 그냥 사용..
					npr(n+1, k);
					used[i] = 0;
				}
			}
		}
	}
}
