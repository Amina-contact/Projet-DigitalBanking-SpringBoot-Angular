package org.sid.ebankingbackend.mappers;

import org.sid.ebankingbackend.dtos.AccountOperationDTO;
import org.sid.ebankingbackend.dtos.CurrentBankAccountDTO;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.dtos.SavingBankAccountDTO;
import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
//MapStruct framework prendre les proprietés du customer et les copier dans customerDTO
@Service
public class BankAccountMapperImpl {
    //le mapper transfert les données d'un objet vers un autre
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        //prendre les proprietés du customer et les copier dans customerDTO
        BeanUtils.copyProperties(customer,customerDTO);
        /*customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());*/
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
         SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
         BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
         savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
         savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
         return savingBankAccountDTO;
    }
    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
         SavingAccount savingAccount=new SavingAccount();
         BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
         savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO()));
         return savingAccount;
    }
    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
          CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
          BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
          currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
          currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
          return currentBankAccountDTO;
    }
    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
          CurrentAccount currentAccount=new CurrentAccount();
          BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
          currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
          return currentAccount;
    }
    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return  accountOperationDTO;
    }
}
