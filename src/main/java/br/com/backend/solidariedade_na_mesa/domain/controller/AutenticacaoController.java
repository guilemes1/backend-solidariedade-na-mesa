package br.com.backend.solidariedade_na_mesa.domain.controller;

import br.com.backend.solidariedade_na_mesa.domain.dto.DadosAutenticacao;
import br.com.backend.solidariedade_na_mesa.domain.dto.DadosRegister;
import br.com.backend.solidariedade_na_mesa.domain.entities.UserEntity;
import br.com.backend.solidariedade_na_mesa.domain.repository.UserRepository;
import br.com.backend.solidariedade_na_mesa.infra.security.DadosTokenJWT;
import br.com.backend.solidariedade_na_mesa.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((UserEntity) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid DadosRegister dados) {
        var user = userRepository.findByLogin(dados.login());

        if (user != null) {
            return ResponseEntity.badRequest().body("Usuaŕio ja existe");
        }

        // Verificar se a senha e a confirmação são iguais
        if (!dados.senha().equals(dados.confirmarSenha())) {
            return ResponseEntity.badRequest().body("A senha e a confirmação da senha não correspondem.");
        }

        var novoUsuario = new UserEntity();
        novoUsuario.setFullName(dados.fullName());
        novoUsuario.setLogin(dados.login());
        novoUsuario.setSenha(passwordEncoder.encode(dados.senha())); // Criptografar a senha

        // Persistir o usuário no banco de dados
        userRepository.save(novoUsuario);

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
