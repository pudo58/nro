package com.nro.god.controller;

import com.nro.god.bean.ResponseData;
import com.nro.god.model.Token;
import com.nro.god.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/token")
@CrossOrigin("http://localhost")
public class TokenController {
    @Autowired
    TokenService tokenService;
    @GetMapping("/get/{id}")
    public Token getTokenById(@PathVariable Long id) {
        return tokenService.findById(id);
    }
    @GetMapping("/get")
    public List<Token> findAll() {
        return tokenService.findAll();
    }
    @GetMapping("/find/{token}")
    public ResponseData<Token> findByToken(@PathVariable String token) {
        return tokenService.findByToken(token);
    }
    @GetMapping("/find-account/{accountId}")
    public Token findByAccountId(@PathVariable Integer accountId) {
        return tokenService.findByAccountId(accountId);
    }
    @PostMapping("/save")
    public Token save(@RequestBody Token token) {
        return tokenService.save(token);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long  id) {
        tokenService.deleteById(id);
    }
}
