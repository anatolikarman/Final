package com.htp.test.service.validator;

import com.htp.test.domain.to.Ward;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WardValidator implements ValidatorInterface<Ward> {




    private static final ValidatorInterface<Ward> instance = new WardValidator();

    private WardValidator(){}

    public static ValidatorInterface<Ward> getInstance(){
        return instance;
    }

    private static final String REGULAR_EXP_idWard = "[1-30]{1}";
    private static final String REGULAR_EXP_wardNum= "[100-399]{1}";


    private static final Pattern patternIdWard = Pattern.compile(REGULAR_EXP_idWard);
    private static final Pattern patternWardNum= Pattern.compile(REGULAR_EXP_wardNum);


    @Override
    public boolean isValid(Ward ward) {


        String idWard = String.valueOf(ward.getWardId());
        String wardNum = String.valueOf(ward.getNumber());


        Matcher matcherIdWard = patternIdWard.matcher(idWard);
        Matcher matcherWardNum = patternWardNum.matcher(wardNum);


        return matcherIdWard.find() &
                matcherWardNum.find();
    }
}
