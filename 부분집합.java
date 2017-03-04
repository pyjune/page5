import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] arr;
	static int [] arr2 = {10, 20, 30};
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		arr = new int[3];
		

		f(0, 3);	

	}
	
	public static void f(int n, int k)
	{
		if(n==k)
		{
			for(int i = 0; i<k; i++)
			{
				if(arr[i]==1)
					System.out.print(arr2[i] +" ");
			}
			System.out.println();
			return;
		}
		else
		{
			for(int i=0; i<=1; i++)
			{
				arr[n] = i;
				f(n+1, k);
			}

		}
	}

}
