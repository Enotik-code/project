package by.mybot.utils;

import by.mybot.exception.ValidationException;

public class Validator {

    public final static Integer FIRSTNAME_MIN_LENGTH = 2;
    public final static Integer FIRSTNAME_MAX_LENGTH = 30;
    public final static Integer SURNAME_MIN_LENGTH = 2;
    public final static Integer SURNAME_MAX_LENGTH = 30;
    public final static Integer PATRONYMIC_MIN_LENGTH = 2;
    public final static Integer PATRONYMIC_MAX_LENGTH = 30;
    public final static Integer EMAIL_MIN_LENGTH = 10;
    public final static Integer EMAIL_MAX_LENGTH = 50;
    public final static Integer PHONE_NUMBER_LENGTH = 17;
    public final static Integer CITY_MIN_LENGTH = 3;
    public final static Integer CITY_MAX_LENGTH = 50;
    public final static Integer PASSPORT_SERIES_LENGTH = 2;
    public final static Integer PASSPORT_NUMBER_LENGTH = 7;
    public final static Integer ADDRESS_MIN_LENGTH = 5;
    public final static Integer ADDRESS_MAX_LENGTH = 50;
    public final static Integer POSITION_MIN_LENGTH = 5;
    public final static Integer POSITION_MAX_LENGTH = 50;

    public static void validateFirstname(String firstname) throws ValidationException {
        if (firstname == null || firstname.isEmpty() || firstname.isBlank()) {
            throw new ValidationException("Имя не может быть пустым");
        }
        if (firstname.length() < FIRSTNAME_MIN_LENGTH || firstname.length() > FIRSTNAME_MAX_LENGTH) {
            throw new ValidationException(String.format("Длина имени должна быть от %d до %d символов",
                    FIRSTNAME_MIN_LENGTH, FIRSTNAME_MAX_LENGTH));
        }
        if (!firstname.matches("^[A-Za-zА-Яа-я ]+$")) {
            throw new ValidationException("Имя должно состоять только из букв");
        }
    }

    public static void validateSurname(String surname) throws ValidationException {
        if (surname == null || surname.isEmpty() || surname.isBlank()) {
            throw new ValidationException("Фамилия не может быть пуста");
        }
        if (surname.length() < SURNAME_MIN_LENGTH || surname.length() > SURNAME_MAX_LENGTH) {
            throw new ValidationException(String.format("Длина фамилии должна быть от %d до %d символов",
                    SURNAME_MIN_LENGTH, SURNAME_MAX_LENGTH));
        }
        if (!surname.matches("^[A-Za-zА-Яа-я ]+$")) {
            throw new ValidationException("Фамилия должна состоять только из букв");
        }
    }

    public static void validatePatronymic(String patronymic) throws ValidationException {
        if (patronymic == null || patronymic.isEmpty() || patronymic.isBlank()) {
            throw new ValidationException("Отчество не может быть пустым");
        }
        if (patronymic.length() < PATRONYMIC_MIN_LENGTH || patronymic.length() > PATRONYMIC_MAX_LENGTH) {
            throw new ValidationException(String.format("Длина отчества должна быть от %d до %d символов",
                    PATRONYMIC_MIN_LENGTH, PATRONYMIC_MAX_LENGTH));
        }
        if (!patronymic.matches("^[A-Za-zА-Яа-я ]+$")) {
            throw new ValidationException("Отчество должно состоять только из букв");
        }
    }

    public static void validatePassportSeries(String passportSeries) throws ValidationException {
        if (passportSeries == null || passportSeries.isEmpty() || passportSeries.isBlank()) {
            throw new ValidationException("Серия паспорта не может быть пуста");
        }
        if (passportSeries.length() != PASSPORT_SERIES_LENGTH) {
            throw new ValidationException(String.format("Серия паспорта должна быть длиной в %d символа", PASSPORT_SERIES_LENGTH));
        }
        if (!passportSeries.matches("^[A-ZА-Я]+$")) {
            throw new ValidationException("Серия паспорта должа состоять только из букв верхнего регистра");
        }
    }

    public static void validatePassportNumber(String passportNumber) throws ValidationException {
        if (passportNumber == null || passportNumber.isEmpty() || passportNumber.isBlank()) {
            throw new ValidationException("Номер паспорта не может быть пустым");
        }
        if (passportNumber.length() != PASSPORT_NUMBER_LENGTH) {
            throw new ValidationException(String.format("Номер паспорта должен быть длиной в %d символов", PASSPORT_NUMBER_LENGTH));
        }
        if (!passportNumber.matches("^[0-9]+$")) {
            throw new ValidationException("Номер паспорта должен состоять только из цифр");
        }
    }

    public static void validateAddress(String address) throws ValidationException {
        if (address == null || address.isEmpty() || address.isBlank()) {
            throw new ValidationException("Адрес не может быть пустым");
        }
        if (address.length() < ADDRESS_MIN_LENGTH || address.length() > ADDRESS_MAX_LENGTH) {
            throw new ValidationException(String.format("Адрес должен быть длиной от %d до %d символов",
                    ADDRESS_MIN_LENGTH, ADDRESS_MAX_LENGTH));
        }
        if (!address.matches("^[A-Za-zА-Яа-я0-9 .-]+$")) {
            throw new ValidationException("Адрес должен состоять только из букв, цифр и символов '.-'");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws ValidationException {
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.isBlank()) {
            throw new ValidationException("Номер телефона не может быть пустым");
        }
        if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
            throw new ValidationException(String.format("Длина номера телефона должна быть %d символов",
                    PHONE_NUMBER_LENGTH));
        }
        if (!phoneNumber.matches("^\\+375[(]{1,1}[0-9]{2,2}[)]{1,1}[0-9]{3,3}[-]{1,1}[0-9]{2,2}[-]{1,1}[0-9]{2,2}$")) {
            throw new ValidationException("Номер телефона введен в некорректном формате");
        }
    }

    public static void validateEmail(String email) throws ValidationException {
        if (email == null || email.isEmpty() || email.isBlank()) {
            throw new ValidationException("Email не может быть пустым");
        }
        if (email.length() < EMAIL_MIN_LENGTH || email.length() > EMAIL_MAX_LENGTH) {
            throw new ValidationException(String.format("Длина Email должна быть от %d до %d символов",
                    EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH));
        }
        if (!email.matches("^[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new ValidationException("Email введен в некорректном формате");
        }
    }

    public static void validatePosition(String position) throws ValidationException {
        if (position == null || position.isEmpty() || position.isBlank()) {
            throw new ValidationException("Должность не может быть пуста");
        }
        if (position.length() < POSITION_MIN_LENGTH || position.length() > POSITION_MAX_LENGTH) {
            throw new ValidationException(String.format("Длина должности должна быть от %d до %d символов",
                    POSITION_MIN_LENGTH, POSITION_MAX_LENGTH));
        }
        if (!position.matches("^[A-Za-zА-Яа-я0-9 .-]+$")) {
            throw new ValidationException("Должность должна состоять только из букв, цифр и символов '-.'");
        }
    }
}
