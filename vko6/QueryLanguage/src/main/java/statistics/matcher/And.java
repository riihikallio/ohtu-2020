package statistics.matcher;

import java.util.List;
import statistics.Player;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    public And(List<Matcher> matchers) {
        this.matchers = new Matcher[matchers.size()];
        this.matchers = matchers.toArray(this.matchers);
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
