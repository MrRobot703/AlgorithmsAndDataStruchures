package dataStruchures.queue.exceptions;

public class QueueEmptyException extends QueueException {
    public QueueEmptyException() {
        super("Queue is empty, there are no more elements!");
    }
}
