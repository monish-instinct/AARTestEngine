package skynetbee.developers.developerenvironment

import android.util.Patterns
import java.util.regex.Pattern

/**
 * Validator utilities for common validation tasks
 * Part of the SkynetBee Developer Environment Library
 */
object Validator {
    
    private val PHONE_PATTERN = Pattern.compile("^[+]?[0-9]{10,15}$")
    private val PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    
    /**
     * Validate email address
     * @param email Email string to validate
     * @return true if valid email, false otherwise
     */
    fun validateEmail(email: String?): Boolean {
        return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    /**
     * Validate phone number
     * @param phone Phone string to validate
     * @return true if valid phone, false otherwise
     */
    fun validatePhone(phone: String?): Boolean {
        return !phone.isNullOrEmpty() && PHONE_PATTERN.matcher(phone).matches()
    }
    
    /**
     * Validate password strength
     * Requirements: At least 8 characters, 1 digit, 1 lowercase, 1 uppercase, 1 special character
     * @param password Password string to validate
     * @return true if strong password, false otherwise
     */
    fun validatePassword(password: String?): Boolean {
        return !password.isNullOrEmpty() && PASSWORD_PATTERN.matcher(password).matches()
    }
    
    /**
     * Validate if string is not empty
     * @param text String to validate
     * @return true if not empty, false otherwise
     */
    fun validateNotEmpty(text: String?): Boolean {
        return !text.isNullOrEmpty() && text.trim().isNotEmpty()
    }
    
    /**
     * Validate minimum length
     * @param text String to validate
     * @param minLength Minimum required length
     * @return true if meets minimum length, false otherwise
     */
    fun validateMinLength(text: String?, minLength: Int): Boolean {
        return !text.isNullOrEmpty() && text.length >= minLength
    }
    
    /**
     * Validate maximum length
     * @param text String to validate
     * @param maxLength Maximum allowed length
     * @return true if within maximum length, false otherwise
     */
    fun validateMaxLength(text: String?, maxLength: Int): Boolean {
        return text != null && text.length <= maxLength
    }
    
    /**
     * Validate numeric string
     * @param text String to validate
     * @return true if numeric, false otherwise
     */
    fun validateNumeric(text: String?): Boolean {
        return !text.isNullOrEmpty() && text.all { it.isDigit() }
    }
    
    /**
     * Validate URL format
     * @param url URL string to validate
     * @return true if valid URL, false otherwise
     */
    fun validateUrl(url: String?): Boolean {
        return !url.isNullOrEmpty() && Patterns.WEB_URL.matcher(url).matches()
    }
    
    /**
     * Get detailed validation result for email
     * @param email Email to validate
     * @return ValidationResult with status and message
     */
    fun getEmailValidationResult(email: String?): ValidationResult {
        return when {
            email.isNullOrEmpty() -> ValidationResult(false, "Email cannot be empty")
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> ValidationResult(false, "Invalid email format")
            else -> ValidationResult(true, "Valid email")
        }
    }
    
    /**
     * Data class for detailed validation results
     */
    data class ValidationResult(
        val isValid: Boolean,
        val message: String
    )
}
