package xyz.akopartem.subtracker_server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    public HashMap<String , List<Sub>> test() {
        Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), because it is desperated.

        int hour = cal.get(Calendar.HOUR);//get the hour number of the day, from 0 to 23

        if (hour == 12) {
            HashMap<String, List<Sub>> subs = new HashMap<>();
            String src = "";
            Gson gson = new GsonBuilder().create();
            try (FileReader reader = new FileReader("src/main/java/xyz/akopartem/subtracker_server/users.json")) {
                StringBuilder sb = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    sb.append((char) c);
                }
                src = sb.toString();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
            List<User> array = new ArrayList<>(List.of(gson.fromJson(src, User[].class)));
            for (User u : array) {
                for (Sub s : u.getSubs()) {
                    if (LocalDate.parse(s.getLastDate()).plusDays(31).equals(LocalDate.now())) {
                        s.setLastDate(LocalDate.now().toString());
                        if (subs.containsKey(u.getToken())) {
                            subs.get(u.getToken()).add(s);
                        } else {
                            ArrayList<Sub> arr = new ArrayList<>();
                            arr.add(s);
                            subs.put(u.getToken(), arr);
                        }
                        System.out.println(s);
                    }
                }
            }
            try (FileWriter writer = new FileWriter("src/main/java/xyz/akopartem/subtracker_server/users.json", false)) {
                writer.write(gson.toJson(array));
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return subs;
        }
        return null;
    }
}
