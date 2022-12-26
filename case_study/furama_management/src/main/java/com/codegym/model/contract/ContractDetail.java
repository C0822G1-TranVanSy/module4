package com.codegym.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "contract_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_facility_id", nullable = false, referencedColumnName = "attach_facility_id")
    private AttachFacility attachFacility;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
