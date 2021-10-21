package org.overtime.common;

import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author ForteScarlet
 */
public class HandleableException extends Exception implements CodeMessageSupport {
    private final int code;
    private final int httpCode;
    private final String message;
    private final Exception exception;

    public HandleableException(int code, int httpCode, String message, Exception exception) {
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
        this.exception = exception;
    }


    public HandleableException(int code, String message, Exception exception) {
        this.code = code;
        this.httpCode = 500;
        this.message = message;
        this.exception = exception;
    }


    public HandleableException(Exception exception) {
        this.code = Result.FAILURE.getCode();
        this.httpCode = 500;
        this.message = exception.getLocalizedMessage();
        this.exception = exception;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public @NotNull String getMessage() {
        return message;
    }

    @Override
    public int getHttpResponseStatus() {
        return httpCode;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return exception.toString();
    }

    @Override
    public String getLocalizedMessage() {
        return exception.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return exception.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return exception.initCause(cause);
    }

    @Override
    public void printStackTrace() {
        exception.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        exception.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        exception.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return exception.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return exception.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        exception.setStackTrace(stackTrace);
    }

}
