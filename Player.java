class Player {

    public final int PARAM = 5; // number of ';'-separated parameters in
                                // a player line

    private String surname;
    private String name;
    private String land;
    private String club;
    private int strength;
    private boolean valid;

    public Player(String name, String surname, int strength,
     String land, String club)
    {
        this.surname=surname;
        this.name=name;
        this.land=land;
        this.club=club;
        this.strength=strength;

        valid = (name.length() > 0);
    }
    public Player(String name, String surname, String strength,
     String land, String club)
    {
        this.surname=surname;
        this.name=name;
        this.land=land;
        this.club=club;

        valid = (name.length() > 0);

        // try {
            setStrength(strength);
        /*}
        catch (StrengthParseError e) {
            valid = false;
        }*/
    }

    public boolean isValid() {
        return valid;
    }

    public void setSurname(String surname) {
        this.surname=surname;
    }
    public String getSurname() {
        return  surname;
    }
    public void setName(String name) {
        this.name=name;
        valid = (name.length() > 0);
    }
    public String getName() {
        return name;
    }
    public void setLand(String land) {
        this.land=land;
    }
    public String getLand() {
        return land;
    }
    public void setClub(String club) {
        this.club=club;
    }
    public String getClub() {
        return club;
    }
    public void setStrength(int strength) {
        this.strength=strength;
    }
    public void setStrength(String s) {
        strength = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                strength *= 10;
                strength += c - '0';
            }
            else if (c == 'k' || c == 'K') {
                // convert the (up to now assumed) dan rank into kyu
                strength = 1 - strength;
            }
        }
    }
    public int getStrength() {
        return strength;
    }
    public String getStringStrength() {
        if (strength > 0)
            return (strength + "-Dan");
        return ( +1 - strength + "-Kyu");
    }
}
