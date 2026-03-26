package com.selex.bigOne.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank(message ="Name is Required")String name , @NotBlank @Email String email) {
}
