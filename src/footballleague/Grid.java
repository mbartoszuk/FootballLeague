package footballleague;

import java.util.ArrayList;
import java.util.Arrays;

class Grid {

    ArrayList<String[]> rows = new ArrayList<>();
    int[] colWidth;
    
    public Grid(int width) {
        this.colWidth = new int[width];
        Arrays.fill(colWidth, 0);
    }
    
    public void addRow(String[] row) {
        rows.add(row);
        for (int colIndex = 0; colIndex < row.length; colIndex++) {
            String filling = row[colIndex];
            int width = colWidth[colIndex];
            if (filling.length() > width) {
                colWidth[colIndex] = filling.length();
            }
        }
    }
    
    @Override
    public String toString() {
        String table = "";
        for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            String[] row = rows.get(rowIndex);
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                table = table + format(rowIndex, colIndex, row[colIndex]) + " ";
            }
            table = table + "\n";
        }
        return table;
    }
    
    private String format(int rowIndex, int colIndex, String cellContent) {
        int width = colWidth[colIndex];
        int paddingWidth = width - cellContent.length();
        String padding = "";
        for (int i = 0; i < paddingWidth; i++) {
            padding = padding + " ";
        }
        return cellContent + padding;
    }
}
