package com.project.passwordManager.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String username;

    private String email;

}
