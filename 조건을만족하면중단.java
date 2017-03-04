// v를 찾으면 검색 중단..
// v가 있으면 1, 없으면 0 출력..

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] arr = { 3, 7, 6, 2, 1, 4, 8, 5};

	public static void main(String[] args) throws Exception{
		
		int r = find(0, 8, 5);
		System.out.println(r);
	}
	
	public static int find(int n, int k, int v)
	{
		if(n==k)
			return 0;
		else if(arr[n] == v)
		{
			return 1;
		}
		else
		{
			int r = find(n+1, k, v);
			if(r==1)
				return 1;
			return 0;
		}
	}
}
