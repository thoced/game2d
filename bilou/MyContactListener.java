package bilou;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

import Entities.PlayerControl;

public class MyContactListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) 
	{
		// TODO Auto-generated method stub
		
		Contact c = contact;
		
 
			Object temp = c.m_fixtureA.m_body.getUserData();
			
			if(temp.getClass() == PlayerControl.class )
			{
				if(((String)c.m_fixtureB.m_body.getUserData()).equals("ground"))
				{
					((PlayerControl)temp).setIsground(true);
					return;
				}
			}
			
		
			
		
		
	}

	@Override
	public void endContact(Contact contact)
	{
		// TODO Auto-generated method stub
		
		
			
	
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		int a=0;
		a++;
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		int a=0;
		a++;
	}

}
