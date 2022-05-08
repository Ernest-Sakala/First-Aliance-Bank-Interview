package com.fab.fab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "new_account")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchModel branch;

    @OneToOne
    @JoinColumn(name = "customer_number")
    private CustomerModel customer;

    private String visa;
    private String internet;
    private String approved;
    private LocalDateTime approvedDate;
    private LocalDateTime createdAt;

    public AccountModel() {
    }

    public AccountModel(int accountId, BranchModel branch, CustomerModel customer, String visa, String internet, String approved, LocalDateTime approvedDate,
            LocalDateTime createdAt) {
        this.accountId = accountId;
        this.branch = branch;
        this.customer = customer;
        this.visa = visa;
        this.internet = internet;
        this.createdAt = createdAt;
        this.approved = approved;
        this.approvedDate = approvedDate;
    }

    /**
     * @return int return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
     * @return String return the visa
     */
    public String getVisa() {
        return visa;
    }

    /**
     * @param visa the visa to set
     */
    public void setVisa(String visa) {
        this.visa = visa;
    }

    /**
     * @return String return the internet
     */
    public String getInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(String internet) {
        this.internet = internet;
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


    /**
     * @return String return the approved
     */
    public String getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(String approved) {
        this.approved = approved;
    }

    /**
     * @return LocalDateTime return the approvedDate
     */
    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    /**
     * @param approvedDate the approvedDate to set
     */
    public void setApprovedDate(LocalDateTime approvedDate) {
        this.approvedDate = approvedDate;
    }

}
