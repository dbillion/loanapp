package com.loanapp.loanapp.model;

import lombok.Data;

@Data
public class LoanDecisionResult {
    private double maxLoanAmount;
    private int maxLoanPeriod;
}
