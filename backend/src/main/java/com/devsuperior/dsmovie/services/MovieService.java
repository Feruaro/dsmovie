package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.exception.ObjectNotFoundException;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> page = repo.findAll(pageable);	
		return page.map(x -> new MovieDTO(x));
	}
	
	public MovieDTO findById(Long id) {	
		return new MovieDTO(repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Movie", id)));		
	}
}
