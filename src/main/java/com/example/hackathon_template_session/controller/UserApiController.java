package com.example.hackathon_template_session.controller;

import com.example.hackathon_template_session.dto.request.AddUserRequest;
import com.example.hackathon_template_session.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity signup(@RequestBody AddUserRequest request){
        Long createdUserId=userService.save(request);
        return ResponseEntity.ok(createdUserId);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        Map<String, String> result = new HashMap<>();
        result.put("message", "Logged out successfully");
        result.put("status", "success");

        return ResponseEntity.ok(result);
    }
}
