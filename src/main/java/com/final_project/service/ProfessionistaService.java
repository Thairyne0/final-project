package com.final_project.service;

import com.final_project.entity.Professionista;
import com.final_project.entity.Utente;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.repository.UtenteRepository;
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
    public Professionista creaProfiloProfessionista(Long utenteId, String indirizzo,
                                                    String nomeAzienda, String regione, String citta,
                                                    String provincia, String cap, String email) {
        Utente utente = utenteRepository.findByIdUtente(utenteId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (utente.getProfessionista() != null) {
            throw new RuntimeException("L'utente ha già un profilo professionista");
        }

        Professionista professionista = new Professionista();
        professionista.setUtente(utente);
        professionista.setNome(utente.getNome());
        professionista.setCognome(utente.getCognome());
        professionista.setEmail(email);
        professionista.setNomeAzienda(nomeAzienda);
        professionista.setRegione(regione);
        professionista.setIndirizzo(indirizzo);
        professionista.setCitta(citta);
        professionista.setProvincia(provincia);
        professionista.setCap(cap);

        return professionistaRepository.save(professionista);
    }
}
