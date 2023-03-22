package com.guptaji.util;

import com.guptaji.entity.BankEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankUtil {

    public static List<BankEntity> bankEntities = new ArrayList<>();

    static {
        bankEntities.add(new BankEntity(1, "HDFC", "HDFC001", "Agra", List.of("Savings", "Current", "Salary")));
        bankEntities.add(new BankEntity(2, "SBI", "SBI001", "Agra", List.of("Savings", "Loan", "Salary")));
        bankEntities.add(new BankEntity(3, "Indian", "Indian001", "Agra", List.of("Current", "Salary")));
        bankEntities.add(new BankEntity(4, "ICICI", "ICICI001", "Agra", List.of("Savings", "Current", "Salary")));
    }

    public static List<BankEntity> returnBankDetails(){
        return bankEntities;
    }

    public static List<BankEntity> addNewBankEntity(BankEntity bankEntity){
        bankEntities.add(bankEntity);
        return bankEntities;
    }

    public static List<BankEntity> deleteBankEntity(BankEntity bankEntity){
        bankEntities.remove(bankEntity);
        return bankEntities;
    }

    public static BankEntity findBankById(int id){
        Optional<BankEntity> bankOptionalObject = bankEntities.stream().filter(temp -> temp.getId() == id).findFirst();
        if (bankOptionalObject.isPresent()){
            return bankOptionalObject.get();
        } else {
            return null;
        }
    }

}
