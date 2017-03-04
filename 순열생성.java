// 5개의 숫자로 3자리 수를 만드는 경우..

public class Solution {
	static int [] arr = { 1,2,3,4, 5};
	static int [] p;
	static int [] used;
	static int cnt;
	public static void main(String[] args) throws Exception{
	
		p = new int[3];
		used = new int[5];
		cnt = 0;
		nPr(0, 3, 5);
	}
	public static void nPr(int n, int k, int m)
	{
		if(n==k)
		{
			System.out.print(cnt++ +" : ");
			for(int i = 0; i<k; i++)
				System.out.print(p[i] + " ");
			System.out.println();
		}
		else
		{
			for(int i=0; i<m; i++)
			{
				if(used[i]==0)
				{
					used[i] = 1;
					p[n] = arr[i];
					nPr(n+1, k, m);
					used[i] = 0;
				}
			}
		}
	}
}
/*
// 3개의 숫자로 3자리 수를 만드는 경우..
public class Solution {
	static int [] arr = { 1,2,3};
	static int [] p;
	static int [] used;
	public static void main(String[] args) throws Exception{
	
		p = new int[3];
		used = new int[3];
		
		nPr(0, 3);
	}
	public static void nPr(int n, int k)
	{
		if(n==k)
		{
			for(int i = 0; i<k; i++)
				System.out.print(p[i] + " ");
			System.out.println();
		}
		else
		{
			for(int i=0; i<k;i++)
			{
				if(used[i]==0)
				{
					used[i] = 1;
					p[n] = arr[i];
					nPr(n+1, k);
					used[i] = 0;
				}
			}
		}
	}
}
*/
