Nomes: Josué Nascimento e João Nunes

Relatório de testes
Todos os testes foram feitos utilizando partições por valor limite já que não havia nenhum teste tão complexo. Todos os testes são parametrizados, logo todos os valores utilizados podem ser encontrados na classe ContaMagicaTest.

Reinicializa a instancia de ContaMagica antes de cada teste:
@BeforeEach
    public void initialize() {
        this.conta = new ContaMagica();
    }

Teste de verificação dos valores inválidos: Ao fazer um deposito utilizamos os valores (0,-1)  para testar o lançamento das exceções. Já na retirada foram usados (0,1,-1) para testar também a retirada de um valor maior que o saldo.

Teste de verificação das mudanças do status da conta ao realizar depósitos: 
Utilizamos os valores limites para testarmos se as mudanças de SILVER para GOLD estavam ocorrendo corretamente, da mesma forma testamos com os valores limites a mudança de GOLD para PLATINUM. Foi testado também se estava acontecendo apenas uma mudança de status por deposito.

Teste de verificação das mudanças do status da conta ao realizar uma retirada: Utilizamos os valores limites para testarmos se as mudanças de PLATINUM para GOLD estavam ocorrendo corretamente, da mesma forma testamos com os valores limites a mudança de GOLD para SILVER. Também foi testado se estava acontecendo apenas uma mudança de status por deposito.



Teste de verificação do bônus ao depositar dependendo do status da conta:
Aqui foram feitos testes em contas de deferentes status a fim de verificar se a bonificação estava aplicando a porcentagem sobre o valor depositado corretamente.

Defeitos encontrados: Ao realizar os testes sobre o método que realiza a mudança do status da conta, encontramos alguns problemas nos testes condicionais. Um pequeno erro que ocorreu por falta de atenção.