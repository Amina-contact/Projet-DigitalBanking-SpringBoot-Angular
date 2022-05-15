package org.sid.ebankingbackend.services;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.exceptions.BalanceNotSufficientException;
import org.sid.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;
import java.util.List;

public interface BankAccountService {
     Customer saveCustomer(Customer customer);
     CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
     SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
     List<Customer> listCustomers();
     BankAccount getBankAccount(String accountId)throws BankAccountNotFoundException;
     void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
     void credit(String accountId,double amount,String description) throws BankAccountNotFoundException;
     void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
     List<BankAccount> bankAccountList();
}
