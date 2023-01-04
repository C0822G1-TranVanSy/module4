package com.codegym.dto.contract;

public class ContractDetailDto {
    private int id;
    private int contract;
    private int attachFacility;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public int getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(int attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
