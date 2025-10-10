package main.java.com.wagmi.finance.strings;

/*
 TODO[Student]: String utilities
 - Read `StringUtilsTest` to understand expectations.
 - Ensure `sanitizeDescription` handles null/empty, collapses whitespace, and removes non-alphanumerics.
 - Ensure `matchesDatePattern` strictly validates YYYY-MM-DD with leap years and correct ranges.
 - Note: Keep behavior consistent with tests; refactor for readability if desired.
*/

public final class StringUtils {
    private StringUtils() {
    }

    public static String sanitizeDescription(String input) {
        // stub: trim, collapse spaces, remove invalid chars
        if (input == null )  throw new NullPointerException("input cannot be null");
        if (input.length()==0) return "";
        // spaces(leading/trailing )
        StringBuilder result = new StringBuilder();
        boolean isPrevSpace= false;
        for (int i =0; i <input.length(); i++){
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)){
                result.append(c);
                isPrevSpace=false;
            }
            else{
                if (!isPrevSpace){
                    result.append(' ');
                    isPrevSpace=true;
                }
            }
        }
        return result.toString().trim();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean matchesDatePattern(String input) {
        // stub: check pattern YYYY-MM-DD length is 10
        if (input == null )  return false;
        if (input.length() !=10 ) return false;
            char[] specialSymbol = input.toCharArray();
         if (specialSymbol[4]!='-' || specialSymbol[7]!='-') {return false;}
         for (int a = 0; a<input.length(); a++){
             if (specialSymbol[a]==' ') return false;
         }
        String year = input.substring(0,4);
        String month = input.substring(5,7);
        String day = input.substring(8,10);

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
}
