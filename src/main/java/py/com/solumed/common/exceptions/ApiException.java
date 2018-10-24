package py.com.solumed.common.exceptions;

/**
 * Created by mcespedes on 10/4/17.
 */
public class ApiException extends Exception{

    private int code;

    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}