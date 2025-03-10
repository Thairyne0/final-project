package com.final_project.service;

import com.final_project.entity.Professionista;
import com.final_project.entity.Utente;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.ProfessionistaRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionistaService {

    @Autowired
    private ProfessionistaRepository professionistaRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Transactional
    public Professionista creaProfiloProfessionista(ProfessionistaRequest professionistaRequest) {
        Utente utente = utenteRepository.findById(professionistaRequest.getUtenteId())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (utente.getProfessionista() != null) {
            throw new RuntimeException("L'utente ha già un profilo professionista");
        }

        Professionista professionista = new Professionista();
        professionista.setUtente(utente);
        professionista.setNome(utente.getNome());
        professionista.setCognome(utente.getCognome());
        professionista.setEmail(professionistaRequest.getEmail());
        professionista.setNomeAzienda(professionistaRequest.getNomeAzienda());
        professionista.setRegione(professionistaRequest.getRegione());
        professionista.setIndirizzo(professionistaRequest.getIndirizzo());
        professionista.setCitta(professionistaRequest.getCitta());
        professionista.setProvincia(professionistaRequest.getProvincia());
        professionista.setCap(professionistaRequest.getCap());
        

        return professionistaRepository.save(professionista);
    }
}
