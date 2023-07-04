package com.example.User.Service;

import com.example.User.Entity.Pet;
import com.example.User.Repository.PetRepository;
import com.example.User.dto.PetRequest;
import com.example.User.dto.PetResponse;
import com.example.User.dto.UserRequest;
import com.example.User.dto.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer registerPet(PetRequest petRequest) {
        Pet pet = convertToPetEntity(petRequest);
        Pet savedPet = petRepository.save(pet);
        return savedPet.getId();
    }


    @Override
    public PetResponse getPetById(Integer petId) {
        Pet pet = petRepository.findById(petId).orElse(null);
        if (pet == null) {
            // Handle the case when the pet is not found
            return null;
        }
        return convertToPetResponse(pet);
    }


    @Override
    public PetResponse updatePetDetails(Integer petId, PetRequest petRequest) {
        Pet pet = petRepository.findById(petId).orElse(null);
        if (pet == null) {
            // Handle the case when the pet is not found
            return null;
        }
        updatePetEntity(pet, petRequest);
        Pet updatedPet = petRepository.save(pet);
        return convertToPetResponse(updatedPet);
    }

    private void updatePetEntity(Pet pet, PetRequest petRequest) {
        pet.setPetName(petRequest.getPetName());
        pet.setAge(petRequest.getAge());
        pet.setGender(petRequest.getGender());
        pet.setCategory(petRequest.getCategory());
    }

    private Pet convertToPetEntity(PetRequest petRequest) {
        return modelMapper.map(petRequest, Pet.class);
    }

    private PetResponse convertToPetResponse(Pet pet) {
        return modelMapper.map(pet, PetResponse.class);
    }
}
