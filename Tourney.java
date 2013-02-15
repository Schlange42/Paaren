import java.util.*;
import java.math.*;

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

    private int reducedHandi;



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



    public void makepairings(int round) {
        updateScores();
        double[][] edges = new double[players.size()][(players.size()*(players.size()-1))/2];
        double[] cost = new double[(players.size()*(players.size()-1))/2];
        double[] b = new double[players.size()];
        double[] solution = new double[(players.size()*(players.size()-1))/2];
        int k=0;
        for(int i=0; i<players.size(); i++) {
            b[i]=1;
            for(int j=i+1; j<players.size(); j++) {
                edges[i][k]=1;
                edges[j][k]=1;
                k++;
                cost[k]=1/(Math.abs(mms.get(players.get(i))-mms.get(players.get(j))));
            }
        }
        Simplex sp = new Simplex(edges,b,cost); 
        solution = sp.primal();
        k=0;
        for(int i=0; i<(players.size()*(players.size()-1))/2; i++){
            boolean bw=true;
            if(solution[i]==1) {
                for(int j=0; j<players.size(); j++) {
                    if(edges[j][i]==1 && !bw) {
                        rounds.get(round).get(k).setBlack(players.get(j));
                        bw=false;
                    }
                    if(edges[j][i]==1 && bw) {
                        rounds.get(round).get(k).setWhite(players.get(j));
                    }
                }
                Player black = rounds.get(round).get(k).getBlack();
                Player white = rounds.get(round).get(k).getWhite();
                if(Math.abs(mms.get(black)-mms.get(white))>reducedHandi) {
                    if(mms.get(black)>mms.get(white)) {
                        Player p = black;
                        rounds.get(round).get(k).setWhite(black);
                        rounds.get(round).get(k).setBlack(p);
                        rounds.get(round).get(k).setHandicap(mms.get(black)-mms.get(white)-reducedHandi);
                    }
                } else {
                    int blacksum=0, whitesum=0;
                    for(int j=0; j<round;j++) {
                        for(int t = 0; t<rounds.get(round).size();t++) {
                            if(rounds.get(round).get(t).getBlack()==black)
                                blacksum++;
                            if(rounds.get(round).get(t).getBlack()==white)
                                whitesum++;

                        }
                    }
                    if(whitesum<blacksum) {
                        Player p = black;
                        rounds.get(round).get(k).setWhite(black);
                        rounds.get(round).get(k).setBlack(p);
                    }
                }
            }
            k++;
        }
    }
}
