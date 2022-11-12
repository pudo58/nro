package com.nro.god.controller;

import com.nro.god.bean.ResponseData;
import com.nro.god.model.Account;
import com.nro.god.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin("http://localhost")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/get/{id}")
    public Account getAccountById(@PathVariable Integer id) {

        return accountService.getAccountById(id);
    }
    @GetMapping("/get")
    public List<Account> findAll() {
        return accountService.findAll();
    }
    @PostMapping("/save")
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        accountService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Account update(@RequestBody Account account,@PathVariable Integer id) {
        return accountService.update(account,id);
    }
    @GetMapping("/find/{username}")
    public Account findByUsername(@PathVariable String username) {
        return accountService.findByUsername(username);
    }
    @PostMapping("/login")
    public ResponseData login(@RequestParam String username,@RequestParam String password) {
        return accountService.login(username,password);
    }
    @PostMapping("/logout")
    public ResponseData logout(@RequestParam String token) {
        return accountService.logout(token);
    }
    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        return accountService.save(account);
    }
    @PostMapping("/change-password")
    public Account changePassword(@RequestParam String token,@RequestParam String password) {
        return accountService.updatePasswordByUserHasLogin(password,token);
    }
    @PostMapping("/change-password-account")
    public Account updatePasswordNotLogin(@RequestParam String username,@RequestParam String password) {
        return accountService.updatePasswordNotLogin(username,password);
    }
    @GetMapping("/page/{page}/{size}")
    public Page<Account> paging(@PathVariable Optional<Integer> page,@PathVariable int size,@RequestParam String token){
        return accountService.paging(page,size,token);
    }
    @GetMapping("/find/equals/{username}")
    public List<Account>findByUsernameEquals(@PathVariable String username){
        return accountService.findByUsernameEquals(username);
    }


}
