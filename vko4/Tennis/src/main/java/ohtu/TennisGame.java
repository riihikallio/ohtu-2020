package ohtu;

public class TennisGame {

    private int player1 = 0;
    private int player2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String name) {
        if (player1Name.equals(name)) {
            player1 += 1;
        } else {
            player2 += 1;
        }
    }

    private String scoreName(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

    private String deuce() {
        StringBuilder str = new StringBuilder();
        str.append(scoreName(player1));
        if (player1 < 4) {
            str.append("-All");
        }
        return str.toString();
    }

    private String ads() {
        int difference = player1 - player2;
        if (difference == 1) {
            return "Advantage player1";
        } else if (difference == -1) {
            return "Advantage player2";
        } else if (difference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String normal() {
        StringBuilder str = new StringBuilder();
        str.append(scoreName(player1));
        str.append("-");
        str.append(scoreName(player2));
        return str.toString();
    }

    public String getScore() {
        if (player1 == player2) {
            return deuce();
        } else if (player1 >= 4 || player2 >= 4) {
            return ads();
        } else {
            return normal();
        }
    }
}
