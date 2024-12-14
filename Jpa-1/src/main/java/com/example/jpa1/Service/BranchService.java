package com.example.jpa1.Service;

import com.example.jpa1.Api.ApiException;
import com.example.jpa1.Model.Branch;
import com.example.jpa1.Model.Merchant;
import com.example.jpa1.Repository.BranchRepository;
import com.example.jpa1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    private final MerchantRepository merchantRepository;


    public List<Branch> getBranch(){
        return branchRepository.findAll();
    }


//// flow1
//    public  void addBranch(Integer merchant_id, Branch branch){
//        Merchant merchant=merchantRepository.findMerchantsById(merchant_id);
//        if(merchant==null){
//            throw  new ApiException("Merchant not found");
//        }
//
//        branch.setMerchant(merchant);
//        branchRepository.save(branch);
//    }

    //flow2

    public void addBranch(Branch branch){
        branchRepository.save(branch);
    }



    public void assignMerchantBranch(Integer merchant_id,Integer Branch_id){
        Merchant merchant=merchantRepository.findMerchantsById(merchant_id);

        Branch branch=branchRepository.findBranchById(Branch_id);

        if(merchant==null|| branch==null){
            throw new ApiException("cant assign");
        }

        branch.setMerchant(merchant);

        branchRepository.save(branch);

    }


    public void  updateBranch(Integer id,Branch branch){

        Branch branch1=branchRepository.findBranchById(id);

        if(branch1==null){
            throw  new ApiException("Branch not found");
        }

         branch1.setArea(branch.getArea());
        branchRepository.save(branch1);
    }


    public void  deleteBranch(Integer id){
        Branch branch1=branchRepository.findBranchById(id);
        if(branch1==null){
            throw new ApiException("Branch not found");
        }
        branchRepository.delete(branch1);
    }







}
