package com.example.jpa1.Service;

import com.example.jpa1.Api.ApiException;
import com.example.jpa1.DTO.ProfileDTO;
import com.example.jpa1.Model.Customer;
import com.example.jpa1.Model.Profile;
import com.example.jpa1.Repository.CustomerRepository;
import com.example.jpa1.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final CustomerRepository customerRepository;

    public List<Profile> getAllProfile(){

        return  profileRepository.findAll();
    }


    public void addProfile(ProfileDTO profileDTO){
        Customer customer=customerRepository.findCustomerById(profileDTO.getCustomer_id());

    if(customer==null){
        throw new ApiException((" Customer not found"));
    }

    Profile profile=new Profile(null,profileDTO.getPhoneNumber(),profileDTO.getGender(),profileDTO.getAge(),profileDTO.getEmail(),customer);

    profileRepository.save(profile);

    }

    public void update(ProfileDTO profileDTO){
        Profile profile=profileRepository.findProfileById(profileDTO.getCustomer_id());

        if(profile==null){
            throw new ApiException(("not found"));
        }

        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAge(profileDTO.getAge());
        profile.setGender(profileDTO.getGender());
        profile.setEmail(profileDTO.getEmail());

        profileRepository.save(profile);
    }


    public  void delete(Integer id){
        profileRepository.findProfileById(id);
    }


}
