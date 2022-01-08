package com.papcenter.service.impl;

import com.papcenter.exception.ModelNotFoundException;
import com.papcenter.model.Cesfam;
import com.papcenter.model.Matrona;
import com.papcenter.repository.CesfamRepository;
import com.papcenter.service.CesfamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CesfamServiceImpl implements CesfamService {

    @Autowired
    private CesfamRepository cesfamRepository;


    @Override
    public List<Cesfam> findAll() {
        return cesfamRepository.findAll();
    }

    @Override
    public Cesfam findById(Integer id) {
        Optional<Cesfam> op = cesfamRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }else{
            throw new ModelNotFoundException("Cesfam no encontrado");
        }
    }

    @Override
    public Cesfam save(Cesfam cesfam) {
        return cesfamRepository.save(cesfam);
    }

    @Override
    public Cesfam update(Cesfam cesfam) {
        return save(cesfam);
    }

    @Override
    public boolean delete(Integer id) {
        cesfamRepository.deleteById(id);
        return true;
    }
}
