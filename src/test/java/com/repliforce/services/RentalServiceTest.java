package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

import static com.repliforce.utils.DateUtils.isSameDate;
import static com.repliforce.utils.DateUtils.obtainDateWithDifferenceOfDays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalServiceTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testRentMovie() {
        // Set up the test environment
        RentalService rentalService = new RentalService();
        User user = new User("X");
        Movie movie = new Movie("The Day of Sigma", 2, 10.0);

        // Execute the method to be tested
        Rent rent = rentalService.rentMovie(user, movie);

        // Verify the results
        collector.checkThat(rent.getPrice(), is(equalTo(10.0)));
        collector.checkThat(isSameDate(rent.getRentDate(), new Date()), is(true));
        collector.checkThat(isSameDate(rent.getReturnDate(), obtainDateWithDifferenceOfDays(1)), is(true));
    }
}
