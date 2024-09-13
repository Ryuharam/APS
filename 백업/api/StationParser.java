package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;

public class StationParser {

    // JSON 파일에서 역(stations) 정보를 파싱하는 메서드
    public static JsonArray parseStationsFromJson(String filePath) {
        try {
            // Gson 객체 생성
            Gson gson = new Gson();
            // 파일을 읽어 JsonObject로 파싱
            JsonObject jsonObject = gson.fromJson(new FileReader(filePath), JsonObject.class);
            // "people" 배열을 가져와 반환
            return jsonObject.getAsJsonArray("people");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
