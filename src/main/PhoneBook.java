package main;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    public static Boolean isPhoneNumberValid(String phoneNumber){
        Pattern phoneNumberPattern = Pattern.compile("^\\d{11}$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

        return phoneNumberMatcher.matches();
    }

    public static Boolean isPhoneNumberInMap(HashMap<String, PhoneBookItem> thePhoneBook, String phoneNumber){
        if(thePhoneBook.containsKey(phoneNumber)) return true;

        else return false;
    }

    public static Set<String> getAllPhoneNumbers(HashMap<String, PhoneBookItem> thePhoneBook){
        return thePhoneBook.keySet();
    }

    public static PhoneBookItem getDetailsWithPhoneNumber(HashMap<String, PhoneBookItem> thePhoneBook, String phoneNumber){
        return thePhoneBook.get(phoneNumber);
    }

}
