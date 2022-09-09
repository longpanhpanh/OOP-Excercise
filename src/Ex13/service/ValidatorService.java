package Ex13.service;

import Ex13.exception.BirthdayException;
import Ex13.exception.EmailException;
import Ex13.exception.FullnameException;
import Ex13.exception.PhoneException;

import java.time.LocalDate;

public class ValidatorService {
    public static boolean checkBirthday(LocalDate birthday) throws BirthdayException {
        if (birthday.getYear() > 2001) throw new BirthdayException("Invalid Year");
        return true;
    }

    public static boolean checkEmail(String email) throws EmailException {
        if (!email.matches("^(.+)@(.+)$")) {
            throw new EmailException("Invalid Email");
        }
        return email.matches("^(.+)@(.+)$");
    }


    public static boolean checkFullname(String fullname) throws FullnameException {
        if (!fullname.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$")) throw new FullnameException("Invalid Name");
        return fullname.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$");
    }

    public static boolean checkPhone(String phone) throws PhoneException {
        if (!phone.matches("^\\d{10}$")) throw new PhoneException("Invalid Phone Number");
        return phone.matches("^\\d{10}$");
    }
}
