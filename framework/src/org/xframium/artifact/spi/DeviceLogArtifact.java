package org.xframium.artifact.spi;

import java.io.File;
import org.xframium.artifact.AbstractArtifact;
import org.xframium.artifact.ArtifactType;
import org.xframium.device.factory.DeviceWebDriver;

public class DeviceLogArtifact extends AbstractArtifact
{
    private static final String FILE_NAME = "device.txt";
    public DeviceLogArtifact()
    {
        setArtifactType( ArtifactType.DEVICE_LOG.name() );
    }
    
    @Override
    protected File _generateArtifact( File rootFolder, DeviceWebDriver webDriver, String xFID )
    {
        
        String logData = webDriver.getCloud().getCloudActionProvider().getLog( webDriver );
        if ( logData != null )
            return writeToDisk( rootFolder, FILE_NAME, logData.getBytes() );
        else
            return null;
    }
}
