import java.awt.*;
import java.util.Map;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame // Aqui está definindo a classe MenuFrame que está herdando do jFrame
{
   private final Color[] colorValues = // matriz de cores - 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN,};   
   private final JRadioButtonMenuItem[] colorItems; // color menu items
   private final JRadioButtonMenuItem[] fonts; // font menu items
   private final JRadioButtonMenuItem[] tamanhos;
   private final JCheckBoxMenuItem[] styleItems; // font style menu items
   private final JLabel displayJLabel; // displays sample text
   private final ButtonGroup fontButtonGroup; // manages font menu items
   private final ButtonGroup colorButtonGroup; // manages color menu items
   private final ButtonGroup tamanhoButtonGroup;
   private int style; // used to create style for font
   private int tamanhoAtual;

   // no-argument constructor set up GUI
   public MenuFrame() // Aqui está definindo o construtor
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File"); // create file menu
      fileMenu.setMnemonic('F'); // set mnemonic to F

      // create About... menu item
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // set mnemonic to A
      fileMenu.add(aboutItem); // add about item to file menu
      aboutItem.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // display message dialog when user selects About...
            @Override
            public void actionPerformed(ActionEvent event) // metodo publico sem retorno
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\\n\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // create exit item
      exitItem.setMnemonic('x'); // set mnemonic to x
      fileMenu.add(exitItem); // add exit item to file menu
      exitItem.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // terminate application when user clicks exitItem
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // exit application
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // create menu bar
      setJMenuBar(bar); // add menu bar to application
      bar.add(fileMenu); // add file menu to menu bar

      JMenu formatMenu = new JMenu("Format"); // create format menu
      formatMenu.setMnemonic('r'); // set mnemonic to r

      // array listing string colors
      String[] colors = {"Black", "Blue", "Red", "Green",};

      JMenu colorMenu = new JMenu("Color"); // create color menu
      colorMenu.setMnemonic('C'); // set mnemonic to C

      // create radio button menu items for colors
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // manages colors
      ItemHandler itemHandler = new ItemHandler(); // handler for colors

      // create color radio button menu items
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // create item
         colorMenu.add(colorItems[count]); // add item to color menu
         colorButtonGroup.add(colorItems[count]); // add to group
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // select first Color item

      formatMenu.add(colorMenu); // add color menu to format menu
      formatMenu.addSeparator(); // add separator in menu


      // array listing font names
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font"); // create font menu
      fontMenu.setMnemonic('n'); // set mnemonic to n
      

      // create radio button menu items for font names
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // manages font names

      // create Font radio button menu items
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); // add font to font menu
         fontButtonGroup.add(fonts[count]); // add to button group
         fonts[count].addActionListener(itemHandler); // add handler
      } 

      fonts[0].setSelected(true); // select first Font menu item
      fontMenu.addSeparator(); // add separator bar to font menu

      String[] styleNames = {"Bold", "Italic"}; // names of styles
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // style handler

      // create style checkbox menu items
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // for style
         fontMenu.add(styleItems[count]); // add to font menu
         styleItems[count].addItemListener(styleHandler); // handler
      }

      formatMenu.add(fontMenu); // add Font menu to Format menu
      bar.add(formatMenu); // add Format menu to menu bar

      formatMenu.addSeparator();

      int[] tamanhoint = {72, 52, 22}; 
      JMenu tamanhoMenu = new JMenu("Tamanho"); 
      tamanhoMenu.setMnemonic('T'); 

      tamanhos = new JRadioButtonMenuItem[tamanhoint.length]; 
      tamanhoButtonGroup = new ButtonGroup(); 

      for (int count = 0; count < tamanhos.length; count++) 
      {
         tamanhos[count] = new JRadioButtonMenuItem(String.valueOf(tamanhoint[count])); 
         tamanhoMenu.add(tamanhos[count]); 
         tamanhoButtonGroup.add(tamanhos[count]); 
         tamanhos[count].addActionListener(itemHandler); 
      }

      tamanhos[0].setSelected(true);
      formatMenu.add(tamanhoMenu);
     
      // set up label to display text
      displayJLabel = new JLabel("Marcelo Campos", SwingConstants.CENTER); // troquei sample text por Marcelo Campos
      displayJLabel.setForeground(colorValues[0]); 
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, tamanhoAtual)); // 

      getContentPane().setBackground(Color.CYAN); // set background - 
      add(displayJLabel, BorderLayout.CENTER); // add displayJLabel
   } // end MenuFrame constructor

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener // implementar o action listener, vem como objeto 
   {
      // process color and font selections
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // process color selection
         for (int count = 0; count < colorItems.length; count++) // leitura da cor do item do vetor 0 = black
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // process font selection
         for (int count = 0; count < fonts.length; count++) // 
         {
            if (event.getSource() == fonts[count]) // 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, tamanhoAtual));
            }
         }

         for (int count = 0; count < tamanhos.length; count++) 
         {
            if (event.getSource() == tamanhos[count])
            {
               int size = Integer.parseInt(tamanhos[count].getText());
               displayJLabel.setFont(displayJLabel.getFont().deriveFont((float) size));
               tamanhoAtual = size;
            }
         }

         repaint(); // redraw application repintar 
      } 
   } // end class ItemHandler

   // inner class to handle item events from checkbox menu items
   private class StyleHandler implements ItemListener 
   {
      // process font style selections
      @Override
      public void itemStateChanged(ItemEvent e) // metodo publico sem retorno, quando mudar o estado do item ele mudara
      {
         String name = displayJLabel.getFont().getName(); // current Font
         Font font; // new font based on user selections

         // determine which CheckBoxes are checked and create Font
         if (styleItems[0].isSelected() && // verificar se os dois estão selecionados o zero e o bold e o 1 italic
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, tamanhoAtual);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, tamanhoAtual);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, tamanhoAtual);
         else
            font = new Font(name, Font.PLAIN, tamanhoAtual);

         displayJLabel.setFont(font);
         repaint(); // redraw application
      } 
   } // end class StyleHandler
} // end class MenuFrame



