package se.krho.generalpersonallife.datalake.model.dao.finance;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Transaction{

    @PrimaryKey
    private final UUID id;

    private final String date;

    public Transaction(UUID id, String date) {
        this.id = id;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("{ @type = %1$s, id = %2$s, date = %3$s }",
                getClass().getName(), getId(), getDate());
    }



}
