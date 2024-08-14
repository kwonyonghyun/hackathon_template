package com.example.hackathon_template_session.dto.request;

import lombok.Getter;
import lombok.Setter;


public record AddUserRequest(
        String email,
        String password
) {

}
