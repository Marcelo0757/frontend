import javax.swing.*; // importando um "javax" = biblioteca - "swing" = modulo - "*" todos os componentes

public class MultipleSelectionTest // declaração da classe 
{
   public static void main(String[] args) // "()" abrindo um bloco de codigos - 
   //"[]" = parametros da matriz de string - void = protegido para não retorno - static = não se pode mexer 
   { 
      MultipleSelectionFrame multipleSelectionFrame = // cria uma novo objeto na MultipleSelectionFrame
         new MultipleSelectionFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation( //
         JFrame.EXIT_ON_CLOSE);
      multipleSelectionFrame.setSize(550, 150); //  invocando um metodo setSize definição de tamanho
      multipleSelectionFrame.setVisible(true); //invocando um metodo setVisible verdadeiro
   } 
} // end class MultipleSelectionTest


