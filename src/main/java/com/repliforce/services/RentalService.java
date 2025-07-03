package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;

import java.util.Date;

import static com.repliforce.utils.DateUtils.addDays;

public class RentalService {

	public Rent rentMovie(User user, Movie movie) {
		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setRentDate(new Date());
		rent.setPrice(movie.getRentalPrice());

		//Return date is set to one day after the rental date
		Date deliveryDate = new Date();
		deliveryDate = addDays(deliveryDate, 1);
		rent.setReturnDate(deliveryDate);
		
		// Set the movie as rented
		//TODO
		
		return rent;
	}
}