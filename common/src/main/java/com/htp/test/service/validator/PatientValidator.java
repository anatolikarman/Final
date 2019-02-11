package com.htp.test.service.validator;

import com.htp.test.domain.to.Patient;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientValidator implements ValidatorInterface<Patient> {

    private static final ValidatorInterface<Patient> instance = new PatientValidator();

    private PatientValidator() {
    }

    public static ValidatorInterface<Patient> getInstance() {
        return instance;
    }

    private static final String REGULAR_EXP_idPatient = "[0-9]{4}";
    private static final String REGULAR_EXP_PATIENT_NAME = "[а-яА-Яa-zA-Z]{2,20}";
    private static final String REGULAR_EXP_PATIENT_SURNAME = "[а-яА-Яa-zA-Z]{2,20}";
    private static final String REGULAR_EXP_PATIENT_DIAGNOSIS = "[а-яА-Яa-zA-Z]{2,20}";


    private static final Pattern patternIdPatient = Pattern.compile(REGULAR_EXP_idPatient);
    private static final Pattern patternPatientName = Pattern.compile(REGULAR_EXP_PATIENT_NAME);
    private static final Pattern patternPatientSurname = Pattern.compile(REGULAR_EXP_PATIENT_SURNAME);
    private static final Pattern patternDiagnosis = Pattern.compile(REGULAR_EXP_PATIENT_DIAGNOSIS);

    @Override
    public boolean isValid(Patient patient) {


        String idPatient = String.valueOf(patient.getPatientId());
        String patientName = String.valueOf(patient.getPatientName());
        String patientSurname = String.valueOf(patient.getPatientSurname());

        Matcher matcherIdPatient = patternIdPatient.matcher(idPatient);
        Matcher matcherPatientName = patternPatientName.matcher(patientName);
        Matcher matcherPatientSurname = patternPatientSurname.matcher(patientSurname);
        Matcher matcherDiagnosis = patternDiagnosis.matcher(patientSurname);

        return matcherIdPatient.find() &
                matcherPatientName.find() &
                matcherPatientSurname.find() &
                matcherDiagnosis.find();
    }

}























