package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonSelector {

	
	static void selectPerson(JsonArray people) {

        if (people != null) {
            // 사람 목록 출력
            printPersonList(people);

            // 사용자 입력을 통해 사람 선택
            List<JsonObject> selectedPeople = selectPeopleByName(people);

            // 선택된 사람 출력
            for (JsonObject person : selectedPeople) {
                System.out.println(person);
            }
        }
	}
	

    // 사람 목록을 출력하는 메서드
    private static void printPersonList(JsonArray jsonArray) {
        System.out.println("사람 목록:");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject person = jsonArray.get(i).getAsJsonObject();
            System.out.println((i + 1) + ". 이름: " + person.get("name").getAsString() + ", 위치: " + person.get("location").getAsString());
        }
    }

    // 사용자로부터 이름으로 사람을 선택받는 메서드
    private static List<JsonObject> selectPeopleByName(JsonArray jsonArray) {
        Scanner scanner = new Scanner(System.in);
        List<JsonObject> selectedPeople = new ArrayList<>();
        List<String> names = new ArrayList<>();
        
        // 이름 리스트 만들기
        for (JsonElement element : jsonArray) {
            JsonObject person = element.getAsJsonObject();
            names.add(person.get("name").getAsString());
        }
        
        System.out.println("선택할 사람의 이름을 입력하세요. 종료는 '종료'를 입력하세요.");
        
        while (true) {
            System.out.print("입력: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("종료")) {
                break;
            }
            
            if (names.contains(input)) {
                // 입력한 이름과 일치하는 사람을 선택
                for (JsonElement element : jsonArray) {
                    JsonObject person = element.getAsJsonObject();
                    if (person.get("name").getAsString().equalsIgnoreCase(input)) {
                        selectedPeople.add(person);
                        break;
                    }
                }
            } else {
                System.out.println("이름이 목록에 없습니다. 다시 입력해 주세요.");
            }
        }
        
        scanner.close();
        return selectedPeople;
    }
}

