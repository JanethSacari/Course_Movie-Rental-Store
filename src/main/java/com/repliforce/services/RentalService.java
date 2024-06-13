package com.repliforce.services;

import com.repliforce.entities.Movie;
import com.repliforce.entities.Rent;
import com.repliforce.entities.User;

import java.util.Date;
import static com.repliforce.utils.DataUtils.addDays;

public class RentalService {
	
	public Rent rentMovie(User user, Movie movie) {
		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setRentDate(new Date());
		rent.setPrice(movie.getRentalPrice());

		//Entrega no dia seguinte
		Date deliveryDate = new Date();
		deliveryDate = addDays(deliveryDate, 1);
		rent.setReturnDate(deliveryDate);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return rent;
	}

	public static void main(String[] args) {
		
	}
}