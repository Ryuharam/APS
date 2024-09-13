package api;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        // 1. JSON 파일에서 역 정보 파싱
        JsonArray people = StationParser.parseStationsFromJson("./data.json");

        // 2. 선택된 사람들의 좌표 가져오기
        System.out.println("사람들의 수는 : " + people.size());
        double[][] coordinates = new double[people.size()][2];

        
        for (int i = 0; i < people.size(); i++) {
        
            System.out.println(i + " 번째 사람의 정보 : ");
            JsonObject person = people.get(i).getAsJsonObject();
            String station = person.get("location").getAsString();
            System.out.println(station + " 입니다");
            JsonObject location = CoordinatesFetcher.getCoordinates(station);
//            CoordinatesFetcher.getCoordinates(station);
            
            if (location != null) {
                coordinates[i][0] = location.get("y").getAsDouble(); // 위도
                coordinates[i][1] = location.get("x").getAsDouble(); // 경도
                
                System.out.println("x 좌표는 : " +  coordinates[i][0] );
                System.out.println("y 좌표는 : " +  coordinates[i][1] );
            } else {
                System.out.println("잘못된 역이름 입니다");
            }
        }

        // 3. 중간 지점 계산 및 출력
        double[] midpoint = MeetingPointCalculator.calculateMidpoint(coordinates);
        System.out.println("최적의 만남 장소의 위도: " + midpoint[0] + ", 경도: " + midpoint[1]);
        
        
        
        
        
    }
}
