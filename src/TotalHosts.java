import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TotalHosts {
    static Map<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args) {
		//Reading a file line by line
		try {
			BufferedReader br = new BufferedReader(new FileReader("log.txt"));
			
			String line = null;
			try {
				while((line = br.readLine()) != null) {
					String[] temp = line.split(" ");
					if(hm.containsKey(temp[0])) {
						hm.put(temp[0], hm.get(temp[0])+1);
					}else {
						hm.put(temp[0], 1);
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
			wr.write(hm);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(hm);
	}
}
