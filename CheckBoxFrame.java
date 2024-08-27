import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.font.*;
import java.util.*;

public class CheckBoxFrame extends JFrame // a classe tem o mesmo nome do arquivo - 

{
   private final JCheckBox underlineCheckBox; // = final privado JCheckBox sublinhadoCheckBox
   private final JTextField textField; // displays text in changing fonts = exibe texto em mudança de fontes
   private final JCheckBox boldJCheckBox; // to select/deselect bold = para selecionar/desmarcar negrito
   private final JCheckBox italicJCheckBox; // to select/deselect italic = para selecionar/desmarcar italic

   // CheckBoxFrame constructor adds JCheckBoxes to JFrame
   public CheckBoxFrame()
   {
      super("JCheckBox Test"); // o texto que aparece no título 
      setLayout(new FlowLayout()); // metodo que configura o layout - um novo flowlayout mais responsivo - estamos enviando

      // set up JTextField and set its font = configure JTextField e defina sua fonte
      textField = new JTextField("Watch the font style change", 20);
      textField.setFont(new Font("Serif", Font.PLAIN, 14));
      add(textField); // add textField to JFrame  - uma declaraçao de variavel - esta invocando o definidor de fonte, 

      boldJCheckBox = new JCheckBox("Bold"); 
      italicJCheckBox = new JCheckBox("Italic"); 
      add(boldJCheckBox); // add bold checkbox to JFrame = adicione caixa de seleção em negrito ao JFrame
      add(italicJCheckBox); // add italic checkbox to JFrame = adicione caixa de seleção italic ao JFrame
      underlineCheckBox = new JCheckBox("Underline");
      add(underlineCheckBox); // adicionar underline no checkbox

      // register listeners for JCheckBoxes = registrar ouvintes para JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler(); // = Manipulador CheckBoxHandler = novo CheckBoxHandler
      boldJCheckBox.addItemListener(handler); // está invocando o bold que vai adicionar um novo objeto - clicou invocando esse metodo 
      italicJCheckBox.addItemListener(handler); // os dois objetos foram adicionados no escutador de eventos - 
      underlineCheckBox.addItemListener(handler); // sublinhar caixa de seleção adicionar manipulador de ouvinte de item
   } 

   // classe interna privada para manipulação de eventos ItemListener
   private class CheckBoxHandler implements ItemListener  
   {
      // responder para o evento checkbox
      @Override // sobrescrito esse metodo 
      public void itemStateChanged(ItemEvent event) // publico sem retorno do tipo item event 
      {
         Font font = null; // armazena a nova fonte

         // determinar quais CheckBoxes estão marcadas e criar Font
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // validador - invocando o metodo isSelect - se o boldcheckbox estiver selecionado ele ira processar esse if 
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // nova fonte com negrito e italico juntos
         else if (boldJCheckBox.isSelected()) // negrito CheckBox está selecionado
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);

         textField.setFont(font); 

            
         if (underlineCheckBox.isSelected()) { // sublinhado CheckBox está selecionado
            font = textField.getFont(); // fonte texto Campo obter fonte
            Map attributes = font. getAttributes(); // Atributos do mapa fonte obter atributos
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // atributos colocar Atributo de texto UNDERLINE Atributo de texto UNDERLINE ON)
            textField.setFont(font.deriveFont(attributes)); // texto Conjunto de campos Fonte derivação de fonte Atributos de fonte
            font = new Font(attributes); // fonte novos atributos de fonte
         }

         
      } 
   }
} // end class CheckBoxFrame

