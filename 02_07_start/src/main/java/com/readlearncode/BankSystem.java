package com.readlearncode;

import com.readlearncode.subsystems.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */

@Stateless
public class BankSystem {
    @EJB
    private CreditRatingService creditRatingService;

    @EJB
    private RepaymentService repaymentService;

    @EJB
    private RepaymentPayabilityService repaymentPayabilityService;

    @EJB
    private TransferService transferService;

    @EJB
    private InternalBankPolicyService internalBankPolicyService;

    public boolean processLoanApplication(Customer customer, Double principle, Double income, Integer months) {
        boolean passes = creditRatingService.checkCustomerRating(customer);
        if (!passes) return false;

        boolean affordable = repaymentPayabilityService.calculatePayability(principle, income, months);
        if (!affordable) return false;

        boolean compliant = internalBankPolicyService.checkCompliance(customer);
        if (!compliant) return false;

        // Application successful, so transfer principle and set up repayment schedule
        transferService.makeTransfer(principle, customer);
        repaymentService.setUpPaymentSchedule(customer, principle, months);

        return true;
    }

}