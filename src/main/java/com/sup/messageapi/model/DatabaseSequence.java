package com.sup.messageapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;
    private int seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseSequence that = (DatabaseSequence) o;
        return seq == that.seq && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seq);
    }
}
