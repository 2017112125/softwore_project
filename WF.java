import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class WF {

	private static final char A = 0;
	public Task task = new Task();
	

	//内部类Task,用于保存相关数据信息
	class Task{
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> shuliang = new ArrayList<Integer>();
		public void add(String key,Integer number) {
			if(list.size() == 0) {
				num.add(number);
				list.add(key);
			}else {
				num.add(number);
				list.add(key);
				for(int i=0;i<num.size();i++) {
					for(int j=i+1;j<num.size();j++) {
						if(num.get(i)<num.get(j)) {
							Integer temp = num.get(i);
							num.set(i,num.get(j));
							num.set(j, temp);
							String str1 = list.get(i);
							list.set(i, list.get(j));
							list.set(j, str1);
						}
					}
				}
				for(int i = 0;i<num.size();++i) {
					for(int j = i;j<num.size();++j) {
						if(num.get(i) == num.get(j)) {
							if(sortString(list.get(i), list.get(j)) == 1) {
								
								}else if(sortString(list.get(i), list.get(j)) == -1){
									String temp = list.get(i);
									list.set(i, list.get(j));
									list.set(j, temp);
									
									
								}
							}
						}
					}
				}
			
		}

		public void addNum(String key,Integer number,Integer wordNum) {
			if(list.size() == 0) {
				num.add(number);
				list.add(key);
				shuliang.add(wordNum);
			}else {
				num.add(number);
				list.add(key);
				shuliang.add(wordNum);
				for(int i=0;i<num.size();i++) {
					for(int j=i+1;j<num.size();j++) {
						if(num.get(i)<num.get(j)) {
							Integer temp = num.get(i);
							num.set(i,num.get(j));
							num.set(j, temp);
							String str1 = list.get(i);
							list.set(i, list.get(j));
							list.set(j, str1);
							Integer h = shuliang.get(i);
							shuliang.set(i, shuliang.get(j));
							shuliang.set(j, h);
						}
					}
				}
				for(int i = 0;i<num.size();++i) {
					for(int j = i;j<num.size();++j) {
						if(num.get(i) == num.get(j)) {
							if(sortString(list.get(i), list.get(j)) == 1) {
								
								}else if(sortString(list.get(i), list.get(j)) == -1){
									String temp = list.get(i);
									list.set(i, list.get(j));
									list.set(j, temp);
									Integer h = shuliang.get(i);
									shuliang.set(i, shuliang.get(j));
									shuliang.set(j, h);
								}
							}
						}
					}
				}
		}
		
		public void show() {
			for(int i = 0;i<num.size();++i) {
				//System.out.println(num.get(i));
				System.out.println(list.get(i)+" : "+num.get(i));
			}
		}
		
		public void showNumber(int n) {
			for(int i = 0;i<n;i++) {
				System.out.println(list.get(i)+" : "+num.get(i));
			}
		}
		
		public void showWord(int n) {
			for(int i = 0;i<shuliang.size();i++) {
				if(shuliang.get(i) == n) {
					System.out.println(list.get(i)+" : "+num.get(i));
				}
			}
		}
		
		//对两个字符串按照字典顺序进行排序
		//排序结果为1，代表str1在字典中应在str2之前
		public  int sortString(String str1,String str2) {
			int result = 1;//保存返回结果
			char [] a = str1.toCharArray();//将str1转换成char数组
			char [] b = str2.toCharArray();//将str2转换成char数组
			//判断两个数组长度的最小值
			int length = a.length;
			int temp = 1;
			if(b.length < a.length) {
				length = b.length;
				temp = 2;
			}
			
			for(int i = 0;i<length;++i) {
				if(a[i] > b[i]) {
					result = -1;
					break;
				}else if(a[i] == b[i]) {
					result = 1;
				}else if(a[i] < b[i]) {
					result = 1;
					temp = 3;
					break;
				}
			}
			if(result == 1) {
				if(temp == 3) {
					result = 1;
				}else if(temp == 1) {
					result = 1;
				}else if(temp == 2) {
					result = -1;
				}
			}
			
			return result;
		}

		
	}

	//读取文件的方法
	public static StringBuilder readTxt(String filePath) {
			StringBuilder content = new StringBuilder();
 
		  try {
		    File file = new File(filePath);
		    if(file.isFile() && file.exists()) {
		      InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		      BufferedReader br = new BufferedReader(isr);
		      String lineTxt = null;
		      while ((lineTxt = br.readLine()) != null) {
		        //System.out.println(lineTxt);
		      	content.append(lineTxt+"\n");
		      }
		      br.close();
		    } else {
		      System.out.println("文件不存在!");
		    }
		  } catch (Exception e) {
		    System.out.println("文件读取错误");
		  }finally{
		  		return content;
		  }


		  //统计单词数
		
 
  }
	
	//统计字母个数
	public static void charNumber(StringBuilder content){
			String charNumber = content.toString();
			char c[] = charNumber.toCharArray();
			int [] d = new int[26];
			for(int i=0;i<d.length;++i) {
				d[i] = 0;
			}
			int length = c.length;
			System.out.println("数组长度为 "+length);
			for(int i = 0;i<length;++i){
					if(c[i]>='a' && c[i]<='z')
						d[c[i]-'a']++;
					if(c[i]>='A' && c[i]<='Z')
						d[c[i]-'A']++;
			}
			for(int i=0;i<d.length;i++){
				System.out.println(d);
			}
		}
  
	//统计单词个数
	public void wordNumber(StringBuilder content){
		int STATE = -1;//用于判断是否在单词中
		//STATE = -1 表示在单词外
		//STATE = 1 表示在单词中
		int TEMP = 1;
		int TIAN = -1;
		String charNumber = content.toString();
		char c [] = charNumber.toCharArray();
		
		int sum = 0;//用于保存单词数目
		StringBuilder str1 = new StringBuilder();
		for(int i = 0;i<c.length;++i){
				if(c[i] >= 'a' && c[i] <= 'z'){
					STATE = 1;
					TIAN = 1;
					str1.append(c[i]);
				}else if(c[i] >= 'A' && c[i] <= 'Z'){
					STATE = 1;
					TIAN = 1;
					c[i] += 'a' - 'A';
					str1.append(c[i]);
				}else if(c[i] >= '0' && c[i] <= '9'){
					str1.append(c[i]);
				}else{
					STATE = -1;
				}
				

				if(STATE == 1){

					if(STATE * TEMP == 1){
						sum++;
						TEMP = -1;
					}
				}else{
					TEMP = 1;
				}
				
				if(STATE == -1) {
					
					if(TIAN * 1 == 1) {
						str1.append(" ");
						TIAN = -1;
					}else {
						TIAN = -1;
					}
				}

		}
		//System.out.println("单词数量 = " + sum);
		String str2 = str1.toString();
		//System.out.println(str2);
		String [] str3 = str2.split(" ");
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		for(int c1 =0;c1<str3.length;++c1) {
			//System.out.println(str3[c1]);
			if(hashmap.get(str3[c1])==null) {
				Integer i = 1;
				hashmap.put(str3[c1], i);
			}else {
				int i = hashmap.get(str3[c1]);
				i += 1;
				hashmap.put(str3[c1],i);
			}
			
		}
		
		Task task = new Task();
		for(Map.Entry<String, Integer> entry: hashmap.entrySet())
        {
	         //System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
	         task.add(entry.getKey(), entry.getValue());
        }
			task.show();
	}
	
	//统计一定数量的单词个数
	public void wordNumberAndNumber(StringBuilder content,int inputNumber) {
		int STATE = -1;//用于判断是否在单词中
		//STATE = -1 表示在单词外
		//STATE = 1 表示在单词中
		int TEMP = 1;
		int TIAN = -1;
		String charNumber = content.toString();
		char c [] = charNumber.toCharArray();
		
		int sum = 0;//用于保存单词数目
		StringBuilder str1 = new StringBuilder();
		for(int i = 0;i<c.length;++i){
				if(c[i] >= 'a' && c[i] <= 'z'){
					STATE = 1;
					TIAN = 1;
					str1.append(c[i]);
				}else if(c[i] >= 'A' && c[i] <= 'Z'){
					STATE = 1;
					TIAN = 1;
					c[i] += 'a' - 'A';
					str1.append(c[i]);
				}else if(c[i] >= '0' && c[i] <= '9'){
					str1.append(c[i]);
				}else{
					STATE = -1;
				}
				

				if(STATE == 1){

					if(STATE * TEMP == 1){
						sum++;
						TEMP = -1;
					}
				}else{
					TEMP = 1;
				}
				
				if(STATE == -1) {
					
					if(TIAN * 1 == 1) {
						str1.append(" ");
						TIAN = -1;
					}else {
						TIAN = -1;
					}
				}

		}
		//System.out.println("单词数量 = " + sum);
		String str2 = str1.toString();
		//System.out.println(str2);
		String [] str3 = str2.split(" ");
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		for(int c1 =0;c1<str3.length;++c1) {
			//System.out.println(str3[c1]);
			if(hashmap.get(str3[c1])==null) {
				Integer i = 1;
				hashmap.put(str3[c1], i);
			}else {
				int i = hashmap.get(str3[c1]);
				i += 1;
				hashmap.put(str3[c1],i);
			}
			
		}
		Task task = new Task();
		
		for(Map.Entry<String, Integer> entry: hashmap.entrySet())
        {
         //System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
         task.add(entry.getKey(), entry.getValue());
        }
		if(inputNumber>sum) {
			System.out.println("没有这么多个单词可以输出");
		}else if(inputNumber == 0) {
			task.show();
		}else if(inputNumber < 0){
			System.out.println("你输入的数目不合法");
		}else {
			task.showNumber(inputNumber);
		}
		
		
	}
	
	//读取文件路径下的所有文件
	public void file(String filePath) {
		//String str = "C:\\\\Users\\\\13220\\\\Desktop\\\\目标目录";
			File file = new File(filePath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) {
					String fileName = fileList[i].getName();
					StringBuilder filestr = new StringBuilder();
					filestr.append(filePath);
					filestr.append("\\\\");
					filestr.append(fileName);
					//System.out.println(filestr.toString());
					StringBuilder content = readTxt(filestr.toString());
					System.out.println(fileName);
					wordNumber(content);
			        //System.out.println("文件：" + fileName);                
			       }		            
	//		    if (fileList[i].isDirectory()) {
	//		        String fileName = fileList[i].getName();
	//		        System.out.println("目录：" + fileName);        
	//		       }
			   }
	//		String strone = "C:\\Users\\13220\\Desktop\\目标目录\\HelloWorld.txt";
	//		StringBuilder content = readTxt(strone);
	//		System.out.println(content.toString());
	}

	//读取文件路径下的所有文件并根据单词数量进行输出
	public void fileNumber(String filePath, int intputNumber) {
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				String fileName = fileList[i].getName();
				StringBuilder filestr = new StringBuilder();
				filestr.append(filePath);
				filestr.append("\\\\");
				filestr.append(fileName);
				StringBuilder content = readTxt(filestr.toString());
				System.out.println(fileName);
				wordNumberAndNumber(content,intputNumber);            
		       }		            
		}
	}
	
	//读取文件路径下的所有文件和其子文件夹下的所有文件
	public void fileAndFolder(String filePath) {
		//String str = "C:\\\\Users\\\\13220\\\\Desktop\\\\目标目录";
			File file = new File(filePath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
//				if (fileList[i].isFile()) {
//					String fileName = fileList[i].getName();
//					StringBuilder filestr = new StringBuilder();
//					filestr.append(filePath);
//					filestr.append("\\\\");
//					filestr.append(fileName);
//					//System.out.println(filestr.toString());
//					StringBuilder content = readTxt(filestr.toString());
//					System.out.println(fileName);
//					wordNumber(content);
//				       //System.out.println("文件：" + fileName);                
//				     }		            
				 if (fileList[i].isDirectory()) {
				      String fileName = fileList[i].getName();
				      StringBuilder folder = new StringBuilder();
				      folder.append(filePath);
				      folder.append("\\");
				      folder.append(fileName);
				      //System.out.println(folder.toString());
				      System.out.println("目录：" + fileName); 
				      file(folder.toString());
				     }
			}
//			String strone = "C:\\Users\\13220\\Desktop\\目标目录\\HelloWorld.txt";
//			StringBuilder content = readTxt(strone);
//			System.out.println(content.toString());
	}
	
	//读取文件路径下的所有文件和其子文件夹下的所有文件
	public void fileAndFolderNumber(String filePath,int intputNumber) {
		//String str = "C:\\\\Users\\\\13220\\\\Desktop\\\\目标目录";
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				String fileName = fileList[i].getName();
				StringBuilder filestr = new StringBuilder();
				filestr.append(filePath);
				filestr.append("\\\\");
				filestr.append(fileName);
				StringBuilder content = readTxt(filestr.toString());
				System.out.println(fileName);
				wordNumberAndNumber(content,intputNumber);
			     }		            
			 if (fileList[i].isDirectory()) {
			      String fileName = fileList[i].getName();
			      StringBuilder folder = new StringBuilder();
			      folder.append(filePath);
			      folder.append("\\");
			      folder.append(fileName);
			      System.out.println("目录：" + fileName); 
			      fileNumber(folder.toString(),intputNumber);
			     }
		}
