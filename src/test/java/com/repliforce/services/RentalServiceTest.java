package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static com.repliforce.utils.DateUtils.isSameDate;
import static com.repliforce.utils.DateUtils.obtainDateWithDifferenceOfDays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class RentalServiceTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRentMovie() throws Exception {
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

    //Elegant testing approach
    @Test(expected = Exception.class)
    public void testRentMovieWithNoStock() throws Exception {
        // Set up the test environment
        RentalService rentalService = new RentalService();
        User user = new User("X");
        Movie movie = new Movie("The Day of Sigma", 0, 10.0); // No stock available

        // Execute the method to be tested
        rentalService.rentMovie(user, movie);
    }

    //Robust testing approach
    @Test
    public void testRentMovieWithNoStoke_2() {
        // Set up the test environment
        RentalService rentalService = new RentalService();
        User user = new User("Zero");
        Movie movie = new Movie("The Day of Sigma", 0, 10.0); // No stock available

        try {
            // Execute the method to be tested
            rentalService.rentMovie(user, movie);
            // If no exception is thrown, the test should fail
            collector.addError(new AssertionError("Expected an exception to be thrown"));
        } catch (Exception e) {
            collector.checkThat(e.getMessage(), is(equalTo("Movie is not available for rent")));
        }
    }

    //New approach using ExpectedException rule
    @Test
    public void testRentMovieWithNoStoke_3() throws Exception {
        // Set up the test environment
        RentalService rentalService = new RentalService();
        User user = new User("Zero");
        Movie movie = new Movie("The Day of Sigma", 0, 10.0); // No stock available

        // Set the expected exception
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Movie is not available for rent");

        // Execute the method to be tested
        rentalService.rentMovie(user, movie);
    }
}
