package com.meuGrupo;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    private int saldo; /// :)    
    private int status; /// :)

    public ContaMagica(){
        saldo = 0; // :)
        status = 0; // :)
    }

    public double getSaldo(){
        return saldo;
    }
	
    public int getStatus(){
        return status;
    }
	
    public void deposito(int valor) throws Exception{
        if(valor <= 0){
            throw new Exception("Valor de depósito não pode ser negativo :)");
        }
        //concede o bonus
        switch(status){
            case 1: saldo += valor * 0.01; break;
            case 2: saldo += valor * 0.025; break;
        }
        //deposita  
        saldo += valor;
        //atualiza o status :)
        if(status < PLATINUM){
            if(saldo > 200000)
                status++;
            else if(status < GOLD){
                if(saldo > 50000)
                    status++;
            }
        }
   }

    public void retirada(int valor) throws Exception{
        if(valor <= 0){
            throw new Exception("Valor de retirada não pode ser negativo :)");
        }
        if(valor > saldo){
            throw new Exception("Valor de retirada não pode exceder o saldo :)");
        }
        //retira
        saldo -= valor;
        //atualiza o status :) jaera :)
        if(status > SILVER){
            if(saldo < 25000)
                status--;
            else if(status > GOLD){
                if(saldo < 100000)
                    status--;
            }
        }
    }
}