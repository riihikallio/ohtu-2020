package ohtu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        ArrayList<Player> players = mapper.fromJson(bodyText, new TypeToken<List<Player>>(){}.getType());
        Collections.sort(players, Collections.reverseOrder());

        for (Player player : players) {
            if ("FIN".equals(player.getNationality())) {
                String t = player.getName().length()<16 ? "\t\t" : "\t";
                System.out.printf("%-22s%s  %3d +%3d =%3d\n",player.getName(),player.getNationality(),
                        player.getGoals(),player.getAssists(),(player.getGoals()+player.getAssists()));
            }
        }
    }

}
