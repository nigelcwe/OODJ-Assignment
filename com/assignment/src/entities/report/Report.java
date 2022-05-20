package com.assignment.src.entities.report;

import com.assignment.src.entities.shared.Entity;
import java.time.LocalDateTime;

public class Report extends Entity {
    public int customerId, trainerId;
    public double paymentAmount, commission;
    public LocalDateTime creationDate;

    public Report(int id, int customerId, int trainerId, double paymentAmount, LocalDateTime creationDate) {
        super(id);
        this.customerId = customerId;
        this.trainerId = trainerId;
        this.paymentAmount = paymentAmount;
        this.commission = paymentAmount * 80 / 100;
        this.creationDate = creationDate;
    }
}
