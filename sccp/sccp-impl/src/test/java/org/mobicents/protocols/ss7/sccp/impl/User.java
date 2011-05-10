/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.mobicents.protocols.ss7.sccp.impl;

import java.io.IOException;

import org.mobicents.protocols.ss7.sccp.SccpListener;
import org.mobicents.protocols.ss7.sccp.SccpProvider;
import org.mobicents.protocols.ss7.sccp.message.MessageFactory;
import org.mobicents.protocols.ss7.sccp.message.SccpMessage;
import org.mobicents.protocols.ss7.sccp.message.UnitData;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;
import org.mobicents.protocols.ss7.sccp.parameter.ProtocolClass;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;

/**
 * @author baranowb
 * @author abhayani
 */
public class User implements SccpListener {
	protected SccpProvider provider;
	protected SccpAddress address;
	protected SccpAddress dest;

	protected SccpMessage msg;

	public User(SccpProvider provider, SccpAddress address, SccpAddress dest, int ssn) {
		this.provider = provider;
		this.address = address;
		this.dest = dest;
		provider.registerSccpListener(ssn, this);
	}

	public boolean check() {
		if (msg == null) {
			return false;
		}

		if (msg.getType() != UnitData.MESSAGE_TYPE) {
			return false;
		}

		UnitData udt = (UnitData) msg;
		if (!matchCalledPartyAddress()) {
			return false;
		}

		if (!matchCallingPartyAddress()) {
			return false;
		}

		return true;
	}
	
	protected boolean matchCalledPartyAddress()
	{
		UnitData udt = (UnitData) msg;
		if (!address.equals(udt.getCalledPartyAddress())) {
			return false;
		}
		return true;
	}
	
	protected boolean matchCallingPartyAddress()
	{
		UnitData udt = (UnitData) msg;
		if (!dest.equals(udt.getCallingPartyAddress())) {
			return false;
		}
		return true;
	}

	protected void send() throws IOException {
		MessageFactory messageFactory = provider.getMessageFactory();
		ParameterFactory paramFactory = provider.getParameterFactory();

		ProtocolClass pClass = paramFactory.createProtocolClass(0, 0);
		UnitData udt = messageFactory.createUnitData(pClass, dest, address);
		udt.setData(new byte[10]);
		provider.send(udt,1);
	}

	public void onMessage(SccpMessage message, int seqControl) {
		this.msg = message;
		System.out.println(String.format("SccpMessage=%s seqControl=%d", message, seqControl));
	}

}