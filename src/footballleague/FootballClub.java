package footballleague;

//@author Maria Bartoszuk

public class FootballClub {
    
    String clubName;
    String clubLocation;
    
    int numberOfWins;
    int numberOfDraws;
    int numberOfDefeats;
    
    int goalsReceived;
    int goalsScored;
    
    int pointsCurrent;
    int matchesPlayed;
    
    public FootballClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }
    
    @Override
    public String toString() {
        return clubName + " " + clubLocation;
    }
    
    public String getName() {
        return clubName;
    }
}
