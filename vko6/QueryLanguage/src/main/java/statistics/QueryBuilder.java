/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.*;
import statistics.matcher.*;

/**
 *
 * @author pera
 */
public class QueryBuilder {

    private List<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
    }

    public Matcher build() {
        Matcher result = new And(matchers);
        this.matchers = new ArrayList<>();
        return result;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... ms) {
        this.matchers.add(new Or(ms));
        return this;
    }
}
