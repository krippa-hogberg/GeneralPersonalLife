package se.krho.generalpersonallife.datalake.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.krho.generalpersonallife.datalake.config.cassandra.TransactionRepository;
import se.krho.generalpersonallife.datalake.model.dao.finance.Transaction;
import se.krho.generalpersonallife.datalake.model.dto.ApiTestGreeting;

import java.util.UUID;

@RestController
public class DataLakeApiController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/api/status")
    public ApiTestGreeting greeting() {
        
        String message = "No message!";

        Transaction transaction = new Transaction(UUID.randomUUID(), "2019-01-31");
        if (transactionRepository == null) {
            message = "transactionRepository is empty";
        }
        else {
            transactionRepository.save(transaction);
            message = "check if item have been stored";
        }


        // Do the actual stuff
        return new ApiTestGreeting(1L, "Message: "+message+"!");
    }
}