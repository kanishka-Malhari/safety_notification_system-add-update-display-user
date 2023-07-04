package com.example.User.Controller;

import com.example.User.Service.PetService;
import com.example.User.dto.PetRequest;
import com.example.User.dto.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
@CrossOrigin
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/addPet")
    public Integer addPet(@RequestBody PetRequest pet){
        return  petService.registerPet(pet);
    }

    @GetMapping("/getPetDetails/{petId}")
    public PetResponse getPetById(@PathVariable Integer petId){
        return  petService.getPetById(petId);
    }

    @PutMapping("/updatePetDetails/{petId}")
    public PetResponse updateUserDetails(@PathVariable Integer petId,@RequestBody PetRequest petRequest){
        return  petService.updatePetDetails(petId,petRequest);
    }


}
