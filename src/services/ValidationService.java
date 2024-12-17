package services;

public class ValidationService {

    public boolean isValidPhoneNumber(String phoneNumber) {
        // Logic to validate phone number (using regex, for example)
        return phoneNumber.matches("\\d{10}");
    }

    // Other validation methods for data integrity
}
