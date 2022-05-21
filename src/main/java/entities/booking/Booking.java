package entities.booking;

import entities.shared.Entity;

import java.time.LocalDateTime;

public class Booking extends Entity {
    public int customerId, trainerId;
    public LocalDateTime creationDate, startTime, endTime;
    public double price;
    public boolean isCompleted, isPaid;
    public String feedback;

    public Booking(int id, int customerId, int trainerId, LocalDateTime creationDate, LocalDateTime startTime, LocalDateTime endTime, double price, boolean isCompleted, boolean isPaid, String feedback) {
        super(id);
        this.customerId = customerId;
        this.trainerId = trainerId;
        this.creationDate = creationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isCompleted = isCompleted;
        this.isPaid = isPaid;
        this.feedback = feedback;
    }
}
