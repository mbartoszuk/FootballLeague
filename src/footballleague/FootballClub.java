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
        return clubName + " " + clubLocation
                + "\nTotal matches played: " + matchesPlayed
                + "\nNumber of wins: " + numberOfWins
                + "\nNumber of draws: " + numberOfDraws
                + "\nNumber of defeats: " + numberOfDefeats
                + "\nTotal scored goals: " + goalsScored
                + "\nTotal received goals: " + goalsReceived
                + "\nCurrent Points: " + pointsCurrent;
    }
    
    public String getName() {
        return clubName;
    }
    
    public String getLocation() {
        return clubLocation;
    }
    
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    
    public int getNumberOfWins() {
        return numberOfWins;
    }
    
    public int getNumberOfDraws() {
        return numberOfDraws;
    }
    
    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }
    
    public int getGoalsScored() {
        return goalsScored;
    }
    
    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void addGoalsScored(int amount) {
        this.goalsScored = this.goalsScored + amount;
    }

    public void addGoalsReceived(int amount) {
        this.goalsReceived = this.goalsReceived + amount;
    }
    
    public void logAWin() {
        this.numberOfWins = this.numberOfWins + 1;
        this.matchesPlayed = this.matchesPlayed + 1;
        this.pointsCurrent = this.pointsCurrent + 3;
    }
    
    public void logADraw() {
        this.numberOfDraws = this.numberOfDraws + 1;
        this.matchesPlayed = this.matchesPlayed + 1;
        this.pointsCurrent = this.pointsCurrent + 1;
    }
    
    public void logADefeat() {
        this.numberOfDefeats = this.numberOfDefeats + 1;
        this.matchesPlayed = this.matchesPlayed + 1;
    }
    
    public int getCurrentPoints() {
        return pointsCurrent;
    }
    
    public int getGoalsDifference() {
        return goalsScored - goalsReceived;
    }
}
