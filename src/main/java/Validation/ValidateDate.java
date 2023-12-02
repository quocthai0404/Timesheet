package Validation;

public class ValidateDate {
	public Boolean checkYear(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || 
	            (year % 400 == 0)); 
	}

	public Boolean checkDate(String year, String month, String day) {
		int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);
        
        if (monthInt > 12 || monthInt < 1 || dayInt > 31 || dayInt < 1 || yearInt < 0) {
            return false;
        }
        if (checkYear(yearInt)) {
            if (monthInt == 2 && dayInt > 29) {
                return false;
            } else if ((monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) && dayInt > 30) {
                return false;
            }
        } else {
            if (monthInt == 2 && dayInt > 28) {
                return false;
            } else if ((monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) && dayInt > 30) {
                return false;
            }
        }
        
		
		return true;

	}
}
