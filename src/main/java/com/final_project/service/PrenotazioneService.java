package com.final_project.service;

import com.final_project.entity.Prenotazione;
import com.final_project.entity.Professionista;
import com.final_project.entity.Utente;
import com.final_project.repository.PrenotazioneRepository;
import com.final_project.request.PrenotazioneRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Transactional
    public Prenotazione creaPrenotazione(PrenotazioneRequest prenotazioneRequest, Professionista professionista, Utente utente) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setMarcaVeicolo(prenotazioneRequest.getMarcaVeicolo());
        prenotazione.setModelloVeicolo(prenotazioneRequest.getModelloVeicolo());
        prenotazione.setDescrizioneProblema(prenotazioneRequest.getDescrizioneProblema());
        prenotazione.setFotoProblema(prenotazioneRequest.getFotoProblema());

        prenotazione.setNomeUtente(prenotazioneRequest.getNomeUtente());
        prenotazione.setCognomeUtente(prenotazioneRequest.getCognomeUtente());
        prenotazione.setEmailUtente(prenotazioneRequest.getEmailUtente());

        prenotazione.setRegione(prenotazioneRequest.getRegione());
        prenotazione.setIndirizzo(prenotazioneRequest.getIndirizzo());
        prenotazione.setCitta(prenotazioneRequest.getCitta());
        prenotazione.setProvincia(prenotazioneRequest.getProvincia());
        prenotazione.setCap(prenotazioneRequest.getCap());
        prenotazione.setDataPrenotazione(prenotazioneRequest.getDataPrenotazione());
        prenotazione.setOrarioPrenotazione(prenotazioneRequest.getOrarioPrenotazione());
        prenotazione.setProfessionista(professionista);
        prenotazione.setUtente(utente);

        return prenotazioneRepository.save(prenotazione);
    }
}

