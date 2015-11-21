package footballleague;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@author Maria Bartoszuk

public class PremierLeagueManager implements LeagueManager {
    
    ArrayList<FootballClub> clubsInPremierLeague = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    ArrayList<Match> matches = new ArrayList<>();
    
    public void menu() {
        System.out.println("Please choose from the following options: "
            + "\nEnter A to Add a new club"
            + "\nEnter D to Display statistics of a specific club"
            + "\nEnter R to Remove an existing club"
            + "\nEnter M to Add a played match"
            + "\nEnter T to Display the league table"
            + "\nEnter C to Display the league calendar"
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
                case "M": this.addMatch();
                          break;
                case "T": this.displayLeagueTable();
                          break;
                case "C": this.displayCalendar();
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

    public void addMatch() {
        System.out.println("Enter the name of the first club: ");
        FootballClub firstClub = findClubByName(input.next());
        if (firstClub == null) {
            System.out.println("Requested club does not exist in this league.");
            return;
        }
        System.out.println("Enter the number of goals scored by this team: ");
        int firstGoalsScored = input.nextInt();
        
        System.out.println("Enter the name of the second club: ");
        FootballClub secondClub = findClubByName(input.next());
        if (secondClub == null) {
            System.out.println("Requested club does not exist in this league.");
            return;
        }
        System.out.println("Enter the number of goals scored by this team: ");
        int secondGoalsScored = input.nextInt();
        
        System.out.println("Enter the date when this match took place (yyyy-mm-dd): ");
        String date = input.next();
        
        Match match = new Match(firstClub, secondClub, date);
        match.addResults(firstGoalsScored, secondGoalsScored);
        matches.add(match);
    }
    
    public void displayLeagueTable() {
        Table table = new Table(clubsInPremierLeague);
        table.sortByScore();
        table.display();
    }
    
    public void displayCalendar() {
        System.out.println("Enter the year to display the league calendar for: ");
        int year = input.nextInt();
        System.out.println("Now enter the month of that year: ");
        Month month = Month.valueOf(input.next().toUpperCase());
        Calendar calendar = new Calendar(month, year);
        System.out.println();
        System.out.println(calendar);
        System.out.println("Enter the day of the month above to see the matches taking place: ");
        int day = input.nextInt();
        
        LocalDate chosenDate = LocalDate.of(year, month, day);
        boolean matchesWereDisplayed = false;
        for (Match match:matches) {
            if(chosenDate.equals(match.getDate())) {
                System.out.println(match);
                matchesWereDisplayed = true;
            }
        }
        if(matchesWereDisplayed == false) {
            System.out.println("No matches were played on this day.");
        }
    }
    
    public static void main(String [] args) {
        PremierLeagueManager test = new PremierLeagueManager();
        test.menu();
    }
}
