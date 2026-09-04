package university.management.validation;

import java.time.LocalDate;

import university.management.entity.Gender;

public final class StudentValidator {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private StudentValidator() {
    }

    public static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public static void validateGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
    }

    public static void validateBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }

        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future.");
        }
    }
}