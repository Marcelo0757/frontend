import javax.swing.JFrame; //biblioteca modulo e componente

public class LabelTest 
{
   public static void main(String[] args) // declaração de método publico somente leitura - metodo sempre dentro de classe - 
   { 
      LabelFrame labelFrame = new LabelFrame(); // LabelFrame = componente título da janela - variavel labelFrame (variavel) do tipo (recebe novo componente) > LabelFrame
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setDefaultCloseOperation = (variavel) definindo operação padrão de fechar - EXIT_ON_CLOSE = SCRENCASE NÃO MUDAR
      // (JFrame.EXIT_ON_CLOSE) 
      labelFrame.setSize(360, 280); // tamanho do frame 360 width (largura) e 280 height (altura)
      labelFrame.setVisible(true); // para mostrar o labelFrame na tela 
   } 
} // fim da classe LabelTest 


