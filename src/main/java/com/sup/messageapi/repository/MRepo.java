package com.sup.messageapi.repository;
import com.sup.messageapi.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MRepo extends MongoRepository<Message, Integer>{
}
