package com.guptaji.service;

import com.guptaji.entity.BankEntity;
import com.guptaji.util.BankUtil;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BankService {

    public static final Logger LOG = Logger.getLogger(BankService.class);

    public List<BankEntity> sendAllBankDetails(){
        LOG.info("API Service::sendAllBankDetails() Hit");
        LOG.debug("API Service::sendAllBankDetails() received a request");
        List<BankEntity> bankDetails = BankUtil.returnBankDetails();
        LOG.info("returning from API Service::sendAllBankDetails() with some response");
        LOG.debug("API Service::sendAllBankDetails() sending a response ::"+ bankDetails);
        return bankDetails;
    }

    public List<BankEntity> addNewBank(BankEntity bankEntity){
        LOG.info("API Service::addNewBank() Hit");
        LOG.debug("API Service::addNewBank() received a request ::"+ bankEntity);
        List<BankEntity> bankDetails = BankUtil.addNewBankEntity(bankEntity);
        LOG.info("returning from API Service::addNewBank() with some response");
        LOG.debug("API Service::addNewBank() sending a response ::"+ bankDetails);
        return bankDetails;
    }

    public List<BankEntity> deleteBankDetailsFromServer(BankEntity bankEntity){
        LOG.info("API Service::deleteBankDetailsFromServer() Hit");
        LOG.debug("API Service::deleteBankDetailsFromServer() received a request ::"+ bankEntity);
        List<BankEntity> bankDetails = BankUtil.deleteBankEntity(bankEntity);
        LOG.info("returning from API Service::deleteBankDetailsFromServer() with some response");
        LOG.debug("API Service::deleteBankDetailsFromServer() sending a response ::"+ bankDetails);
        return bankDetails;
    }

    public BankEntity findBankDetailsById(int id){
        BankEntity bankEntity = BankUtil.findBankById(id);
        return bankEntity;
    }
}
