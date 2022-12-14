package com.homework.interstella.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto {

    @NotNull(message = "입력 값이 없습니다.")
    @Min(value = 1, message = "입력 값이 범위 밖입니다.")
    @Max(value = 10000, message = "입력 값이 범위 밖입니다.")
    private Integer t;
    @NotNull(message = "입력 값이 없습니다.")
    private Integer k;
    @NotNull(message = "입력 값이 없습니다.")
    private int[] piList;
    @NotNull(message = "입력 값이 없습니다.")
    private int[] niList;
}
