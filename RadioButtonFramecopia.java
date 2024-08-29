import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class RadioButtonFrame extends JFrame 
{
   private JTextField textField; // used to display font changes = 

   private Font plainFont; // font for plain text
   private Font boldFont; // font for bold text
   private Font italicFont; // font for italic text
   private Font boldItalicFont; // font for bold and italic text

   private Color blueColor;
   private Color redColor;
   private Color yellowColor;
   private Color blackColor;


   private JRadioButton plainJRadioButton; // selects plain text
   private JRadioButton boldJRadioButton; // selects bold text
   private JRadioButton italicJRadioButton; // selects italic text
   private JRadioButton boldItalicJRadioButton; // bold and italic
   private ButtonGroup radioGroup;

   private JRadioButton blueJRadioButton; // selects plain text
   private JRadioButton redJRadioButton; // selects bold text
   private JRadioButton yellowJRadioButton; // selects italic text
   private JRadioButton blackJRadioButton; // bold and italic
   private ButtonGroup colorRadioGroup; // buttongroup to hold radio buttons = 

   // RadioButtonFrame constructor adds JRadioButtons to JFrame
   public RadioButtonFrame() // construtor dentro da class 
   {
      super("RadioButton Test"); // titulo da janela
      setLayout(new FlowLayout()); // definir layout - aumenta conforme vc deseja - responsividade

      textField = new JTextField("Watch the font style change", 25); // recebendo o valor de um novo objeto - aparece no campo imput com o tamanho de 25 colunas
      add(textField); // add textField to JFrame

      // create radio buttons
      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); // add plain button to JFrame
      add(boldJRadioButton); // add bold button to JFrame
      add(italicJRadioButton); // add italic button to JFrame
      add(boldItalicJRadioButton); // add bold and italic button

      // create logical relationship between JRadioButtons
      radioGroup = new ButtonGroup(); // create ButtonGroup // cada botão clicado o outro apaga
      radioGroup.add(plainJRadioButton); // add plain to group
      radioGroup.add(boldJRadioButton); // add bold to group
      radioGroup.add(italicJRadioButton); // add italic to group
      radioGroup.add(boldItalicJRadioButton); // add bold and italic

      blueJRadioButton = new JRadioButton("Blue",false);
      redJRadioButton = new JRadioButton("Red",false);
      yellowJRadioButton = new JRadioButton("Yellow",false);
      blackJRadioButton = new JRadioButton("Black",true);
      add(blueJRadioButton);
      add(redJRadioButton);
      add(yellowJRadioButton);
      add(blackJRadioButton);


      colorRadioGroup = new ButtonGroup();
      colorRadioGroup.add(blueJRadioButton);
      colorRadioGroup.add(redJRadioButton);
      colorRadioGroup.add(yellowJRadioButton);
      colorRadioGroup.add(blackJRadioButton);

      // create font objects
      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont);

      blueColor = new Color(0,0,255);
      redColor = new Color(255,0,255);
      yellowColor = new Color(255,255,0);
      blackColor = new Color(0,0,255);



      // register events for JRadioButtons
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont)); // está enviando fonte plana
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont)); //  está enviando fonte negrita
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));  // está enviando fonte italic
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));
   } 

   // private inner class to handle radio button events
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // font associated with this listener

      public RadioButtonHandler(Font f)
      {
         font = f; 
      } 
   
      // handle radio button events
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); 
      } 
   } 

   private class ColorRadioButtonHandler implements ItemListener
   {
      private Color color;

   public ColorRadioButtonHandler(Color c) {
      color = c;

   }

   }
   
   
   @Override
   public void itemStateChanged(ItemEvent event)
   {
      textField.setForeground(color);
   }
} // end class RadioButtonFrame 


    
}
