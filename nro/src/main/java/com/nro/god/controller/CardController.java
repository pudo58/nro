package com.nro.god.controller;

import com.nro.god.model.Card;
import com.nro.god.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
@CrossOrigin("http://localhost")
public class CardController {
    @Autowired
    CardService cardService;
    @PostMapping("/save")
    public Card save(@RequestBody Card card) {
        return cardService.save(card);
    }
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        cardService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public Card findById(@PathVariable Integer id) {
        return cardService.findById(id);
    }
    @PutMapping("/update/{id}")
    public Card update(@RequestBody Card card,@PathVariable Integer id) {
        return cardService.update(card,id);
    }
    @GetMapping("/get")
    public List<Card> findAll() {
        return cardService.findAll();
    }
    @GetMapping("/getDistinctName")
    public String[] findDistinctName() {
        return cardService.findDistinctName();
    }

}
