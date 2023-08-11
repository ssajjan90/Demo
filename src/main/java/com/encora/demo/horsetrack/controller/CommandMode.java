/**
 * 
 */
package com.encora.demo.horsetrack.controller;

/**
 * @author ssajjan
 *
 */
public interface CommandMode {

	public void init();
	public void startUpMessages();
	public void winner(int horseNumber);
	public void bet(int horseNumber, int amount);
	public boolean quit();
	public void execute(String command);
	public void restock();
	
	
}
