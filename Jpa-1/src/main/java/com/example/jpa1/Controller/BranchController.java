package com.example.jpa1.Controller;


import com.example.jpa1.Model.Branch;
import com.example.jpa1.Repository.BranchRepository;
import com.example.jpa1.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity getbranch(){
        return ResponseEntity.status(200).body(branchService.getBranch());
    }

//    @PostMapping("/add/{merchant_id}")
//    public ResponseEntity add(@PathVariable Integer merchant_id, @RequestBody @Valid Branch branch){
//        branchService.addBranch(merchant_id, branch);
//
//        return ResponseEntity.status(200).body("branch added");
//    }


    @PostMapping("/add")
    public ResponseEntity add( @RequestBody @Valid Branch branch){
        branchService.addBranch(branch);

        return ResponseEntity.status(200).body("branch added");
    }

    @PostMapping("/assign/{merchant_id}/{branch_id}")
    public ResponseEntity assignMerchantToBranch(@PathVariable Integer merchant_id,@PathVariable Integer branch_id){
        branchService.assignMerchantBranch(merchant_id, branch_id);
        return ResponseEntity.status(200).body("assign Merchant To Branch");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Branch updatedBranch) {
        branchService.updateBranch(id, updatedBranch);
        return ResponseEntity.status(200).body("Branch updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body("Branch deleted");
    }

}
