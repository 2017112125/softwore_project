package shuzu;

import java.util.Scanner;

public class Main {
	public static int  MaxZiShuZu(int [] shuzu,int length) {
		int max = shuzu[0];
		int total = 0;
		int temp = 0;
		for(int x=0;x<length;x++) {
			total = 0;
			for(int i=x;i<length;i++) {
				total = total+shuzu[i];
				if(max<total) {
					max = total;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������������顪�������ʽ:1 -2 3 5 -1");
		System.out.println("����س���ʾ�������");
		String str = sc.nextLine().toString();
		String arr[] = str.split(" ");
		int a[] = new int[arr.length];
		for(int j = 0; j < a.length; j++)
		{
			a[j] = Integer.parseInt(arr[j]);
		}
		int max = MaxZiShuZu(a,a.length);
		System.out.println("������֮�͵����ֵ"+max);

	}

}
