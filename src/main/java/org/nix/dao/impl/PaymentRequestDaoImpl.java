package org.nix.dao.impl;

import org.nix.RequestStatus;
import org.nix.dao.PaymentRequestDao;
import org.nix.dao.PaymentRequestMapper;
import org.nix.models.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.sql.*;
import java.util.List;

@Repository
public class PaymentRequestDaoImpl implements PaymentRequestDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentRequestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPaymentRequest(@Valid PaymentRequest paymentRequest) {
        jdbcTemplate.update("INSERT INTO requests(client_name, sum) values (?, ?)", paymentRequest.getClientName(),
                paymentRequest.getSum());
    }


    @Override
    public PaymentRequest getPaymentRequest(long id) {
        return (PaymentRequest) jdbcTemplate.query("SELECT * FROM requests where id = ?", new PaymentRequestMapper(), id).get(0);
    }

    @Override
    public List<PaymentRequest> getListOfPaymentRequests() {
        return jdbcTemplate.query("SELECT * FROM requests order by id", new PaymentRequestMapper());
    }

    @Override
    public List<PaymentRequest> getListOfPaymentRequests(RequestStatus status) {
        return jdbcTemplate.query("SELECT * FROM requests where cast(status as varchar) = ? order by id", new PaymentRequestMapper(), status.name());
    }

    @Override
    public void updatePaymentRequest(long id, RequestStatus status) {
        jdbcTemplate.update("update requests set status = cast(? as e_status) where id = ?",
                status.name(), id);
    }

    @Override
    public void updatePaymentRequest(long id, PaymentRequest request, RequestStatus status) {
        jdbcTemplate.update("update requests set client_name = ?, sum = ?, status = cast(? as e_status) where id = ?",
                request.getClientName(), request.getSum(), status.name(), id);
    }

    @Override
    public void deletePaymentRequest(int id) {
        jdbcTemplate.update("delete from requests where id = ?", id);
    }

    @Override
    public PaymentRequest getLastPaymentRequest() {
        return (PaymentRequest) jdbcTemplate.query("SELECT * FROM requests order by id desc limit 1", new PaymentRequestMapper()).get(0);
    }
}
