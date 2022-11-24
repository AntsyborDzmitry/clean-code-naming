package com.epam.engx.cleancode.naming.task4.service.impl;

import com.epam.engx.cleancode.naming.task4.service.ContactService;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class ContactServiceImpl implements ContactService {

    private CustomerContactDAO customerContactDAO;

    public CustomerContact findContactById(Long id) {
        return customerContactDAO.findById(id);
    }

    public void updateContact(CustomerContact contact) {
        customerContactDAO.update(contact);
    }
}
