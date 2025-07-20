import java.io.*;
import java.util.*;

class People implements Comparable<People>{
    int age;
    String name;
    int order;
    
    public People(int age, String name, int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }
    
    public int compareTo(People o){
        if(this.age == o.age){
            return this.order - o.order;
        }
        return this.age - o.age;
    }
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        List<People> list = new ArrayList<>();
        
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new People(age, name, i));
        }
        
        Collections.sort(list);
        
        for(People p : list){
            sb.append(p.age+" "+p.name+"\n");
        }
        
        System.out.println(sb);
	}
}