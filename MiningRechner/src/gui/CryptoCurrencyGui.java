package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bl.CalculatorBlock;
import bl.CalculatorDirect;
import bl.CryptoCurrency;
import dto.CalculatorDTO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class CryptoCurrencyGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnzahlGPU;
	private JTextField txtKwhkosten;
	static CalculatorDTO dto;
	static CalculatorBlock calcBlock;;
	static CalculatorDirect calcDirect;

	public static void main(String[] args) {
		dto = new CalculatorDTO();
		calcBlock = new CalculatorBlock(dto);
		calcDirect = new CalculatorDirect(dto);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CryptoCurrencyGui frame = new CryptoCurrencyGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CryptoCurrencyGui()  {
		//Titel
		setTitle("CurrencyCalculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitel = new JLabel("Currency Calculator");
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTitel.setBounds(88, 11, 221, 32);
		contentPane.add(lblTitel);
		
		//Image Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(CryptoCurrencyGui.class.getResource("/images/rsz_128px-cryptocurrency_logosvg.png")));
		lblLogo.setForeground(Color.BLACK);
		lblLogo.setBackground(Color.DARK_GRAY);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(155, 112, 65, 65);
		contentPane.add(lblLogo);
		
		JLabel lblKurs = new JLabel("Ausgabe Kurs");
		lblKurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblKurs.setBackground(Color.DARK_GRAY);
		lblKurs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKurs.setForeground(Color.BLACK);
		lblKurs.setBounds(107, 188, 158, 14);
		contentPane.add(lblKurs);
		
		JLabel lblAusgabe = new JLabel("Grafikkarten Details:");
		lblAusgabe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAusgabe.setBounds(10, 213, 135, 14);
		contentPane.add(lblAusgabe);
		
		
		txtAnzahlGPU = new JTextField();
		txtAnzahlGPU.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnzahlGPU.setToolTipText("Anzahl\r\n");
		txtAnzahlGPU.setText("");
		txtAnzahlGPU.setBounds(307, 256, 27, 20);
		contentPane.add(txtAnzahlGPU);
		txtAnzahlGPU.setColumns(10);
		
		JLabel lblKw = new JLabel("kWh Kosten (CHF)");
		lblKw.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKw.setBounds(10, 316, 135, 14);
		contentPane.add(lblKw);
		
		txtKwhkosten = new JTextField();
		txtKwhkosten.setText("");
		txtKwhkosten.setToolTipText("kWh Kosten in CHF.");
		txtKwhkosten.setHorizontalAlignment(SwingConstants.LEFT);
		txtKwhkosten.setColumns(10);
		txtKwhkosten.setBounds(10, 334, 158, 20);
		contentPane.add(txtKwhkosten);
		
		JLabel lblProfitProMonat = new JLabel("Profit pro Monat (%)");
		lblProfitProMonat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfitProMonat.setBounds(10, 385, 135, 14);
		contentPane.add(lblProfitProMonat);
		
		JLabel lblProfitProMonat_1 = new JLabel("Profit pro Monat (CHF)");
		lblProfitProMonat_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfitProMonat_1.setBounds(208, 386, 151, 14);
		contentPane.add(lblProfitProMonat_1);
		
		JLabel lblOutputPerc = new JLabel("%");
		lblOutputPerc.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblOutputPerc.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputPerc.setBounds(10, 410, 135, 115);
		contentPane.add(lblOutputPerc);
		
		JLabel lblOutputChf = new JLabel("CHF");
		lblOutputChf.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOutputChf.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputChf.setBounds(208, 410, 135, 115);
		contentPane.add(lblOutputChf);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int anzahlGpus = Integer.parseInt(txtAnzahlGPU.getText());
				dto.setGpuAnzahl(anzahlGpus);
				
				double kostenKwh = Double.parseDouble(txtKwhkosten.getText());
				dto.setkWhKosten(kostenKwh);
				
				CryptoCurrency calculator;
				if (dto.getSelectedCurrency().isBlock()) {
					calculator = calcBlock;
				}
				else {
					calculator = calcDirect;
				}
				dto.setProfitBetrag(calculator.rechneBetrag());
				dto.setProfitPercentage(calculator.rechnePercentage());
				lblOutputChf.setText("" + dto.getProfitBetrag());
				lblOutputPerc.setText("" + dto.getProfitPercentage());
				
			}
		});
		btnBerechnen.setForeground(Color.RED);
		btnBerechnen.setBounds(179, 333, 103, 23);
		contentPane.add(btnBerechnen);
		
		//Currency Buttons
		String btcCurrency = "BTC";
		JButton btnBtc = new JButton(btcCurrency);
		btnBtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(btcCurrency);
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnBtc.setBounds(31, 56, 80, 25);
		contentPane.add(btnBtc);
		
		String ethCurrency = "ETH";
		JButton btnEth = new JButton(ethCurrency);
		btnEth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(ethCurrency);
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnEth.setBounds(107, 56, 80, 25);
		contentPane.add(btnEth);
		
		String etcCurrency = "ETC";
		JButton btnEtc = new JButton(etcCurrency);
		btnEtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(etcCurrency );
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnEtc.setBounds(185, 56, 80, 25);
		contentPane.add(btnEtc);

		String xmrCurrency = "XMR";
		JButton btnXm = new JButton(xmrCurrency);
		btnXm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(xmrCurrency );
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnXm.setBounds(263, 56, 80, 25);
		contentPane.add(btnXm);
		
		String zecCurrency = "ZEC";
		JButton btnZec = new JButton(zecCurrency);
		btnZec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(zecCurrency );
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnZec.setBounds(31, 80, 80, 25);
		contentPane.add(btnZec);
		
		String pascCurrency = "PASC";
		JButton btnPasc = new JButton(pascCurrency);
		btnPasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(pascCurrency );
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnPasc.setBounds(107, 80, 80, 25);
		contentPane.add(btnPasc);
		
		String dashCurrency = "PASC";
		JButton btnDash = new JButton(dashCurrency);
		btnDash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(dashCurrency );
				lblKurs.setText("Kurs: " + dto.getExchangerate());
				
			}
		});
		btnDash.setBounds(185, 80, 80, 25);
		contentPane.add(btnDash);
		
		String ltcCurrency = "LTC";
		JButton btnLtc = new JButton(ltcCurrency);
		btnLtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setSelectedCurrency(ltcCurrency);
				lblKurs.setText("Kurs: " + dto.getExchangerate());
			}
		});
		btnLtc.setBounds(263, 80, 80, 25);
		contentPane.add(btnLtc);
		
		//GPU Buttons
		String model1 = "GTX 1080";
		JButton btn1080 = new JButton(model1);
		btn1080.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dto.setSelectedGpuModel(model1);
			}
		});
		btn1080.setBackground(new Color(0, 128, 128));
		btn1080.setForeground(Color.BLACK);
		btn1080.setBounds(10, 238, 89, 23);
		contentPane.add(btn1080);
		
		String model2 = "GTX 1080Ti";
		JButton btnGtxTi_1 = new JButton(model2);
		btnGtxTi_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGtxTi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dto.setSelectedGpuModel(model2);
			}
		});
		btnGtxTi_1.setForeground(Color.BLACK);
		btnGtxTi_1.setBackground(new Color(0, 128, 128));
		btnGtxTi_1.setBounds(10, 270, 89, 23);
		contentPane.add(btnGtxTi_1);
		
		String model3 = "GTX 1070";
		JButton btnGtx = new JButton(model3);
		btnGtx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dto.setSelectedGpuModel(model3);
			}
		});
		btnGtx.setForeground(Color.BLACK);
		btnGtx.setBackground(new Color(0, 128, 128));
		btnGtx.setBounds(107, 238, 89, 23);
		contentPane.add(btnGtx);
		
		String model4 = "GTX 1060";
		JButton btnGtxTi = new JButton(model4);
		btnGtxTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dto.setSelectedGpuModel(model4);
			}
		});
		btnGtxTi.setForeground(Color.BLACK);
		btnGtxTi.setBackground(new Color(0, 128, 128));
		btnGtxTi.setBounds(208, 238, 89, 23);
		contentPane.add(btnGtxTi);
		
		String model5 = "GTX 1070Ti";
		JButton btnGtxTi_2 = new JButton(model5);
		btnGtxTi_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dto.setSelectedGpuModel(model5);
			}
		});
		btnGtxTi_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGtxTi_2.setForeground(Color.BLACK);
		btnGtxTi_2.setBackground(new Color(0, 128, 128));
		btnGtxTi_2.setBounds(107, 270, 89, 23);
		contentPane.add(btnGtxTi_2);
		
		String model6 = "GTX 1060Ti";
		JButton btnGtxTi_3 = new JButton(model6);
		btnGtxTi_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dto.setSelectedGpuModel(model6);
				
			}
		});
		btnGtxTi_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGtxTi_3.setForeground(Color.BLACK);
		btnGtxTi_3.setBackground(new Color(0, 128, 128));
		btnGtxTi_3.setBounds(208, 270, 89, 23);
		contentPane.add(btnGtxTi_3);
	}
}
