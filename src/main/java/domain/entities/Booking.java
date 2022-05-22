package domain.entities;

import domain.entities.shared.Entity;

import java.time.LocalDateTime;

public class Booking extends Entity {
    protected int customerId, trainerId;
    protected LocalDateTime creationDate, startTime, endTime;
    protected double price;
    protected boolean isCompleted, isPaid;
    protected String feedback;

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
