package com.example.jpa1.Controller;


import com.example.jpa1.DTO.ProfileDTO;
import com.example.jpa1.Model.Customer;
import com.example.jpa1.Model.Profile;
import com.example.jpa1.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;


    @GetMapping("/get")
    public ResponseEntity getProfile(){
        return ResponseEntity.status(200).body(profileService.getAllProfile());
    }



    @PostMapping("/add")
    public ResponseEntity addProfile(@RequestBody ProfileDTO profileDTO){

        profileService.addProfile(profileDTO);

        return ResponseEntity.status(200).body("Profile add");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProfile(@RequestBody @Valid ProfileDTO profileDTO) {
        profileService.update(profileDTO);
        return ResponseEntity.status(200).body("ProfileDTO updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Integer id) {
        profileService.delete(id);
        return ResponseEntity.status(200).body("ProfileDTO deleted successfully.");
    }





}
