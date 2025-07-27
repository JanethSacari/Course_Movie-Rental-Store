package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;
import com.repliforce.utils.DateUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static com.repliforce.utils.DateUtils.isSameDate;
import static com.repliforce.utils.DateUtils.obtainDateWithDifferenceOfDays;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        assertThat(rent.getPrice(), is(equalTo(10.0)));
        assertThat(rent.getPrice(), is(not(6.0)));
        assertThat(isSameDate(rent.getRentDate(), new Date()), is(true));
        assertThat(isSameDate(rent.getReturnDate(), obtainDateWithDifferenceOfDays(1)), is(true));
    }
}
