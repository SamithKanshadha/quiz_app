
import java.awt.EventQueue;

public class Main{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					QuizFrame quizFrame = new QuizFrame();
					
					quizFrame.frame.setVisible(true);
					quizFrame.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
