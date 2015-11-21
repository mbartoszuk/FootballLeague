package footballleague;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.YearMonth;

public class Calendar {
    
    YearMonth date;
    
    public Calendar(Month month, int year) {
        this.date = YearMonth.of(year, month);
    }
    
    public String toString() {
        Grid grid = new Grid(7);
        grid.addRow(new String[]{"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"});
        
        int firstSunday = 0;
        for(int i = 1; i <= 7; i++) {
            if(date.atDay(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                firstSunday = i;
            }
        }
        if (firstSunday != 1) {
            firstSunday = firstSunday - 7;
        }
        
        //i is a first day (Sunday) in every week of the month
        for(int i = firstSunday; i <= date.lengthOfMonth(); i = i + 7) {
            String[] week = new String[7];
            for (int j = 0; j < week.length; j++) {
                if(date.isValidDay(i + j)) {
                    week[j] = Integer.toString(i + j);
                } else {
                    week[j] = "";
                }
            }
            grid.addRow(week);
        }
        return date.getMonth().toString() + " " + date.getYear() + "\n" + grid;
    }
}
