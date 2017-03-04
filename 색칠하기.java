/* 2가지 색 사용. 인접노드는 서로 다른색.
 * 칠할 수 없는 경우 0, 칠할 수 있는 경우 많은 색의 노드 수와 번호 출력..
T
V E 다음 줄부터 E개의 간선

2
7 9
1 2
1 4
1 6
2 3
2 7
3 5
4 7
5 7
6 7
7 10
1 2
1 4
1 6
2 3
2 5
2 7
3 5
4 7
5 7
6 7
출력
#1 4 2 4 5 6
#2 0
*/

import java.util.*;
import java.io.FileInputStream;

public class Solution {
	static int V;
	static int E;
	static int [][] adj; // 인접행렬
	static int [] color; // 노드별 최장거리
	static int [] cnt;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			color = new int[V+1];
			cnt = new int[3]; // 1, 2로 칠해진 수 기록..0사용안함..
			
			for(int i=0;i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
			}
			int r = draw();
			if(r==0)
				System.out.println("#"+tc+" 0");
			else
			{
				
				r = cnt[1]>cnt[2]? 1 : 2 ;
				System.out.print("#"+tc+" "+cnt[r]);
				for(int i = 1; i<=V; i++)
				{
					if(color[i] ==r)
						System.out.print(" "+i);
				}
				System.out.println();
			}
		}
	}
	public static int draw()
	{
		Queue <Integer> q = new LinkedList<>();
		q.add(1);
		color[1] = 1;
		cnt[1]++;
		int result = 1;
		while(!q.isEmpty())
		{
			int t = q.poll();
			for(int i = 1; i<=V; i++)
			{
				if(adj[t][i]!=0)
				{
					if(color[t]==color[i]) //인접인데 같은 색이면..
					{
						result = 0;
						break;
					}
					else if(color[i]==0)
					{
						color[i] = color[t]==1?2:1;
						cnt[color[i]]++; // 색상별 노드수 카운트..
						q.add(i);
					}
				}
			}
			if(result == 0)
				break;
		}
		return result;
	}
}
