package com.example.User.dto;

public class PetRequest {

    private String petName;
    private Float age;
    private String gender;
    private String category;

    public PetRequest(String petName, Float age, String gender, String category) {
        this.petName = petName;
        this.age = age;
        this.gender = gender;
        this.category = category;
    }

    public PetRequest() {
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PetRequest{" +
                "petName='" + petName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
