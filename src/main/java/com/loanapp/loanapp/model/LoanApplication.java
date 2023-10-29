package com.loanapp.loanapp.model;
import lombok.Data;

@Data
public class LoanApplication {
    private PersonalCode personalCode;
    private double loanAmount;
    private int loanPeriod;
}
