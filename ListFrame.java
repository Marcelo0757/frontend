import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame {
   private final JList<String> colorJList; // list to display colors
   private static final String[] colorNames = { "Black", "Blue", "Cyan", // primeira matriz de colorNames
         "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
         "Orange", "Pink", "Red", "White", "Yellow" };
   private static final Color[] colors = { Color.BLACK, Color.BLUE,
         Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
         Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
         Color.RED, Color.WHITE, Color.YELLOW };

   private final JList<String> sizeJList;
   private static final String[] sizeNames = { "Small", "Medium", "Big" };

   // ListFrame constructor add JScrollPane containing JList to JFrame
   public ListFrame() // construtor 
   {
      super("List Test"); // titulo
      setLayout(new FlowLayout()); // definição de aumento ou diminuição do quadro

      colorJList = new JList<String>(colorNames); // list of colorNames - recendo novo objeto
      colorJList.setVisibleRowCount(5); // display five rows at once  
      //- estamos definindo o numero de linhas 
      
      // do not allow multiple selections
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // add a JScrollPane containing JList to frame
      add(new JScrollPane(colorJList)); // 

      sizeJList = new JList<String>(sizeNames); // list of colorNames - recendo novo objeto
      sizeJList.setVisibleRowCount(5); // display five rows at once  
      //- estamos definindo o numero de linhas 
      
      // do not allow multiple selections
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(new JScrollPane(sizeJList));


      colorJList.addListSelectionListener( // adicionado ListSelectionListener 
         new ListSelectionListener() // anonymous inner class
         {   
            // handle list selection events
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               getContentPane().setBackground( //
                  colors[colorJList.getSelectedIndex()]); // numero do vetor dentro do elemento 12
            } 
         } 
      ); 
      
      sizeJList.addListSelectionListener(
         new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350,150);
                     break;

                  case 1:
                     setSize(550,350);
                     break;

                  case 2:
                     setSize(750,550);
                     break;

                  default:
                     setSize(350,150);
                     break;
            }  
         } 
      }
   );
   }
}
