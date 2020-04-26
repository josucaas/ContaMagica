package com.meuGrupo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContaMagicaTest {
    ContaMagica conta;

    @BeforeEach
    public void initialize() {
        this.conta = new ContaMagica();
    }

    @ParameterizedTest
    @CsvSource({"50000, 0, 0",
                "50001, 0, 1",
                "50001, 148514, 1", // (50001 + 148514 * 1.01) = 200000
                "50001, 149515, 2", // (50001 + 148515 * 1.01) = 200001
                "200001, 0, 1",
                "200000, 1, 2"
               })
    void testaDepositoMudancaStatus(int valorA, int valorB, int eRes){        
        try{
            conta.deposito(valorA);
            if(valorB != 0)
                conta.deposito(valorB);
        }
        catch(Exception E){}

        int resultado= conta.getStatus();
        Assertions.assertEquals(eRes, resultado);
    }

    @ParameterizedTest
    @CsvSource({"-1",
                "0"})
    void testaDepositoValorInvalido(int valor){
        Assertions.assertThrows(Exception.class, () -> {
            conta.deposito(valor);
        });
    }

    @ParameterizedTest
    @CsvSource({"100001, 0, 2",      //100000
                "100002, 0, 1",      //99999
                "100002, 74999, 1",  //25000
                "100002, 75000, 0",  //24999
                "175002, 0, 1",      //24999 porem de uma só vez
               })
    void testaRetiradaMudancaStatus(int valorA, int valorB, int eRes){        
        try{
            conta.deposito(200000);
            conta.deposito(1);
            conta.retirada(valorA);
            if(valorB != 0)
                conta.retirada(valorB);
        }
        catch(Exception E){}

        int resultado= conta.getStatus();
        Assertions.assertEquals(eRes, resultado);
    }

    @ParameterizedTest
    @CsvSource({"-1", //negativo
                "0",  //zero
                "1"}) //maior do que o saldo
    void testeRetiradaValorInvalido(int valor){
        Assertions.assertThrows(Exception.class, () -> {
            conta.retirada(valor);
        });
    }

    @ParameterizedTest
    @CsvSource({"50000, 0, 1000, 51000",
                "50001, 0, 1000, 51011",
                "200000, 1, 1000, 201026", 
               })
    void testaDepositoBonus(int valorA, int valorB, int valorC, double eRes){        
        try{
            conta.deposito(valorA);
            if(valorB != 0)
                conta.deposito(valorB);
            conta.deposito(valorC);
        }
        catch(Exception E){}

        double resultado= conta.getSaldo();
        Assertions.assertEquals(eRes, resultado);
    }
}

    