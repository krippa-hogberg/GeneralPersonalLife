package se.krho.generalpersonallife.datalake.config.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import se.krho.generalpersonallife.datalake.model.dao.finance.Transaction;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, UUID> {

}
