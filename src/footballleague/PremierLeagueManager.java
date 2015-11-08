package footballleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@author Maria Bartoszuk

public class PremierLeagueManager {
    
    List<FootballClub> clubsInPremierLeague = new ArrayList<>();
    
    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose from the following options: ");
        String choice = input.next();
    }
    
    private void addFootballClub() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of a new club: ");
        String clubName = input.next();
        System.out.println("Enter the location of the new club: ");
        String clubLocation = input.next();
        FootballClub newClub = new FootballClub(clubName, clubLocation);
        clubsInPremierLeague.add(newClub);
    }
    
    public static void main(String [] args) {
        
    }
}
