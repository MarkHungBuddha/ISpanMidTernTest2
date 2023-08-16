package org.example;


//https://data.gov.tw/dataset/161539

public class IndigenousData {

    private int seq;//主鍵
    private String Datelisted;//新增日期
    private String year;//年度
    private String type;//類別
    private String area;//地區
    private float totalpercent;//總計
    private float legislatorsAndManagerspercent;//民意代表&主管及經理人員
    private float professionalspercent;//專業人員
    private float technicianAndassistantTechnicianpercent;//技術員及助理專業人員
    private float clericalSupportWorkerpercent;//事務支援人員
    private float serviceAndsalesWorkerpercent;//服務及銷售工作人員
    private float primaryIndustrialWorkerpercent;//農林漁牧業生產人員
    private float craftAndRelatedWorkerpercent;//技藝有關工作人員
    private float machineryOperatorAndAssemblerpercent;//機械設備操作及組裝人員
    private float elementaryWorkerLaborerpercent;//基層技術工及勞力工
    private float sampleCount;//樣本數_人
    private float populationCount;//母體數_人



    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getDatelisted() {
        return Datelisted;
    }

    public void setDatelisted(String datelisted) {
        Datelisted = datelisted;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }



    public float getTotalpercent() {
        return totalpercent;
    }

    public void setTotalpercent(float totalpercent) {
        this.totalpercent = totalpercent;
    }

    public float getLegislatorsAndManagerspercent() {
        return legislatorsAndManagerspercent;
    }

    public void setLegislatorsAndManagerspercent(float legislatorsAndManagerspercent) {
        this.legislatorsAndManagerspercent = legislatorsAndManagerspercent;
    }

    public float getProfessionalspercent() {
        return professionalspercent;
    }

    public void setProfessionalspercent(float professionalspercent) {
        this.professionalspercent = professionalspercent;
    }

    public float getTechnicianAndassistantTechnicianpercent() {
        return technicianAndassistantTechnicianpercent;
    }

    public void setTechnicianAndassistantTechnicianpercent(float technicianAndassistantTechnicianpercent) {
        this.technicianAndassistantTechnicianpercent = technicianAndassistantTechnicianpercent;
    }

    public float getClericalSupportWorkerpercent() {
        return clericalSupportWorkerpercent;
    }

    public void setClericalSupportWorkerpercent(float clericalSupportWorkerpercent) {
        this.clericalSupportWorkerpercent = clericalSupportWorkerpercent;
    }

    public float getServiceAndsalesWorkerpercent() {
        return serviceAndsalesWorkerpercent;
    }

    public void setServiceAndsalesWorkerpercent(float serviceAndsalesWorkerpercent) {
        this.serviceAndsalesWorkerpercent = serviceAndsalesWorkerpercent;
    }

    public float getPrimaryIndustrialWorkerpercent() {
        return primaryIndustrialWorkerpercent;
    }

    public void setPrimaryIndustrialWorkerpercent(float primaryIndustrialWorkerpercent) {
        this.primaryIndustrialWorkerpercent = primaryIndustrialWorkerpercent;
    }

    public float getCraftAndRelatedWorkerpercent() {
        return craftAndRelatedWorkerpercent;
    }

    public void setCraftAndRelatedWorkerpercent(float craftAndRelatedWorkerpercent) {
        this.craftAndRelatedWorkerpercent = craftAndRelatedWorkerpercent;
    }

    public float getMachineryOperatorAndAssemblerpercent() {
        return machineryOperatorAndAssemblerpercent;
    }

    public void setMachineryOperatorAndAssemblerpercent(float machineryOperatorAndAssemblerpercent) {
        this.machineryOperatorAndAssemblerpercent = machineryOperatorAndAssemblerpercent;
    }

    public float getElementaryWorkerLaborerpercent() {
        return elementaryWorkerLaborerpercent;
    }

    public void setElementaryWorkerLaborerpercent(float elementaryWorkerLaborerpercent) {
        this.elementaryWorkerLaborerpercent = elementaryWorkerLaborerpercent;
    }

    public float getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(float sampleCount) {
        this.sampleCount = sampleCount;
    }

    public float getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(float populationCount) {
        this.populationCount = populationCount;
    }
}
