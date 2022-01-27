package org.nix.service.impl;

import org.nix.RequestStatus;
import org.nix.dao.PaymentRequestDao;
import org.nix.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CheckStatusServiceImpl implements CheckStatusService {

    PaymentRequestDao dao;

    @Override
    public RequestStatus checkStatus(long identifier) {
        if (dao.getPaymentRequest(identifier).getStatus() == RequestStatus.NEW)
            dao.updatePaymentRequest(identifier, RequestStatus.values()[new Random().nextInt(2) + 1]);
        return dao.getPaymentRequest(identifier).getStatus();
    }

    @Autowired
    public CheckStatusServiceImpl(PaymentRequestDao dao) {
        this.dao = dao;
    }
}
