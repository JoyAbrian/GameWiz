package com.ruukaze.gamewiz.models;

public class InvolvedCompany {
    private int id;
    private Company company;
    private boolean developer;
    private boolean porting;
    private boolean publisher;
    private boolean supporting;

    public InvolvedCompany(int id, Company company, boolean developer, boolean porting, boolean publisher, boolean supporting) {
        this.id = id;
        this.company = company;
        this.developer = developer;
        this.porting = porting;
        this.publisher = publisher;
        this.supporting = supporting;
    }

    public InvolvedCompany(int companyId) {
        this.id = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public void setDeveloper(boolean developer) {
        this.developer = developer;
    }

    public boolean isPorting() {
        return porting;
    }

    public void setPorting(boolean porting) {
        this.porting = porting;
    }

    public boolean isPublisher() {
        return publisher;
    }

    public void setPublisher(boolean publisher) {
        this.publisher = publisher;
    }

    public boolean isSupporting() {
        return supporting;
    }

    public void setSupporting(boolean supporting) {
        this.supporting = supporting;
    }
}
