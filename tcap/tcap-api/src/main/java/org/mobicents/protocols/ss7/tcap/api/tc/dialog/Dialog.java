package org.mobicents.protocols.ss7.tcap.api.tc.dialog;

import org.mobicents.protocols.ss7.tcap.api.TCAPSendException;
import org.mobicents.protocols.ss7.tcap.api.tc.component.ComponentRequest;
import org.mobicents.protocols.ss7.tcap.api.tc.dialog.events.*;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;

public interface Dialog {


	/**
	 * returns this dialog ID. It MUST be unique at any given time in local
	 * stack.
	 * 
	 * @return
	 */
	public long getDialogId();

	/**
	 * Sets local address used by this dialog. Its as "Originating Address" for
	 * TC_BEGIN.
	 * 
	 * @param localAddress
	 */
	public void setLocalAddress(SccpAddress localAddress);

	/**
	 * Gets local sccp address
	 * 
	 * @return
	 */
	public SccpAddress getLocalAddress();

	/**
	 * Sets remote address used by this dialog. Its as "Destination Address".
	 * 
	 * @param localAddress
	 */
	public void setRemoteAddress(SccpAddress localAddress);

	/**
	 * Gets remote sccp address
	 * 
	 * @return
	 */
	public SccpAddress getRemoteAddress();

	/**
	 * returns new, unique for this dialog, invocation id to be used in
	 * TC_INVOKE
	 * 
	 * @return
	 */
	public long getNewInvokeId();

	/**
	 * 
	 * @return <ul>
	 *         <li><b>true </b></li> - if dialog is established(at least on
	 *         TC_CONTINUE has been sent/received.)
	 *         <li><b>false</b></li> - no TC_CONTINUE sent/received
	 *         </ul>
	 */
	public boolean isEstabilished();

	/**
	 * 
	 * @return <ul>
	 *         <li><b>true </b></li> - if dialog is structured - its created
	 *         with TC_BEGIN not TC_UNI
	 *         <li><b>false</b></li> - otherwise
	 *         </ul>
	 */
	public boolean isStructured();

	// //////////////////
	// Sender methods //
	// //////////////////
	/**
	 * Schedules component for sending. All components on list are queued. If
	 * used passes cancel component, canceled component is removed and
	 * indication passed to TC User
	 * 
	 * @param componentRequest
	 */
	public void sendComponent(ComponentRequest componentRequest);

	// sender methods, propalby those will change!
	public void sendBegin() throws TCAPSendException;

	public void sendContinue() throws TCAPSendException;

	public void sendEnd() throws TCAPSendException;

	public void sendUni() throws TCAPSendException;


	/**
	 * Sends custom made dialog event
	 * 
	 * @param event
	 */
	public void send(DialogRequest event) throws TCAPSendException;
}