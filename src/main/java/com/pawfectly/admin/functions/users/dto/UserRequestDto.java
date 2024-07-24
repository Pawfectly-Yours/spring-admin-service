package com.pawfectly.admin.functions.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String email;

    private String firstName;

    private String lastName;

    private String middleName;

    private String address;

    private String mobileNo;

    private String password;
}
