import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ConwaysGame extends JFrame implements ActionListener
{
  Conway conway;
  ConwayPanel panel;
  JButton startButton;

  ConwaysGame(int width,int height)
  {
    conway = new Conway(width,height);
    panel = new ConwayPanel(conway);
    startButton = new JButton("Start");
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    setLayout(new BorderLayout());
    setVisible(true);
    add(panel);
    add(startButton,BorderLayout.PAGE_END);
    startButton.addActionListener(this);
    setSize(new Dimension(600,600));
    repaint();




    






  }

  public void actionPerformed(ActionEvent e) {
      System.out.println("Button pressed");
          conway = conway.newGeneration();
          this.panel.conway = conway;

      repaint();


  }



  public static void main(String[] args)
  {
    ConwaysGame game = new ConwaysGame(50,50);
    //game.pack();
    game.setVisible(true);


  }





}
