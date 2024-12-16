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


       Comparator<UserAmount> minheapComparator=Comparator.comparingDouble(UserAmount::getAmount);
       Comparator<UserAmount> maxheapComparator=Comparator.comparingDouble(UserAmount::getAmount);

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
        List<SettlementTransaction> settlement=new ArrayList<>();
        while(!minPriority.isEmpty() && !maxPriority.isEmpty()){
            UserAmount lender=maxPriority.poll();
            UserAmount borrower=minPriority.poll();

        }

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
    }
}
