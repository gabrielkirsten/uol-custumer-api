package br.com.uol.custumerapi.controller;

import br.com.uol.custumerapi.model.dto.CustumerDTO;
import br.com.uol.custumerapi.service.CustumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("custumers")
public class CustumerController {

    private CustumerService custumerService;

    public CustumerController(CustumerService custumerService) {
        this.custumerService = custumerService;
    }

    @PostMapping
    public ResponseEntity postCustumer(@RequestBody CustumerDTO custumerDto) {
        return ResponseEntity.ok(custumerService.addNewCustumer(custumerDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCostumer(@PathVariable Long id) {
        return ResponseEntity.ok(custumerService.getCostumerById(id));
    }

    @GetMapping
    public ResponseEntity getCostumer() {
        return ResponseEntity.ok(custumerService.getAllCustumers());
    }

}