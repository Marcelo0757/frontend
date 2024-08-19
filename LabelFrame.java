import java.awt.*; // specifies how components are arranged = Especifica como os componentes são organizados
import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax 

public class LabelFrame extends JFrame // =  classe esta recebendo (tudo do componente)  JFrame (herança JFrame herdeiro LabelFrame)
{
   private final JLabel label1; // JLabel with just text - private = criando uma variavel para ser usada na classe - 
   // declaração da variavel label 1 do tipo jlabel somente leitura dentro da classe labelframe
   private final JLabel label2; // JLabel constructed with text and icon - variavel somente para leitura 
   private final JLabel label3; // JLabel with added text and icon - JLabel = para uso somente dentro da classe 

   // LabelFrame constructor adds JLabels to JFrame
   public LabelFrame() // construtor 
   {
      super("Testing JLabel"); //  super = definindo o titulo da janela (nome do titulo) parte superior somente titulo
      setLayout(new FlowLayout()); // set frame layout - define o layout de como vai ser - setLayout = metodo - new FlowLayout = criando um novo objeto
      // frame é a janela ou quadro
      // JLabel constructor with a string argument
      label1 = new JLabel("Label with text"); // declaração de variavel - "=" operador de atribuição - 
      label1.setToolTipText("This is label1"); // set = definir ToolTipText = texto ds ferramenta de dica
      add(label1); // add label1 to JFrame - adicionando uma variavel - adicionando componente do JLabel - variavel Label1 acima descrito

      // JLabel constructor with string, Icon and alignment arguments
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // icon definição de tipo - declaração de variavel - tipo icon - new = novo - 
      // "(" inicio da declaração de parametros - getClass() = invocar a classe do JFrame "." operador de invocação de método - 
      // getResource =  basicamente irão buscar pelo recurso - 
      label2 = new JLabel("Label with text and icon", bug, // "," separar parametros - SwingConstants.LEFT - parametro do tipo Swingconstants alinhado a esquerda 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2"); // invoca o texto de ferramenta de dicas
      add(label2); // add label2 to JFrame

      label3 = new JLabel(); // JLabel constructor no arguments - declaração de variavel
      label3.setText("Label with icon and text at bottom"); // 
      label3.setIcon(bug); // add icon to JLabel 
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("This is label3");
      add(label3); // add label3 to JFrame
   } 
} // end class LabelFrame


