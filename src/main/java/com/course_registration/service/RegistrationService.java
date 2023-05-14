package com.course_registration.service;

import com.course_registration.model.Registration;

import java.util.List;

public interface RegistrationService {

    Registration getRegistrationById(Long id);

    List<Registration> getAllRegistration();

    Registration createRegistration(Registration registration);

    Registration updateRegistration(Long id, Registration registration);

    void deleteRegistration(Long id);
}
