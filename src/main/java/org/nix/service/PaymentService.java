package org.nix.service;

import org.nix.RequestStatus;
import org.nix.models.PaymentRequest;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface PaymentService {
    void createRequest(@Valid PaymentRequest request);
    List<PaymentRequest> getAllPaymentRequests();
    List<PaymentRequest> getAllPaymentRequests(RequestStatus status);
    PaymentRequest getById(int id);
    PaymentRequest getLast();

    void updateRequest(int id, RequestStatus status);
    void updateRequest(int id, PaymentRequest request, RequestStatus status);

    void deleteRequest(int id);
}
