package com.epicEnergyServices.request;


import com.epicEnergyServices.entity.Cliente;
import com.epicEnergyServices.entity.StatoFattura;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FatturaRequest {

    @NotNull(message = "Date is required")
    private LocalDate data;

    @NotNull(message = "Amount is required")
    private String importo;

    @NotNull(message = "Status is required")
    private StatoFattura stato;

    @NotNull(message = "Invoice number is required")
    private String numeroFattura;

    @NotNull(message = "Customer ID is required")
    private Long idCliente;

}
