package com.nro.god.controller;

import com.nro.god.model.RechargeCard;
import com.nro.god.service.RechargeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recharge-card")
@CrossOrigin("http://localhost")
public class RechargeCardController {
    @Autowired
    RechargeCardService rechargeCardService;

    @PostMapping("/save/{token}")
    public RechargeCard save(@RequestBody RechargeCard rechargeCard,@PathVariable String token) {
        return rechargeCardService.save(rechargeCard,token);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        rechargeCardService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public RechargeCard findById(@PathVariable Long id) {
        return rechargeCardService.findById(id);
    }
    @GetMapping("/get/{page}/{size}/{token}")
    public Page<RechargeCard> findAll(@PathVariable int page,@PathVariable int size,@PathVariable String token) {
        return rechargeCardService.findAll(page,size,token);
    }
    @GetMapping("/get")
    public List<RechargeCard> findAll() {
        return rechargeCardService.findAll();
    }
    @PutMapping("/update/{id}/{token}")
    public synchronized RechargeCard updateStatus(@PathVariable Long id,@RequestBody RechargeCard rechargeCard,@PathVariable String token) {
        return rechargeCardService.updateStatus(id,rechargeCard,token);
    }
    @GetMapping("/history/{token}")
    public List<RechargeCard>findRechargeCardByAccountIdLimit5(@PathVariable String token ){
        return  rechargeCardService.findRechargeCardByAccountIdLimit5(token);
    }
    @GetMapping("/get-by-status/{status}/{token}")
    public List<RechargeCard> getByStatus(@PathVariable Integer status,@PathVariable String token){
        return rechargeCardService.getByStatus(status,token);
    }

}
