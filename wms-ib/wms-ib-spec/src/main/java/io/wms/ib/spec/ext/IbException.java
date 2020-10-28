package io.wms.ib.spec.ext;

/**
 * Inbound Business Exception.
 */
public class IbException extends RuntimeException {

    private final String code;

    public static IbException ofCode(String code) {
        return new IbException(code);
    }

    private IbException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
