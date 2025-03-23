package main.java;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONParser {

    public static void main(String[] args) {
        // JSON文件路径
        String filePath = "src/main/resources/data.json";

        try {
            // 读取并解析JSON文件
            JSONObject jsonObject = parseJSONFile(filePath);

            // 打印解析结果
            System.out.println("解析结果：");
            System.out.println("姓名： " + jsonObject.getString("name"));
            System.out.println("年龄： " + jsonObject.getInt("age"));
            System.out.println("城市： " + jsonObject.getJSONObject("address").getString("city"));
            System.out.println("爱好： " + jsonObject.getJSONArray("hobbies").toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JSONObject parseJSONFile(String filePath) throws IOException {
        // 读取文件内容
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();

        // 将内容转换为JSONObject
        return new JSONObject(sb.toString());
    }
}