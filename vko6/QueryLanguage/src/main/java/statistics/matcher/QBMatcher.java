package statistics.matcher;

import java.util.List;
import statistics.Player;

public class QBMatcher implements Matcher {
    private List<Matcher> matchers;

    public QBMatcher(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher m: matchers) {
            if(!m.matches(p)) {
                return false;
            }
        }
        return true;
    }
}
