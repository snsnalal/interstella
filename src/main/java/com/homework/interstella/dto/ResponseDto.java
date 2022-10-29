package com.homework.interstella.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto {

    @NotNull
    @Min(value = 1, message = "입력 값이 범위 밖입니다.")
    @Max(value = 10000, message = "입력 값이 범위 밖입니다.")
    private Integer t;
    @NotNull
    private Integer k;
    @NotNull
    private int[] piList;
    @NotNull
    private int[] niList;
}
