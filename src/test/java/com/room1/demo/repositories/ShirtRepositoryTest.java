package com.room1.demo.repositories;

import com.room1.demo.models.Shirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShirtRepositoryTest {

    @Autowired
    ShirtRepository shirtRepository;

    @Before
    public void setUp() throws Exception {
        shirtRepository.deleteAll();

        shirtRepository.save(new Shirt(1, "small", "white", "shirt", BigDecimal.valueOf(10.00), 10));
        shirtRepository.save(new Shirt(2, "medium", "white", "shirt", BigDecimal.valueOf(10.00), 10));
        shirtRepository.save(new Shirt(3, "large", "white", "shirt", BigDecimal.valueOf(10.00), 10));
        shirtRepository.save(new Shirt(4, "large", "blue", "shirt", BigDecimal.valueOf(10.00), 10));
        shirtRepository.save(new Shirt(5, "large", "red", "shirt", BigDecimal.valueOf(10.00), 10));
        shirtRepository.save(new Shirt(6, "large", "black", "shirt", BigDecimal.valueOf(10.00), 10));

    }

    @Test
    public void findAllShirtsByColor() {
        List<Shirt> whiteShirtList = shirtRepository.findAllShirtsByColor("white");
        assertEquals(3, whiteShirtList.size());
    }

    @Test
    public void findAllShirtsBySize() {
        List<Shirt> largeShirtList = shirtRepository.findAllShirtsBySize("large");
        assertEquals(4, largeShirtList.size());

    }
}