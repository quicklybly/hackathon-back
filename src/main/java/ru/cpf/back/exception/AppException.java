package ru.cpf.back.exception;

public class AppException extends RuntimeException {
    protected final CODE code;

    protected AppException(CODE code, String msg) {
        this(code, null, msg);
    }

    protected AppException(CODE code, Throwable e, String msg) {
        super(msg, e);
        this.code = code;
    }

    public CODE getCode() {
        return code;
    }

    public enum CODE {
        USER_NOT_FOUND("User with such id not found"),
        ;
        final String codeDescription;

        CODE(String codeDescription) {
            this.codeDescription = codeDescription;
        }

        public String getCodeDescription() {
            return codeDescription;
        }

        public AppException get() {
            return new AppException(this, this.codeDescription);
        }

        public AppException get(String msg) {
            return new AppException(this, this.codeDescription + " : " + msg);
        }

        public AppException get(Throwable e) {
            return new AppException(this, e, this.codeDescription + " : " + e.getMessage());
        }

        public AppException get(Throwable e, String msg) {
            return new AppException(this, e, this.codeDescription + " : " + msg);
        }
    }
}
