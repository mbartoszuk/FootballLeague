package footballleague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Table {
    
    private ArrayList<FootballClub> clubs;

    public Table(ArrayList<FootballClub> clubsInPremierLeague) {
        this.clubs = new ArrayList<>(clubsInPremierLeague);
        
    }

    public void display() {
        Grid grid = new Grid(9);
        grid.addRow(new String []{"Name", "Location", "Current Points", "Matches Played", "Number of Wins", "Number of Draws",
                                  "Number of Defeats", "Goals Scored", "Goals Received"});
        for(FootballClub club : clubs) {
            grid.addRow(new String []{club.getName(), club.getLocation(), Integer.toString(club.getCurrentPoints()),
                Integer.toString(club.getMatchesPlayed()), Integer.toString(club.getNumberOfWins()),
                Integer.toString(club.getNumberOfDraws()), Integer.toString(club.getNumberOfDefeats()),
                Integer.toString(club.getGoalsScored()), Integer.toString(club.getGoalsReceived())
            });
        }
        System.out.println(grid);
    }
    
    public void sortByScore() {
        Comparator<FootballClub> byPointsAsc = new ByPointsAndScoreDifference();
        Comparator<FootballClub> byPointsDesc = Collections.reverseOrder(byPointsAsc);
        Collections.sort(clubs, byPointsDesc);
    }
}
