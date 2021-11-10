package com.ally.assignment.unicorn.service;

import com.ally.assignment.unicorn.controller.UnicornController;
import com.ally.assignment.unicorn.error.ResourceNotFoundException;
import com.ally.assignment.unicorn.model.IdentifiableMarks;
import com.ally.assignment.unicorn.repository.IdentifiableMarksRepository;
import com.ally.assignment.unicorn.repository.UnicornRepository;
import com.ally.assignment.unicorn.model.Unicorn;
import com.ally.assignment.unicorn.responseVo.IdentifiableMarksVo;
import com.ally.assignment.unicorn.responseVo.UnicornVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class UnicornService {

    private static final Logger logger = LoggerFactory.getLogger(UnicornController.class);

    @Autowired
    UnicornRepository unicornRepository;

    @Autowired
    IdentifiableMarksRepository identifiableMarksRepository;

    public List<UnicornVo> getAllUnicornResource()
    {
        List<UnicornVo> unicornList = new ArrayList<>();
        List<Unicorn> resultUnicorns = unicornRepository.findAll();
        for(Unicorn unicorn : resultUnicorns){
           unicornList.add(convertUnicornToUnicornVo(unicorn));
        }
        return unicornList;
    }

    public Long createUnicornResource(Unicorn unicorn) {
        Unicorn unicornSaved = unicornRepository.save(unicorn);
        for( IdentifiableMarks identifiableMarks : unicorn.getIdentifiableMarks()){
            identifiableMarksRepository.save(identifiableMarks);
        }

        return unicornSaved.getUnicornId();
    }

    public UnicornVo getUnicornById(long unicornId)
    {

        Unicorn unicorn =  unicornRepository.findById(unicornId).orElse(null);

        return null != unicorn ? convertUnicornToUnicornVo(unicorn) : null;


    }

    private UnicornVo convertUnicornToUnicornVo(Unicorn result) {
        UnicornVo unicornVo = new UnicornVo();
        unicornVo.setUnicornId(result.getUnicornId());
        unicornVo.setEyeColor(result.getEyeColor());
        unicornVo.setHeightUnit(result.getHeightUnit());
        unicornVo.setHeight(result.getHeight());
        unicornVo.setHairColor(result.getHairColor());
        unicornVo.setHornColor(result.getHornColor());
        unicornVo.setName(result.getName());
        unicornVo.setWeight(result.getWeight());
        unicornVo.setWeightUnit(result.getWeightUnit());
        unicornVo.setHornLength(result.getHornLength());
        
        Set<IdentifiableMarksVo> identifiableMarksVos = new HashSet<>();
        Set<IdentifiableMarks> identifiableMarksSet = identifiableMarksRepository.findAllIdentifiableMarksByUnicorn(result.getUnicornId());
        for(IdentifiableMarks identifiableMarks : identifiableMarksSet){
            IdentifiableMarksVo identifiableMarksVo = new IdentifiableMarksVo();
            identifiableMarksVo.setMark(identifiableMarks.getMark());
            identifiableMarksVo.setColor(identifiableMarks.getColor());
            identifiableMarksVo.setSide(identifiableMarks.getSide());
            identifiableMarksVo.setLocation(identifiableMarks.getLocation());
            identifiableMarksVos.add(identifiableMarksVo);
        }
        unicornVo.setIdentifiableMarks(identifiableMarksVos);
        return unicornVo;
    }


    public void updateUnicornResource(Long unicornId, Unicorn unicorn) {
        UnicornVo unicornVo = getUnicornById(unicornId);
        if(null != unicornVo && unicornVo.getUnicornId() != 0){
            createUnicornResource(unicorn);
        }else{
            throw new ResourceNotFoundException(unicornId);
        }
    }
}



