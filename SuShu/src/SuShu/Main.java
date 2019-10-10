package SuShu;
import java.util.ArrayList;

public class Main {
	public static int[] SuShu(int length) {
		int temp = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=length;i++) {
			if(i%2!=0) {
				list.add(i);
			}
		}
		int returnShuzu[] = new int[list.size()];
		for(int t=0;t<list.size();t++) {
			returnShuzu[t]=list.get(t);
		}
		return returnShuzu;
	}

	public static void main(String[] args) {
		int [] shuzu = SuShu(20000);
		int num = shuzu.length%5;
		for(int i=0;i<shuzu.length-num;i=i+5) {
			for(int t=0;t<5;t++) {
				System.out.print(shuzu[t+i]+" ");
			}
			System.out.println();
		}
		for(int t=0;t<num;t++) {
			System.out.println(shuzu[shuzu.length-num+t]);
		}
		
	}

}
