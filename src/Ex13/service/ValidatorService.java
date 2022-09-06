package Ex13.service;

import Ex13.exception.BirthdayException;
import Ex13.exception.EmailException;
import Ex13.exception.FullnameException;
import Ex13.exception.PhoneException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidatorService {
    public static void checkBirthday(LocalDate birthday) throws BirthdayException {
        if (birthday.getYear() > 2001) throw new BirthdayException("Invalid Year");
    }

    public static void checkEmail(String email) throws EmailException {
        if (!email.matches("^(.+)@(.+)$")) {
            throw new EmailException("Invalid Email");
        }
    }


    public static void checkFullname(String fullname) throws FullnameException {
        if (!fullname.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$")) throw new FullnameException("Invalid Name");
    }

    public static void checkPhone(String phone) throws PhoneException {
        if (!phone.matches("^\\d{10}$")) throw new PhoneException("Invalid Phone Number");
    }
}
