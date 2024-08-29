import javax.swing.JFrame; // importação de biblioteca

public class ComboBoxTest // classe publica ComboBoxTest 
{ // abre chave do inicio do codigo
   public static void main(String[] args) // sempre que quiser executar uma classe precisa do método com a assinatura public static voi main (String[]args). 
   //Ele é público para que a JVM possa chama-lo. É static para que a JVM não precise instanciar um objeto da sua classe e voide porque não retorna nada para a JVM.
   { // inicia o bloco de código
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // declaração de váriavel - '=' atribuição - new = criação de um ComboBoxFrame - ";" encerrar a linha de código
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // definindo uma operação padrão de fechamento - 
      comboBoxFrame.setSize(350, 150); // metodo de alterar tamanho 
      comboBoxFrame.setVisible(true); // deixar o comboBoxFrame visivel se fosse falso estaria invisivel 
   } // 
} // end class ComboBoxTest - chave de fechamento de codigo

// 