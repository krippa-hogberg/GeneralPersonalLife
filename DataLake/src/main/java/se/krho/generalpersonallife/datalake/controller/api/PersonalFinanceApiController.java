package se.krho.generalpersonallife.datalake.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.krho.generalpersonallife.datalake.config.cassandra.TransactionRepository;
import se.krho.generalpersonallife.datalake.model.dao.finance.Transaction;
import se.krho.generalpersonallife.datalake.model.dto.ApiTestGreeting;

import javax.ws.rs.QueryParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

@RestController
public class PersonalFinanceApiController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/api/personalfinance/transaction")
    public List<Transaction> getTransactions(@QueryParam("day") String day, @QueryParam("category") String category) throws ParseException {
        List<Transaction> transactions = null;

        Date dayAsDate = null;
        if (day != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            dayAsDate = sdf.parse(day);
        }

        if (day != null && category == null) transactions = transactionRepository.findAllByDay(dayAsDate);
        else if (day != null && category != null) transactions = transactionRepository.findAllByDayAndCategory(dayAsDate, category);
        else transactions = transactionRepository.findAll();


        return transactions;
    }

    @PostMapping("/api/personalfinance/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction, @QueryParam("force") String force) {
        if (force == null || !force.equals("existingId")) transaction.setId(UUID.randomUUID());
        transactionRepository.save(transaction);
        return transaction;
    }
}