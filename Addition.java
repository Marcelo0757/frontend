import javax.swing.JOptionPane; // o import vai fazer a importação de toda biblioteca "javax" "biblioteca visual do java", o ponto é invocação do comando "swing = modulo" 
// que invoca o componente JOptionPane

public class Addition // public = método de exportação de classe adição .....criar uma classe de adição
{
   public static void main(String[] args) // public (declaração que exporta) "static"=  declaração de método somente leitura" ..
   // "void" = "método protegido sem retorno, somente leitura exportavel" "main" = nome do método executor.."String"  = tipo de váriavel tipo texto do parametro "args" tipo texto 
   {
      
      String firstNumber = // "String" é declaração de variável "secondNumber" é o nome da variável - o comando "=" é um operador de atribuição
         JOptionPane.showInputDialog("Enter first integer"); //  entre com o primeiro número // JOptionPane "padrão Pascal Case" é componente de um modelo da biblioteca java.  o "." ponto é operador de invocação - 
      //showInputDialog = exibindo uma caixa de dialogo com entrada de dados - Parenteses é colocado para mostrar parametros - tudo que estiver dentro de parenteses e parametros 
      String secondNumber = // linha de comando para inserir o segundo número
         JOptionPane.showInputDialog("Enter second integer"); // entre com o segundo número // é um componente de um modelo da biblioteca java - o ponto e vírgula serva para finalizar a linha de código  

      // converte texto inserido em valores para que seja feito o cálculo
      int number1 = Integer.parseInt(firstNumber); // é uma declaração de variável do primeiro número - "int" qual é o tipo da variável - "Integer" = componente 
      // - parseInt =  analisar e depois converter em número inteiro ()parenteses é usado para mostrar parametros - 
      int number2 = Integer.parseInt(secondNumber); // é uma declaração de variável que vai receber um texto que será convertido em número

      int sum = number1 + number2; // é uma declaração de variavel que recebera a soma dos números - qual o tipo da variavel "sum" é o numero inteiro 

            JOptionPane.showMessageDialog(null, "The sum is " + sum, // "+" é um concatenador // qualquer coisa que concatenar a direita já será convertida em String 
            // ','a virgula é para separar os parametros 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} // Aqui encerra o bloco de código da classe
