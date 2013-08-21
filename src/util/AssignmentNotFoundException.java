/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package util;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentNotFoundException extends Exception {

    /**
     * Creates a new instance of
     * <code>AssignmentNotFoundException</code> without detail message.
     */
    public AssignmentNotFoundException() {
    }

    /**
     * Constructs an instance of
     * <code>AssignmentNotFoundException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public AssignmentNotFoundException(String msg) {
        super(msg);
    }
}
