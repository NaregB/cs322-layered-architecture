package am.homework.api.controller;

import am.homework.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(value = "/check-balance/{id}")
    public ResponseEntity<?> checkBalance(@PathVariable Long id) {
        double balance = bankAccountService.checkBalance(id);
        return balance == -1 ? ResponseEntity.notFound().build() : ResponseEntity.ok(balance);
    }
}
