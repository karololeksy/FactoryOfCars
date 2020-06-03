package com.miasi.project.service;

import com.miasi.project.delegates.CheckMaterialAvability;
import com.miasi.project.model.*;
import com.miasi.project.repository.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final CamundaService camundaService;

    private final EngineRepository engineRepository;
    private final ModelRepository modelRepository;
    private final PaintRepository paintRepository;
    private final TiresRepository tiresRepository;
    private final TransmissionRepository transmissionRepository;
    private final CheckMaterialAvability checkMaterialAvability;


    public void confirmOrder() {
        camundaService.receive();
    }

    public List<Engine> getEngines() {
        return engineRepository.findAll();
    }

    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    public List<Paint> getPaints() {
        return paintRepository.findAll();
    }

    public List<Tires> getTires() {
        return tiresRepository.findAll();
    }

    public List<Transmission> getTransmissions() {
        return transmissionRepository.findAll();
    }

    public boolean orderCar(CarOrder carOrder) {
        checkMaterialAvability.setCarOrder(carOrder);
        camundaService.start();
        return true;
    }
}
