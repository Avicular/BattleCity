package tankModel;

import java.util.ArrayList;
import java.util.TimerTask;

public class newBulletMovement extends TimerTask {
	
	public newBullet bullet;
	public ArrayList<newBullet> pociski; 
	
	public newBulletMovement(newBullet bullet) {
		this.bullet = bullet;
	}
	
	
	@Override
	public void run() {
		
		if (this.bullet.isVisible() == true)
			if (this.bullet.bulletAngle == -Math.PI/2)
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()-4);
			else if (this.bullet.bulletAngle == (double) 0)
				this.bullet.setLocation(this.bullet.getX()+4, this.bullet.getY());
			else if (this.bullet.bulletAngle == Math.PI/2)
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()+4);
			else if (this.bullet.bulletAngle == Math.PI)
				this.bullet.setLocation(this.bullet.getX()-4, this.bullet.getY());
	}

}
