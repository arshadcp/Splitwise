package dev.arshad.Splitwise.Strategy;

import dev.arshad.Splitwise.DTO.UserAmount;
import dev.arshad.Splitwise.Model.Enum.ExpenseType;
import dev.arshad.Splitwise.Model.Expense;
import dev.arshad.Splitwise.Model.SettlementTransaction;
import dev.arshad.Splitwise.Model.User;
import dev.arshad.Splitwise.Model.UserExpense;

import java.util.*;

public class MinimumTransactionSettlementStrategy implements SettlementStrategy{
    public List<SettlementTransaction> getSettlementTransaction(List<Expense> expenses){

        HashMap<User, Double> expenseMap  = getOutstandingBalance( expenses);


       Comparator<UserAmount> minheapComparator=Comparator.comparingDouble(UserAmount::getAmount);//fetching getamount from UserAmount
       Comparator<UserAmount> maxheapComparator=Comparator.comparingDouble(UserAmount::getAmount);// :: reference to a method we can also do (double amount1,double amount2)

         PriorityQueue<UserAmount> minPriority=new PriorityQueue<>(minheapComparator);
         PriorityQueue<UserAmount> maxPriority=new PriorityQueue<>(maxheapComparator);

        for(Map.Entry<User,Double> entry: expenseMap.entrySet()){
           if(entry.getValue()<0){
               minPriority.add(new UserAmount(entry.getKey(),entry.getValue()));
           }
           else if(entry.getValue()>0){
               maxPriority.add(new UserAmount(entry.getKey(),entry.getValue()));
           }
           else{
               System.out.println("User does not need to participate in settle up");
           }

        }
        List<SettlementTransaction> settlementTransactions=new ArrayList<>();
        while(!minPriority.isEmpty() && !maxPriority.isEmpty()){
            UserAmount lender=maxPriority.poll();
            UserAmount borrower=minPriority.poll();

            if(Math.abs(borrower.getAmount())>lender.getAmount()){

                borrower.setAmount(borrower.getAmount()+ lender.getAmount());
                minPriority.add(borrower);
                SettlementTransaction settlement=new SettlementTransaction(borrower.getUser(),
                        lender.getUser(), lender.getAmount());
                settlementTransactions.add(settlement);
            }
             else if(Math.abs(borrower.getAmount())<lender.getAmount()){

                lender.setAmount( lender.getAmount()+borrower.getAmount());
                maxPriority.add(lender);
                SettlementTransaction settlement=new SettlementTransaction(borrower.getUser(),
                        lender.getUser(), borrower.getAmount());
                settlementTransactions.add(settlement);
            }
             else{
                 SettlementTransaction settlement=new SettlementTransaction(borrower.getUser(),lender.getUser(),lender.getAmount());
                settlementTransactions.add(settlement);
            }

        }
        return settlementTransactions;
    }

    public HashMap<User, Double> getOutstandingBalance(List<Expense> expenses){
        HashMap<User, Double> expenseMap = new HashMap<>();
        for(Expense expanse:expenses){
            for(UserExpense userExpense:expanse.getUserExpenses()) {


                User participant = userExpense.getUser();
                Double amount = userExpense.getAmount();

                if (expenseMap.containsKey(participant)) {
                    if (userExpense.getExpenseType() == ExpenseType.PAID) {
                        expenseMap.put(participant, expenseMap.get(participant) + amount);

                    } else {
                        expenseMap.put(participant, expenseMap.get(participant) - amount);
                    }
                } else {//coming for the first time
                    if (userExpense.getExpenseType() == ExpenseType.PAID) {
                        expenseMap.put(participant, 0 + amount);
                    } else {
                        expenseMap.put(participant, 0 - amount);
                    }
                }
            }
        }
        return expenseMap;
    }
}
