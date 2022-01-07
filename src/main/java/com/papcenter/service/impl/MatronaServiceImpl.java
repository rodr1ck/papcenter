package com.papcenter.service.impl;

import com.papcenter.model.Matrona;
import com.papcenter.repository.MatronaRepository;
import com.papcenter.service.MatronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatronaServiceImpl implements MatronaService {

    @Autowired
    private MatronaRepository matronaRepository;

    @Override
    public List<Matrona> findAll() {
        return matronaRepository.findAll();
    }

    @Override
    public Matrona findById(Integer id) {
        Optional<Matrona> matrona = matronaRepository.findById(id);
        return matrona.isPresent() ? matrona.get() : new Matrona();
    }

    @Override
    public Matrona save(Matrona matrona) {
        return matronaRepository.save(matrona);
    }

    @Override
    public Matrona update(Matrona matrona) {
        return save(matrona);
    }

    @Override
    public boolean delete(Integer id) {
        matronaRepository.deleteById(id);
        return true;
    }
}
