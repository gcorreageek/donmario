package miLib;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

		public class Contenedor extends Container
		{
		// La imagen que queremos de fondo, un fichero .gif
		//public ImageIcon icono = new ImageIcon ("Images/Explosin-fucsia.jpg");
		
		// Redefinición del método paint()
		public void paint (Graphics g)
		{
		// Borramos todo y lo pintamos del color de fondo por defecto.
		Rectangle r = g.getClipBounds();
		g.setColor(this.getBackground());
		g.fillRect (r.x, r.y, r.width, r.height);
		
		// Pintamos la imagen
		//g.drawImage (icono.getImage(), 0,0,this);
		
		// Hacemos que se pinten los botones dentro de este contenedor
		super.paint(g);
		}
		
	/*	public static void main(String[] args) {
			JFrame ventana = new JFrame();
			
			ventana.setContentPane(new Contenedor());
			ventana.setVisible(true);
		}*/
		}
		
		/*JFrame ventana = new JFrame();
ventana.setContentPane(new Contenedor());*/