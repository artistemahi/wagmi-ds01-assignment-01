package main.java.com.wagmi.finance.recursion;

/*
 TODO[Student]: Recursive utilities
 - `isValidDateRecursive`: parse YYYY-MM-DD without regex; handle ranges + leap years.
 - `categoryTotalRecursive`: sum amounts for a category (expenses only) recursively.
 - `generateBudgetReportRecursive`: build a non-empty string summarizing items recursively.
 - See `RecursionUtilsTest` for behavior and edge cases.
*/

import main.java.com.wagmi.finance.model.Transaction;

public final class RecursionUtils {
    private RecursionUtils() {
    }
//-------validate-----
    public static boolean isValidDateRecursive(String date) {
        // stub: validate YYYY-MM-DD recursively
        if (date == null )  return false;
        if (date.length() !=10 ) return false;
        char[] specialSymbol = date.toCharArray();
        if (specialSymbol[4]!='-' || specialSymbol[7]!='-') {return false;}
        for (int a = 0; a<date.length(); a++){
            if (specialSymbol[a]==' ') return false;
        }
        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8,10);

        // year checking
        if  (year.length()!=4) return false;
        for (int i = 0; i < year.length(); i++) {
            char years = year.charAt(i);
            if (years < '0' || years > '9') return false;
        }
        int y = Integer.parseInt(year);
        if  (y <1 || y>9999) {return false;}

        //month checking
        if (month.length()!=2) return false;
        for (int j = 0; j < month.length(); j++) {
            char months = month.charAt(j);
            if (months < '0' || months > '9') return false;
        }
        int m = Integer.parseInt(month);
        if (m<1 || m>12) return false;

        // day checking
        if (day.length()!=2) return false;
        for (int k = 0; k < day.length(); k++) {
            char days = day.charAt(k);
            if (days < '0' || days > '9') return false;
        }
        int d= Integer.parseInt(day);
        if (m==1 || m==3 || m==5 || m==7 || m==8|| m == 10 || m==12){
            if (d<1 || d>31) return false; // month having 31 days
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11){
            if (d<1 || d>30) return false; // months having 30 days
        }
        else {
            boolean isleapYear = (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0));
            if (isleapYear==true)
            {  // if leap year
                if (d<1 || d>29) return false;
            }
            else { // if not a leap year
                if (d<1 || d>28) return false;
            }
        }
        return true;
//        throw new UnsupportedOperationException("Not implemented");
    }
//--------category total---
    public static double categoryTotalRecursive(Transaction[] arr, String category) {
        // stub: sum matching category recursively
        if (arr.length==0 || category==null) return 0.0;
        if (category=="Unknown") return 0.0;
       return TotalByRecursion(arr,category,0);
//        throw new UnsupportedOperationException("Not implemented");
    }
    //total function
    public static double TotalByRecursion(Transaction[] arr, String category, int index){
        if (index>=arr.length) return 0.0; // base condition
        Transaction target = arr[index];
        double Current_Amount = 0.0;
        if (target.getCategory().equals(category)){
            Current_Amount = target.getAmount();
        }
        return Current_Amount+TotalByRecursion(arr,category,index+1);
    }
//-------budgetrep----
    public static String generateBudgetReportRecursive(Transaction[] arr) {
        // stub: build report string recursively
        if (arr.length==0) return "No Transaction found";
        return BudgetReport(arr,0);
//        throw new UnsupportedOperationException("Not implemented");
    }
    // budget function
    public static String BudgetReport(Transaction[] arr,int index ){
        if(index== arr.length-1) return arr[index].getCategory()+":"+arr[index].getAmount()+"\n";
        String current = arr[index].getCategory()+":"+arr[index].getAmount()+"\n";
    return current+BudgetReport(arr,index+1);
    }

}
