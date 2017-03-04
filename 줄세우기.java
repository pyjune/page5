// acmicpc.net 2252번(줄 세우기) 통과 코드..
// 인접리스트 + 위상정렬

import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int M;
	static int [][] L;
	static int []IND;
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		//int T = sc.nextInt();
		//for(int tc = 1; tc<=T; tc++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			L = new int [M][2];
			IND = new int [N+1];
			A = new ArrayList[N+1];
			for(int i = 0; i<=N; i++)
				A[i] = new ArrayList<>();
			for(int i = 0; i<M; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				A[n1].add(n2);
				IND[n2]++; // 진입차수 계산
			}
			psort();
		}
	}
	public static void psort()
	{
		Queue <Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++)
		{
			if(IND[i]==0)
				q.add(i);
		}
		while(!q.isEmpty())
		{
			int t = q.poll();
			System.out.print(t+" ");
			for(int i = 0; i<A[t].size();i++)
			{
				int n = A[t].get(i);
				IND[n]--;
				if(IND[n]==0)
					q.add(n);
			}
		}
		System.out.println();
	}
}
