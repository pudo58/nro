package com.nro.god.service;

import com.nro.god.model.Card;
import com.nro.god.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }
    public void deleteById(Integer id) {
        cardRepository.deleteById(id);
    }
    public Card findById(Integer id) {
        return cardRepository.findById(id).get();
    }
    public Card update(Card card,Integer id) {
        Card card1 = cardRepository.findById(id).get();
        card1.setName(card.getName());
        card1.setKhuyenMai(card.getKhuyenMai());
        return cardRepository.save(card1);
    }
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
    public String[]findDistinctName(){
        return cardRepository.findDistinctName();
    }

}
