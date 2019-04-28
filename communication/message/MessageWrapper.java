/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.message;

import java.io.Serializable;

/**
 *
 * @author andre and joao
 */
public class MessageWrapper implements Serializable {

	private Message m;

	/**
	 * Setter of the message.
	 *
	 * @param m
	 */
	public void setMessage(Message m) {
		this.m = m;
	}

	/**
	 * Getter of the message.
	 *
	 * @return
	 */
	public Message getMessage() {
		return this.m;
	}
}
