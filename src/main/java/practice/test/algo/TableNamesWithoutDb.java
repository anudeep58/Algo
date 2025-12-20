package practice.test.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableNamesWithoutDb {

    public static void main(String[] args) {
//        String sqlQuery = "SELECT column1, column2 from table1 WHERE column3 = 'value' " +
//                "INNER JOIN db.table2 ON table1.id = table2.id " +
//                "INSERT INTO table3 (column1, column2) VALUES ('value1', 'value2')";
//
//        // Define the regular expression for finding table names without a database qualifier
//        String regex = "\\b(?:FROM|JOIN|INTO)\\s+(?:(?:(?!\\w+\\.)\\w+)|(?:(?!\\w+\\.)\\w+(?=\\s*\\())\\b)";
//
//        // Compile the pattern
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//
//        // Create a matcher for the SQL query
//        Matcher matcher = pattern.matcher(sqlQuery);
//
//        // Find and print all matches
//        while (matcher.find()) {
//            String tableName = matcher.group().trim();
//            System.out.println("Table Name without DB: " + tableName);
        TableNamesWithoutDb tableNamesWithoutDb = new TableNamesWithoutDb();
        tableNamesWithoutDb.summaryRanges(new int[]{0,1,2,4,5,7}).forEach(System.out::println);
    }


    public List<String> summaryRanges(int[] nums) {
        int start = nums[0];
        int currentCount = 0;
        List<String> aa = new ArrayList();
        for(int i =0; i <= nums.length - 1; i++)
        {
           // currentCount = nums[i];
            if(start +currentCount != nums[i]){
                aa.add(start+"->"+nums[i-1]);
                start = nums[i];
            }
            else{
                currentCount++;
            }
        }
        return aa;
    }
}
