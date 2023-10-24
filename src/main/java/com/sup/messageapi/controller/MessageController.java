package com.sup.messageapi.controller;

import com.sup.messageapi.model.Message;
import com.sup.messageapi.repository.MRepo;
import com.sup.messageapi.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MRepo repo;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/messages")
    public String saveMessage(@RequestBody Message message){

        message.setId((int) service.generateSequence(Message.SEQUENCE_NAME));
        repo.save(message);

        return "Added Successfully";
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> getMessage(@PathVariable int id) {
        return repo.findById(id);
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {

        return repo.findAll();
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable int id){
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Successfully";
        }


        return "Message not found!";
    }
}
