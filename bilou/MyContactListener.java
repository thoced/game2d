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
		
 
			Object tempA = contact.m_fixtureA.m_body.getUserData();
			Object tempB = contact.m_fixtureB.m_body.getUserData();
			
			if(tempA != null && tempA.getClass() == PlayerControl.class)
			{
				if(tempB != null && tempB.equals("ground"))
					((PlayerControl)tempA).setIsground(true);
			}
			
			if(tempB != null && tempB.getClass() == PlayerControl.class)
			{
				if(tempA != null && tempA.equals("ground"))
					((PlayerControl)tempB).setIsground(true);
			}
			
			/*if(temp != null && temp.getClass() == PlayerControl.class )
			{
				if(((String)c.m_fixtureB.m_body.getUserData()).equals("ground"))
				{
					((PlayerControl)temp).setIsground(true);
					return;
				}
			}*/
			
				
		
			
		
		
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
