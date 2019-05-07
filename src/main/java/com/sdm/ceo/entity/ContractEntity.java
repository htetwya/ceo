package com.sdm.ceo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sdm.core.model.DefaultEntity;

@Entity(name = "ContractEntity")
@Table(name = "tbl_contracts")
public class ContractEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private long toContact;

    @Column(nullable = false)
    private long amount;

    @Column
    private String cloudLink;

    @Column(nullable = false)
    private Date contractDate;

    @Column
    private int productId;

    @Column(nullable = false)
    private long senderId;

    @Column(nullable = false)
    private long signId;

    @Column
    private String note;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_contract_attachments", joinColumns = @JoinColumn(name = "contractId", nullable = false))
    @Column(name = "fileId")
    private List<String> file = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getToContact() {
        return toContact;
    }

    public void setToContact(long toContact) {
        this.toContact = toContact;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCloudLink() {
        return cloudLink;
    }

    public void setCloudLink(String cloudLink) {
        this.cloudLink = cloudLink;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getSignId() {
        return signId;
    }

    public void setSignId(long signId) {
        this.signId = signId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }
}