//		String strone = "C:\\Users\\13220\\Desktop\\目标目录\\HelloWorld.txt";
//		StringBuilder content = readTxt(strone);
//		System.out.println(content.toString());
	}
	
	//在统计单词时不统计跳词数组中的单词
	public void stopWord(StringBuilder content,String [] args) {
		int STATE = -1;//用于判断是否在单词中
		//STATE = -1 表示在单词外
		//STATE = 1 表示在单词中
		int TEMP = 1;
		int TIAN = -1;
		String charNumber = content.toString();
		char c [] = charNumber.toCharArray();
		
		int sum = 0;//用于保存单词数目
		StringBuilder str1 = new StringBuilder();
		for(int i = 0;i<c.length;++i){
				if(c[i] >= 'a' && c[i] <= 'z'){
					STATE = 1;
					TIAN = 1;
					str1.append(c[i]);
				}else if(c[i] >= 'A' && c[i] <= 'Z'){
					STATE = 1;
					TIAN = 1;
					c[i] += 'a' - 'A';
					str1.append(c[i]);
				}else if(c[i] >= '0' && c[i] <= '9'){
					str1.append(c[i]);
				}else{
					STATE = -1;
				}
				

				if(STATE == 1){

					if(STATE * TEMP == 1){
						sum++;
						TEMP = -1;
					}
				}else{
					TEMP = 1;
				}
				
				if(STATE == -1) {
					
					if(TIAN * 1 == 1) {
						str1.append(" ");
						TIAN = -1;
					}else {
						TIAN = -1;
					}
				}

		}
		//System.out.println("单词数量 = " + sum);
		String str2 = str1.toString();
		//System.out.println(str2);
		String [] str3 = str2.split(" ");
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		for(int c1 =0;c1<str3.length;++c1) {
			//System.out.println(str3[c1]);
			if(hashmap.get(str3[c1])==null) {
				Integer i = 1;
				hashmap.put(str3[c1], i);
			}else {
				int i = hashmap.get(str3[c1]);
				i += 1;
				hashmap.put(str3[c1],i);
			}
			
		}
		
		for(int i = 0;i<args.length;++i) {
			hashmap.remove(args[i]);
		}
		Task task = new Task();
		
		for(Map.Entry<String, Integer> entry: hashmap.entrySet())
        {
         //System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
         task.add(entry.getKey(), entry.getValue());
        }
		task.show();

	}
	
	//返回跳词表文件的内容并将其转化成String数组
	public String [] skipWord(StringBuilder content) {
		int STATE = -1;//用于判断是否在单词中
		//STATE = -1 表示在单词外
		//STATE = 1 表示在单词中
		int TEMP = 1;
		int TIAN = -1;
		String charNumber = content.toString();
		char c [] = charNumber.toCharArray();
		
		int sum = 0;//用于保存单词数目
		StringBuilder str1 = new StringBuilder();
		for(int i = 0;i<c.length;++i){
				if(c[i] >= 'a' && c[i] <= 'z'){
					STATE = 1;
					TIAN = 1;
					str1.append(c[i]);
				}else if(c[i] >= 'A' && c[i] <= 'Z'){
					STATE = 1;
					TIAN = 1;
					c[i] += 'a' - 'A';
					str1.append(c[i]);
				}else if(c[i] >= '0' && c[i] <= '9'){
					str1.append(c[i]);
				}else{
					STATE = -1;
				}
				

				if(STATE == 1){

					if(STATE * TEMP == 1){
						sum++;
						TEMP = -1;
					}
				}else{
					TEMP = 1;
				}
				
				if(STATE == -1) {
					
					if(TIAN * 1 == 1) {
						str1.append(" ");
						TIAN = -1;
					}else {
						TIAN = -1;
					}
				}

		}
		//System.out.println("单词数量 = " + sum);
		String str2 = str1.toString();
		//System.out.println(str2);
		String [] str3 = str2.split(" ");
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		for(int c1 =0;c1<str3.length;++c1) {
			//System.out.println(str3[c1]);
			if(hashmap.get(str3[c1])==null) {
				Integer i = 1;
				hashmap.put(str3[c1], i);
			}else {
				int i = hashmap.get(str3[c1]);
				i += 1;
				hashmap.put(str3[c1],i);
			}
			
		}
		//Task task = new Task();
		String [] result = new String[hashmap.size()];
		int i = 0;
		for(Map.Entry<String, Integer> entry: hashmap.entrySet())
        {
         //System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
         //task.add(entry.getKey(), entry.getValue());
			result[i++] = entry.getKey();
			
        }
		//task.show();
		//测试输出部分
//		for(int i1=0;i1<result.length;i1++) {
//			System.out.println(result[i1]);
//		}
		return result;

	}
	
	//统计指定单词数组的短语
	public void duanyu(StringBuilder content,int inputNum) {
		//如何判断短语
		//从第一个单词开始进行计数，若单词之间只有一个空格，则认为还是处于一个短语内
		int STATE = 0;
		int TEMP = -1;
		int TIAN = 1;
		String string = content.toString();
		//将文件内容变为字符数组
		char [] charNum = string.toCharArray();
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < charNum.length;i++) {
			if(charNum[i] >= 'a' && charNum[i] <= 'z') {
				STATE = 1;
				if(TEMP == 0) {
					result.append(" ");
				}
				TEMP = 1;
				TIAN = 0;
				result.append(charNum[i]);
			}else if(charNum[i] >= 'A' && charNum[i] <='Z') {
				STATE = 1;
				if(TEMP == 0) {
					result.append(" ");
				}
				TEMP = 1;
				TIAN = 0;
				result.append(charNum[i]);
			}else if(charNum[i] >= '0' && charNum[i] <='9') {
				result.append(charNum[i]);
				TIAN = 0;
			}else if(charNum[i] == ' ') {
				if(TEMP == 1) {//说明在这个空格之前是位于短语之中的
					TEMP = 0;//改变标志位
				}else if(TEMP == 0) {//说明遇到了两个空格
					result.append("#");
					STATE = 0;//位于空格外
					TEMP = -1;
				}
			}else {
				STATE = 0;
				TEMP = -2;
			}
			
			if(STATE == 0) {
				if(TEMP == -1) {
					
				}else if(TEMP == -2 && ++TIAN == 1){
					result.append("@");
				}
				
			}
			
		}	
		//System.out.println(result.toString());
		String str1 = result.toString();
		String [] numStr = str1.split("@");
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		for(int c1 =0;c1<numStr.length;++c1) {
			//System.out.println(str3[c1]);
			if(hashmap.get(numStr[c1])==null) {
				Integer i = 1;
				hashmap.put(numStr[c1], i);
			}else {
				int i = hashmap.get(numStr[c1]);
				i += 1;
				hashmap.put(numStr[c1],i);
			}
			
		}
		Task task = new Task();
		
		for(Map.Entry<String, Integer> entry: hashmap.entrySet())
        {
         //System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
         task.addNum(entry.getKey(), entry.getValue(),wordNum(entry.getKey()));
        }
		task.showWord(inputNum);
		
	}
	
	//根据字符串中的空格数量来判断短语中的单词数
	public Integer wordNum(String str) {
		char charNum [] = str.toCharArray();
		int sum = 1;
		for(int i = 0; i < charNum.length; ++i) {
			if(charNum[i] == ' ') {
				sum++;
			}
		}
		return sum;
	}
	
	//输出提示信息
	public void toshow() {
		System.out.println("你没有输入任何参数");
		System.out.println("请按照以下格式输出");
		System.out.println("-f <file> 输出文件中所有不重复的单词，按照出现次数由多到少排列，出现次数同样多的，以字典序排列。");
		System.out.println("-d <directory>  指定文件目录，对目录下每一个文件执行  wf.exe -f <file> 的操作。");
		System.out.println("-d -s  <directory>  同上， 但是会递归遍历目录下的所有子目录。");
		System.out.println("-n 支持 -n 参数，输出出现次数最多的前 n 个单词,当没有指明数量的时候，我们默认列出所有单词的频率。");
		System.out.println("-x <stopwordfile>  -f <file> 跳过出现在stopwordfile文件中的词");
		System.out.println("-p <number> 参数 <number> 说明要输出多少个词的短语，并按照出现频率排列。同一频率的词组， 按照字典序来排列。 ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long startTime = System.currentTimeMillis();//保存开始时间
		// WF wf = new WF();
		// int length = args.length;
		// if(length == 0) {
		// 	wf.toshow();
		// 	long endTime = System.currentTimeMillis();
		// 	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
		// 	return;
		// }
		// if(length == 2) {
		// 	if(args[0].equals("-f")) {
		// 		StringBuilder content = readTxt(args[1]);//读取路径中的内容
		// 		if(content.toString().equals("")) {
		// 			wf.toshow();
		// 			return;
		// 		}else {
		// 			wf.wordNumber(content);
		// 		}
		// 	}
		// }
		// //命令格式 -d "文件目录" -n number
		// if(args[0].equals("-d")) {
		// 	if(args[1].equals("-s")) {
		// 		if(args[length - 2].equals("-n")) {
		// 			int number = Integer.parseInt(args[length - 1]);
		// 			wf.fileAndFolderNumber(args[1], number);
		// 		}
		// 	}
		// }
		
		
		
		//命令行参数判断
		
		//根据命令行String数组的个数来进行相应的操作
		//
		long startTime = System.currentTimeMillis();//保存开始时间
		int NumLength = args.length;
		WF wf = new WF();
		
		if(NumLength == 2) {
			if(args[0].equals("-f")) {
				StringBuilder content = readTxt(args[1]);
				wf.wordNumber(content);
			}else if(args[0].equals("-d")) {
				wf.file(args[1]);
			}else {
				wf.toshow();
			}
		}
		if(NumLength == 3) {
			if(args[0].equals("-f") && args[1].equals("-s")) {
				wf.fileAndFolder(args[2]);
			}else {
				wf.toshow();
			}
		}
		if(NumLength == 4) {
			if(args[0].equals("-f")) {
				//形式-f filename -n 单词数量
				//输出文件中的前n个单词
				if(args[2].equals("-n")) {
					StringBuilder content = readTxt(args[1]);
					int inputNumber = Integer.parseInt(args[3]);
					wf.wordNumberAndNumber(content, inputNumber);
				}else if(args[2].equals("-x")) {
					//形式 -f filename -x 跳词表文件
					StringBuilder content = readTxt(args[3]);
					String [] skipWord = wf.skipWord(content);
					StringBuilder fileContent = readTxt(args[1]);
					wf.stopWord(fileContent, skipWord);
				}else if(args[2].equals("-p")){
					//形式 -f filename -p 短语单词数
					StringBuilder content = readTxt(args[1]);
					int inputNumber = Integer.parseInt(args[3]);
					wf.duanyu(content, inputNumber);
				}else{
					wf.toshow();
				}
			}else if(args[0].equals("-d")) {
				if(args[2].equals("-n")) {
					int intputNumber = Integer.parseInt(args[3]);
					wf.fileNumber(args[1], intputNumber);
				}else if(args[2].equals("-x")){
					//方法待补充
				}else if(args[2].equals("-p")) {
					//方法待补充
				}else {
					wf.toshow();
				}
				
			}else if(args[0].equals("-n")) {
				if(args[2].equals("-f")) {
					StringBuilder content = readTxt(args[3]);
					int inputNumber = Integer.parseInt(args[1]);
					wf.wordNumberAndNumber(content, inputNumber);
				}else if(args[2].equals("-d")) {
					//方法待补充
				}else {
					wf.toshow();
				}
				
			}else if(args[0].equals("-x")) {
				if(args[2].equals("-f")) {
					StringBuilder content = readTxt(args[1]);
					String [] skipWord = wf.skipWord(content);
					StringBuilder fileContent = readTxt(args[3]);
					wf.stopWord(fileContent, skipWord);
				}else if(args[2].equals("-d")) {
					//方法待补充
				}else {
					wf.toshow();
				}
				
			}else if(args[0].equals("-p")){
				if(args[2].equals("-f")) {
					StringBuilder content = readTxt(args[3]);
					int inputNumber = Integer.parseInt(args[1]);
					wf.duanyu(content, inputNumber);
				}else if(args[2].equals("-d")) {
					//方法待补充
				}else {
					wf.toshow();
				}
			}else {
				wf.toshow();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
	}


}