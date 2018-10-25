
import javax.swing.JOptionPane;
public class GUI {

	/**
	 * Implementinng the input dialog box and show message
	 *+box
	 * Something to check on the showMessage dialog box
	 * JOption.PLAIN_MESSAGE is the one without any icon
	 */
	public static void main(String[] args) {
		String num1, num2;
		int number1, number2, sum;

		num1 = JOptionPane.showInputDialog("num1");
		number1 = Integer.parseInt(num1);

		num2 = JOptionPane.showInputDialog("num2");
		number2 = Integer.parseInt(num2);

		sum = number1 + number2;

		JOptionPane.showMessageDialog(null, "the sum is : " + sum , "Results", JOptionPane.PLAIN_MESSAGE );

		System.exit(0);

	}
}
