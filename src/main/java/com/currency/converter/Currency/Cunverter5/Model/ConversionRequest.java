package com.currency.converter.Currency.Cunverter5.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {

    private String from;
    private String to;
    private double amount;

    public String getFrom() {
        return from;
    }
    public void setFrom(String from){
        this.from=from;
    }
    public String getTo(){
        return to;
    }
    public void setTo(String to){
        this.to=to;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
}

