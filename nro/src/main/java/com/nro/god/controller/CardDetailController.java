package com.nro.god.controller;

import com.nro.god.model.CardDetail;
import com.nro.god.service.CardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card-detail")
@CrossOrigin("http://localhost")
public class CardDetailController {
    @Autowired
    CardDetailService cardDetailService;
    @PostMapping("/save")
    public CardDetail save(@RequestBody CardDetail cardDetail) {
        return cardDetailService.save(cardDetail);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        cardDetailService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public CardDetail findById(@PathVariable Integer id) {
        return cardDetailService.findById(id);
    }
    @PutMapping("/update/{id}")
    public CardDetail update(@RequestBody CardDetail cardDetail, @PathVariable Integer id){
        return cardDetailService.update(cardDetail,id);
    }
    @GetMapping("/get")
    public List<CardDetail> findAll() {
        return cardDetailService.findAll();
    }
    @GetMapping("/get/card/{name}")
    public List<CardDetail> findByCardName(@PathVariable String name){
        return cardDetailService.findByCardName(name);
    }
}
