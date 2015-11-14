package footballleague;

import java.util.Comparator;

class ByPointsAndScoreDifference implements Comparator<FootballClub> {  

    /**
     * -1 if left < right
     * 0 if left = right
     * 1 if left > right
     */
    @Override
    public int compare(FootballClub left, FootballClub right) {
        int pointsDifference = left.getCurrentPoints() - right.getCurrentPoints();
        if (pointsDifference != 0) {
            return pointsDifference;
        }
        return left.getGoalsDifference() - right.getGoalsDifference();
    }
}
