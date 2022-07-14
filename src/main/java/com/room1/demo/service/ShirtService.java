package com.room1.demo.service;

import com.room1.demo.models.Shirt;
import com.room1.demo.repositories.ShirtRepository;
import com.room1.demo.viewmodel.ShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public ShirtViewModel saveShirt(ShirtViewModel viewModel) {
        Shirt s = new Shirt();
            s.setPrice(viewModel.getPrice());
            s.setColor(viewModel.getColor());
            s.setSize(viewModel.getSize());
            s.setDescription(viewModel.getDescription());
            s.setQuantity(viewModel.getQuantity());

        shirtRepository.save(s);
        viewModel.setId(s.getId());

        return viewModel;
    }


    public ShirtViewModel findShirt(int id)   {
        Optional<Shirt> shirt = shirtRepository.findById(id);

        return shirt.isPresent() ? buildShirtViewModel(shirt.get()) : null;

    }

    public List<ShirtViewModel> findAllShirtViewModels() {
        List<Shirt> shirtList = shirtRepository.findAll();
        List<ShirtViewModel> ivmList = new ArrayList<>();

        for(Shirt shirt : shirtList) {
            ShirtViewModel ivm = buildShirtViewModel(shirt);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    public void updateShirt(ShirtViewModel viewModel) {
        Shirt s = new Shirt();
        s.setId(viewModel.getId());
        s.setPrice(viewModel.getPrice());
        s.setColor(viewModel.getColor());
        s.setSize(viewModel.getSize());
        s.setDescription(viewModel.getDescription());
        s.setQuantity(viewModel.getQuantity());
        shirtRepository.save(s);

    }

    public void removeShirt(int id) {
        shirtRepository.deleteById(id);
    }

    public List<ShirtViewModel> findAllShirtsByColor(String color){
        List<Shirt> shirtList = shirtRepository.findAllShirtsByColor(color);
        List<ShirtViewModel> viewModelList = new ArrayList<>();
        for( Shirt shirt : shirtList){
            ShirtViewModel swm = buildShirtViewModel(shirt);
            viewModelList.add(swm);
        }
       return viewModelList;
    }

    public List<ShirtViewModel> findAllShirtsBySize(String size) {
        List<Shirt> shirtList = shirtRepository.findAllShirtsBySize(size);
        List<ShirtViewModel> viewModelList = new ArrayList<>();
        for (Shirt shirt : shirtList) {
            ShirtViewModel swm = buildShirtViewModel(shirt);
            viewModelList.add(swm);
        }
        return viewModelList;


    }

    private ShirtViewModel buildShirtViewModel(Shirt shirt) {

        ShirtViewModel ivm = new ShirtViewModel();
        ivm.setId(shirt.getId());
        ivm.setPrice(shirt.getPrice());
        ivm.setSize(shirt.getSize());
        ivm.setDescription(shirt.getDescription());
        ivm.setQuantity(shirt.getQuantity());
        ivm.setColor(shirt.getColor());

        // Return the Shirt View Model
        return ivm;
    }




}
