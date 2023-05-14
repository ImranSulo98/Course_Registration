package com.course_registration.service;

import com.course_registration.model.Registration;
import com.course_registration.repository.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @Override
    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration createRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Long id, Registration newRegistration) {
        Registration registration = registrationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        registration.setName(newRegistration.getName());
        return registrationRepository.save(newRegistration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        registrationRepository.deleteById(id);
    }
}
