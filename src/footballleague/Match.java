package footballleague;

import java.time.LocalDate;
import java.time.Month;

class Match {

    FootballClub firstClub;
    FootballClub secondClub;
    int firstScore;
    int secondScore;
    LocalDate date;
    
    Match(FootballClub firstClub, FootballClub secondClub, String date) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
        this.date = LocalDate.parse(date);
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
        
        this.firstScore = firstGoalsScored;
        this.secondScore = secondGoalsScored;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public String toString() {
        return this.firstClub.getName() + " - " + this.secondClub.getName() +
                " " + this.firstScore + " : " + this.secondScore;
    }
}
