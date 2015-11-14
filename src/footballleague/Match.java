package footballleague;

class Match {

    FootballClub firstClub;
    FootballClub secondClub;
    
    Match(FootballClub firstClub, FootballClub secondClub) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
    }

    public void addResults(int firstGoalsScored, int secondGoalsScored) {
        firstClub.addGoalsScored(firstGoalsScored);
        secondClub.addGoalsScored(secondGoalsScored);
        
        firstClub.addGoalsReceived(secondGoalsScored);
        secondClub.addGoalsReceived(firstGoalsScored);
        
        if (firstGoalsScored > secondGoalsScored) {
            firstClub.logAWin();
            secondClub.logADefeat();
        } else if (firstGoalsScored == secondGoalsScored) {
            firstClub.logADraw();
            secondClub.logADraw();
        } else if (firstGoalsScored < secondGoalsScored) {
            firstClub.logADefeat();
            secondClub.logAWin();
        }
    }
}
