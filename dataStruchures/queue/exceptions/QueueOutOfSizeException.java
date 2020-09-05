package dataStruchures.queue.exceptions;

public class QueueOutOfSizeException extends QueueException {
    public QueueOutOfSizeException() {
        super("Queue is full, cannot except anymore elements!");
    }
}
