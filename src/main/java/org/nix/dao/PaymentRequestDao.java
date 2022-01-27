package org.nix.dao;

import org.nix.RequestStatus;
import org.nix.models.PaymentRequest;

import java.io.Serializable;
import java.util.List;

public interface PaymentRequestDao extends Serializable {

    // C
    void createPaymentRequest(PaymentRequest paymentRequest);

    // R
    PaymentRequest getPaymentRequest(long id);
    List<PaymentRequest> getListOfPaymentRequests();
    List<PaymentRequest> getListOfPaymentRequests(RequestStatus status);
    PaymentRequest getLastPaymentRequest();

    // U
    void updatePaymentRequest(long id, PaymentRequest request, RequestStatus status);
    void updatePaymentRequest(long id, RequestStatus status);

    // D
    void deletePaymentRequest(int id);

}
