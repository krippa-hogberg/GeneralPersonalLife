package se.krho.generalpersonallife.datalake.config.cassandra;

import com.google.common.collect.ImmutableSet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import se.krho.generalpersonallife.datalake.model.dao.finance.Transaction;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, UUID> {

}
