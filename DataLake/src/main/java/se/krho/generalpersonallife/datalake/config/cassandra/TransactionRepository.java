package se.krho.generalpersonallife.datalake.config.cassandra;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import se.krho.generalpersonallife.datalake.model.dao.finance.Transaction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, UUID> {

    @AllowFiltering
    List<Transaction> findAllByDay(Date day);

    @AllowFiltering
    List<Transaction> findAllByCategory(String category);

    @AllowFiltering
    List<Transaction> findAllByDayAndCategory(Date day, String category);

}
