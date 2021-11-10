package com.ally.assignment.unicorn.responseVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentifiableMarksVo {
    private String side;

    private String location;

    private String mark;

    private String color;
}
