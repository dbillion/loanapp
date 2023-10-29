package com.loanapp.loanapp.model;

import org.springframework.stereotype.Service;

@Service
public class LoanDecisionEngine {
    private static final double MIN_LOAN = 2000;
    private static final double MAX_LOAN = 10000;
    private static final int MIN_PERIOD = 12;
    private static final int MAX_PERIOD = 60;

    public LoanDecisionResult calculateMaxLoan(LoanApplication loanApplication) {
        LoanDecisionResult result = new LoanDecisionResult();

        if (loanApplication.getPersonalCode() == PersonalCode.DEBT) {
            return result;
        }

        int creditModifier = loanApplication.getPersonalCode().getCreditModifier();
        double maxLoanAmount = 0;
        int maxLoanPeriod = 0;

        for (double loanAmount = MIN_LOAN; loanAmount <= MAX_LOAN; loanAmount++) {
            for (int loanPeriod = MIN_PERIOD; loanPeriod <= MAX_PERIOD; loanPeriod++) {
                double creditScore = (creditModifier / loanAmount) * loanPeriod;
                if (creditScore >= 1 && loanAmount > maxLoanAmount) {
                    maxLoanAmount = loanAmount;
                    maxLoanPeriod = loanPeriod;
                }
            }
        }

        result.setMaxLoanAmount(maxLoanAmount);
        result.setMaxLoanPeriod(maxLoanPeriod);
        return result;
    }
}
