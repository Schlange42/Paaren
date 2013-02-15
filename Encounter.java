import java.util.*;

    public enum Result {
        UNKNOWN, BLACK, WHITE, JIGO
    }
class Encounter{
    //enum Result {
    //    UNKNOWN, BLACK, WHITE, JIGO
    //}
    private Player black;
    private Player white;
    private int handicap;
    private Result result;
    public void setBlack(Player black) {
        this.black=black;
    }
    public Player getBlack(){
        return black;
    }
    public void setWhite(Player white) {
        this.white=white;
    }
    public Player getWhite(){
        return white;
    }
    public void setHandicap(int handicap) {
        this.handicap=handicap;
    }
    public int getHandicap(){
        return Handicap;
    }
    public void setResult(Result result) {
        this.result=result;
    }
    public Result getResult(){
        return result;
    }
}
