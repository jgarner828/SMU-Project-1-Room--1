package com.room1.demo.repositories;

import com.room1.demo.models.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();

        consoleRepository.save(
                new Console(1, "64", "Nintendo", "64kb", "AMD64",  BigDecimal.valueOf(19.99), 10));
        consoleRepository.save(
                new Console(2, "Genesis", "Sega", "64kb", "IBM",  BigDecimal.valueOf(19.99), 10));
        consoleRepository.save(
                new Console(3, "Xbox 360", "Microsoft", "64kb", "AMD64",  BigDecimal.valueOf(199.99), 10));
        consoleRepository.save(
                new Console(4, "Xbox", "Microsoft", "64Gb", "AMD",  BigDecimal.valueOf(299.99), 10));

    }

    @Test
    public void findConsoleByManufacturer() {
        List<Console> microsoftConsoles = consoleRepository.findConsoleByManufacturer("Microsoft");
        assertEquals(2, microsoftConsoles.size());

        List<Console> segaConsoles = consoleRepository.findConsoleByManufacturer("Sega");
        assertEquals(1, segaConsoles.size());
    }
}