package com.example.jpa1.Repository;


import com.example.jpa1.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

    Merchant findMerchantsById(Integer id);
}
