package xyz.akopartem.subtracker_server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.*;

@SpringBootApplication
public class SubtrackerServerApplication {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                if (Calendar.getInstance().get(Calendar.HOUR) == 12) {
                    HashMap<String, List<Sub>> subs = new HashMap<>();
                    String src = "";
                    if (new Date().getHours() == 12) {
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
                                    s.setLastDate(LocalDate.now().minusDays(1).toString());
                                    if (subs.containsKey(u.getToken())) {
                                        subs.get(u.getToken()).add(s);
                                    } else {
                                        ArrayList<Sub> arr = new ArrayList<>();
                                        arr.add(s);
                                        subs.put(u.getToken(), arr);
                                    }
                                    Retrofit retrofit = new Retrofit.Builder()
                                            .baseUrl("https://fcm.googleapis.com/")
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();
                                    String token = u.getToken();
                                    Notification n = new Notification(token, "type_b", new Notification__1("Завтра, " +
                                            LocalDate.now().getDayOfMonth() + " " +
                                            new SimpleDateFormat("MMMM", Locale.getDefault()).format(new Date()) +
                                            ", запланировано списние " + s.getPrice() + " рублей за подписку " + s.getName()
                                            , s.getName()));
                                    SendPush sp = retrofit.create(SendPush.class);
                                    Call<Resp> a = sp.send(n);
                                    try {
                                        if (a.execute().code() != 200) {

                                        }
                                        ;
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
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
                    }
                }
            }
        };
        timer.schedule(tt, 1000, 1000 * 60);
        SpringApplication.run(SubtrackerServerApplication.class, args);
    }

    public interface SendPush {
        String token = "key=AAAANLqYVPM:APA91bFKLZcsakcaStlWvrrIrmXPPT72qIpL0UjFy2gdc1SRON-0FlKEX23YXTRffC_LfMP2OpUCNpsc0OYbC59gqdQbXlg_9tGQCjTiImxqIttnpBMMIeMr6aeGTun-o8jAqkKIXN3V";

        @Headers({"Content-Type: application/json", "Authorization: " + token})
        @POST("fcm/send")
        Call<Resp> send(@Body Notification user);
    }
}
