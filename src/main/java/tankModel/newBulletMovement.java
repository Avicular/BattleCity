package tankModel;

import java.util.ArrayList;
import java.util.TimerTask;

public class newBulletMovement extends TimerTask {
	
	public newBullet bullet;
	public ArrayList<newBullet> pociski; 
	public int counter;
	public int score1;
	public int score2;
	public String objectName = null;
	public String bulletName = null;
	
	public newBulletMovement(newBullet bullet) {
		this.bullet = bullet;
	}
	
	
	@Override
	public void run() {
		
		if (this.bullet.isVisible() == true)
			if (this.bullet.bulletAngle == -Math.PI/2) {
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() - 1).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() - 1).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
						score1 = score1 + 300;
						System.out.println(score1);
					}
					else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
						score2 = score2 + 300;
						System.out.println(score2);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
					System.out.println("GAME OVER");
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()-4);
//				System.out.println(bulletName);
			} 
			else if (this.bullet.bulletAngle == (double) 0){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + i).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall") 
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
					else if (objectName == "enemy" & bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
						score1 = score1 + 300;
						System.out.println(score1);
					}
					else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
						score2 = score2 + 300;
						System.out.println(score2);
					}						
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
					System.out.println("GAME OVER");
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX()+4, this.bullet.getY());
				System.out.println(objectName);
			}
			else if (this.bullet.bulletAngle == Math.PI/2){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() + 21).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() + 21).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
						score1 = score1 + 300;
						System.out.println(score1);
					} else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
						score2 = score2 + 300;
						System.out.println(score2);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
					System.out.println("GAME OVER");
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()+4);
			}
			else if (this.bullet.bulletAngle == Math.PI){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() - 1, bullet.getY() + i).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() - 1, bullet.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
						score1 = score1 + 300;
						System.out.println(score1);
					} else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
						score2 = score2 + 300;
						System.out.println(score2);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
					System.out.println("GAME OVER");
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX()-4, this.bullet.getY());
			}
	}

}
