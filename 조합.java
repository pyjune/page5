
public class Solution {
	
	static int [] a = {1, 2, 3};
	static int [] c;
	public static void main(String[] args) throws Exception{
		c = new int[2];
		
		nCk(3, 2, 2);
	}
	// n 남은 개수, k는 남은 수에서 골라야 하는 개수, m은 조합의 크기 
	public static void nCk(int n, int k, int m)
	{
		if(k==0)
		{
			for(int i = 0; i<m;i++)
				System.out.print(c[i]+" ");
			System.out.println();
		}
		else if(n<k)
		{
			return; 
		}
		else
		{
			c[k-1] = a[n-1];
			nCk(n-1, k-1, m);
			nCk(n-1, k, m);
		}
	}
}
