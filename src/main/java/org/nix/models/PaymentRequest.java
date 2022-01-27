package org.nix.models;

import org.hibernate.annotations.Type;
import org.nix.RequestStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "requests")
public class PaymentRequest {

    @Id
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    @Column(name = "id")
    private long identifier;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "sum")
    private long sum;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private RequestStatus status;

    public PaymentRequest(String clientName, long sum) throws ParseException {
        super();
        this.clientName = clientName;
        this.sum = sum;
    }

    public PaymentRequest() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public RequestStatus getStatus() {
        return status;
    }


    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "identifier=" + identifier +
                ", clientName='" + clientName + '\'' +
                ", sum=" + sum +
                ", status=" + status +
                '}';
    }
}
