package jdialer.jtapi;

/**
 * Trace.java
 *
 * THIS SAMPLE APPLICATION AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF
 * ANY KIND BY CISCO, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY FITNESS FOR A PARTICULAR PURPOSE,
 * NONINFRINGEMENT, SATISFACTORY QUALITY OR ARISING FROM A COURSE OF DEALING, LAW,
 * USAGE, OR TRADE PRACTICE.  CISCO TAKES NO RESPONSIBILITY REGARDING ITS USAGE IN AN
 * APPLICATION, AND IT IS PRESENTED ONLY AS AN EXAMPLE.  THE SAMPLE CODE HAS NOT BEEN
 * THOROUGHLY TESTED AND IS PROVIDED AS AN EXAMPLE ONLY, THEREFORE CISCO DOES NOT
 * GUARANTEE OR MAKE ANY REPRESENTATIONS REGARDING ITS RELIABILITY, SERVICEABILITY,
 * OR FUNCTION.  IN NO EVENT DOES CISCO WARRANT THAT THE SOFTWARE IS ERROR FREE OR THAT
 * CUSTOMER WILL BE ABLE TO OPERATE THE SOFTWARE WITHOUT PROBLEMS OR INTERRUPTIONS.
 * NOR DOES CISCO WARRANT THAT THE SOFTWARE OR ANY EQUIPMENT ON WHICH THE SOFTWARE IS
 * USED WILL BE FREE OF VULNERABILITY TO INTRUSION OR ATTACK.  THIS SAMPLE APPLICATION
 * IS NOT SUPPORTED BY CISCO IN ANY MANNER. CISCO DOES NOT ASSUME ANY LIABILITY ARISING
 * FROM THE USE OF THE APPLICATION. FURTHERMORE, IN NO EVENT SHALL CISCO OR ITS SUPPLIERS
 * BE LIABLE FOR ANY INCIDENTAL OR CONSEQUENTIAL DAMAGES, LOST PROFITS, OR LOST DATA,
 * OR ANY OTHER INDIRECT DAMAGES EVEN IF CISCO OR ITS SUPPLIERS HAVE BEEN INFORMED OF THE
 * POSSIBILITY THEREOF.
 */
public interface Trace
{
/**
	 * bufPrint (str) puts str in buffer only.
	 */
	public void bufPrint ( String string );

	/**
	 * print () println () bufPrint and invoke flush ();
	 */
	public void print ( String string );
	public void print ( char character );
	public void print ( int integer );
	public void println ( String string );
	public void println ( char character );
	public void println ( int integer );

	/**
	 * flush out the buffer.
	 */
	public void flush ();
}
