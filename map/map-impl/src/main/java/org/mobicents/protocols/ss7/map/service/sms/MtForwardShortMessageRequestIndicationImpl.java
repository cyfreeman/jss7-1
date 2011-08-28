/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.map.service.sms;

import java.io.IOException;

import org.mobicents.protocols.asn.AsnException;
import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.asn.Tag;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParsingComponentException;
import org.mobicents.protocols.ss7.map.api.MAPParsingComponentExceptionReason;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.service.sms.MtForwardShortMessageRequestIndication;
import org.mobicents.protocols.ss7.map.api.service.sms.SM_RP_DA;
import org.mobicents.protocols.ss7.map.api.service.sms.SM_RP_OA;
import org.mobicents.protocols.ss7.map.primitives.MAPExtensionContainerImpl;

/**
 * 
 * @author sergey vetyutnev
 * 
 */
public class MtForwardShortMessageRequestIndicationImpl extends SmsServiceImpl implements MtForwardShortMessageRequestIndication {

	private SM_RP_DA sM_RP_DA;
	private SM_RP_OA sM_RP_OA;
	private byte[] sM_RP_UI;
	private Boolean moreMessagesToSend;
	private MAPExtensionContainer extensionContainer;
	
	public MtForwardShortMessageRequestIndicationImpl() {
	}	
	
	public MtForwardShortMessageRequestIndicationImpl(SM_RP_DA sM_RP_DA, SM_RP_OA sM_RP_OA, byte[] sM_RP_UI, Boolean moreMessagesToSend,
			MAPExtensionContainer extensionContainer) {
		this.sM_RP_DA = sM_RP_DA;
		this.sM_RP_OA = sM_RP_OA;
		this.sM_RP_UI = sM_RP_UI;
		this.moreMessagesToSend = moreMessagesToSend;
		this.extensionContainer = extensionContainer;
	}	
	

	@Override
	public SM_RP_DA getSM_RP_DA() {
		return this.sM_RP_DA;
	}

	@Override
	public SM_RP_OA getSM_RP_OA() {
		return this.sM_RP_OA;
	}

	@Override
	public byte[] getSM_RP_UI() {
		return this.sM_RP_UI;
	}

	@Override
	public Boolean getMoreMessagesToSend() {
		return this.moreMessagesToSend;
	}

	@Override
	public MAPExtensionContainer getExtensionContainer() {
		return this.extensionContainer;
	}

	
	@Override
	public int getTag() throws MAPException {
		return Tag.SEQUENCE;
	}

	@Override
	public int getTagClass() {
		return Tag.CLASS_UNIVERSAL;
	}

	@Override
	public boolean getIsPrimitive() {
		return false;
	}

	
	@Override
	public void decodeAll(AsnInputStream ansIS) throws MAPParsingComponentException {

		try {
			int length = ansIS.readLength();
			this._decode(ansIS, length);
		} catch (IOException e) {
			throw new MAPParsingComponentException("IOException when decoding mtForwardShortMessageRequest: " + e.getMessage(), e,
					MAPParsingComponentExceptionReason.MistypedParameter);
		} catch (AsnException e) {
			throw new MAPParsingComponentException("AsnException when decoding mtForwardShortMessageRequest: " + e.getMessage(), e,
					MAPParsingComponentExceptionReason.MistypedParameter);
		}
	}

	@Override
	public void decodeData(AsnInputStream ansIS, int length) throws MAPParsingComponentException {

		try {
			this._decode(ansIS, length);
		} catch (IOException e) {
			throw new MAPParsingComponentException("IOException when decoding mtForwardShortMessageRequest: " + e.getMessage(), e,
					MAPParsingComponentExceptionReason.MistypedParameter);
		} catch (AsnException e) {
			throw new MAPParsingComponentException("AsnException when decoding mtForwardShortMessageRequest: " + e.getMessage(), e,
					MAPParsingComponentExceptionReason.MistypedParameter);
		}
	}

