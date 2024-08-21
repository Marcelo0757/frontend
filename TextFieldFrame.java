import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TextFieldFrame extends JFrame 
{
   private final JTextField textField1; // text field with set size
   private final JTextField textField2; // text field with text
   private final JTextField textField3; // text field with text and size
   private final JPasswordField passwordField; // password field with text

   // TextFieldFrame constructor adds JTextFields to JFrame
   public TextFieldFrame()
   {
      super("Testing JTextField and JPasswordField");
      setLayout(new FlowLayout());

      // construct textfield with 10 columns
      textField1 = new JTextField(10); 
      add(textField1); // add textField1 to JFrame

      // construct textfield with default text
      textField2 = new JTextField("Enter your text here now");
      add(textField2); // add textField2 to JFrame

      // construct textfield with default text and 21 columns
      textField3 = new JTextField("Uneditable text field", 21);
      textField3.setEditable(false); // disable editing
      add(textField3); // add textField3 to JFrame

      // construct passwordfield with default text
      passwordField = new JPasswordField("Hidden text"); // 
      add(passwordField); // add passwordField to JFrame

      // register event handlers
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   } // end TextFieldFrame constructor

   // private inner class for event handling
   private class TextFieldHandler implements ActionListener 
   {
      // process textfield events
      @Override // @Override = 
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 
         // user pressed Enter in JTextField textField1
         if (event.getSource() == textField1)
            string = String.format("textField1: %s",
               event.getActionCommand());

         // user pressed Enter in JTextField textField2
         else if (event.getSource() == textField2) //"==" operador de comparação  - else é o então 
            string = String.format("textField2: %s",
               event.getActionCommand());

         // user pressed Enter in JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", //  "%s" = formato de string
               event.getActionCommand());

         // user pressed Enter in JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand()); // captura o valor daquele objeto e o  transforma em string

         // display JTextField content
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // end private inner class TextFieldHandler
} // end class TextFieldFrame


