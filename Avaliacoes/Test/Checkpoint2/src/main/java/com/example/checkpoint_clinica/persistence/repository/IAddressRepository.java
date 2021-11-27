package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Set JpaRepository queries provider
public interface IAddressRepository extends JpaRepository<AddressEntity, Integer> {

}
