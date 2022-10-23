package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,
            numeroNove, ponto,soma,subtracacao,multiplicacao,divisao,igual,botao_limpar;

    private TextView Expressao,Resultado;

    private ImageView basckpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracacao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);


        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expressao.setText("");
                Resultado.setText("");
            }
        });

        basckpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.Expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0 ;
                    int var1 = string.length()-1;
                    String Expressao = string.substring(var0,var1);
                    expressao.setText(Expressao);
                }
                Resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(Expressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double) longResult){
                        Resultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        Resultado.setText((CharSequence) String.valueOf(Resultado));

                    }
                }catch (Exception e){

                }
            }
        });


    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracacao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.limpar);
        Expressao = findViewById(R.id.Expressao);
        Resultado = findViewById(R.id.Resultado);
        basckpace = findViewById(R.id.backspace);
    }
    public void AcrescentarUmaExessao(String string, boolean limpar_dados){

        if(Resultado.getText().equals("")){
            Expressao.setText(" ");
        }
        if (limpar_dados){
            Resultado.setText(" ");
            Expressao.append(string);
        }else{
            Expressao.append(Resultado.getText());
            Expressao.append(string);
            Resultado.setText(" ");
        }
    }

    @Override
    public void onClick( View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExessao( "0",true);
                break;

            case R.id.numero_um:
                AcrescentarUmaExessao( "1",true);
                break;

            case R.id.numero_dois:
                AcrescentarUmaExessao( "2",true);
                break;

            case R.id.numero_tres:
                AcrescentarUmaExessao( "3",true);
                break;

            case R.id.numero_quatro:
                AcrescentarUmaExessao( "4",true);
                break;

            case R.id.numero_cinco:
                AcrescentarUmaExessao( "5",true);
                break;

            case R.id.numero_seis:
                AcrescentarUmaExessao( "6",true);
                break;

            case R.id.numero_sete:
                AcrescentarUmaExessao( "7",true);
                break;

            case R.id.numero_oito:
                AcrescentarUmaExessao( "8",true);
                break;

            case R.id.numero_nove:
                AcrescentarUmaExessao( "9",true);
                break;

            case R.id.ponto:
                AcrescentarUmaExessao( ".",true);
                break;

            case R.id.soma:
                AcrescentarUmaExessao( "+" ,  false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExessao(  "-" ,  false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExessao( "*" , false);
                break;

            case R.id.divisao:
                AcrescentarUmaExessao(  "/" , false);
                break;
        }
    }
}