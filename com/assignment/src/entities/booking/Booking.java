package com.assignment.src.entities.booking;

import com.assignment.src.entities.shared.Entity;
import java.time.LocalDateTime;

public class Booking extends Entity {
    public int customerId, trainerId, feedback;
    public LocalDateTime creationDate, startTime, endTime;
    public double price;
    public boolean isCompleted, isPaid;

    public Booking(int id, int customerId, int trainerId, LocalDateTime creationDate, LocalDateTime startTime, LocalDateTime endTime, double price, boolean isCompleted, boolean isPaid, int feedback) {
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
