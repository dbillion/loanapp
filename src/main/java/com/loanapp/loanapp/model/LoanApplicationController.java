package com.loanapp.loanapp.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanApplicationController {
    private final LoanDecisionEngine loanDecisionEngine;

    public LoanApplicationController(LoanDecisionEngine loanDecisionEngine) {
        this.loanDecisionEngine = loanDecisionEngine;
    }

    @GetMapping("/")
    public String applyForm(Model model) {
        model.addAttribute("loanApplication", new LoanApplication());
        model.addAttribute("personalCodes", PersonalCode.values());
        return "apply"; 
    }


    @PostMapping("/results")
    public String applyForLoan(@ModelAttribute LoanApplication loanApplication, Model model) {
        LoanDecisionResult result = loanDecisionEngine.calculateMaxLoan(loanApplication);

        model.addAttribute("requestedLoanAmount", loanApplication.getLoanAmount());
        model.addAttribute("requestedLoanPeriod", loanApplication.getLoanPeriod());
        model.addAttribute("personalCode", loanApplication.getPersonalCode());
        model.addAttribute("creditModifier", loanApplication.getPersonalCode().getCreditModifier());

        if (result.getMaxLoanAmount() == 0) {
            model.addAttribute("message",
                    "Your Loan application was not Approved this time! Dont worry about it as you are always invited to try again😀😀😀 ,  Will you be interested in our other services? 😁😁😁");
        } else {
            model.addAttribute("message","Your Loan application was Successful, Our Official will Reach Out Too You Soon 🥳😀 "
                          );
        }

        model.addAttribute("result", result);
        return "results"; 
    }
}



