package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Status;
import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.models.arcondicionado.ArCondicionado;
import com.pmoc.mirante.models.cabo.CaboModel;
import com.pmoc.mirante.models.combinador.CombinadorModel;
import com.pmoc.mirante.models.disjuntor.DisjuntorModel;
import com.pmoc.mirante.models.dps.DPSModel;
import com.pmoc.mirante.models.exaustor.ExaustorModel;
import com.pmoc.mirante.models.nobreak.NobreakModel;
import com.pmoc.mirante.models.parabolica.Parabolica;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import com.pmoc.mirante.models.switcher.SwitcherModel;
import com.pmoc.mirante.models.telemetria.TelemetriaModel;
import com.pmoc.mirante.models.torre.TorreModel;
import com.pmoc.mirante.models.transmissor.TransmissorModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record StationDTO(
        @NotNull
        Status status,
        @NotBlank
        String nome,
        @NotBlank
        String latitude,
        @NotBlank
        String longitude,
        @NotBlank
        Double endereco,
        String link_grafana,
        List<ReceptorModel> receptor,
        List<Parabolica> parabolica,
        List<AntenaModel> antena,
        List<ArCondicionado> arCondicionado,
        List<CaboModel> cabo,
        List<CombinadorModel> combinador,
        List<DisjuntorModel> disjuntor,
        List<DPSModel> dps,
        List<ExaustorModel> exaustor,
        List<NobreakModel> nobreak,
        List<SwitcherModel> switcher,
        List<TelemetriaModel> telemetria,
        List<TorreModel> torre,
        List<TransmissorModel> transmissor
) {
}
