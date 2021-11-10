package com.ally.assignment.unicorn.service;

import com.ally.assignment.unicorn.model.IdentifiableMarks;
import com.ally.assignment.unicorn.model.Unicorn;
import com.ally.assignment.unicorn.repository.IdentifiableMarksRepository;
import com.ally.assignment.unicorn.repository.UnicornRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnicornServiceTest {

    @InjectMocks
    UnicornService unicornService;

    @Mock
    UnicornRepository unicornRepository;

    @Mock
    IdentifiableMarksRepository identifiableMarksRepository;

    @Test
    public void getAllUnicornResource()
    {
        //given
        List<Unicorn> unicornList = new ArrayList<>();
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Side","Location","mark","color", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"name","haircolor",20,"hornColor","eyeColor",240,
                "heightUnit",260,"weightUnit",identifiableMarksSet);
        unicornList.add(unicorn);

        //when & then
        when(unicornRepository.findAll()).thenReturn(unicornList);

        //assert
        assertEquals(1, unicornList.size());
        assertEquals(20, unicornList.get(0).getHornLength());

    }

    @Test
    public void getUnicornById()
    {
        //given
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Side","Head","Mole","Black", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"name","haircolor",20,"hornColor","eyeColor",240,
                "heightUnit",260,"weightUnit",identifiableMarksSet);

        //when & then
        when(unicornRepository.findById(1L)).thenReturn(Optional.of(unicorn));

        //assert
        assertEquals(240,unicorn.getHeight() );
        assertEquals("Black",unicorn.getIdentifiableMarks().stream().iterator().next().getColor());
    }

    @Test
    public void createUnicornResource()
    {
        //given
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Top","Leg","Scar","Gold", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"name","Gold",20,"White","Brown",240,
                "heightUnit",260,"weightUnit",identifiableMarksSet);

        //when & then
        when(unicornRepository.save(unicorn)).thenReturn(unicorn);
        //assert
        assertEquals(260,unicorn.getWeight() );
        assertEquals("Gold",unicorn.getIdentifiableMarks().stream().iterator().next().getColor());
    }

}
