import java.util.*;

class Tourney {

    // a round is an ArrayList <Encounter>, so the whole tourney consists
    // of an ArrayList <ArrayList <Encounter> >.

    private ArrayList <Player> players;

    private ArrayList <ArrayList <Encounter> > rounds;

    private int lowerBar; // players <= this strength start at mms = 0
    private int upperBar; // players >= this start at mss = upper-lower

    private HashMap <Player, Integer> mms;
    private HashMap <Player, Integer> sos;
    private HashMap <Player, Integer> sosos;



    public void addPlayer(Player p)
    {
        players.add(p);
    }

    // not sure if we need this, change if wanted
    public ArrayList <Player> getPlayers()
    {
        return players;
    }

    public void updateScores()
    {
        // this updates all maps with new mms, sos, sosos
    }

}
