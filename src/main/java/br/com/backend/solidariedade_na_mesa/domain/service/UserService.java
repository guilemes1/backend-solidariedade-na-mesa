package br.com.backend.solidariedade_na_mesa.domain.service;

import br.com.backend.solidariedade_na_mesa.domain.repository.BillingAdressRepository;
import br.com.backend.solidariedade_na_mesa.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillingAdressRepository billingAdressRepository;

    public ResponseEntity atualizarUser() {
        return null;
    }
}
