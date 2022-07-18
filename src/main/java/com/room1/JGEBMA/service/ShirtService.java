package com.room1.JGEBMA.service;

import com.room1.JGEBMA.models.Shirt;
import com.room1.JGEBMA.repositories.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class ShirtService {

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    public ShirtService(ShirtRepository shirtRepository) {
        this.shirtRepository = shirtRepository;
    }



    public List<Shirt> findAllShirts() { return shirtRepository.findAll();   }

    public Shirt findShirtById(int id)   {
        Optional<Shirt> shirt = shirtRepository.findById(id);
        return shirt.isPresent() ? shirt.get() : null;
    }

    @Transactional
    public Shirt saveShirt(Shirt shirt) { shirtRepository.save(shirt); return shirt;   }

    @Transactional
    public void updateShirt(Shirt shirt) {  shirtRepository.save(shirt);   }

    public void removeShirt(int id) {  shirtRepository.deleteById(id);    }

    public List<Shirt> findAllShirtsByColor(String color){ return shirtRepository.findAllShirtsByColor(color);  }

    public List<Shirt> findAllShirtsBySize(String size) { return shirtRepository.findAllShirtsBySize(size); }


}
