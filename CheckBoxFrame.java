import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javafx.scene.text.Text;
import javax.swing.JCheckBox;
import java.awt.font.*;
import java.util.*;

public class CheckBoxFrame extends JFrame // a classe tem o mesmo nome do arquivo - 

{
   private final JCheckBox underlineCheckBox;
   private final JTextField textField; // displays text in changing fonts
   private final JCheckBox boldJCheckBox; // to select/deselect bold
   private final JCheckBox italicJCheckBox; // to select/deselect italic

   // CheckBoxFrame constructor adds JCheckBoxes to JFrame
   public CheckBoxFrame()
   {
      super("JCheckBox Test"); // o texto que aparece no título 
      setLayout(new FlowLayout()); // metodo que configura o layout - um novo flowlayout mais responsivo - estamos enviando

      // set up JTextField and set its font
      textField = new JTextField("Watch the font style change", 20);
      textField.setFont(new Font("Serif", Font.PLAIN, 14));
      add(textField); // add textField to JFrame  - uma declaraçao de variavel - esta invocando o definidor de fonte, 

      boldJCheckBox = new JCheckBox("Bold"); 
      italicJCheckBox = new JCheckBox("Italic"); 
      add(boldJCheckBox); // add bold checkbox to JFrame
      add(italicJCheckBox); // add italic checkbox to JFrame
      underlineCheckBox = new JCheckBox("Underline");
      add(underlineCheckBox);

      // register listeners for JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler();
      boldJCheckBox.addItemListener(handler); // está invocando o bold que vai adicionar um novo objeto - clicou invocando esse metodo 
      italicJCheckBox.addItemListener(handler); // os dois objetos foram adicionados no escutador de eventos - 
      underlineCheckBox.addItemListener(handler);
   } 

   // private inner class for ItemListener event handling
   private class CheckBoxHandler implements ItemListener  
   {
      // respond to checkbox events
      @Override // sobrescrito esse metodo 
      public void itemStateChanged(ItemEvent event) // publico sem retorno do tipo item event 
      {
         Font font = null; // stores the new Font

         // determine which CheckBoxes are checked and create Font
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // validador - invocando o metodo isSelect - se o boldcheckbox estiver selecionado ele ira processar esse if 
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // nova fonte com negrito e italico juntos
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);

         textField.setFont(font); 

            font = new Font("Serif", Font.PLAIN, 14);
         if (underlineCheckBox.isSelected()) {
            font = textField.getFont();
            Map attributes = font. getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            textField.setFont(font.deriveFont(attributes));
            font = new Font(attributes);
         }

         
      } 
   }
} // end class CheckBoxFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
