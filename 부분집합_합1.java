// 모든 부분 집합을 만들어서 해결하는 경우..
// 두 번째 테스트케이스까지만 적용 가능

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] L;
	static int [] arr;
	static int cnt;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++)
		{
			int N = sc.nextInt();
			int sum_K = sc.nextInt();

			arr = new int[N];
			L = new int [N];
			cnt = 0;
			
			for(int i = 0; i<N; i++)
			{
				arr[i] = i+1;
			}
			subset_sum(0, N, sum_K);
			System.out.println("#"+tc+" "+cnt);
			// System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	public static void subset_sum(int n, int k, int sum_k)
	{
		int sum =0;
		if(n==k)
		{
			for(int i = 0; i<k; i++)
			{
				if(L[i] == 1)
					sum += arr[i];
			}
			if( sum == sum_k)
			{
				cnt++;
			}

			return;
		}
		else
		{
			for(int i=0; i<=1; i++)
			{
				L[n] = i;
				subset_sum(n+1, k, sum_k);
			}

		}
	}

}
