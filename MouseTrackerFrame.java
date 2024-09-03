import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame // classe publica MouseTrackerFrame herdeiro de JFrame
{
   private final JPanel mousePanel; // panel in which mouse events occur - painel no qual ocorrem eventos de mouse
   private final JLabel statusBar; // displays event information - informação de evento no display
   // MouseTrackerFrame constructor sets up GUI and 
   // registers mouse event handlers
   public MouseTrackerFrame() // () declaração de método público MouseTrackerFrame
   {
      super("Demonstrating Mouse Events"); // Título do painel

      mousePanel = new JPanel(); // declaração de novo JPanel do mousePanel
      mousePanel.setBackground(Color.WHITE); // definir a cor do fundo branco
      add(mousePanel, BorderLayout.CENTER); // add panel to JFrame - layout de borda central

      statusBar = new JLabel("Mouse outside JPanel"); // mouse está fora do JPanel por isso fica branco
      add(statusBar, BorderLayout.SOUTH); // add label to JFrame - adiciona BorderLayout no sul

      // create and register listener for mouse and mouse motion events
      MouseHandler handler = new MouseHandler(); // vai adicionar o novo MouseHandler
      mousePanel.addMouseListener(handler); // vai adicionar o escutador na hora de se movimentar
      mousePanel.addMouseMotionListener(handler); // adicionar o escutador no painel do mouse - 
   } 

   private class MouseHandler implements MouseListener, 
      MouseMotionListener 
   {
      // MouseListener event handlers
      // handle event when mouse released immediately after press

      @Override
      public void mouseClicked(MouseEvent event) // depois de clicado ele envia mensagem para o Status bar 
      {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // parametros event.getX e .getY
      } // string formatada -  primeiro %d referencia getX e
      // segundo do getY

      // handle event when mouse pressed

      @Override
      public void mousePressed(MouseEvent event) // alguns milisegundos 
      {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      // handle event when mouse released 

      @Override
      public void mouseReleased(MouseEvent event) // mouse soltou 
      {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // 
      }

      // handle event when mouse enters area

      @Override
      public void mouseEntered(MouseEvent event) // quando entra com o mouse no painel muda a cor do fundo
      {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
         mousePanel.setBackground(Color.GREEN); // quando entra com o mouse no painel muda a cor do fundo
      }

      // handle event when mouse exits area

      @Override
      public void mouseExited(MouseEvent event) // mouse saiu 
      {
         statusBar.setText("Mouse outside JPanel"); // manda mensagem para o statusbar que o mouse 
         // saiu do painel e ficou branco
         mousePanel.setBackground(Color.WHITE); // definição da cor de fundo do mousePanel
      }
      // MouseMotionListener event handlers
      // handle event when user drags mouse with button pressed

      @Override
      public void mouseDragged(MouseEvent event) // quando clica segura e arrasta 
      {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 
            // primeira referencia getx e segunda gety
       
      // handle event when user moves mouse

      @Override
      public void mouseMoved(MouseEvent event) // mouse foi movido e sera enviado mensagem para o statusbar 
      {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // primeiro parametro faz ref ao event.getx e o segundo ao event.gety
      } 
   } // end inner class MouseHandler
} // end class MouseTrackerFrame

