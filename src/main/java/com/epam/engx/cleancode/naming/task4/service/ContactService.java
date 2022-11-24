package com.epam.engx.cleancode.naming.task4.service;


import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;

public interface ContactService {

    CustomerContact findContactById(Long id);

    void updateContact(CustomerContact contact);

}
