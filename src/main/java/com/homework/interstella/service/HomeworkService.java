package com.homework.interstella.service;

import com.homework.interstella.controller.HomeworkController;
import com.homework.interstella.dto.ResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HomeworkService {

    public int calcProblem2(ResponseDto responseDto){
        int []dp = new int[10001];
        dp[0] = 1;
        List<Coin> coinList = new ArrayList<>();
        for(int i = 0; i < responseDto.getK(); i++){
            coinList.add(new Coin(responseDto.getPiList()[i], responseDto.getNiList()[i]));
        }

        Collections.sort(coinList);

        for(int i = 0; i < coinList.size(); i++){
            for(int j = responseDto.getT(); j >= 0; j--){
                for(int k = 1; k <= coinList.get(i).getNum(); k++){
                    if(j - coinList.get(i).getValue() * k >= 0){
                        dp[j] += dp[j - coinList.get(i).getValue() * k];
                    }else {
                        continue;
                    }
                }
            }
        }

        return dp[responseDto.getT()];
    }
    @Getter
    @Setter
    public static class Coin implements Comparable<Coin>{
        private int value;
        private int num;

        public Coin(int value, int num){
            this.value = value;
            this.num = num;
        }

        @Override
        public int compareTo(Coin o) {
            return o.value - this.value;
        }

    }
}
