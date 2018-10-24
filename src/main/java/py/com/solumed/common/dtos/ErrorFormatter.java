package py.com.solumed.common.dtos;

import org.springframework.http.HttpStatus;

/**
 * Created by mcespedes
 */
public class ErrorFormatter {

    /**
     * Private constructor in order to prevent to instantiate this class.
     */
    private ErrorFormatter() {
    }

    public static String formatErrorMessage(String errorMessage, long errorId) {
        return String.format("%s . Reference error id: %d", errorMessage, errorId);
    }

    public static String formatErrorMessage(HttpStatus httpStatus, long errorId) {
        return formatErrorMessage(httpStatus.getReasonPhrase(), errorId);
    }
}
