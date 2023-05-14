package com.course_registration.controller;


import com.course_registration.model.Registration;
import com.course_registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration/{id}")
    public Registration getRegistrationById(@PathVariable Long id){
        return registrationService.getRegistrationById(id);
    }

    @GetMapping("/registrations")
    public List<Registration> getAllRegistrations(){
        return registrationService.getAllRegistration();
    }

    @PostMapping("/registration")
    public Registration createRegistration(@RequestBody Registration registration){
        return registrationService.createRegistration(registration);
    }

    @PutMapping("/registration/{id}")
    public Registration updateRegistration(@PathVariable Long id,@RequestBody Registration registration){
        return registrationService.updateRegistration(id,registration);
    }

    @DeleteMapping("/registration/{id}")
    public void deleteRegistration(@PathVariable Long id){
        registrationService.deleteRegistration(id);
    }


}
