package com.example.jpa1.Controller;


import com.example.jpa1.Model.Customer;
import com.example.jpa1.Model.Merchant;
import com.example.jpa1.Service.MerchantServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Merchant")
@RequiredArgsConstructor
public class MerchantController {

    private  final MerchantServise merchantServise;


    public ResponseEntity get(){
        return ResponseEntity.status(200).body(merchantServise.getAllMerchant());
    }


    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Merchant merchant) {
        merchantServise.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer id, @RequestBody @Valid Merchant merchant) {
        merchantServise.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body("Merchant updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        merchantServise.delete(id);
        return ResponseEntity.status(200).body("Merchant deleted successfully.");
    }
}
