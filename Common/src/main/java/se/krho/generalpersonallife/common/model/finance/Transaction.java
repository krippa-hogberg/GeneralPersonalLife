package se.krho.generalpersonallife.common.model.finance;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private UUID id;

    private Date day;
    private String msg;
    private String explanation;
    private String category;
    private String subcategory;
    private double amount;

    public Transaction() {
        super();
    }
    public Transaction(Date day, String msg, String explanation, String category, String subcategory, double amount) {
        super();

        this.id = UUID.randomUUID();
        this.day = day;
        this.msg = msg;
        this.explanation = explanation;
        this.category = category;
        this.subcategory = subcategory;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
