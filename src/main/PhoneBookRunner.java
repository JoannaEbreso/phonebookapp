package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookRunner {

    public static void main(String[] args) {
        PhoneBookItem phoneBookItem =  new PhoneBookItem();
        HashMap<String, PhoneBookItem> phonebook = new HashMap<>();
        Scanner sc  =  new Scanner(System.in);

        System.out.println("Welcome!!!");
        System.out.println("Please enter the corresponding number for the operation you want to perform. \n 1. Enter a new number in phonebook \n " +
                "2. Get the list of phone numbers in phone book \n 3. Get details for a phone number \n 4. Exit the application");
        System.out.println();
        int choice = sc.nextInt();
        int coun = 0;
        out:
        while(choice != 4){
            if(coun!=0){
                System.out.println();
                System.out.println("What else would you like to do?");
                System.out.println("Please enter the corresponding number for the operation you want to perform. \n 1. Enter a new number in phonebook \n " +
                        "2. Get the list of phone numbers in phone book \n 3. Get details for a phone number \n 4. Exit the application");
                       choice = sc.nextInt();
            }
            

            switch (choice){
                case 1:
                    System.out.println("Enter the phone number you want to add to the phonebook: ");
                    sc.nextLine();
                    String phoneNumber  = sc.nextLine();

                    if(PhoneBook.isPhoneNumberValid(phoneNumber)){
                        if(phonebook.isEmpty() || !PhoneBook.isPhoneNumberInMap(phonebook,phoneNumber)){
                                System.out.println("Enter your name: ");
                                String name = sc.nextLine();
                                phoneBookItem.setName(name);
                                System.out.println("Enter your email address: ");
                                String email = sc.nextLine();
                                phoneBookItem.setEmail(email);
                                System.out.println("Enter your home address: ");
                                System.out.println();
                                String address = sc.nextLine();
                                phoneBookItem.setAddress(address);

                                phonebook.put(phoneNumber, phoneBookItem);
                                // choice = 4;
                                System.out.println("DONE!");
                                coun++;
                                continue out;

                                // break;
                        }
                        else System.out.println("This phone number already exists in the phonebook");
                    }

                    else System.out.println("The number entered is not valid");

                    break;

                case 2:
                    Set<String> setOfPhoneNumbers = PhoneBook.getAllPhoneNumbers(phonebook);
                    setOfPhoneNumbers.stream().forEach(item -> System.out.println(item));

                    System.out.println("DONE!");
                    coun++;
                    continue out;
                    // break;

                case 3:
                    System.out.println();
                    System.out.println("Enter the phone number you want to check details for: ");

                    String newPhoneNumber  = sc.next();


                    if(PhoneBook.isPhoneNumberValid(newPhoneNumber)){
                        if(phonebook.isEmpty()){
                            System.out.println("THE PHONEBOOK IS EMPTY");
                            coun++;
                           continue out;
                        }
                        else {
                            System.out.println(PhoneBook.getDetailsWithPhoneNumber(phonebook, newPhoneNumber));

                            System.out.println("DONE!");
                            coun++;
                           continue out;
                        }
                    }

                    else{
                        System.out.println("THE PHONE NUMBER IS NOT VALID");
                    }
                    break;

                default:
                    System.out.println("NOTHING WAS CHOSEN");
                    break;

            }
            // System.out.println("What else would you like to do?");
            // System.out.println("Please enter the corresponding number for the operation you want to perform. \n 1. Enter a new number in phonebook \n " +
            //         "2. Get the list of phone numbers in phone book \n 3. Get details for a phone number \n 4. Exit the application");
                    // choice = 4;

        }
    }
}
