package com.github.huffmanCoding.exception;

/**
 * @author Mostafa Asgari
 * Email : mostafa.asg@gmail.com
 * website https://bigdatacode.wordpress.com/
 * @since 5/21/16
 */
public class InvalidNodeIDException extends Exception {

    public InvalidNodeIDException() {
    }

    public InvalidNodeIDException(String message) {
        super(message);
    }

    public InvalidNodeIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNodeIDException(Throwable cause) {
        super(cause);
    }

    public InvalidNodeIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
