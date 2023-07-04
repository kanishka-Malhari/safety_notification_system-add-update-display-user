package com.example.User.Service;

import com.example.User.dto.PetRequest;
import com.example.User.dto.PetResponse;

public interface PetService {


        Integer registerPet(PetRequest pet);

        PetResponse getPetById(Integer petId);

        PetResponse updatePetDetails(Integer petId, PetRequest petRequest);
    }

