import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame // classe publica herda JFrame para ComboBoxFrame
{
   private final JComboBox<String> imagesJComboBox; // hold icon names //
   private final JLabel label; // displays selected icon

   private static final String[] names = // definindo uma matriz de string com 4 vetores 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { // 4 variaveis de  1 classe = "private" -  matriz de icon
      new ImageIcon(getClass().getResource(names[0])), // 
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame() // construtor 
   {
      super("Testing JComboBox"); //super é o título 
      setLayout(new FlowLayout()); // set frame layout  - FlowLayout e um modo espansivo, responsiva - vc deixa a janela do tamanho que vc quiser   

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox - esta recebendo um novo objeto do mesmo tipo declarado - uma matriz declarada (names = parametro)
      imagesJComboBox.setMaximumRowCount(3); // display three rows - metodo (setMaximumCount) herdado do JComboBox  - irá aparecer no máximo 3 linhas

      imagesJComboBox.addItemListener(
         new ItemListener() // anonymous inner class
         {
            // handle JComboBox event
            @Override // sobrescrever
            public void itemStateChanged(ItemEvent event) // 
            {
               // determine whether item selected
               if (event.getStateChange() == ItemEvent.SELECTED) // "getStateChange" - estado que foi modificado - "==" operador de modificação
                  label.setIcon(icons[ // 
                     imagesJComboBox.getSelectedIndex()]); // vetor que sera recolhido do indice dos vetores da matriz do proprio ComboBox
            } 
         } // end anonymous inner class
      ); // end call to addItemListener

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(icons[0]); // display first icon
      add(label); // add label to JFrame
   }
} // end class ComboBoxFrame



