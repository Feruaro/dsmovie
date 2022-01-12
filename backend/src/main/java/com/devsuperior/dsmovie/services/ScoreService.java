package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.exception.ObjectNotFoundException;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ScoreRepository repo;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO objDTO) {
		User user = userRepo.findByEmail(objDTO.getEmail());		
		if(user == null) {
			user = userRepo.saveAndFlush(new User(null, objDTO.getEmail()));
		}
		
		Movie movie = movieRepo.findById(objDTO.getMovieId()).orElseThrow(() -> new ObjectNotFoundException("Movie", objDTO.getMovieId()));
		
		repo.saveAndFlush(new Score(movie, user, objDTO.getScore()));
		
		double sum = 0d;
		for(Score i : movie.getScores()) {
			sum += i.getValue();
		}
		
		int count = movie.getScores().size();
		double avg = sum / count;
		
		movie.setCount(count);
		movie.setScore(avg);
		movie = movieRepo.save(movie);	
		
		return new MovieDTO(movie);
	}
	
	
}
