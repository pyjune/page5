import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int V;
	static int E;
	static int [][] adj;
	static int [] visited;
	static int cnt; // dfs2()
	static int min; // dfs3()
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			visited = new int [V+1];
			cnt = 0;
			min = Integer.MAX_VALUE;
			for(int i = 0 ; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
				//adj[n2][n1] = 1; // 무향그래프인 경우 추가..
			}
			//dfs(1);
			//dfs2(1, 4);
			// System.out.println(cnt);
			dfs3(1, 4, 0);
			System.out.println(min);
		}
	}
	public static void dfs3(int n, int k, int e)
	{
		if(n==k)
		{
			if(min>e)
				min = e;
		}
		else if(e>min) // backtracking.....option..
		{
			return;
		}
		else
		{
			visited[n] = 1;
			for(int i=1; i<=V; i++)
			{
				if(adj[n][i]==1 && visited[i]==0)
				{
					dfs3(i, k, e+1);
				}
			}
			visited[n] = 0;
		}
	}
	public static void dfs2(int n, int k)
	{
		if(n==k)
		{
			cnt++;
			//System.out.println(n);
		}
		else
		{
			visited[n] = 1;
			//System.out.print(n+" ");
			for(int i=1; i<=V; i++)
			{
				if(adj[n][i] == 1 && visited[i]==0)
				{
					dfs2(i, k);
				}
			}
			visited[n] = 0;
		}
	}
	public static void dfs(int n)
	{
		visited[n] = 1;
		System.out.print(n + " ");
		for(int i = 1; i<=V; i++)
		{
			if(adj[n][i]==1 && visited[i]==0)
			{
				dfs(i);
			}
		}
	}

}
