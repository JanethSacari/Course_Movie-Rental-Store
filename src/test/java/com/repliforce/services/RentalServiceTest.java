package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;
import com.repliforce.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class RentalServiceTest {

    @Test
    public void testRentMovie() {
        // Set up the test environment
        RentalService rentalService = new RentalService();
        User user = new User("X");
        Movie movie = new Movie("The Day of Sigma", 2, 10.0);

        // Execute the method to be tested
        Rent rent = rentalService.rentMovie(user, movie);

        // Verify the results
        Assert.assertTrue(rent.getPrice() == 10.0);
        Assert.assertTrue(DateUtils.isSameDate(rent.getRentDate(), new Date()));
        Assert.assertTrue(DateUtils.isSameDate(rent.getReturnDate(), DateUtils.obterDataComDiferencaDias(1)));
    }
}
