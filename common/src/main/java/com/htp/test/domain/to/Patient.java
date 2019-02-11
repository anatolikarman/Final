package com.htp.test.domain.to;

public class Patient {
    private Long patientId;
    private String patientName;
    private String patientSurname;
    private String diagnosis;
    private Integer ward;
  //  private String assignedDoctor;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

 //  public String getAssignedDoctor() {
 //      return assignedDoctor;
 //  }

 //  public void setAssignedDoctor(String assignedDoctor) {
 //      this.assignedDoctor = assignedDoctor;
 //  }
}
