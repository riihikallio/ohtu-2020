package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

//        Matcher m = new All();
//
//        Matcher m = new And(
//                new HasFewerThan(1, "goals"),
//                new PlaysIn("NYR")
//        );
//
//        Matcher m = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );
//        Matcher m = new And(
//                new HasAtLeast(50, "points"),
//                new Or(
//                        new PlaysIn("NYR"),
//                        new PlaysIn("NYI"),
//                        new PlaysIn("BOS")
//                )
//        );

        QueryBuilder query = new QueryBuilder();
        Matcher m = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "assists")
                        .hasFewerThan(5, "goals").build(),
                query.playsIn("EDM")
                        .hasAtLeast(40, "points").build()
        ).build();

        int count = 0;
        for (Player player : stats.matches(m)) {
            System.out.println(player);
            count++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Yhteensä " + count + " pelaajaa.");
    }
}
