package com.ally.assignment.unicorn.responseVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnicornVo {

    private long unicornId;

    private String name;

    private String hairColor;

    private long hornLength;

    private String hornColor;

    private String eyeColor;

    private long height;

    private String heightUnit;

    private long weight;

    private String weightUnit;

    private Set<IdentifiableMarksVo> identifiableMarks = new HashSet<>();
}
