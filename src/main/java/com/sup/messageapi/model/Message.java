package com.sup.messageapi.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "messages")
public class Message {
    @Transient
    public static final String SEQUENCE_NAME = "messages_sequence";

    @Id
    private int id;
    @NotNull
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}

