package com.assignment.src.entities.report;

import com.assignment.src.entities.shared.Entity;
import java.time.LocalDateTime;

public class Report extends Entity {
    public int customerId, trainerId, managerId;
    public double paymentAmount;
    public boolean isPaid;
    public LocalDateTime creationDate, paymentDate, startTime, endTime;

    public Report(int id, int customerId, int trainerId, int managerId, double paymentAmount, boolean isPaid, LocalDateTime creationDate, LocalDateTime paymentDate, LocalDateTime startTime, LocalDateTime endTime) {
        super(id);
        this.customerId = customerId;
        this.trainerId = trainerId;
        this.managerId = managerId;
        this.paymentAmount = paymentAmount;
        this.isPaid = isPaid;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