	private void _decode(AsnInputStream ansIS, int length) throws MAPParsingComponentException, IOException, AsnException {

		this.sM_RP_DA = null;
		this.sM_RP_OA = null;
		this.sM_RP_UI = null;
		this.moreMessagesToSend = null;
		this.extensionContainer = null;

		AsnInputStream ais = ansIS.readSequenceStreamData(length);
		int num = 0;
		while (true) {
			if (ais.available() == 0)
				break;

			int tag = ais.readTag();

			switch (num) {
			case 0:
				// SM_RP_DA
				if (ais.getTagClass() != Tag.CLASS_CONTEXT_SPECIFIC || !ais.isTagPrimitive())
					throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter 0 bad tag class or not primitive",
							MAPParsingComponentExceptionReason.MistypedParameter);
				this.sM_RP_DA = new SM_RP_DAImpl();
				((SM_RP_DAImpl)this.sM_RP_DA).decodeAll(ais);
				break;

			case 1:
				// SM_RP_OA
				if (ais.getTagClass() != Tag.CLASS_CONTEXT_SPECIFIC || !ais.isTagPrimitive())
					throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter 1 bad tag class or not primitive",
							MAPParsingComponentExceptionReason.MistypedParameter);
				this.sM_RP_OA = new SM_RP_OAImpl();
				((SM_RP_OAImpl)this.sM_RP_OA).decodeAll(ais);
				break;

			case 2:
				// sm-RP-UI
				if (ais.getTagClass() != Tag.CLASS_UNIVERSAL || !ais.isTagPrimitive())
					throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter 2 bad tag class or not primitive",
							MAPParsingComponentExceptionReason.MistypedParameter);
				if (tag != Tag.STRING_OCTET)
					throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter 2 tag must be STRING_OCTET, found: "
							+ tag, MAPParsingComponentExceptionReason.MistypedParameter);
				this.sM_RP_UI = ais.readOctetString();
				break;

			default:
				if (tag == Tag.SEQUENCE && ais.getTagClass() == Tag.CLASS_UNIVERSAL) {
					
					if (ais.isTagPrimitive())
						throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter extensionContainer is primitive",
								MAPParsingComponentExceptionReason.MistypedParameter);
					this.extensionContainer = new MAPExtensionContainerImpl();
					((MAPExtensionContainerImpl)this.extensionContainer).decodeAll(ais);
				} else if (tag == Tag.NULL && ais.getTagClass() == Tag.CLASS_UNIVERSAL) {
					
					if (!ais.isTagPrimitive())
						throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Parameter moreMessagesToSend is not primitive",
								MAPParsingComponentExceptionReason.MistypedParameter);
					ais.readNull();
					this.moreMessagesToSend = true;
				} else {
					
					ais.advanceElement();
				}
				break;
			}

			num++;
		}

		if (num < 3)
			throw new MAPParsingComponentException("Error while decoding mtForwardShortMessageRequest: Needs at least 3 mandatory parameters, found " + num,
					MAPParsingComponentExceptionReason.MistypedParameter);
	}

	@Override
	public void encodeAll(AsnOutputStream asnOs) throws MAPException {

		this.encodeAll(asnOs, Tag.CLASS_UNIVERSAL, Tag.SEQUENCE);
	}

	@Override
	public void encodeAll(AsnOutputStream asnOs, int tagClass, int tag) throws MAPException {
		
		try {
			asnOs.writeTag(tagClass, false, tag);
			int pos = asnOs.StartContentDefiniteLength();
			this.encodeData(asnOs);
			asnOs.FinalizeContent(pos);
		} catch (AsnException e) {
			throw new MAPException("AsnException when encoding mtForwardShortMessageRequest: " + e.getMessage(), e);
		}
	}

	@Override
	public void encodeData(AsnOutputStream asnOs) throws MAPException {

		if (this.sM_RP_DA == null || this.sM_RP_OA == null || this.sM_RP_UI == null)
			throw new MAPException("sm_RP_DA,sm_RP_OA and sm_RP_UI must not be null");

		try {
			((SM_RP_DAImpl)this.sM_RP_DA).encodeAll(asnOs);
			((SM_RP_OAImpl)this.sM_RP_OA).encodeAll(asnOs);
			asnOs.writeOctetString(this.sM_RP_UI);

			if (this.moreMessagesToSend != null)
				asnOs.writeNull();
			if (this.extensionContainer != null)
				((MAPExtensionContainerImpl)this.extensionContainer).encodeAll(asnOs);
		} catch (IOException e) {
			throw new MAPException("IOException when encoding mtForwardShortMessageRequest: " + e.getMessage(), e);
		} catch (AsnException e) {
			throw new MAPException("AsnException when encoding mtForwardShortMessageRequest: " + e.getMessage(), e);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MoForwardShortMessageRequest [");

		if (this.sM_RP_DA != null) {
			sb.append("sm_RP_DA=");
			sb.append(this.sM_RP_DA.toString());
		}
		if (this.sM_RP_OA != null) {
			sb.append(", sm_RP_OA=");
			sb.append(this.sM_RP_OA.toString());
		}
		if (this.sM_RP_UI != null) {
			sb.append(", sm_RP_UI=[");
			sb.append(this.printDataArr(this.sM_RP_UI));
			sb.append("]");
		}
		if (this.extensionContainer != null) {
			sb.append(", extensionContainer=");
			sb.append(this.extensionContainer.toString());
		}
		if (this.moreMessagesToSend != null) {
			sb.append(", moreMessagesToSend=");
			sb.append(this.moreMessagesToSend);
		}

		sb.append("]");

		return sb.toString();
	}

	private String printDataArr(byte[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int b : arr) {
			sb.append(b);
			sb.append(", ");
		}

		return sb.toString();
	}
}
