import javax.swing.JFrame;

public class ListTest 
{
   public static void main(String[] args) // "() = declaração de metodo"  
   // -  "[]"  = parametro args tipo matriz de String - 
   { 
      ListFrame listFrame = new ListFrame(); // create ListFrame - criando uma variavel tipo LisFrame atribuiu um objeto do mesmo tipo 
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      listFrame.setSize(350, 150); // definindo o tamanho do listFrame
      listFrame.setVisible(true); // Exibindo o listFrame
   } 
} // end class ListTest


