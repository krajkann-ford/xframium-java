/*******************************************************************************
 * xFramium
 *
 * Copyright 2016 by Moreland Labs, Ltd. (http://www.morelandlabs.com)
 *
 * Some open source application is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 *  
 * Some open source application is distributed in the hope that it will 
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with xFramium.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 *******************************************************************************/
package org.xframium.gesture.factory.spi.perfecto;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.xframium.device.cloud.action.CloudActionProvider;
import org.xframium.device.factory.DeviceWebDriver;
import org.xframium.gesture.AbstractTwoFingerGesture;
import org.xframium.integrations.common.PercentagePoint;
import org.xframium.integrations.perfectoMobile.rest.PerfectoMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class TwoFingerGesture.
 */
public class TwoFingerGesture extends AbstractTwoFingerGesture
{
	
	/* (non-Javadoc)
	 * @see com.perfectoMobile.gesture.AbstractGesture#_executeGesture(org.openqa.selenium.WebDriver)
	 */
	@Override
	protected boolean _executeGesture( WebDriver webDriver )
	{
		
		String executionId = getExecutionId( webDriver );
		String deviceName = getDeviceName( webDriver );
		if ( executionId != null && deviceName != null )
		{
			
			if ( webElement != null )
			{
				CloudActionProvider aP = ( (DeviceWebDriver) webDriver ).getCloud().getCloudActionProvider();
		        
		        Point at = aP.translatePoint( ( (DeviceWebDriver) webDriver), webElement.getLocation() );
		        Dimension size = aP.translateDimension( (DeviceWebDriver) webDriver, webElement.getSize() );
				
		        if ( at != null && size != null && size.getWidth() > 0 && size.getHeight() > 0 )
				{
					int x = getStartOne().getX() * size.getWidth() + at.getX();
					int y = getStartOne().getY() * size.getHeight() + at.getY();
					Point swipeStart = new Point( x, y );
					
					x = getEndOne().getX() * size.getWidth() + at.getX();
					y = getEndOne().getY() * size.getHeight() + at.getY();
					Point swipeEnd = new Point( x, y );
					
					PerfectoMobile.instance(( (DeviceWebDriver) webDriver ).getxFID() ).gestures().pinch( executionId, deviceName, new PercentagePoint( swipeStart.getX(), swipeStart.getY(), false ), new PercentagePoint( swipeEnd.getX(), swipeEnd.getY(), false ) );
					return true;
				}
				else
				{
					log.warn( "A relative elements was specified however no size could be determined" );
					return false;
				}
			}

			PerfectoMobile.instance(( (DeviceWebDriver) webDriver ).getxFID() ).gestures().pinch( executionId, deviceName, new PercentagePoint( getStartOne().getX(), getStartOne().getY() ), new PercentagePoint( getEndOne().getX(), getEndOne().getY() ) );
			return true;
		}
		else
			return false;
	}

}
