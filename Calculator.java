import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
   private final JTextField textField1; // text field with set size
   private final JTextField textField2; // text field with text

   private final JLabel label1;
   private final JLabel label2;

   private final JButton btnCalcular;
   private final JLabel lblNotificacao;

   // TextFieldFrame constructor adds JTextFields to JFrame
   public Calculator() {
      super("Calculadora de soma");
      setLayout(new GridLayout(3, 2, 5, 5));

      label1 = new JLabel("Digite o número 1:", SwingConstants.RIGHT);
      add(label1); // construct textfield with 10 columns
      textField1 = new JTextField(10);
      add(textField1); // add textField1 to JFrame

      label2 = new JLabel("Digite o número 2:", SwingConstants.RIGHT);
      add(label2); // construct textfield with default text
      textField2 = new JTextField(10);
      add(textField2); // add textField2 to JFrame

      btnCalcular = new JButton("Calcular");
      add(btnCalcular);
      lblNotificacao = new JLabel("Resultado:?");
      add(lblNotificacao);

      // register event handlers
      TextFieldHandler handler = new TextFieldHandler();
      btnCalcular.addActionListener(handler);

   } // end TextFieldFrame constructor

   // private inner class for event handling
   private class TextFieldHandler implements ActionListener {
      // process textfield events
      @Override // @Override =
      public void actionPerformed(ActionEvent event) {
         if (textField1.getText().trim().length() == 0) { // trim remove os espaços laterais
            // notificar usuário que o campo 1 está vazio
            lblNotificacao.setText("O campo 1 está vazio");
            textField1.requestFocus(); // induzir o usuario a digitar
         } else {
            if (textField2.getText().trim().length() == 0) {
               // notificar o usuário que o campo 2 está vazio
               lblNotificacao.setText("O campo 2 está vazio");
               textField2.requestFocus();
            } else {
               try {
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                  lblNotificacao.setText(String.format("Resultado: %s" , soma));
                  // aqui será feita a soma
               } catch (Exception e) {
                  lblNotificacao.setText("<html><body>Ops! Parece que foi digitdo alguma coisa errada, favor revisar a digitação, pois podem ser digitados apenas números inteiros.");
               }

            }
         }
      }
   }

   // end private inner class TextFieldHandler

   public static void main(String[] args) {
      Calculator calculator = new Calculator();
      calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      calculator.setSize(450, 200);
      calculator.setVisible(true);
   }
}
