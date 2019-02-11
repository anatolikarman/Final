package com.htp.test.domain.to;

public class Prescription {
    private Long prescriptionId;
    private String prescribedBy;
    private String prescripedTo;
    private Long Drug_id;

    public Long getDrug_id() {
        return Drug_id;
    }

    public void setDrug_id(Long drug_id) {
        Drug_id = drug_id;
    }

    public String getPrescripedTo() {
        return prescripedTo;
    }

    public void setPrescripedTo(String prescripedTo) {
        this.prescripedTo = prescripedTo;
    }



    private String drugId;
   // private String dosage;

//   public String getDosage() {
//       return dosage;
//   }

//   public void setDosage(String dosage) {
//       this.dosage = dosage;
//   }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public String getPrescribedTo() {
        return prescripedTo;
    }

    public void setPrescribedTo(String prescripedTo) {
        this.prescripedTo = prescripedTo;
    }

 //   public String getDrugName() {
 //       return drugName;
  //  }

 //   public void setDrugName(String drugName) {
 //       this.drugName = drugName;
 //   }
}
