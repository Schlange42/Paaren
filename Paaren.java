import java.util.*;
import java.io.*;

class Paaren {
    public static void main(String[] args)
        throws IOException
    {
        System.out.println("Hallo Welt.");

        if (args.length != 1) {
            System.err.println("Genau ein Dateiname zum Einlesen bitte.");
            return;
        }
        ArrayList <Player> plist = readPlayerFile(args[0]);

        System.out.println("Anzahl Spieler: " + plist.size());
        for (int i = 0; i < plist.size(); ++i) {
            System.out.println(plist.get(i).toString());
        }
    }



    private static ArrayList<Player> readPlayerFile(String filename)
        throws IOException
    {
        ArrayList<Player> plist = new ArrayList<Player>();
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        while((line = in.readLine()) != null){
            if(line == "" || line.startsWith("#"))
                continue;
            String[] linepart = line.split(";");
            if(linepart.length != Player.PARAM){
                System.err.println("fehlerhafter Spieler: " + line);
                continue;
            }
            Player p = new Player(linepart[0], linepart[1], linepart[2], linepart[3], linepart[4]);
            if(!p.isValid()) {
                System.err.println("Spieler hat zu wenige oder nicht sinnvolle Parameter: " + p);
                continue;
            }
            plist.add(p);
        }
        return plist;
    }
}
