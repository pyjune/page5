/*
3
8
2 6 7
10
3 4 5 6
12
4 2 3 7 8
*/

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] len;
	static int cnt;
	static int [] used;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int l = sc.nextInt();
			int N = sc.nextInt();
			len = new int [N];
			used = new int [l+1];
			cnt = 0;
			for(int i = 0; i<N; i++)
			{
				len[i] = sc.nextInt();
			}
			find(0, l, N);
			System.out.println("#"+tc+" "+cnt);
		}
	}
	public static void find(int s, int l, int k)
	{
		if(s==l)
		{
			cnt++;
		}
		else if(s<0||s>l)
			return;
		else if(used[s]==1)
			return;
		else
		{
			used[s] = 1;
			for(int i = 0; i<k; i++)
			{
					find(s-len[i], l, k);
					find(s+len[i], l, k);
			}
		}
	}
}
