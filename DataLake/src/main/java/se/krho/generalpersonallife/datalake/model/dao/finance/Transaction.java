package se.krho.generalpersonallife.datalake.model.dao.finance;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public class Transaction extends se.krho.generalpersonallife.common.model.finance.Transaction {

    @PrimaryKey
    private UUID id;

}
