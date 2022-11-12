package com.nro.god.service;

import com.nro.god.bean.ResponseData;
import com.nro.god.model.Token;
import com.nro.god.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {
    @Autowired
    TokenRepository tokenRepository;
    public ResponseData<Token> findByToken(String token) {
        Token token1 = tokenRepository.findByToken(token);
         if(token1 != null)
            return new ResponseData<Token>(HttpStatus.OK.value(),"Success",token1,token1.getCode());
         return new ResponseData<Token>(HttpStatus.NOT_FOUND.value(), "Not found",null,null);
    }
    public Token findByAccountId(Integer accountId) {
        return tokenRepository.findByAccountId(accountId);
    }
    public Token save(Token token) {
        return tokenRepository.save(token);
    }
    public void deleteById(Long  id) {
        tokenRepository.deleteById(id);
    }
    public List<Token> findAll() {
        return tokenRepository.findAll();
    }
    public Token findById(Long id) {
        return tokenRepository.findById(id).get();
    }
}
