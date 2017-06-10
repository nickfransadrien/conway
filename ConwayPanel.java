  import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class ConwayPanel extends JPanel implements MouseListener {

    int blockSize;
    Conway conway;
    ConwayPanel(Conway conway)
  {
    this.conway = conway;
    blockSize = 10;
    this.setVisible(true);
    this.setFocusable(true);
    this.setSize(new Dimension(500,500));
    setBackground(new Color(0,0,0));
    this.addMouseListener(this);
  }
  @Override
  protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
    for(int i=0;i<conway.width;i++)
      for(int j=0;j<conway.height;j++)
        if(conway.getCell(i,j) == 1)
        g.fillRect(i*blockSize,j*blockSize,blockSize,blockSize);


  }

public void mousePressed(MouseEvent e) {
  int positionX = e.getX() /  blockSize;
  int positionY = e.getY() /  blockSize;
  System.out.println(e.getX());
  System.out.println(e.getY());
  conway.toggleCell(positionX,positionY);
  System.out.println("mouse pressed");
  repaint();



}
public void mouseEntered(MouseEvent e){

}
public void mouseExited(MouseEvent e){

}
public void mouseClicked(MouseEvent e){

}

public void mouseReleased(MouseEvent e) {

}


}
