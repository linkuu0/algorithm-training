package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {

    public boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();
        for (String phone: phone_book) {
            map.put(phone, "");
        }

        for (String phone: phone_book) {
            for (int j = 0; j < phone.length(); j++) {
                if (map.containsKey(phone.substring(0, j)))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();
        boolean answer = phoneList.solution(new String[]{});

        System.out.println("answer = " + answer);

    }
}
