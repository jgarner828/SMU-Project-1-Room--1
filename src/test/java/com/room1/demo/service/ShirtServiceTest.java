package com.room1.demo.service;

import com.room1.demo.models.Invoice;
import com.room1.demo.models.Shirt;
import com.room1.demo.repositories.ShirtRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ShirtServiceTest {
    ShirtService shirtService;
    ShirtRepository shirtRepository;

    @Before
    public void setUp() throws Exception {
        setUpShirtRepositoryMock();

        shirtService = new ShirtService(shirtRepository);
        Shirt shirt2 = new Shirt();

        shirt2.setId(1);
        shirt2.setSize("medium");
        shirt2.setColor("Red");
        shirt2.setDescription("Good quality");
        shirt2.setPrice(new BigDecimal(25.66));
        shirt2.setQuantity(4);

        System.out.println("ShirtRepository.save(shirt) will return " + shirtRepository.save(shirt2));
        System.out.println("ShirtRepository.findById(shirt) will return " + shirtRepository.findById(1));
        System.out.println("ShirtRepository.findByAll(shirt) will return " + shirtRepository.findAll());
    }

    @Test
    public void justRunTheSetUp() {
        System.out.println("Placeholder");
    }

    private void setUpShirtRepositoryMock() {
        shirtRepository = mock(ShirtRepository.class);
        Shirt shirt = new Shirt();

        shirt.setId(1);
        shirt.setSize("medium");
        shirt.setColor("Red");
        shirt.setDescription("Good quality");
        shirt.setPrice(new BigDecimal(25.66));
        shirt.setQuantity(4);

        Shirt shirt2 = new Shirt();
        shirt2.setId(1);
        shirt2.setSize("medium");
        shirt2.setColor("Red");
        shirt2.setDescription("Good quality");
        shirt2.setPrice(new BigDecimal(25.66));
        shirt2.setQuantity(4);

        List<Shirt> inList = new ArrayList<>();
        inList.add(shirt);

        doReturn(shirt).when(shirtRepository).save(shirt2);
        doReturn(Optional.of(shirt)).when(shirtRepository).findById(1);
        doReturn(inList).when(shirtRepository).findAll();

    }

}