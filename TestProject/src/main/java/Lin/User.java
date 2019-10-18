package mathquiz;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class User {

    private int score=0;  //20
    private Map<String, Integer> userMap;
    private String name;  //lin

    public User(String name) {
        this.name = name;
        getUserInfo();
    }

    public void setScore(int s) {  //s=30
        for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
            if (name.equals(entry.getKey())) {  
                entry.setValue(s);   //lin->30
            }
        }
        score = s;
    }

    public int getScore() {
        return score;  //20
    }

    public void getUserInfo() {
        String path = "C:\\Users\\LENOVO\\Desktop\\users.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            userMap = new HashMap<>();
            if ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                userMap.put(str[0], Integer.parseInt(str[1]));  //把已存在的信息加到userMap里
            }
            if (userMap.containsKey(name)) {  //如果名字重复
                for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        score = entry.getValue();   //20
                    }
                }

            } else {  //如果名字不重复
                userMap.put(name, score);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFile() {
        String path = "C:\\Users\\LENOVO\\Desktop\\users.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
                String info = entry.getKey() + " " + entry.getValue();
                bw.write(info);
                bw.newLine();
            }
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
