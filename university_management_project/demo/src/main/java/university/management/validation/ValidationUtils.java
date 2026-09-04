package university.management.validation;

import java.time.LocalDate;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
    }

    public static void validateString(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }

    public static void validateUpdateResult(int rowsUpdated) {
        if (rowsUpdated == 0) {
            throw new RuntimeException("No record was found with the provided ID.");
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