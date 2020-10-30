/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pera
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchFinds() {
        Player p = stats.search("Kurri");
        assertNotNull(p);
    }

    @Test
    public void searchReturnsNull() {
        Player p = stats.search("Batman");
        assertNull(p);
    }

    @Test
    public void teamWorks() {
        List<Player> t = stats.team("EDM");
        assertEquals(3, t.size());
    }

    @Test
    public void topScorersWorks() {
        List<Player> t = stats.topScorers(2);
        assertEquals(3, t.size());
        assertTrue("Gretzky".equals(t.get(0).getName()));
    }
}
