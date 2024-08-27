
import javax.swing.JFrame; // separando a execução

public class CheckBoxTest // metodo  classe checkBoxTest
{
   public static void main(String[] args) // proibido contra mudança futura ,  
   { 
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      checkBoxFrame.setSize(275, 100); 
      checkBoxFrame.setVisible(true); 
   } 
} // end class CheckBoxTest

