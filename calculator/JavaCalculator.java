import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.Math;

public class JavaCalculator extends JFrame
{
	private JFrame f;
    private JButton jbtNum1, jbtNum2, jbtNum3, jbtNum4, jbtNum5, jbtNum6, jbtNum7, jbtNum8, jbtNum9, jbtNum0;
	private JButton jbtPt, jbtCE;
    private JButton jbtAdd, jbtSubtract, jbtMultiply, jbtDivide, jbtEqual;
	private JButton jbtClr, jbtNeg, jbtSin, jbtCos, jbtTan;
    private JTextField jtfInput, jtfOutput, jtfAns;
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    String display = "", display2 = "";
	
	Stack <String> opStk = new Stack<>();
	Stack <String> numStk = new Stack<>();
	
    public JavaCalculator() 
	{
		f = new JFrame("Calculator_Test");
		JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
		p1.add(jtfInput = new JTextField(20));
		jtfInput.setText("= ");
        p1.add(jtfOutput = new JTextField(20));
		jtfAns = new JTextField(20);
		jtfAns.setVisible(false);
		jtfInput.setForeground(new Color(65, 65, 65));
		jtfInput.setHorizontalAlignment(JTextField.RIGHT);
        jtfInput.setEditable(false);
        jtfOutput.setHorizontalAlignment(JTextField.RIGHT);
        jtfOutput.setEditable(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 3));
        p2.add(jbtNum1 = new JButton("1"));
        p2.add(jbtNum2 = new JButton("2"));
        p2.add(jbtNum3 = new JButton("3"));
        p2.add(jbtNum4 = new JButton("4"));
        p2.add(jbtNum5 = new JButton("5"));
        p2.add(jbtNum6 = new JButton("6"));
        p2.add(jbtNum7 = new JButton("7"));
        p2.add(jbtNum8 = new JButton("8"));
        p2.add(jbtNum9 = new JButton("9"));
        p2.add(jbtNum0 = new JButton("0"));
		p2.add(jbtPt = new JButton("."));   
        p2.add(jbtCE = new JButton("CE"));   

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(5, 2));
        p3.add(jbtAdd = new JButton("+"));
        p3.add(jbtSubtract = new JButton("-"));
        p3.add(jbtMultiply = new JButton("*"));
        p3.add(jbtDivide = new JButton("/"));
        p3.add(jbtEqual = new JButton("="));
		p3.add(jbtClr = new JButton("C"));
		p3.add(jbtNeg = new JButton("(-)"));	
		p3.add(jbtSin = new JButton("sin"));
		p3.add(jbtCos = new JButton("cos"));
		p3.add(jbtTan = new JButton("tan"));

        JPanel p = new JPanel();
		JPanel p_ = new JPanel();
        p.setLayout(new GridLayout(1,2));
		p_.setLayout(new GridLayout(2,1));
        p_.add(p1, BorderLayout.NORTH);
        p_.add(p2, BorderLayout.SOUTH);
		p.add(p_, BorderLayout.WEST);
        p.add(p3, BorderLayout.EAST);

        f.add(p);
		f.setSize(500,250);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*jbtNum1.addActionListener(new ListenNum());
        jbtNum2.addActionListener(new ListenNum());
        jbtNum3.addActionListener(new ListenNum());
        jbtNum4.addActionListener(new ListenNum());
        jbtNum5.addActionListener(new ListenNum());
        jbtNum6.addActionListener(new ListenNum());
        jbtNum7.addActionListener(new ListenNum());
        jbtNum8.addActionListener(new ListenNum());
        jbtNum9.addActionListener(new ListenNum());
        jbtNum0.addActionListener(new ListenNum());*/
		
        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());
		
		jbtPt.addActionListener(new ListenToPt());
		jbtCE.addActionListener(new ListenToCE());

		jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
		jbtClr.addActionListener(new ListenToClr());
		jbtEqual.addActionListener(new ListenToEqual());
        jbtNeg.addActionListener(new ListenToNeg());
		
		jbtSin.addActionListener(new ListenToSin());
		jbtCos.addActionListener(new ListenToCos());
		jbtTan.addActionListener(new ListenToTan());
    }
	
	class ListenToOne implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
			display = jtfOutput.getText();
			jtfOutput.setText("1");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "1");
        }
    }

    class ListenToTwo implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("2");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "2");
        }
    }

    class ListenToThree implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("3");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "3");
        }
    }

    class ListenToFour implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("4");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "4");
        }
    }

    class ListenToFive implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("5");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "5");
        }
    }

    class ListenToSix implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("6");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "6");	
        }
    }

    class ListenToSeven implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("7");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "7");		
        }
    }

    class ListenToEight implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("8");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "8");	
        }
    }

    class ListenToNine implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("9");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "9");
        }
    }

    class ListenToZero implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText("0");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "0");
        }
    }
	
	class ListenToPt implements ActionListener
	{
        public void actionPerformed(ActionEvent e) 
		{
            display = jtfOutput.getText();
			jtfOutput.setText(display + ".");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + ".");
        }
    }
	
	class ListenToCE implements ActionListener
	{
        public void actionPerformed(ActionEvent e) 
		{
			String display_ = "= ";
			display2 = jtfInput.getText();
			
			if (!display2.equals("") && !display2.equals("= "))
			{
				String ss = display2.substring(display2.length()-1);
				if (ss.equals(" "))
					display_ = display2.substring(0, display2.length()-3);
				else
					display_ = display2.substring(0, display2.length()-1);
			}
			
			jtfInput.setText(display_);
			jtfOutput.setText("");
        }
    }
	
    class ListenToAdd implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("+ ");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + " + ");
        }
    }

    class ListenToSubtract implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("- ");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + " - ");
        }
    }

    class ListenToMultiply implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("* ");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + " * ");
        }
    }

    class ListenToDivide implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("/ ");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + " / ");
        }
    }

	class ListenToClr implements ActionListener
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("");
			jtfInput.setText("= ");
			removeAll();
        }
    }
	
    class ListenToEqual implements ActionListener 
	{
        double result = 0.0;
		
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				String expr = jtfInput.getText();	
				System.out.println(expr);
				method(expr);
				result = display();
				
				jtfInput.setText("= ");
				jtfOutput.setText(result + "");
				jtfAns.setText(result + "");
				removeAll();
			}
			
			catch (Exception ex)
			{
				jtfInput.setText("= ");
				jtfOutput.setText("Error");
				removeAll();
				System.out.println("Exception on Arr");	
			}
        }
    }
	
	class ListenToNeg implements ActionListener
	{
        public void actionPerformed(ActionEvent e) 
		{
			display2 = jtfInput.getText();
			int length = display2.length()-1;
				
			if (Character.isDigit(display2.charAt(length)) || display2.charAt(length) == '.')
			{
				StringBuilder sb = new StringBuilder();
				String str = "";
				
				for (int i = length, j = 0; i >= 0; i--, j++)
				{
					str = display2.substring(length-j);
					
					if (display2.charAt(display2.length()-1) == '-')
					{
						display2 = removeLastChar(display2);
						jtfInput.setText(display2 + sb);
						break;
					}
					
					else if (display2.charAt(display2.length()-1) == ' ')
					{
						jtfInput.setText(display2 + "-" + sb);
						break;
					} 
					
					else
					{
						sb.insert(0, str);
						display2 = removeLastChar(display2);	
					}
				}	
			}
			
			else
			{
				jtfInput.setText(display2 + "-");
			}
        }
    }
	
	class ListenToSin implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("Sin");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "Sin");
        }
    }
	
	class ListenToCos implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("Cos");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "Cos");
        }
    }
	
	class ListenToTan implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
		{
            jtfOutput.setText("Tan");
			display2 = jtfInput.getText();
			jtfInput.setText(display2 + "Tan");
        }
    }
		
	public boolean checkNum(String s)
	{
		if (s == null)
			return false;
		return pattern.matcher(s).matches();
	}
	
	/*public String checkRes()
	{
		String res = jtfAns.getText();
		
		if (res == null)
			return "";
		return res;
	}*/

	public void method(String str)
	{
		String num1, num2;
		String oper, res, trig;
        String[] s = str.split(" |\\=", 0);
		
		for (int i = 0; i < s.length; i++)
		{
			if (s[i].equals("+") || s[i].equals("-") || s[i].equals("*") || s[i].equals("/"))
			{
				if (opStk.empty() == false)
				{
					if (priority(s[i]) <= priority(opStk.peek()))
					{
						num1 = (String)numStk.pop();
						num2 = (String)numStk.pop();
						oper = (String)opStk.pop();
						res = calculate(num1, num2, oper);
						numStk.push(res);
						opStk.push(s[i]);
						System.out.println("A: " + num2 + " " + oper + " " + num1); //
					}
					else
					{
						opStk.push(s[i]);
					}
				}
				else
				{
					opStk.push(s[i]);
				}
			}
			else if (s[i].contains("Sin"))
			{
				trig = calculateSin(s[i]);
				numStk.push(trig);
			}
			else if (s[i].contains("Cos"))
			{
				trig = calculateCos(s[i]);
				numStk.push(trig);
			}
			else if (s[i].contains("Tan"))
			{
				trig = calculateTan(s[i]);
				numStk.push(trig);
			}
			else
			{
				numStk.push(s[i]);	
			}
			
		}
		while (opStk.empty() == false)
		{
			num1 = (String)numStk.pop();
			num2 = (String)numStk.pop();
			oper = (String)opStk.pop();
			res = calculate(num1, num2, oper);
			numStk.push(res);
			System.out.println("B: " + num2 + " " + oper + " " + num1); //
		}
		System.out.print("opStk: " + opStk); //
		System.out.print("numStk: " + numStk); //
	}
	
	public int priority(String oper)
	{
        if (oper.equals("*") || oper.equals("/"))
		{
            return 1;
        } 
		else 
		{
            return 0;
        }
    }
	
	public String calculate(String num1_, String num2_, String oper)
	{
		double _num1_ = Double.parseDouble(num1_);
		double _num2_ = Double.parseDouble(num2_);
		double res = 0.0;
		String res_ = "";
		
		switch (oper)
		{
            case "+": res = _num1_ + _num2_; break;
            case "-": res = _num2_ - _num1_; break;
            case "*": res = _num1_ * _num2_; break;
            case "/": res = _num2_ / _num1_;
        }
		
		res_ = Double.toString(res);
		
        return res_;
	}
	
	public String calculateSin(String str)
	{
		String[] s = str.split("Sin", 0);
		Double num1 = 0.0, num2 = 0.0;
		String ans = "";
		
		num2 = Double.parseDouble(s[1]);
		num2 = Math.sin(Math.toRadians(num2));
		
		switch (s[0])
		{
			case "-": num2 *= -1; break;
			case "": break;
			default: num1 = Double.parseDouble(s[0]);
					num2 = num1 * num2;
			
		}
		ans = num2.toString();
		
		return ans;
	}
	
	public String calculateCos(String str)
	{
		String[] s = str.split("Cos", 0);
		Double num1 = 0.0, num2 = 0.0;
		String ans = "";
		
		num2 = Double.parseDouble(s[1]);
		num2 = Math.cos(Math.toRadians(num2));
		
		switch (s[0])
		{
			case "-": num2 *= -1; break;
			case "": break;
			default: num1 = Double.parseDouble(s[0]);
					num2 = num1 * num2;
			
		}
		ans = num2.toString();
		
		return ans;
	}
	
	public String calculateTan(String str)
	{
		String[] s = str.split("Tan", 0);
		Double num1 = 0.0, num2 = 0.0;
		String ans = "";
		
		num2 = Double.parseDouble(s[1]);
		num2 = Math.tan(Math.toRadians(num2));
		
		switch (s[0])
		{
			case "-": num2 *= -1; break;
			case "": break;
			default: num1 = Double.parseDouble(s[0]);
					num2 = num1 * num2;
			
		}
		ans = num2.toString();
		
		return ans;
	}

	public String removeLastChar(String s)
	{
        s = s.substring(0, s.length()-1);
		return s;
    }
	
	public double display()
	{
		String res_ = numStk.pop();
		double res = Double.parseDouble(res_);
		
		return res;
	}
	
	public void removeAll()
	{
		while (!numStk.empty())
		{
			numStk.pop();
		}
		
		while (!opStk.empty())
		{
			opStk.pop();
		}
	}
	
    public static void main(String[] args)
	{
        new JavaCalculator();
    }
} 