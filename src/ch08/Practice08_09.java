package ch08;

public class Practice08_09 {
    public static void main(String[] args) {
        throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100);
    }
}

class UnsupportedFunctionException extends RuntimeException {

    private final int ERR_CODE;

    UnsupportedFunctionException(String message, int errorCode) {
        super(message);
        ERR_CODE = errorCode;
    }

    public int getErrorCode() {
        return ERR_CODE;
    }

    @Override
    public String getMessage() {
        return "[" + ERR_CODE + "] " + super.getMessage();
    }
}
