package xyz.akopartem.subtracker_server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

@RestController
public class TokenController {
    @PostMapping("/token")
    public Response token(@RequestBody HashMap<String, String> token) {
        System.out.println(token);
        Gson gson = new GsonBuilder().create();
        String src = "";
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
        array.add(new User(token.get("token"), new ArrayList<>()));
        try (FileWriter writer = new FileWriter("src/main/java/xyz/akopartem/subtracker_server/users.json", false)) {
            writer.write(gson.toJson(array));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new Response(200, "ok");
    }

    @PostMapping("/addSub")
    public Response add(@RequestBody String body) {
        System.out.println("add");
        Gson gson = new GsonBuilder().create();
        HashMap hm = gson.fromJson(body, HashMap.class);
        System.out.println(hm);
        String src = "";
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
        ArrayList<User> array = new ArrayList<>(List.of(gson.fromJson(src, User[].class)));
        for (User u : array) {
            if (u.getToken().equals(hm.get("token"))) {
                u.getSubs().add(new Sub((String) hm.get("name"), Integer.parseInt("" + hm.get("price")), (String) hm.get("lastDate")));
            }
        }
        try (FileWriter writer = new FileWriter("src/main/java/xyz/akopartem/subtracker_server/users.json", false)) {
            writer.write(gson.toJson(array));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new Response(200, "successful");
    }
    @PostMapping("/removeSub")
    public Response remove(@RequestBody String body) {
        System.out.println("rem");
        Gson gson = new GsonBuilder().create();
        HashMap hm = gson.fromJson(body, HashMap.class);
        System.out.println(hm);
        String src = "";
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
        ArrayList<User> array = new ArrayList<>(List.of(gson.fromJson(src, User[].class)));
        for (User u : array) {
            if (u.getToken().equals(hm.get("token"))) {
                u.getSubs().removeIf(s -> s.getName().equals(hm.get("name")) && s.getPrice().equals(Integer.parseInt((String) hm.get("price"))) && s.getLastDate().equals(hm.get("lastDate")));
            }
        }
        try (FileWriter writer = new FileWriter("src/main/java/xyz/akopartem/subtracker_server/users.json", false)) {
            writer.write(gson.toJson(array));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new Response(200, "successful");
    }
}
