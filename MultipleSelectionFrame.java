import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame 
// JFrame e a herança que MultipleSelectionFrame está herdando
{
   private final JList<String> colorJList; // list to hold color names
   private final JList<String> copyJList;
   private final JList<String> copyJList2; // list to hold copied names
   
   private JButton copyJButton;
   private JButton copyJButton2; // copia 2 do JButton
   
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   // MultipleSelectionFrame constructor
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout()); // metodo Flow que responde expansivamente

      colorJList = new JList<String>(colorNames); // list of color names - inseridos os nomes
      colorJList.setVisibleRowCount(5); // show five rows quantidade de linhas que irá aparecer 
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // modo de seleção intervalo multiplo de seleção
      add(new JScrollPane(colorJList)); // add list with scrollpane

      copyJButton = new JButton("Copy >>>"); // 
      copyJButton.addActionListener( // 
         new ActionListener() // anonymous inner class - recebendo um novo objeto Action Listener
         {  
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // place selected values in copyJList
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray( // pegar os valores selecionados da lista
                     new String[0])); // envia para uma matriz toArray
            }
         } 
      ); 

      add(copyJButton); // add copy button to JFrame - adicionando um botão de cópia

      

      copyJList = new JList<String>(); // list to hold copied color names
      copyJList.setVisibleRowCount(5); // show 5 rows
      copyJList.setFixedCellWidth(100); // set width // definindo a largura da celula fixa
      copyJList.setFixedCellHeight(15); // set height - definindo a altura fixa da celula
      copyJList.setSelectionMode( // definir o selection modo single interval selection
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // 
      add(new JScrollPane(copyJList)); // add list with scrollpane

      copyJButton2 = new JButton("Copy >>>"); // 
      copyJButton2.addActionListener( // 
         new ActionListener() // anonymous inner class - recebendo um novo objeto Action Listener
         {  
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // place selected values in copyJList
               copyJList2.setListData(
                  copyJList.getSelectedValuesList().toArray( // pegar os valores selecionados da lista
                     new String[0])); // envia para uma matriz toArray
            }
         } 
      ); 

      add(copyJButton2); // add copy button to JFrame - adicionando um botão de cópia

      

      copyJList2 = new JList<String>(); // list to hold copied color names
      copyJList2.setVisibleRowCount(5); // show 5 rows
      copyJList2.setFixedCellWidth(100); // set width // definindo a largura da celula fixa
      copyJList2.setFixedCellHeight(15); // set height - definindo a altura fixa da celula
      copyJList2.setSelectionMode( // definir o selection modo single interval selection
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // 
      add(new JScrollPane(copyJList2)); // add list with scrollpane

   } 
} // end class MultipleSelectionFrame


