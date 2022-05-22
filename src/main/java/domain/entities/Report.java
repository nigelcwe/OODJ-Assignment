package domain.entities;

import domain.entities.shared.Entity;
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
        this.commission = paymentAmount * 65 / 100;
        this.creationDate = creationDate;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
