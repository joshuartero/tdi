package TDI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
   
public class PanelImage extends JPanel {

    private BufferedImage bmp=null; 
    
    public PanelImage() {    	
       bmp = new BufferedImage(50,50, BufferedImage.TYPE_INT_RGB);
       super.setSize(50,50);
    }  
   
    public PanelImage(String nombreImagen) {  
       this.setImagen(nombreImagen);  
    }  
   
    public void setImagen(String nombreImagen) {       
       if (nombreImagen != null) {                                  
          try {
             bmp = ImageIO.read(new File(nombreImagen));
             super.setSize(bmp.getWidth(),bmp.getHeight());
          }
          catch (IOException ex) {
             System.out.println("No se pudo leer la imagen");
          }         
       }
       else {  
          bmp = null;  
       }      
    }         
 
   public void setPixel(int x, int y, int color) {
      bmp.setRGB(x,y,color);
//      repaint(); // seria ineficiente redibujar por cada pixel      
   }
   
   public int getPixel(int x, int y) {
      return bmp.getRGB(x,y);
   }   

   @Override
   public void setSize(int w,int h) {          
      bmp = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
      super.setSize(w,h);      
   }
   
   @Override
   public Dimension getPreferredSize() { 
       return new Dimension(getWidth(), getHeight());       
   }
      
   @Override
   public void paint(Graphics g) {  
      if (bmp != null) { 
         g.drawImage(bmp, 0, 0, getWidth(), getHeight(),this);
         setOpaque(false); 
      }
      else {  
         setOpaque(true);  
      }  
      super.paint(g);  
   }   
   
} 