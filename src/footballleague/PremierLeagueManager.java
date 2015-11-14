package footballleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@author Maria Bartoszuk

public class PremierLeagueManager {
    
    List<FootballClub> clubsInPremierLeague = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    
    public void menu() {
        System.out.println("Please choose from the following options: "
            + "\nEnter A to Add a new club"
            + "\nEnter D to Display statistics of a specific club"
            + "\nEnter R to Remove an existing club"
            + "\nEnter Q to Quit the program");
        
        boolean quit = false;
        
        while(!quit) {
            String choice = input.next();
            switch (choice) {
                case "A": this.addFootballClub();
                          break;
                case "D": this.displayClubStats();
                          break;
                case "R": this.removeFootballClub();
                          break;
                case "Q": quit = true;
                          break;
                default: System.out.println("This option is invalid. Choose again.");
            }
        }
    }
    
    private void addFootballClub() {
        System.out.println("Enter the name of a new club: ");
        String clubName = input.next();
        System.out.println("Enter the location of the new club: ");
        String clubLocation = input.next();
        FootballClub newClub = new FootballClub(clubName, clubLocation);
        clubsInPremierLeague.add(newClub);
    }
    
    public FootballClub findClubByName(String clubName) {
        for (FootballClub candidate : clubsInPremierLeague) {
            String candidateName = candidate.getName();
            if (clubName.equals(candidateName)) {
                return candidate;
            }
        }
        return null;
    }
    
    private void displayClubStats() {
        System.out.println("Enter the name of the club to see its statistics: ");
        String clubName = input.next();
        FootballClub club = findClubByName(clubName);
        if (club == null) {
            System.out.println("Requested club does not exist in this league.");
        } else {
            System.out.println(club);
        }
    }
    
    public void removeFootballClub() {
        System.out.println("Enter the name of the club to remove it from the league: ");
        String clubName = input.next();
        FootballClub club = findClubByName(clubName);
        if (club == null) {
            System.out.println("Requested club does not exist in this league.");
        } else {
            this.clubsInPremierLeague.remove(club);
            System.out.println(club + " was deleted from the league.");
        }
    }
    
    public static void main(String [] args) {
        PremierLeagueManager test = new PremierLeagueManager();
        test.menu();
    }
}
