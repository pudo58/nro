package com.nro.god.service;

import com.nro.god.model.CardDetail;
import com.nro.god.repository.CardDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardDetailService {
    @Autowired
    CardDetailRepository cardDetailRepository;

    public CardDetail save(CardDetail cardDetail) {
        return cardDetailRepository.save(cardDetail);
    }
    public void deleteById(Integer id) {
        cardDetailRepository.deleteById(id);
    }
    public CardDetail findById(Integer id) {
        return cardDetailRepository.findById(id).get();
    }
    public CardDetail update(CardDetail cardDetail,Integer id){
        CardDetail cardDetail1 = cardDetailRepository.findById(id).get();
        //cardDetail1.setCard(cardDetail.getCard());
        cardDetail1.setPrice(cardDetail.getPrice());
        cardDetail1.setThoiVang(cardDetail.getThoiVang());
        return cardDetailRepository.save(cardDetail1);
    }
    public List<CardDetail> findAll() {
        return cardDetailRepository.findAll();
    }
    public List<CardDetail> findByCardName(String name){
        return cardDetailRepository.findByCardName(name);
    }

}
