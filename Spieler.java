class Spieler {
    private String surname;
    private String name;
    private String land;
    private String club;
    private int strength;
    public Spieler(String surname, String name, String land, String club, int strength) {
	this.surname=surname;
	this.name=name;
	this.land=land;
	this.club=club;
	this.strength=strength;
    }
    public void setSurname(String surname) {
	this.surname=surname;
    }
    public String getSurname() {
	return  surname;
    }
    public void setName(String name) {
	this.name=name;
    }
    public String getName() {
	return  name;
    }
    public void setLand(String land) {
	this.land=land;
    }
    public String getLand() {
	return  land;
    }
    public void setClub(String club) {
	this.club=club;
    }
    public String getClub() {
	return  club;
    }
    public void setStrength(int strength) {
	this.strength=strength;
    }
    public int getStrength() {
	return  strength;
    }
    public String getStringStrength() {
	if(strength>0)
	    return (strength + "-Dan");
	return(+1-strength + "-Kyu");
    }
}
