package com.tahaahvazi.instagram.repository;

import com.tahaahvazi.instagram.model.Photos;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photos, Integer> {
}
