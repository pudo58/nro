package com.nro.god.service;

import com.nro.god.bean.ResponseData;
import com.nro.god.model.Account;
import com.nro.god.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    com.nro.god.repository.AccountRepository accountRepository;
    @Autowired
    com.nro.god.repository.TokenRepository tokenRepository;

    public Account getAccountById(Integer id) {
        return accountRepository.findById(id).get();
    }
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    public Account save(Account account) {
        if(findByUsername(account.getUsername())!=null) {
            throw new RuntimeException("Username đã tồn tại");
        }
        else if(account.getUsername().matches("^[a-zA-Z]+$[8,]"))
            throw new RuntimeException("Username phải có ít nhất 8 ký tự và không có ký tự đặc biệt");
        else if(account.getPassword().matches("^[a-zA-Z]+$[8,]"))
            throw new RuntimeException("Password phải có ít nhất 8 ký tự và không có ký tự đặc biệt");
        return accountRepository.save(account);
    }
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }
    public Account update(Account account,Integer id) {
        Account account1 = accountRepository.findById(id).get();
        account1.setUsername(account1.getUsername());
        if(account.getPassword().matches("^[a-zA-Z0-9]+$[8,]"))
            throw new RuntimeException("Password phải có ít nhất 8 ký tự và không có ký tự đặc biệt");
        account1.setPassword(account.getPassword());
        account1.setThoiVang(account.getThoiVang());
        account1.setRole(account.getRole());
        account1.setActive(account.getActive());
        account1.setIsAdmin(account.getIsAdmin());
        return accountRepository.save(account1);
    }
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
    public ResponseData login(String username, String password) {
        Account account1 = accountRepository.findByUsernameAndPassword(username, password);
        if(account1 == null){
            return new ResponseData<Account>(HttpStatus.FORBIDDEN.value(), "Username or password is incorrect", null,null);
        }else {
           if(tokenRepository.findByAccountId(account1.getId()) != null){
               tokenRepository.deleteById(tokenRepository.findByAccountId(account1.getId()).getId());
               Token token = new Token();
               token.setCode(UUID.randomUUID().toString());
               token.setCreated(new Date());
               token.setAccount(account1);
               tokenRepository.save(token);
               return new ResponseData<Account>(HttpStatus.OK.value(), "Login successfully", account1,token.getCode());
           }
               Token token = new Token();
               token.setCode(UUID.randomUUID().toString());
               token.setCreated(new Date());
               token.setAccount(account1);
               tokenRepository.save(token);
               return new ResponseData<Account>(HttpStatus.OK.value(), "Login successfully", account1,token.getCode());
        }

    }
    public ResponseData logout(String token) {
        if (tokenRepository.findByToken(token) != null) {
            tokenRepository.deleteById(tokenRepository.findByToken(token).getId());
            return new ResponseData<Account>(HttpStatus.OK.value(), "Logout successfully", null, null);
        } else {
            return new ResponseData<Account>(HttpStatus.NO_CONTENT.value(), "Token is incorrect", null, null);
        }
    }
    public Account updatePasswordByUserHasLogin(String password, String token) {
        Account account = tokenRepository.findByToken(token).getAccount();
        account.setPassword(password);
        return accountRepository.save(account);
    }
    public Account updatePasswordNotLogin(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        account.setPassword(password);
        return accountRepository.save(account);
    }
    public Page<Account> paging(Optional<Integer> page,int size,String token){
        if(tokenRepository.findByToken(token) == null)
            throw new RuntimeException("Not loggin");
        return accountRepository.findAll(PageRequest.of(page.orElse(0),size));
    }
    public List<Account>findByUsernameEquals(String username){
        return accountRepository.findByUsernameEquals(username);
    }

}
