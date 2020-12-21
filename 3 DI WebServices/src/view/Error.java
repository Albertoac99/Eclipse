package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Error extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Error() {
		setModal(true);
		setBounds(100, 100, 423, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JTextArea txtrErrorPorFavor = new JTextArea();
			txtrErrorPorFavor.setFont(new Font("Monospaced", Font.PLAIN, 12));
			txtrErrorPorFavor.setEditable(false);
			txtrErrorPorFavor.setText("\t\t\tError\r\n--> El stock m\u00EDnimo debe ser mayor o igual a 0\r\n--> El stock actual debe ser mayor o igual que el m\u00EDnimo \r\n\ty menor o igual que el m\u00E1ximo\r\n-->El stock m\u00E1ximo debe ser mayor que el m\u00EDnimo\r\n-->El precio debe ser mayor o igual a 0");
			contentPanel.add(txtrErrorPorFavor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
