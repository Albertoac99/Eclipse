package paneles;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import javax.swing.JPanel;

public class IncrementoSuma extends JPanel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	public IncrementoSuma() {
		
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("Moviendo el ratón encima del Panel...");
				
			}
			
		}
			);
			
		}

	public float suma(float numero) {
		
		return numero+1;
		
	}
	
	public float resta(float numero) {
		
		return numero-1;
	}
	
	
	

}
