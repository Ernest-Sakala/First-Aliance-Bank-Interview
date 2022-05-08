package com.fab.fab.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_change")
public class AccountChangeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchModel branch;

    private String changeRequest;

    private LocalDateTime createdAt;

    public AccountChangeModel() {
    }

    public AccountChangeModel(int id, CustomerModel customer, BranchModel branch, String changeRequest,
            LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.branch = branch;
        this.changeRequest = changeRequest;
        this.createdAt = createdAt;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return CustomerModel return the customer
     */
    public CustomerModel getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    /**
     * @return BranchModel return the branch
     */
    public BranchModel getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(BranchModel branch) {
        this.branch = branch;
    }

    /**
     * @return String return the changeRequest
     */
    public String getChangeRequest() {
        return changeRequest;
    }

    /**
     * @param changeRequest the changeRequest to set
     */
    public void setChangeRequest(String changeRequest) {
        this.changeRequest = changeRequest;
    }

    /**
     * @return LocalDateTime return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
