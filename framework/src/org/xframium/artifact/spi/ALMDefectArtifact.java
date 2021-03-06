package org.xframium.artifact.spi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xframium.artifact.AbstractArtifact;
import org.xframium.artifact.ArtifactType;
import org.xframium.device.factory.DeviceWebDriver;
import org.xframium.exception.XFramiumException.ExceptionType;
import org.xframium.integrations.alm.ALMRESTConnection;
import org.xframium.integrations.alm.entity.ALMAttachment;
import org.xframium.integrations.alm.entity.ALMData;
import org.xframium.integrations.alm.entity.ALMDefect;
import org.xframium.reporting.ExecutionContext;

public class ALMDefectArtifact extends AbstractArtifact
{
    private static Pattern CUSTOM_PATTERN = Pattern.compile( "(.*)\\((.*)\\,(.*)\\)=(\\w*)" );
    private static Pattern OVERRIDE_PATTERN = Pattern.compile( "(.*)\\((.*)\\,(\\w*)\\)" ); 
    
    public ALMDefectArtifact()
    {
        setArtifactType( ArtifactType.ALM_DEFECT.name() );
    }
    
    @Override
    protected File _generateArtifact( File rootFolder, DeviceWebDriver webDriver, String xFID ) throws Exception
    {
        if ( webDriver.isConnected() && !webDriver.getExecutionContext().getStatus() && webDriver.getExecutionContext().getExceptionType() != null && webDriver.getExecutionContext().getExceptionType().equals( ExceptionType.SCRIPT ) )
        {
            //
            // ALM Integration
            //
            ALMDefect almDefect = new ALMDefect();
            almDefect.setAssignedTo( ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.assignedTo" ) );
            
            String descriptionTemplate = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defect.template.BG_DESCRIPTION" );
            if ( descriptionTemplate != null )
                almDefect.setDescription( webDriver.toFormattedString( descriptionTemplate ) );
            else
                almDefect.setDescription( webDriver.getExecutionContext().getMessageDetail() );
            
            almDefect.setDetectedBy( ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.userName" ) );
            almDefect.setDetectedInCycle( ExecutionContext.instance( xFID ).getPhase() );
            if ( ExecutionContext.instance( xFID ).getAut().getEnvironment() != null )
                almDefect.setDetectedInEnvironment( ExecutionContext.instance( xFID ).getAut().getEnvironment() );
            
            if ( ExecutionContext.instance( xFID ).getAut().getVersion() > 0 )
                almDefect.setDetectedInRelease( ((int) ExecutionContext.instance( xFID ).getAut().getVersion()) + "" );

            
            String defaultPriorityValue = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.priority" );
            int defaultPriority = 1;
            if ( defaultPriorityValue != null && !defaultPriorityValue.isEmpty() )
                defaultPriority = Integer.parseInt( defaultPriorityValue );
            
            if ( webDriver.getExecutionContext().getTest().getPriority() > 0 )
                almDefect.setPriority( webDriver.getExecutionContext().getTest().getPriority() );
            else
                almDefect.setPriority( defaultPriority );

            
            String defaultSeverityValue = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.severity" );
            int defaultSeverity = 1;
            if ( defaultSeverityValue != null && !defaultSeverityValue.isEmpty() )
                defaultSeverity = Integer.parseInt( defaultSeverityValue );
            
            if ( webDriver.getExecutionContext().getTest().getSeverity() > 0 )
                almDefect.setSeverity( webDriver.getExecutionContext().getTest().getSeverity() );
            else
                almDefect.setSeverity( defaultSeverity );
            
            
            
            almDefect.setStatus( ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defectStatus" ) );
            
            String summaryTemplate = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defect.template.BG_SUMMARY" );
            if ( summaryTemplate != null )
                almDefect.setSummary( webDriver.toFormattedString( summaryTemplate ) );
            else
                almDefect.setSummary( webDriver.getExecutionContext().getMessage() );
            
            //
            // Add custom fields with static values
            //
            String almCustomFields = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defectCustomFields" );
            if ( almCustomFields != null && !almCustomFields.isEmpty() )
            {
                for ( String fieldDef : almCustomFields.split( ":" ) )
                {
                    Matcher fieldMatcher = CUSTOM_PATTERN.matcher( fieldDef );
                    
                    if ( fieldMatcher.find() )
                    {
                        ALMData almData = new ALMData( fieldMatcher.group( 1 ), fieldMatcher.group( 3 ), fieldMatcher.group( 2 ), fieldMatcher.group( 4 ) );
                        //
                        // Allow the data to be formatted
                        //
                        String customData = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defect.template." + almData.getPhysicalName() );
                        if ( customData != null )
                            almData.setValue( webDriver.toFormattedString( customData ) );
                        
                            
                        almDefect.addCustomData( almData.getPhysicalName(), almData );
                    }
                }
            }
            
            // Override fields names
            //
            //
            String almOverrideFields = ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.defectOverrideFields" );
            if ( almOverrideFields != null && !almOverrideFields.isEmpty() )
            {
                for ( String fieldDef : almOverrideFields.split( ":" ) )
                {
                    Matcher fieldMatcher = OVERRIDE_PATTERN.matcher( fieldDef );
                    
                    if ( fieldMatcher.find() )
                    {
                        ALMData almData = new ALMData( fieldMatcher.group( 1 ), fieldMatcher.group( 3 ), fieldMatcher.group( 2 ), null );    
                        almDefect.addCustomData( almData.getPhysicalName(), almData );
                    }
                }
            }
            
            
            List<ALMAttachment> artifactList = new ArrayList<ALMAttachment>( 10 );
            for ( ArtifactType a : ArtifactType.CONSOLE_LOG.getSupported() )
            {
                if ( webDriver.getExecutionContext().getExecutionParameter( a.name() + "_ABS" ) != null )
                {
                    artifactList.add( new ALMAttachment( new File( webDriver.getExecutionContext().getExecutionParameter( a.name() + "_ABS" ) ), null, "", a.getDescription() ) );
                }
            }
            
            String screenShot = webDriver.getExecutionContext().getScreenShotLocation();
            if ( screenShot != null )
            {
                artifactList.add( new ALMAttachment( new File( screenShot ), null, "", "SCREENSHOT" ) );
            }
            
            almDefect.setAttachments( artifactList.toArray( new ALMAttachment[ 0 ] ) );
            ALMRESTConnection arc = new ALMRESTConnection( ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.serverUrl" ), ExecutionContext.instance( xFID ).getDomain(), ExecutionContext.instance( xFID ).getSuiteName() );
            arc.login( ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.userName" ), ExecutionContext.instance( xFID ).getConfigProperties().get( "alm.password" ) );
            if ( log.isInfoEnabled() )
                log.info( "ALM: " + almDefect.toXML() );
            String almDefectUrl = arc.addDefect( almDefect );
            
            
            webDriver.getExecutionContext().addExecutionParameter( getArtifactType() + "_" + URL, almDefectUrl + "?login-form-required=y" );
            arc.logout();
            
            
        }
        
        return null;
    }
}
