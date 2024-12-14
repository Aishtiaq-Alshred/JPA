package com.example.jpa1.Service;


import com.example.jpa1.Api.ApiException;
import com.example.jpa1.Model.Merchant;
import com.example.jpa1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantServise {

    private  final MerchantRepository merchantRepository;



    public List<Merchant> getAllMerchant(){

        return merchantRepository.findAll();
    }

    public  void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    public void  updateMerchant(Integer id,Merchant merchant){

        Merchant merchant1=merchantRepository.findMerchantsById(id);

        if(merchant1==null){
            throw  new ApiException("Merchant not found");
        }

        merchant1.setName(merchant.getName());
        merchantRepository.save(merchant1);
    }


    public void  delete(Integer id){
        Merchant merchant=merchantRepository.findMerchantsById(id);

        if(merchant==null){
            throw new ApiException("Merchant not found");
        }
        merchantRepository.delete(merchant);
    }
}
