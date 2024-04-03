//@@author mukund1403
package seedu.duke;


import seedu.duke.exceptions.ExpensesException;

import java.util.ArrayList;


/**
 * A class to add a new expense
 */
public class Expense {
    private String payerName;
    private float totalAmount;
    private ArrayList<Pair<String, Float>> payees = new ArrayList<>();

    private String description;

    /**
     * Constructor to create new Expense
     *
     * @param isUnequal   : Boolean showing whether expense is split unequally or not
     * @param payerName   : The name of the user who paid for the Expense
     * @param description : Description of the expense
     * @param totalAmount : The total amount before being divided
     *
     * @param payees : ArrayList of pairs containing names of people who are involved in the transaction and
     *               the amount they owe (Index 0 is the payer and will also be added to the payees but as last index)
     */
    public Expense(boolean isUnequal, String payerName, String description,
                   float totalAmount, ArrayList<Pair<String,Float>> payees)
            throws ExpensesException {
        this.payees = payees;
        this.payerName = payerName;
        this.totalAmount = totalAmount;
        this.description = description;
        printSuccessMessage();
    }

    public Expense(String payerName, String description, float totalAmount, ArrayList<Pair<String, Float>> payees){
        this.payees = payees;
        this.payerName = payerName;
        this.totalAmount = totalAmount;
        this.description = description;
        printSuccessMessage();
    }

    public Expense(User payer, double amount) {
    }

    //@@author Cohii2
    public String getPayerName() {
        return payerName;
    }

    /**
     * @return : float showing the total amount before division
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Pair<String, Float>> getPayees() {
        return payees;
    }

    //@@author mukund1403
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String expensesDetails = "";
        expensesDetails += "description " + description + " and amount " + totalAmount +
                " paid by " + payerName + " and split between:\n";
        for (Pair<String, Float> payee : payees) {
            expensesDetails += payee.getKey() + " who owes " + String.format("%.2f", payee.getValue()) + "\n";
        }
        return expensesDetails;
    }

    void printSuccessMessage() {
        System.out.printf("Added new expense with description %s and amount %.2f paid by %s and split between:\n",
                this.description, this.totalAmount, this.payerName);
        for (Pair<String, Float> payee : payees) {
            System.out.printf("%s who owes %.2f\n", payee.getKey(), payee.getValue());
        }
        System.out.println();
    }

    public String getPayer() {
        return payerName;
    }
}



