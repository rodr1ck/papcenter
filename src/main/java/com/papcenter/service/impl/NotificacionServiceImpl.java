package com.papcenter.service.impl;

import com.papcenter.exception.ModelNotFoundException;
import com.papcenter.model.Matrona;
import com.papcenter.model.Notificacion;
import com.papcenter.repository.NotificacionRepository;
import com.papcenter.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService{

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion findById(Integer id) {
        Optional<Notificacion> op = notificacionRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }else{
            throw new ModelNotFoundException("Notificacion no encontrada");
        }
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Notificacion update(Notificacion notificacion) {
        return save(notificacion);
    }

    @Override
    public boolean delete(Integer id) {
        notificacionRepository.deleteById(id);
        return true;
    }
}
