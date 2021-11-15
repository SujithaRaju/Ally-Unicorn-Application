package com.ally.assignment.unicorn.service;

import com.ally.assignment.unicorn.model.IdentifiableMarks;
import com.ally.assignment.unicorn.model.Unicorn;
import com.ally.assignment.unicorn.repository.IdentifiableMarksRepository;
import com.ally.assignment.unicorn.repository.UnicornRepository;
import com.ally.assignment.unicorn.responseVo.UnicornVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnicornServiceTest {

    @InjectMocks
    UnicornService unicornService;

    @Mock
    UnicornRepository unicornRepository;

    @Mock
    IdentifiableMarksRepository identifiableMarksRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllUnicornResourceTest()
    {
        //given
        List<Unicorn> unicornList = new ArrayList<>();
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Left","Hind Quarters","Star","Blue", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"Sparkle Princess","White",104,"Gold","Sapphire",94,
                "cm",104,"kg",identifiableMarksSet);
        unicornList.add(unicorn);

        //when & then
       when(unicornRepository.findAll()).thenReturn(unicornList);

       //test
        List<UnicornVo> getAllResource = unicornService.getAllUnicornResource();


        //assert
        assertEquals(1, getAllResource.size());
        verify(unicornRepository,times(1)).findAll();

    }

    @Test
    public void getUnicornByIdTest()
    {
        //given
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Left","Hind Quarters","Star","Blue", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"Sparkle Princess","White",104,"Gold","Sapphire",94,
                "cm",104,"kg",identifiableMarksSet);

        //when & then
        when(unicornRepository.findById(1L)).thenReturn(Optional.of(unicorn));

        //test
        UnicornVo unicornVo=unicornService.getUnicornById(1);

        //assert
        assertEquals(94,unicornVo.getHeight() );

    }

    @Test
    public void createUnicornResourceTest()
    {
        //given
        Set<IdentifiableMarks> identifiableMarksSet=new HashSet<>();
        IdentifiableMarks identifiableMarks=new IdentifiableMarks(1, "Left","Hind Quarters","Star","Blue", new Unicorn());
        identifiableMarksSet.add(identifiableMarks);
        Unicorn unicorn=new Unicorn(1,"Sparkle Princess","White",104,"Gold","Sapphire",94,
                "cm",104,"kg",identifiableMarksSet);

        //when & then
        when(unicornRepository.save(unicorn)).thenReturn(unicorn);

        //test
        unicornService.createUnicornResource(unicorn);


        //assert
        assertEquals(104,unicorn.getWeight() );
        assertEquals("Blue",unicorn.getIdentifiableMarks().stream().iterator().next().getColor());
    }

}
