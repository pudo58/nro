package com.nro.god.service;

import com.nro.god.model.Account;
import com.nro.god.model.RechargeCard;
import com.nro.god.repository.RechargeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RechargeCardService {
    @Autowired
    RechargeCardRepository  rechargeCardRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    TokenService tokenService;
    public RechargeCard save(RechargeCard rechargeCard, String token) {
        Account account = tokenService.findByToken(token).getData().getAccount();
        rechargeCard.setStatus(0);
        rechargeCard.setCreated(new Date());
        rechargeCard.setAccount(account);
        return rechargeCardRepository.save(rechargeCard);
    }
    public void deleteById(Long  id) {
        rechargeCardRepository.deleteById(id);
    }
    public List<RechargeCard> findAll() {
        return rechargeCardRepository.findAll();
    }
    public RechargeCard findById(Long id) {
        return rechargeCardRepository.findById(id).get();
    }
    public synchronized RechargeCard updateStatus(Long id,RechargeCard rechargeCard,String token) {
        Account acc = tokenService.findByToken(token).getData().getAccount();
        if(acc.getIsAdmin() == false )
            throw new RuntimeException("Not admin");

        RechargeCard rechargeCard1 = rechargeCardRepository.findById(id).get();
        if(rechargeCard1.getStatus()==1)
            throw new RuntimeException("This card has been used");
        rechargeCard1.setStatus(1);
       if(rechargeCardRepository.save(rechargeCard1)!=null){
           if(rechargeCard1.getStatus() == 1){
               Account account = rechargeCard1.getAccount();
               account.setId(rechargeCard1.getAccount().getId());
               if(account.getActive()==0)account.setActive(1);
               account.setThoiVang(account.getThoiVang()+rechargeCard1.getCardDetail().getThoiVang());
               accountService.update(account,account.getId());
           }
       }
        return rechargeCard1;
    }
    public Page<RechargeCard> findAll(int page, int size,String token) {
        Account acc = tokenService.findByToken(token).getData().getAccount();
        if(acc.getIsAdmin() == false )
            throw new RuntimeException("Not admin");
        Sort sort = Sort.sort(RechargeCard.class).by(RechargeCard::getCreated).descending();
        return rechargeCardRepository.findAll(PageRequest.of(page,size,sort));
    }
    public List<RechargeCard>findRechargeCardByAccountIdLimit5(String token){
        return rechargeCardRepository.findRechargeCardByAccountIdLimit5(token);
    }
    public List<RechargeCard> getByStatus(Integer status,String token){
        Account acc = tokenService.findByToken(token).getData().getAccount();
        if(acc.getIsAdmin() == false )
            throw new RuntimeException("Not admin");
        return rechargeCardRepository.getByStatus(status);
    }
}
