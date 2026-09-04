package university.management.validation;

import java.time.LocalDate;

public final class ServiceValidation {

    private ServiceValidation() {
    }

    public static void validateId(Long id) {
        ValidationUtils.validateId(id);
    }

    public static void validateString(String value, String fieldName) {
        ValidationUtils.validateString(value, fieldName);
    }

    public static void validateDate(LocalDate date) {
        ValidationUtils.validateBirthDate(date);
    }

    public static void validateNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null.");
        }
    }

    public static void validateUpdateResult(int rowsUpdated) {
        ValidationUtils.validateUpdateResult(rowsUpdated);
    }
}
