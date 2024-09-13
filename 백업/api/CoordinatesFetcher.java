package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CoordinatesFetcher {
    private static final String API_KEY = "25bef52da531b6fd0bb5f8cf1a02a02a";

    public static JsonObject getCoordinates(String stationName) {
        try {
            // 역 이름을 UTF-8로 인코딩
            String encodedStationName = URLEncoder.encode(stationName, "UTF-8");
            String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" + encodedStationName;

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // Gson 객체를 사용하여 JSON 문자열을 JsonObject로 변환
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            JsonArray documents = jsonResponse.getAsJsonArray("documents");

            System.out.println(documents.toString());
            
            
            // 검색 결과가 없는 경우 null 반환
            if (documents.size() == 0) {
                System.out.println("검색 결과가 없습니다.");
                return null;
            }

            // 첫 번째 결과 반환
            return documents.get(0).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
