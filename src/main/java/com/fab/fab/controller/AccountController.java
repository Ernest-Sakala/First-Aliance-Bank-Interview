package com.fab.fab.controller;

import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.AccountModel;
import com.fab.fab.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody AccountModel accountModel) {

        try {

            accountService.addAccount(accountModel);

            return ResponseEntity.ok(new MessageDto("Account Added Successfully"));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getAccounts() {

        try {

            return ResponseEntity.ok(accountService.getAccounts());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping(path = "branch", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> accountsByBranch(@RequestParam(value = "branchId") int branchId) {

        try {

            return ResponseEntity.ok(accountService.getAccountByBranch(branchId));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

}
