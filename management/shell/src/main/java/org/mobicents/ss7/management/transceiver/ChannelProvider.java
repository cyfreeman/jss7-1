package org.mobicents.ss7.management.transceiver;

import java.io.IOException;

public class ChannelProvider {
    
    private MessageFactory messageFactory =  new MessageFactory();

    public static ChannelProvider open() {
        return new ChannelProvider();
    }
    
    public ShellChannel openChannel() throws IOException {
        return ShellChannel.open(this);
    }
    
    public ShellServerChannel openServerChannel() throws IOException {
        return ShellServerChannel.open(this);
    }
    
    public ChannelSelector openSelector() throws IOException {
        return ChannelSelector.open();
    }
    
    public MessageFactory getMessageFactory(){
        return messageFactory;
    }
}