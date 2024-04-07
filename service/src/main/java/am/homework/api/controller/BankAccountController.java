package am.homework.api.controller;

import am.homework.api.dto.BankAccountDto;
import am.homework.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/debit-balance")
    public ResponseEntity<?> debitBalance(@RequestBody BankAccountDto bankAccountDto) {
        boolean success = bankAccountService.debit(bankAccountDto.getId(), bankAccountDto.getAmount());
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/credit-balance")
    public ResponseEntity<?> creditBalance(@RequestBody BankAccountDto bankAccountDto) {
        boolean success = bankAccountService.credit(bankAccountDto.getId(), bankAccountDto.getAmount());
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
