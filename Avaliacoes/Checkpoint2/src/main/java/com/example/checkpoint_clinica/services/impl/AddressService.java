package com.example.checkpoint_clinica.services.impl;

import com.example.checkpoint_clinica.persistence.entities.AddressEntity;
import com.example.checkpoint_clinica.persistence.repository.IAddressRepository;
import com.example.checkpoint_clinica.services.IClinicService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IClinicService<AddressEntity> {

    private final IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public AddressEntity saveAndFlush(AddressEntity addressEntity) {
        return addressRepository.saveAndFlush(addressEntity);
    }

    @Override
    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<AddressEntity> findById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        addressRepository.deleteById(id);
        return ResponseEntity.ok("Dentist successfully deleted!");
    }

    @Override
    public AddressEntity update(AddressEntity address) {
        AddressEntity addressMapped = addressRepository.getById(address.getId());

        if (address.getState() != null) {
            addressMapped.setState(address.getState());
        }

        if (address.getCity() != null) {
            addressMapped.setCity(address.getCity());
        }

        return addressRepository.saveAndFlush(addressMapped);
    }


}
